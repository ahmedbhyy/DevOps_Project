# Utiliser une image de base Java
FROM openjdk:11

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar généré dans le répertoire de travail
COPY target/DevOps_Project-2.1.jar /app/DevOps_Project-2.1.jar

# Exposer le port sur lequel l'application Java s'exécute (ajuster si nécessaire)
EXPOSE 8090

# Commande pour démarrer l'application au lancement du conteneur
CMD ["java", "-jar", "DevOps_Project-2.1.jar"]