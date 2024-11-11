const adminController = require("../controllers/adminController");
const route = require("express").Router();

/**
 * @swagger
 * /admin/update/{id}:
 *   put:
 *     summary: Met à jour les informations de l'administrateur
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema:
 *           type: string
 *         description: ID de l'administrateur
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
 *     responses:
 *       200:
 *         description: Informations de l'administrateur mises à jour.
 *       404:
 *         description: Administrateur introuvable.
 */
route.put("/update/:id", adminController.update);

/**
 * @swagger
 * /admin/getById/{id}:
 *   get:
 *     summary: Récupère les informations d'un administrateur
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema:
 *           type: string
 *         description: ID de l'administrateur
 *     responses:
 *       200:
 *         description: Informations de l'administrateur récupérées.
 *       404:
 *         description: Administrateur introuvable.
 */
route.get("/getById/:id", adminController.getById);

module.exports = route;
