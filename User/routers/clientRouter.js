const clientController = require("../controllers/clientController");
const route = require("express").Router();

/**
 * @swagger
 * /client/add:
 *   post:
 *     summary: Ajoute un nouveau client
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nom:
 *                 type: string
 *               prenom:
 *                 type: string
 *               email:
 *                 type: string
 *               password:
 *                 type: string
 *               telephone:
 *                 type: string
 *               address:
 *                 type: string
 *     responses:
 *       201:
 *         description: Client créé avec succès.
 *       400:
 *         description: Erreur lors de la création du client.
 */
route.post("/add", clientController.create);

/**
 * @swagger
 * /client/update/{id}:
 *   put:
 *     summary: Met à jour un client existant
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema:
 *           type: string
 *         description: ID du client
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nom:
 *                 type: string
 *               prenom:
 *                 type: string
 *               email:
 *                 type: string
 *               password:
 *                 type: string
 *               telephone:
 *                 type: string
 *               address:
 *                 type: string
 *     responses:
 *       200:
 *         description: Client mis à jour avec succès.
 *       404:
 *         description: Client introuvable.
 */
route.put("/update/:id", clientController.update);

/**
 * @swagger
 * /client/:
 *   get:
 *     summary: Récupère tous les clients
 *     responses:
 *       200:
 *         description: Liste des clients récupérée.
 *       400:
 *         description: Erreur lors de la récupération.
 */
route.get("/", clientController.read);

/**
 * @swagger
 * /client/delete/{id}:
 *   delete:
 *     summary: Supprime un client
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema:
 *           type: string
 *         description: ID du client
 *     responses:
 *       200:
 *         description: Client supprimé avec succès.
 *       404:
 *         description: Client introuvable.
 */
route.delete("/delete/:id", clientController.delete);

/**
 * @swagger
 * /client/getById/{id}:
 *   get:
 *     summary: Récupère un client par son ID
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema:
 *           type: string
 *         description: ID du client
 *     responses:
 *       200:
 *         description: Client récupéré avec succès.
 *       404:
 *         description: Client introuvable.
 */
route.get("/getById/:id", clientController.getById);

module.exports = route;
