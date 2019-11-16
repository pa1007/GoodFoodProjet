insert into Serveur
values (1, 'Tutus', 'Peter', 'maitre d''hotel');
insert into Serveur
values (2, 'Lilo', 'Vito', 'serveur g1');
insert into Serveur
values (3, 'Don', 'Carl', 'serveur g2');
insert into Serveur
values (4, 'Leo', 'Jon', 'serveur g1');
insert into Serveur
values (5, 'Dean', 'Geak', 'chef serveur');

insert into Plat(idPlat, libelle, numtype, prix)
values (1, 'assiette de crudités', 1, 25);
insert into Plat(idPlat, libelle, numtype, prix)
values (2, 'tarte de saison', 6, 25);
insert into Plat(idPlat, libelle, numtype, prix)
values (3, 'sorbet mirabelle', 6, 35);
insert into Plat(idPlat, libelle, numtype, prix)
values (4, 'filet de boeuf', 2, 62);
insert into Plat(idPlat, libelle, numtype, prix)
values (5, 'salade verte', 1, 15);
insert into Plat(idPlat, libelle, numtype, prix)
values (6, 'chevre chaud', 1, 21);
insert into Plat(idPlat, libelle, numtype, prix)
values (7, 'pate lorrain', 1, 25);
insert into Plat(idPlat, libelle, numtype, prix)
values (8, 'saumon fumé', 1, 30);
insert into Plat(idPlat, libelle, numtype, prix)
values (9, 'entrecote printaniere', 2, 58);
insert into Plat(idPlat, libelle, numtype, prix)
values (10, 'gratin dauphinois', 4, 42);
insert into Plat(idPlat, libelle, numtype, prix)
values (11, 'brochet à l''oseille', 3, 68);
insert into Plat(idPlat, libelle, numtype, prix)
values (12, 'gigot d''agneau', 2, 56);
insert into Plat(idPlat, libelle, numtype, prix)
values (13, 'crème caramel', 6, 15);
insert into Plat(idPlat, libelle, numtype, prix)
values (14, 'munster au cumin', 5, 18);
insert into Plat(idPlat, libelle, numtype, prix)
values (15, 'filet de sole au beurre', 3, 70);
insert into Plat(idPlat, libelle, numtype, prix)
values (16, 'fois gras de lorraine', 1, 61);

insert into `Table`
values (10, 4, 'SA1');
insert into `Table`
values (11, 6, 'SA1');
insert into `Table`
values (12, 8, 'SA1');
insert into `Table`
values (13, 4, 'SA2');
insert into `Table`
values (14, 6, 'SA1');
insert into `Table`
values (15, 4, 'SA1');
insert into `Table`
values (16, 4, 'SA2');
insert into `Table`
values (17, 6, 'SA1');
insert into `Table`
values (18, 2, 'SA1');
insert into `Table`
values (19, 4, 'SA2');

insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (100, 10, str_to_date('10/09/2016', '%d/%m/%Y'), 2, str_to_date('10/09/2016 20:50', '%d/%m/%Y %H:%i'), 'Carte',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (101, 11, str_to_date('10/09/2016', '%d/%m/%Y'), 4, str_to_date('10/09/2016 21:20', '%d/%m/%Y %H:%i'), 'Chèque',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (102, 17, str_to_date('10/09/2016', '%d/%m/%Y'), 2, str_to_date('10/09/2016 20:55', '%d/%m/%Y %H:%i'), 'Carte',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (103, 12, str_to_date('10/09/2016', '%d/%m/%Y'), 2, str_to_date('10/09/2016 21:10', '%d/%m/%Y %H:%i'), 'Espèces',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (104, 18, str_to_date('10/09/2016', '%d/%m/%Y'), 1, str_to_date('10/09/2016 21:00', '%d/%m/%Y %H:%i'), 'Chèque',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (105, 10, str_to_date('10/09/2016', '%d/%m/%Y'), 2, str_to_date('10/09/2016 20:45', '%d/%m/%Y %H:%i'), 'Carte',
        0);
insert into Commande(NumCommande, numTable, dateCommande, NbPersonne, dateEncaissement, modePaiement, MontantTotal)
values (106, 14, str_to_date('11/10/2016', '%d/%m/%Y'), 2, str_to_date('11/10/2016 22:45', '%d/%m/%Y %H:%i'), 'Carte',
        0);

insert into affecter
values (10, str_to_date('10/09/2016', '%d/%m/%Y'), 1);
insert into affecter
values (11, str_to_date('10/09/2016', '%d/%m/%Y'), 1);
insert into affecter
values (12, str_to_date('10/09/2016', '%d/%m/%Y'), 1);
insert into affecter
values (17, str_to_date('10/09/2016', '%d/%m/%Y'), 2);
insert into affecter
values (18, str_to_date('10/09/2016', '%d/%m/%Y'), 2);
insert into affecter
values (15, str_to_date('10/09/2016', '%d/%m/%Y'), 3);
insert into affecter
values (16, str_to_date('10/09/2016', '%d/%m/%Y'), 3);
insert into affecter
values (10, str_to_date('11/09/2016', '%d/%m/%Y'), 1);

insert into contient
values (100, 4, 2);
insert into contient
values (100, 5, 2);
insert into contient
values (100, 13, 1);
insert into contient
values (100, 3, 1);
insert into contient
values (101, 7, 2);
insert into contient
values (101, 16, 2);
insert into contient
values (101, 12, 2);
insert into contient
values (101, 15, 2);
insert into contient
values (101, 2, 2);
insert into contient
values (101, 3, 2);
insert into contient
values (102, 1, 2);
insert into contient
values (102, 10, 2);
insert into contient
values (102, 14, 2);
insert into contient
values (102, 2, 1);
insert into contient
values (102, 3, 1);
insert into contient
values (103, 9, 2);
insert into contient
values (103, 14, 2);
insert into contient
values (103, 2, 1);
insert into contient
values (103, 3, 1);
insert into contient
values (104, 7, 1);
insert into contient
values (104, 11, 1);
insert into contient
values (104, 14, 1);
insert into contient
values (104, 3, 1);
insert into contient
values (105, 3, 2);
insert into contient
values (106, 3, 2);

insert into type (idType, nomType)
values (1, 'Entrée');
insert into type (idType, nomType)
values (2, 'Viande');
insert into type (idType, nomType)
values (3, 'Poisson');
insert into type (idType, nomType)
values (4, 'Plat');
insert into type (idType, nomType)
values (5, 'Fromage');
insert into type (idType, nomType)
values (6, 'Dessert');

insert into Salle (numSalle, nomSalle, NumRestaurant)
values ('SA1', 'paris', 'R1');
insert into Salle (numSalle, nomSalle, NumRestaurant)
values ('SA2', 'London', 'R1');

insert into Restaurant (numRestaurant, Nom)
values ('R1', 'Monde');

create table Commande (
    NumCommande varchar(30) not null primary key,
    dateCommande datetime not null,
    dateEncaissement datetime not null,
    MontantTotal decimal(11) not null,
    NbPersonne int not null,
    numTable varchar(30) not null,
    modePaiement varchar(15) not null
);

create table Plat (
    libelle varchar(30) not null,
    idPlat int not null primary key,
    prix decimal not null,
    numtype int not null
);

create table Restaurant (
    numRestaurant varchar(30) not null primary key,
    Nom varchar(50) not null
);

create table Salle (
    numSalle varchar(30) not null primary key,
    nomSalle varchar(50) not null,
    NumRestaurant varchar(30) not null
);

create table Serveur (
    numServeur varchar(30) not null primary key,
    nom varchar(50) not null,
    prenom varchar(50) not null,
    grade varchar(30) not null
);

create table `Table` (
    NumTable varchar(30) not null primary key,
    PlaceMax int not null,
    NumSalle varchar(30) not null
);

create table affecter (
    numTab int not null,
    dataff date not null,
    numserv int not null,
    primary key (numTab, dataff)
);

create table auditer (
    numcom int not null primary key,
    numtab int null,
    datcom date null,
    nbpers int null,
    datpaie date null,
    montcom decimal null
);

create table contient (
    NumCommande varchar(30) not null,
    idPlat int not null,
    quantite int not null,
    primary key (NumCommande, idPlat)
);

create table type (
    idType int not null primary key,
    nomType varchar(15) not null
);
