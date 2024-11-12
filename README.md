# 🍽️ Application de Restauration - Documentation

## 📝 Introduction
L'application de restauration est construite avec une architecture **microservices**, où chaque module représente une fonctionnalité spécifique. La majorité des microservices sont développés avec **Spring Boot**, tandis qu'un microservice de gestion des utilisateurs utilise **Node.js** et **MongoDB**.

L'ensemble de l'application est conteneurisé à l'aide de **Docker Compose** pour une gestion simplifiée, et sécurisé avec **Keycloak** pour l'authentification et l'autorisation.

---

## 🏛️ Architecture de l'Application

### Microservices Spring Boot
L'application se compose de plusieurs microservices, chacun ayant une fonction distincte :

| Microservice          | Base de données | Fonctionnalité                               |
|-----------------------|-----------------|----------------------------------------------|
| Reclamation           | H2              | Gestion des réclamations clients            |
| GestionStock          | MySQL           | Gestion des stocks                          |
| GestionLivraison      | H2              | Suivi des livraisons                        |
| GestionCommandes      | H2              | Gestion des commandes clients               |
| GestionMenu           | MySQL           | Gestion des menus du restaurant             |
| API Gateway           | -               | Redirection des requêtes vers les services  |
| Eureka                | -               | Service de découverte des microservices     |

### Communication entre Microservices
- **Livraison <-> Commandes** : Coordination pour les commandes en attente de livraison
- **Livraison <-> Réclamations** : Consultation des réclamations liées aux commandes

### Microservice User (Node.js)
- **Base de données** : MongoDB
- **Fonction** : Gestion des informations utilisateurs

### Microservice ConfigServer
Le **ConfigServer** centralise toutes les configurations nécessaires pour les microservices, ce qui facilite la gestion des paramètres de configuration.

---

## 🔒 Sécurité avec Keycloak
**Keycloak** est utilisé pour gérer l'authentification et l'autorisation :

1. **Génération de tokens JWT** : L’API Gateway génère un token JWT pour chaque utilisateur authentifié.
2. **Validation des tokens** : Les autres microservices vérifient les tokens pour autoriser ou restreindre l'accès.
3. **Gestion des rôles** : Les rôles définis dans Keycloak régissent les permissions d'accès aux différents services.

### Exemple de Configuration dans Keycloak
- **Clients** : Créez un client pour l’API Gateway dans Keycloak et configurez les URI de redirection et la validation des tokens.
- **Rôles et utilisateurs** : Créez des rôles (ex. : `user`, `admin`) et attribuez-les aux utilisateurs.

---

## 🛠️ Technologies Utilisées
- **Spring Boot** : Développement des microservices.
- **Node.js et MongoDB** : Gestion des utilisateurs.
- **Docker et Docker Compose** : Conteneurisation.
- **Keycloak** : Gestion de la sécurité.
- **Eureka** : Service de découverte des instances.
- **Bases de données** : H2 et MySQL.

---

## 🚀 Déploiement

### Exigences Préalables
- **Git** : Pour cloner le dépôt
- **Docker & Docker Compose** : Assurez-vous que Docker est installé

### Étapes de Déploiement
1. **Cloner le dépôt** :
   ```bash
   git clone <URL_du_dépôt>
   cd <nom_du_dépôt>
2. **Configurer Docker-compose** :

- Ouvrez le fichier `docker-compose.yml` et ajustez les paramètres pour chaque microservice si nécessaire.
- Assurez-vous que chaque service est bien configuré pour fonctionner dans Docker.
3. **Configurer Keycloak** :
  - Accédez à l'interface Keycloak (généralement à [http://localhost:8080/auth](http://localhost:8080/auth)).
- Créez les clients et configurez les URI de redirection.
- Ajoutez les utilisateurs et assignez des rôles.
4. **Lancer l'application** :
docker-compose up -d
5. **Vérifier l'état des services** :
docker-compose ps
---

## 📋 Conclusion

Ce projet démontre comment une **architecture microservices** facilite le développement d'une application de gestion de restaurant **flexible** et **sécurisée**. En répartissant les fonctionnalités en microservices, chaque module est **indépendant** et **extensible**, ce qui simplifie les mises à jour et rend la maintenance plus aisée.

👉 Pour en savoir plus sur chaque technologie utilisée, consultez la documentation.

📢 **Contribuez !** Vos suggestions et améliorations sont les bienvenues. Proposez des modifications via des pull requests pour aider à faire évoluer le projet !

---

