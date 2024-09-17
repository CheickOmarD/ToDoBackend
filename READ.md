# ToDo Application

## Description

ToDo est une application de gestion des tâches développée en **Java Spring Boot** avec un backend en **spring boot 3.2.3**. L'application permet aux utilisateurs de créer, gérer et assigner des tâches. Elle implémente également un système de sécurité basé sur **Spring Security** avec **JWT** pour gérer l'authentification et les autorisations des utilisateurs.

## Fonctionnalités

- Authentification des utilisateurs avec JWT.
- Gestion des rôles (utilisateur, administrateur).
- Création, mise à jour, suppression et visualisation des tâches.
- Assignation de tâches à des utilisateurs spécifiques.
- Gestion des statuts des tâches (en cours, terminé, etc.).
- Sécurisation des accès avec des rôles basés sur les tâches (RBAC).

## Technologies Utilisées

- **Backend**: Java Spring Boot
- **Base de données**: PostgreSQL
- **Sécurité**: Spring Security, JWT
- **IDE**: Visual Studio Code

## Installation

### Prérequis

- Java 22 
- Maven
- PostgreSQL

### Étapes d'installation

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/votre-repo/todo-app.git
   cd todo-app
Configurer la base de données :

Créez une base de données PostgreSQL appelée todo_db.
Mettez à jour le fichier application.properties avec vos informations de connexion :
properties
Copier le code
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=postgres
spring.datasource.password=PASSWORD
spring.jpa.hibernate.ddl-auto=update
Compiler et exécuter le backend :

bash
Copier le code
mvn clean install
mvn spring-boot:run


Utilisation
Authentification
L'application utilise JWT pour authentifier les utilisateurs. Lors de la connexion, un token est généré et utilisé pour sécuriser les requêtes ultérieures.

Gestion des Tâches
Les utilisateurs peuvent :

Créer une tâche
Modifier une tâche existante
Supprimer une tâche
Visualiser la liste des tâches
Assigner une tâche à un autre utilisateur
API Endpoints
Utilisateur
POST /auth/signup: Créer un nouvel utilisateur.
POST /auth/signin: Authentifier un utilisateur.
Tâche
POST /taches: Créer une nouvelle tâche.
GET /taches: Récupérer toutes les tâches.
PUT /taches/{id}: Mettre à jour une tâche.
DELETE /taches/{id}: Supprimer une tâche.