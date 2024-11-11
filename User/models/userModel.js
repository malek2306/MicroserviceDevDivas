const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
    nom: {
        type: String,
        required: true,
        trim: true
    },
    prenom: {
        type: String,
        required: true,
        trim: true
    },
    email:{
        type: String,
        required: true,
        unique: true,
        trim: true
    },
    password: {
        type: String,
        required: true,
        trim: true
    },
    verified: {
        type: Boolean,
        default: false
    },
    codeVerification: {
        type: String,
        trim: true
    },
    resetToken: {
        type: String,
    }
}, {timestamps: true});

module.exports = mongoose.model("users", userSchema);