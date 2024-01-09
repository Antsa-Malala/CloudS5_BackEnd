create database vente_vehicule;

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

create sequence seq_utilisateur start 1 increment 1;
create table utilisateur(
    id_utilisateur varchar(10) default 'USR' || nextval('seq_utilisateur') primary key,
    nom varchar(100) not null,
    id_ville int references ville(id_ville),
    prenom varchar(100) not null,
    adresse varchar(100) not null,
    contact varchar(20) not null,
    mail varchar(150) not null,
    mot_de_passe varchar(150) not null,
    role int not null
);
select * from utilisateur;
insert into utilisateur(id_utilisateur,nom,id_ville,prenom,adresse,contact,mail,mot_de_passe,role) values('USR' || nextval('seq_utilisateur'),'koto',3,'fenitra','IC11 Ter C Tana', '034 12 345 45','koto@gmail.com', 'rakoto',0);
insert into utilisateur(id_utilisateur,nom,id_ville,prenom,adresse,contact,mail,mot_de_passe,role) values('USR' || nextval('seq_utilisateur'),'rak',3,'rabe','IC11 Ter C Tana', '034 12 163 67','to562@gmail.com', 'rakoto',0);
insert into utilisateur(id_utilisateur,nom,id_ville,prenom,adresse,contact,mail,mot_de_passe,role) values('USR' || nextval('seq_utilisateur'),'to',3,'antsa','IC11 Ter C Tana', '034 12 345 67','rakoto@gmail.com', 'rakoto',0);
insert into utilisateur(id_utilisateur,nom,id_ville,prenom,adresse,contact,mail,mot_de_passe,role) values('USR' || nextval('seq_utilisateur'),'rakoto',3,'huhu','IC11 Ter C Tana', '034 12 345 67','rak@gmail.com', 'rakoto',1);

create table modele(
    id_modele serial primary key,
    nom_modele varchar(200) not null,
    id_marque int references marque(id_marque),
    id_categorie int references categorie(id_categorie),
    etat int not null
);
select * from marque;
insert into modele(nom_modele,id_marque,id_categorie,etat) values('A1',3,2,0);
insert into modele(nom_modele,id_marque,id_categorie,etat) values('A3',4,2,0);
insert into modele(nom_modele,id_marque,id_categorie,etat) values('A4',5,2,0);
insert into modele(nom_modele,id_marque,id_categorie,etat) values('A5',6,2,0);
insert into modele(nom_modele,id_marque,id_categorie,etat) values('A6',7,2,0);

create table energie(
    id_energie serial primary key,
    nom_energie varchar(100) not null,
    etat int not null
);
insert into energie(nom_energie,etat) values('Essence',0);
insert into energie(nom_energie,etat) values('Diesel',0);
insert into energie(nom_energie,etat) values('Electrique',0);
insert into energie(nom_energie,etat) values('Hybride',0);

create table boite(
    id_boite serial primary key,
    nom_boite varchar(100) not null,
    etat int not null
);
insert into boite(nom_boite,etat) values('Manuelle',0);
insert into boite(nom_boite,etat) values('Automatique',0);

create table couleur(
    id_couleur serial primary key,
    nom_couleur varchar(100) not null,
    etat int not null
);
insert into couleur(nom_couleur,etat) values('Blanc',0);
insert into couleur(nom_couleur,etat) values('Noir',0);
insert into couleur(nom_couleur,etat) values('Gris',0);
insert into couleur(nom_couleur,etat) values('Bleu',0);

create table porte(
    id_porte serial primary key,
    valeur int not null,
    etat int not null
);
-- drop table porte cascade ;
insert into porte(valeur,etat) values(2,0);
insert into porte(valeur,etat) values(3,0);
insert into porte(valeur,etat) values(4,0);
insert into porte(valeur,etat) values(5,0);

create sequence seq_voiture start 1 increment 1;
create table voiture(
    id_voiture varchar(10) default 'VTR' || nextval('seq_voiture') primary key,
    id_categorie int references categorie(id_categorie),
    id_marque int references marque(id_marque),
    id_modele int references modele(id_modele),
    id_energie int references energie(id_energie),
    id_boite int references boite(id_boite),
    consommation decimal(9,2) not null,
    reservoir decimal(9,2) not null,
    id_place int not null ,
    id_porte int references porte(id_porte),
    kilometrage decimal(9,2) not null,
    id_couleur int references couleur(id_couleur),
    etat int not null
);
insert into voiture(id_voiture,id_categorie,id_marque,id_modele,id_energie,id_boite,consommation,reservoir,id_place,id_porte,kilometrage,id_couleur,etat) values('VTR' || nextval('seq_voiture'),2,3,1,1,1,5.5,50,5,1,1000,1,0);
insert into voiture(id_voiture,id_categorie,id_marque,id_modele,id_energie,id_boite,consommation,reservoir,id_place,id_porte,kilometrage,id_couleur,etat) values('VTR' || nextval('seq_voiture'),2,3,1,1,1,5.5,50,5,1,1000,1,0);
insert into voiture(id_voiture,id_categorie,id_marque,id_modele,id_energie,id_boite,consommation,reservoir,id_place,id_porte,kilometrage,id_couleur,etat) values('VTR' || nextval('seq_voiture'),2,3,1,1,1,5.5,50,5,1,1000,1,0);

create sequence seq_annonce start 1 increment 1;
create table annonce(
    id_annonce varchar(10) primary key,
    date_annonce date not null,
    prix decimal(9,2) not null ,
    id_voiture varchar(10) references voiture(id_voiture),
    id_ville int references ville(id_ville),
    description text not null,
    etat int not null,
    id_utilisateur varchar(10) references utilisateur(id_utilisateur)
);
insert into annonce(id_annonce,date_annonce,prix,id_voiture,id_ville,description,etat,id_utilisateur) values('ANN' || nextval('seq_annonce'),current_date,100000,'VTR1',3,'Voiture en bon état',0,'USR2');
insert into annonce(id_annonce,date_annonce,prix,id_voiture,id_ville,description,etat,id_utilisateur) values('ANN' || nextval('seq_annonce'),current_date,10000,'VTR2',4,'Voiture en bon état',1,'USR2');
insert into annonce(id_annonce,date_annonce,prix,id_voiture,id_ville,description,etat,id_utilisateur) values('ANN' || nextval('seq_annonce'),current_date,10000,'VTR3',4,'Voiture en bon état',1,'USR3');

create sequence seq_vente start 1 increment 1;
create table vente(
    id_vente varchar(10) primary key,
    id_annonce varchar(10) references annonce(id_annonce),
    date_vente date not null
);

create sequence seq_validation start 1 increment 1;
create table validation(
    id_validation varchar(10) primary key,
    date_validation date not null,
    id_utilisateur varchar(10) references utilisateur(id_utilisateur),
    id_annonce varchar(10) references annonce(id_annonce)
);
select * from v_NbUtilisateur;
create view v_NbUtilisateur as
    select count(*) as nb_utilisateur from utilisateur where role = 0;

select * from v_VenduByPrix;
drop view v_VenduByPrix;
create or replace view v_VenduByPrix as
    select a.prix from vente join annonce a on a.id_annonce = vente.id_annonce;
select count(*) as nb from v_VenduByPrix where prix between 10000 and 100000;

create view v_AnnonceByMarque as
    select m.nom_marque , count(*) as nb_annonce from annonce join voiture v on v.id_voiture = annonce.id_voiture join marque m on m.id_marque = v.id_marque where annonce.etat = 10 group by m.nom_marque;
select nb_annonce from v_AnnonceByMarque where nom_marque ilike 'Mercedes';

create view v_BeneficeByMois as
    select date_part('month',v.date_vente) as mois , date_part('year',v.date_vente) as annee, sum(a.prix*0.0001) as benefice from vente v join annonce a on a.id_annonce = v.id_annonce group by date_part('month',v.date_vente), date_part('year',v.date_vente);
select * from v_BeneficeByMois;




CREATE OR REPLACE FUNCTION f_nbventebyprice(
    prix_min DECIMAL(12, 2),
    prix_max DECIMAL(12, 2),
    pas_prix DECIMAL(12, 2)
)
RETURNS TABLE (
    prix_min DECIMAL(12, 2),
    prix_max DECIMAL(12, 2),
    nb_vente INT
)
AS $$
DECLARE
    prix_min_ DECIMAL(12, 2);
    prix_max_ DECIMAL(12, 2);
    nb_vente_ INT;
BEGIN
    prix_min_ := prix_min;
    prix_max_ := prix_min_ + pas_prix;
    FOR i IN 1..9 LOOP
        SELECT COUNT(*)
        INTO nb_vente_
        FROM vente v
        JOIN annonce a ON v.id_annonce = a.id_annonce
        WHERE a.prix BETWEEN prix_min_ AND prix_max_;

        -- Insert the values into the result set
        RETURN NEXT prix_min_, prix_max_, nb_vente_;

        -- Update the price ranges for the next iteration
        prix_min_ := prix_max_;
        prix_max_ := prix_max_ + pas_prix;
    END LOOP;
END;
$$ LANGUAGE plpgsql;

