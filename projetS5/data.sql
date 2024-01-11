create table boite(
    id_boite serial primary key,
    nom_boite varchar(100),
    etat int
);

insert into boite values(default, 'Automatique', 0);
insert into boite values(default, 'Manuel', 0);

-- --------------------------------------------------

create table energie(
    id_energie serial primary key,
    nom_energie varchar(100),
    etat int
);

insert into energie values(default, 'Essence', 0);
insert into energie values(default, 'Gasoil', 0);

-- ------------------------------------------

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

-- ------------------------------------------------------

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

-- --------------------------------------------------------


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

-- -----------------------------------------------------
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

-- -------------------------------------------------------------

CREATE TABLE Modele(
   id_modele serial,
   nom_modele VARCHAR(200),
   id_marque INT NOT NULL,
   id_categorie INT NOT NULL,
   etat INT,
   PRIMARY KEY(id_modele),
   FOREIGN KEY(id_marque) references marque(id_marque),
   FOREIGN KEY(id_categorie) references categorie(id_categorie)
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
