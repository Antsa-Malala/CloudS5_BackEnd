
drop database cloud;
CREATE DATABASE cloud;
CREATE user cloud WITH PASSWORD 'cloud';
GRANT ALL PRIVILEGES ON DATABASE "cloud" to cloud;
ALTER DATABASE cloud OWNER TO cloud;


drop table categorie;
create table categorie(
    id_categorie serial primary key,
    nom_categorie varchar(100) not null,
    etat int not null
);
insert into categorie(nom_categorie,etat) values('SUV',0);
insert into categorie(nom_categorie,etat) values('Berline',0);
insert into categorie(nom_categorie,etat) values('Citadine',0);
insert into categorie(nom_categorie,etat) values('Monospace',0);
insert into categorie(nom_categorie,etat) values('Coupé',0);
insert into categorie(nom_categorie,etat) values('Cabriolet',0);
insert into categorie(nom_categorie,etat) values('Pickup',0);
insert into categorie(nom_categorie,etat) values('Utilitaire',0);
insert into categorie(nom_categorie,etat) values('4x4',0);
insert into categorie(nom_categorie,etat) values('Camion',0);
insert into categorie(nom_categorie,etat) values('Bus',0);
insert into categorie(nom_categorie,etat) values('Camionnette',0);
insert into categorie(nom_categorie,etat) values('Remorque',0);
insert into categorie(nom_categorie,etat) values('Tracteur',0);
insert into categorie(nom_categorie,etat) values('Engin',0);

drop table marque;
create table marque(
    id_marque serial primary key,
    nom_marque varchar(100) not null,
    etat int not null
);
insert into marque(nom_marque,etat) values('Mercedes',0);
insert into marque(nom_marque,etat) values('BMW',0);
insert into marque(nom_marque,etat) values('Audi',0);
insert into marque(nom_marque,etat) values('Volkswagen',0);
insert into marque(nom_marque,etat) values('Ford',0);
insert into marque(nom_marque,etat) values('Opel',0);
insert into marque(nom_marque,etat) values('Renault',0);
insert into marque(nom_marque,etat) values('Peugeot',0);
insert into marque(nom_marque,etat) values('Citroen',0);
insert into marque(nom_marque,etat) values('Fiat',0);
insert into marque(nom_marque,etat) values('Toyota',0);
insert into marque(nom_marque,etat) values('Nissan',0);
insert into marque(nom_marque,etat) values('Hyundai',0);
insert into marque(nom_marque,etat) values('Kia',0);
insert into marque(nom_marque,etat) values('Dacia',0);
insert into marque(nom_marque,etat) values('Seat',0);
insert into marque(nom_marque,etat) values('Skoda',0);
insert into marque(nom_marque,etat) values('Mazda',0);
insert into marque(nom_marque,etat) values('Mitsubishi',0);
insert into marque(nom_marque,etat) values('Suzuki',0);
insert into marque(nom_marque,etat) values('Honda',0);
insert into marque(nom_marque,etat) values('Alfa Romeo',0);
insert into marque(nom_marque,etat) values('Lancia',0);
insert into marque(nom_marque,etat) values('Land Rover',0);
insert into marque(nom_marque,etat) values('Jeep',0);
insert into marque(nom_marque,etat) values('Porsche',0);

create table ville(
    id_ville serial primary key,
    nom_ville varchar(100) not null,
    etat int not null
);
insert into ville(nom_ville,etat) values('France',0);
insert into ville(nom_ville,etat) values('Allemagne',0);
insert into ville(nom_ville,etat) values('Italie',0);
insert into ville(nom_ville,etat) values('Espagne',0);
insert into ville(nom_ville,etat) values('Portugal',0);
insert into ville(nom_ville,etat) values('Belgique',0);
insert into ville(nom_ville,etat) values('Suisse',0);
insert into ville(nom_ville,etat) values('Luxembourg',0);
insert into ville(nom_ville,etat) values('Royaume-Uni',0);
insert into ville(nom_ville,etat) values('Pays-Bas',0);



CREATE TABLE Modele(
   id_modele serial,
   nom_modele VARCHAR(200),
   id_marque INT NOT NULL,
   id_categorie INT NOT NULL,
   etat INT,
   PRIMARY KEY(id_modele)
);


-- Insérer des données dans la table Modele en utilisant les marques et catégories existantes

-- Mercedes
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('A-Class', 1, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('C-Class', 1, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('GLE', 1, 1, 0);

-- BMW
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('3 Series', 2, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('X5', 2, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('i3', 2, 3, 0);

-- Audi
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('A4', 3, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Q7', 3, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('TT', 3, 5, 0);

-- Volkswagen
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Golf', 4, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Tiguan', 4, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Passat', 4, 2, 0);

-- Ford
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Fusion', 5, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Escape', 5, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('F-150', 5, 7, 0);

-- Opel
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Astra', 6, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Insignia', 6, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Crossland X', 6, 1, 0);

-- Renault
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Clio', 7, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Megane', 7, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Kadjar', 7, 1, 0);

-- Peugeot
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('208', 8, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('308', 8, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('3008', 8, 1, 0);

-- Citroen
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('C3', 9, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('C4', 9, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('C5 Aircross', 9, 1, 0);

-- Fiat
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('500', 10, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Tipo', 10, 2, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('500X', 10, 1, 0);

-- Toyota
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Corolla', 11, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Rav4', 11, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Camry', 11, 2, 0);

-- Nissan
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Micra', 12, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Qashqai', 12, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('X-Trail', 12, 2, 0);

-- Hyundai
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('i30', 13, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Tucson', 13, 1, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Santa Fe', 13, 2, 0);

-- Kia
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Ceed', 14, 3, 0);
insert into Modele(nom_modele, id_marque, id_categorie, etat) values('Sportage', 14, 1, 0);


CREATE OR REPLACE VIEW v_Modele as
SELECT marque.*,
categorie.*,modele.id_modele,Modele.nom_modele,modele.etat
from Modele
join marque on marque.id_marque=modele.id_marque
join categorie on categorie.id_categorie=modele.id_categorie;

CREATE TABLE Porte(
   id_porte serial,
   valeur INT NOT NULL,
   etat INT,
   PRIMARY KEY(id_porte)
);

INSERT INTO Porte(valeur, etat) VALUES (2, 0);  
INSERT INTO Porte(valeur, etat) VALUES (4, 0);
INSERT INTO Porte(valeur, etat) VALUES (5, 0);  
INSERT INTO Porte(valeur, etat) VALUES (6, 0);  
INSERT INTO Porte(valeur, etat) VALUES (8, 0);  


CREATE TABLE Place(
   id_place serial,
   valeur INT NOT NULL,
   etat INT,
   PRIMARY KEY(id_place)
);

INSERT INTO Place(valeur, etat) VALUES (2, 0);
INSERT INTO Place(valeur, etat) VALUES (4, 0); 
INSERT INTO Place(valeur, etat) VALUES (5, 0); 
INSERT INTO Place(valeur, etat) VALUES (7, 0);  
INSERT INTO Place(valeur, etat) VALUES (9, 0); 
INSERT INTO Place(valeur, etat) VALUES (12, 0); 


