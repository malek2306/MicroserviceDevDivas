const express = require('express');
const app = express();
const cors = require('cors');
require("./db");
const dotenv = require('dotenv').config();
const port = 3000;
require("./eureka")
const { swaggerUi, swaggerSpec } = require('./swagger');

app.use(express.json());
app.use(cors());

// Configurer Swagger pour être accessible à l'URL /api-docs
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

const authRouter = require("./routers/authRouter")
app.use("/auth", authRouter)

const adminRouter = require("./routers/adminRouter")
app.use("/admin", adminRouter)

const clientRouter = require("./routers/clientRouter")
app.use("/client", clientRouter)
  

// Démarrage du serveur
app.listen(port, function() {
    console.log(`Le serveur est en cours d'exécution à http://localhost:${port}`);
    console.log(`Documentation Swagger disponible à http://localhost:${port}/api-docs`);
});