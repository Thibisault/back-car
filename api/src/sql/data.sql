-- Script SQL pour créer la structure de données avec les nouveaux noms

-- 1. Création de la table AppUser
CREATE TABLE AppUser (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- 2. Création de la table ChatMessage
CREATE TABLE ChatMessage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    senderId BIGINT NOT NULL,
    receiverId BIGINT NOT NULL,
    messageContent TEXT NOT NULL,
    timestamp BIGINT NOT NULL,
    FOREIGN KEY (senderId) REFERENCES AppUser(id),
    FOREIGN KEY (receiverId) REFERENCES AppUser(id)
);

-- 3. Ajout d'index pour optimiser les requêtes
CREATE INDEX idx_senderId ON ChatMessage(senderId);
CREATE INDEX idx_receiverId ON ChatMessage(receiverId);

-- 4. Insérer des données d'exemple
INSERT INTO AppUser (name, email, password) VALUES ('Thibault Danis', 'thibault.danis@example.com', 'password123');
INSERT INTO AppUser (name, email, password) VALUES ('Thibia Dania', 'thibia.dania@example.com', 'password456');

INSERT INTO ChatMessage (senderId, receiverId, messageContent, timestamp) VALUES (1, 2, 'Hello Thibia!', 1619500200);
INSERT INTO ChatMessage (senderId, receiverId, messageContent, timestamp) VALUES (2, 1, 'Hi Thibault!', 1619500800);
