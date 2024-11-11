const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const Admin = require('./models/adminModel');
require('dotenv').config(); // Charger les variables d'environnement

// Définition de l'option strictQuery à false pour éviter l'avertissement de dépréciation
mongoose.set('strictQuery', false);

// URL de connexion MongoDB
const url = "mongodb://0.0.0.0:27017/microserviceUser";

// Fonction asynchrone pour la connexion
async function connectDB() {
  try {
    await mongoose.connect(url);
    console.log('Connecté avec succès à MongoDB');
  } catch (err) {
    console.error('Erreur lors de la connexion à MongoDB', err);
  }
}

// Fonction pour vérifier et créer l'admin si nécessaire
async function ensureAdminExists() {
  try {
    const adminExists = await Admin.findOne();
    if (!adminExists) {
      // Vérification des variables d'environnement
      if (!process.env.ADMIN_PASSWORD || !process.env.ADMIN_NOM || !process.env.ADMIN_PRENOM || !process.env.ADMIN_EMAIL) {
        console.error("Erreur : Les informations de l'admin (nom, prénom, email, mot de passe) doivent être définies dans le fichier .env.");
        return;
      }

      const hashedPassword = await bcrypt.hash(process.env.ADMIN_PASSWORD, 10);
      const newAdmin = new Admin({
        nom: process.env.ADMIN_NOM,
        prenom: process.env.ADMIN_PRENOM,
        email: process.env.ADMIN_EMAIL,
        password: hashedPassword,
        verified: true,
        confirmed: true
      });

      await newAdmin.save();
      console.log('Le compte Admin a été créé avec succès.');
    } else {
      console.log('Un compte Admin existe déjà.');
    }
  } catch (error) {
    console.error('Erreur lors de la création du compte Admin:', error);
  }
}

// Appel des fonctions de connexion et vérification de l'admin
(async () => {
  await connectDB();
  await ensureAdminExists();
})();
