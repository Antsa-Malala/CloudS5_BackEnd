DROP DATABASE vente_vehicule;
CREATE DATABASE vente_vehicule;
\c vente_vehicule

CREATE TABLE ville(
    id_ville SERIAL PRIMARY KEY,
    nom_ville VARCHAR(100),
    etat INT
);

CREATE TABLE couleur(
    id_couleur SERIAL PRIMARY KEY,
    nom_couleur VARCHAR(100),
    etat INT
);