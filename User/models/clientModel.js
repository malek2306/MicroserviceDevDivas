const mongoose = require("mongoose");
const userModel = require("./userModel");

const clientSchema = new mongoose.Schema({
    address: {
        type: String,
        required: true,
        trim: true
    },
    telephone: {
        type: String,
        required: true,
        trim: true
    },
}, {timestamps: true});

module.exports = userModel.discriminator("clients", clientSchema);