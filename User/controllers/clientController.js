const clientModel = require("../models/clientModel");
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
    create: async (req, res) => {
        try {
            const schemaVal = Joi.object({
                nom: Joi.string().required(),
                prenom: Joi.string().required(),
                email: Joi.string().email().required(),
                password: Joi.string().min(8).max(30).regex(/[a-zA-Z0-9]{3,30}/).required(),
                telephone: Joi.string(),
                address: Joi.string()
            });
    
            const { error, value } = schemaVal.validate(req.body);
            if (error) {
                return res.status(400).json({ error: error.details[0].message });
            };
    
            const plainPassword = req.body.password;
            const hashedPassword = await bcrypt.hash(plainPassword, saltRounds);
    
            const cust = new clientModel({
                ...req.body, 
                password: hashedPassword,
                codeVerification: crypto.randomBytes(20).toString('hex')
            });
    
            const item = await cust.save();
    
            transport.sendMail({
                from: "MED Esprit",
                to: item.email,
                subject: "Inscription",
                text: "Inscrit avec succès",
                html: `<!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Document</title>
                        </head>
                        <body>
                            <b>Inscrit avec succès</b>
                            <a href='http://localhost:3000/auth/verify/${item.codeVerification}'>Cliquez ici pour vérifier votre compte</a>
                        </body>
                        </html>`
            });
    
            res.status(201).json({ success: true, message: "success", data: item });
    
        } catch (error) {
            res.status(400).json({ success: false, message: "error" + error, data: null });
        }
    },
    update: async (req, res) => {
        try {
            const { id } = req.params;

            const schemaVal = Joi.object({
                nom: Joi.string().required(),
                prenom: Joi.string().required(),
                email: Joi.string().email().required(),
                password: Joi.string().min(8).max(30).regex(/[a-zA-Z0-9]{3,30}/).required(),
                telephone: Joi.string(),
                address: Joi.string()
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

            const cust = await clientModel.findByIdAndUpdate(id, updateData, { new: true });

            if (!cust) {
                return res.status(404).json({ success: false, message: "Client not found", data: null });
            }

            res.status(200).json({ success: true, message: "Client updated successfully", data: cust });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
    read: async (req, res) => {
        try {
            const prod = await clientModel.find();
            res.status(200).json({ success: true, message: "Success", data: prod });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
    delete: async (req, res) => {
        try {
            const { id } = req.params;

            const cust = await clientModel.findByIdAndDelete(id);

            if (!cust) {
                return res.status(404).json({ success: false, message: "Client not found", data: null });
            }

            res.status(200).json({ success: true, message: "Client deleted successfully", data: null });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
    getById: async (req, res) => {
        try {
            const { id } = req.params;

            const cust = await clientModel.findById(id);
            
            if (!cust) {
                return res.status(404).json({ success: false, message: "Client not found", data: null });
            }

            res.status(200).json({ success: true, message: "Success", data: cust });
        } catch (error) {
            res.status(400).json({ success: false, message: "Error: " + error, data: null });
        }
    },
}