const adminModel = require("../models/adminModel");
const bcrypt = require('bcrypt');
const saltRounds = 10;
const nodemailer = require("nodemailer");
const crypto = require('crypto');
const Joi = require('joi');

var transport = nodemailer.createTransport({
    host: "sandbox.smtp.mailtrap.io",
    port: 2525,
    auth: {
      user: "7653b5629037ad",
      pass: "032935cb7fc7c9"
    }
});

module.exports = {
    update: async (req, res) => {
        try {
            const { id } = req.params;

            const schemaVal = Joi.object({
                nom: Joi.string().required(),
                prenom: Joi.string().required(),
                email: Joi.string().email().required(),
                password: Joi.string().min(8).max(30).regex(/[a-zA-Z0-9]{3,30}/).required()
            })
            const { error, value } = schemaVal.validate(req.body);
            if(error){
                return res.status(400).json({error:error.details[0].message})
            };

            
            const { password, ...updateData } = req.body;
            

            if (password) {
                const hashedPassword = await bcrypt.hash(password, saltRounds);
                updateData.password = hashedPassword;
            }

            const cust = await adminModel.findByIdAndUpdate(id, updateData, { new: true });

            if (!cust) {
                return res.status(404).json({ success: false, message: "Admin not found", data: null });
            }

            res.status(200).json({ success: true, message: "Admin updated successfully", data: cust });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
    getById: async (req, res) => {
        try {
            const { id } = req.params;

            const cust = await adminModel.findById(id);
            
            if (!cust) {
                return res.status(404).json({ success: false, message: "Admin not found", data: null });
            }

            res.status(200).json({ success: true, message: "Success", data: cust });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
}