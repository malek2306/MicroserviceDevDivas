# Utilise la version correcte de Node.js
FROM node:22.11.0

# Met à jour les dépendances et installe les outils nécessaires
RUN apt-get update && apt-get install -y build-essential

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers package.json et package-lock.json
COPY package*.json ./

# Installe les dépendances
RUN npm install

# Copie le reste du code
COPY . .

# Expose le port que l'application va utiliser
EXPOSE 3000

# Démarre l'application avec npm
CMD ["npm", "start"]