const mongoose = require("mongoose");
const userModel = require("./userModel");

const adminSchema = new mongoose.Schema({
}, {timestamps: true});

module.exports = userModel.discriminator("admin", adminSchema);