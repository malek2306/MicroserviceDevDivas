Documentation du Projet : Application de Restauration

Introduction : 

L'application de restauration repose sur une architecture microservices, où chaque module correspond à une fonctionnalité spécifique. Les microservices sont construits avec Spring Boot, et un microservice supplémentaire est développé avec Node.js et MongoDB pour gérer les utilisateurs.

L'application a été conteneurisée à l'aide de Docker Compose pour une gestion simplifiée des services, et sécurisée via Keycloak pour gérer l'authentification et l'autorisation.

Architecture de l'Application : 

1. Microservices Spring Boot
L'application se compose de sept microservices principaux, chacun ayant une fonctionnalité spécifique :

Microservice Reclamation : Utilise une base de données H2 pour gérer les réclamations des clients.
Microservice GestionStock : Gère les stocks des produits avec une base de données MySQL.
Microservice GestionLivraison : Suivi des livraisons, utilisant H2 comme base de données.
Microservice GestionCommandes : Gère les commandes des clients avec une base de données H2.
Microservice GestionMenu : Gère les menus du restaurant, avec MySQL comme base de données.
Microservice API Gateway : Sert de passerelle pour rediriger les requêtes vers les microservices appropriés.
Microservice Eureka : Implémente le service de découverte d'instances, permettant de gérer les microservices en fonction de leur état d'exécution.

2. Communication entre Microservices
Communication entre Livraison et Commandes : Le microservice de livraison interagit avec le microservice de gestion des commandes pour récupérer les commandes en attente de livraison.
Communication entre Livraison et Reclamation : Le microservice de livraison peut récupérer les réclamations associées à une commande en consultant le microservice de réclamations.

4. Microservice ConfigServer
Le microservice ConfigServer centralise toutes les configurations nécessaires pour les microservices de l'application, permettant ainsi une gestion plus flexible et centralisée des paramètres de configuration.

5. Sécurité avec Keycloak
Keycloak est utilisé pour sécuriser l'application. L'API Gateway interagit avec Keycloak pour générer un token d'accès pour les utilisateurs. Ce token est utilisé pour authentifier et autoriser l'accès aux autres microservices.

6. Microservice User (Node.js)
Un microservice User a été développé en Node.js avec MongoDB pour gérer les informations des utilisateurs. Ce microservice permet d'enregistrer et de gérer les utilisateurs de l'application.

7. Conteneurisation avec Docker
L'application a été conteneurisée en utilisant Docker Compose, permettant ainsi de faciliter le déploiement et la gestion des différents microservices et de leurs dépendances.

Technologies Utilisées : 
Spring Boot : Framework pour les microservices.
Node.js et MongoDB : Utilisé pour le microservice User.
Docker et Docker Compose : Conteneurisation des services.
Keycloak : Gestion de la sécurité et de l'authentification.
Eureka : Service de découverte d'instances.
H2 et MySQL : Bases de données utilisées pour les différents microservices.

Déploiement : 
Étapes de Déploiement
-Cloner le dépôt Git contenant les microservices.
-Configurer Docker Compose pour lancer tous les services.
-Vérifier la configuration de Keycloak pour la gestion des utilisateurs et des tokens d'accès.
-Lancer les microservices via Docker Compose pour un déploiement local ou en production.

Conclusion : 
Ce projet montre l'utilisation de plusieurs microservices pour construire une application de gestion de restaurant moderne, sécurisée et flexible. L'architecture microservices permet une extensibilité et une indépendance de chaque module, facilitant ainsi les mises à jour et le maintien de l'application.
