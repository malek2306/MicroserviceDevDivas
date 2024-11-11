const auth = require("../controllers/auth");
const route = require("express").Router();

/**
 * @swagger
 * /auth/verify/{codeVerification}:
 *   get:
 *     summary: Vérifie le code de vérification de l'utilisateur
 *     parameters:
 *       - in: path
 *         name: codeVerification
 *         required: true
 *         schema:
 *           type: string
 *         description: Code de vérification de l'utilisateur
 *     responses:
 *       200:
 *         description: Code vérifié avec succès.
 *       400:
 *         description: Erreur lors de la vérification.
 */
route.get("/verify/:codeVerification", auth.verif);

/**
 * @swagger
 * /auth/login:
 *   post:
 *     summary: Connexion utilisateur
 *     description: Authentifie un utilisateur avec email et mot de passe.
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email:
 *                 type: string
 *               password:
 *                 type: string
 *     responses:
 *       201:
 *         description: Connexion réussie.
 *       400:
 *         description: Email ou mot de passe incorrect.
 */
route.post("/login", auth.login);

/**
 * @swagger
 * /auth/logout:
 *   post:
 *     summary: Déconnexion de l'utilisateur
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               refreshToken:
 *                 type: string
 *                 description: Jeton de rafraîchissement pour la déconnexion.
 *     responses:
 *       200:
 *         description: Déconnexion réussie.
 *       401:
 *         description: Jeton manquant.
 *       403:
 *         description: Jeton invalide.
 */
route.post("/logout", auth.logout);

/**
 * @swagger
 * /auth/verifyRefreshToken:
 *   post:
 *     summary: Vérifie et renouvelle le jeton d'accès
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               refreshToken:
 *                 type: string
 *     responses:
 *       200:
 *         description: Jeton actualisé avec succès.
 *       401:
 *         description: Jeton manquant.
 *       403:
 *         description: Jeton invalide.
 */
route.post("/verifyRefreshToken", auth.verifyRefreshToken);

/**
 * @swagger
 * /auth/userConnect:
 *   get:
 *     summary: Récupère les informations de l'utilisateur connecté
 *     responses:
 *       200:
 *         description: Utilisateur connecté.
 *       403:
 *         description: Accès refusé.
 */
route.get("/userConnect", auth.userConnect);

/**
 * @swagger
 * /auth/forgotPassword:
 *   post:
 *     summary: Demande de réinitialisation du mot de passe
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email:
 *                 type: string
 *     responses:
 *       200:
 *         description: Email de réinitialisation envoyé.
 *       400:
 *         description: Utilisateur non trouvé.
 */
route.post("/forgotPassword", auth.forgotPassword);

/**
 * @swagger
 * /auth/reset/{resetToken}:
 *   post:
 *     summary: Réinitialise le mot de passe de l'utilisateur
 *     parameters:
 *       - in: path
 *         name: resetToken
 *         required: true
 *         schema:
 *           type: string
 *         description: Jeton de réinitialisation de mot de passe
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               newPassword:
 *                 type: string
 *     responses:
 *       201:
 *         description: Mot de passe réinitialisé avec succès.
 *       400:
 *         description: Jeton de réinitialisation invalide.
 */
route.post("/reset/:resetToken", auth.resetPassword);

module.exports = route;
