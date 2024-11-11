const swaggerJSDoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');

const swaggerOptions = {
  definition: {
    openapi: '3.0.0',
    info: {
      title: 'API Documentation',
      version: '1.0.0',
      description: 'Documentation de l\'API pour votre projet Node.js Express MongoDB',
    },
    servers: [
      {
        url: 'http://localhost:3000', // Remplacez par l'URL de votre API
      },
    ],
  },
  apis: ['./routers/*.js'], // Chemin de vos fichiers de route contenant les commentaires Swagger
};

const swaggerSpec = swaggerJSDoc(swaggerOptions);

module.exports = { swaggerUi, swaggerSpec };
