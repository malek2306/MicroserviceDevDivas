🍽️ Application de Restauration - Architecture Microservices
Bienvenue dans le dépôt de l'application de restauration, construite en utilisant une architecture microservices pour gérer les différentes fonctionnalités d'un restaurant. Chaque microservice est conteneurisé via Docker et orchestré avec Docker Compose pour un déploiement simplifié.

📑 Table des matières
Aperçu de l'Architecture
Services et Microservices
Technologies Utilisées
Déploiement
Exigences Préalables
Lancer l'Application
Sécurité
Conclusion
📐 Aperçu de l'Architecture
L'application utilise une architecture microservices où chaque module répond à un besoin spécifique :

Spring Boot pour les microservices principaux
Node.js et MongoDB pour le microservice de gestion des utilisateurs
Keycloak pour l'authentification et l'autorisation
Docker Compose pour une gestion simplifiée des conteneurs
Les microservices sont interconnectés pour gérer les réclamations, les livraisons, les commandes, le stock, et les menus du restaurant.

📦 Services et Microservices
Microservices Spring Boot
Microservice	Base de données	Fonctionnalité
Reclamation	H2	Gestion des réclamations clients
GestionStock	MySQL	Gestion des stocks
GestionLivraison	H2	Suivi des livraisons
GestionCommandes	H2	Gestion des commandes clients
GestionMenu	MySQL	Gestion des menus du restaurant
API Gateway	-	Redirection des requêtes vers les services
Eureka	-	Service de découverte des microservices
Communication entre Microservices
Livraison <-> Commandes : Coordination pour les commandes en attente de livraison
Livraison <-> Réclamations : Consultation des réclamations liées aux commandes
Microservice User (Node.js)
Base de données : MongoDB
Fonction : Gestion des informations utilisateurs
Microservice ConfigServer
Centralise les configurations pour tous les microservices, facilitant ainsi la gestion des paramètres.

🛠️ Technologies Utilisées
Spring Boot : Framework pour les microservices
Node.js et MongoDB : Pour la gestion des utilisateurs
Docker & Docker Compose : Pour la conteneurisation et l'orchestration des services
Keycloak : Pour la gestion de la sécurité et de l'authentification
Eureka : Découverte des services
Bases de données : H2 et MySQL
🚀 Déploiement
Exigences Préalables
Git : Pour cloner le dépôt
Docker & Docker Compose : Assurez-vous que Docker est installé
Étapes de Déploiement
Cloner le dépôt :

bash
Copy code
git clone <URL_du_dépôt>
cd <nom_du_dépôt>
Configurer Docker Compose : Vérifiez et modifiez le fichier docker-compose.yml pour adapter les configurations selon vos besoins.

Configurer Keycloak :

Paramétrez les rôles, les utilisateurs et les clients.
Vérifiez que l'API Gateway est configurée pour générer et valider les tokens.
Démarrer l'application :

bash
Copy code
docker-compose up -d
Accéder aux services :

Accédez à l'API Gateway via http://localhost:<port_gateway>
Accédez à l'interface Keycloak via http://localhost:<port_keycloak>
🔒 Sécurité avec Keycloak
Keycloak sécurise l'application en gérant l'authentification et l'autorisation :

API Gateway génère un token d'accès pour chaque utilisateur.
Les autres microservices vérifient le token pour autoriser l'accès aux fonctionnalités.
📋 Conclusion
Ce projet illustre l’utilisation des microservices pour construire une application de gestion de restaurant moderne et modulaire. L’architecture est extensible et chaque module est indépendant, permettant des mises à jour et un maintien simplifiés.

