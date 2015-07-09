-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 09 Juillet 2015 à 16:36
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `mydb`
--

-- --------------------------------------------------------

--
-- Structure de la table `carnet_sante`
--

CREATE TABLE IF NOT EXISTS `carnet_sante` (
  `idcarnet_sante` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `traitements_en_cours` varchar(250) DEFAULT NULL,
  `utilisateur_idutilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idcarnet_sante`),
  KEY `fk_carnet_sante_utilisateur_idx` (`utilisateur_idutilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `centre_medical`
--

CREATE TABLE IF NOT EXISTS `centre_medical` (
  `idcentre_medical` int(11) NOT NULL,
  `medecin_gerant` varchar(100) NOT NULL,
  `adresse_centre` varchar(250) NOT NULL,
  `nb_patients` int(11) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`idcentre_medical`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `centre_medical`
--

INSERT INTO `centre_medical` (`idcentre_medical`, `medecin_gerant`, `adresse_centre`, `nb_patients`, `telephone`) VALUES
(1, 'Dr Queen Perkins', '40, allé des soigneurs-95190 GOUSSAINVILLE', 2, '01.36.35.34.91');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire_medicament`
--

CREATE TABLE IF NOT EXISTS `commentaire_medicament` (
  `idcommentaire_medicament` int(11) NOT NULL,
  `commentaire` text,
  `date_envoi` datetime DEFAULT NULL,
  `auteur_idutilisateur` int(11) NOT NULL,
  `critique_idinfo_medicament` int(11) NOT NULL,
  PRIMARY KEY (`idcommentaire_medicament`),
  KEY `fk_commentaire_medicament_utilisateur1_idx` (`auteur_idutilisateur`),
  KEY `fk_commentaire_medicament_info_medicament1_idx` (`critique_idinfo_medicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `info_medicament`
--

CREATE TABLE IF NOT EXISTS `info_medicament` (
  `idinfo_medicament` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `fabriquant` varchar(45) NOT NULL,
  `date_production` date NOT NULL,
  `date_peremption` date NOT NULL,
  `note` int(11) DEFAULT NULL,
  `reference` varchar(10) DEFAULT NULL,
  `list_medicaments_idlist_medicaments` int(11) NOT NULL,
  PRIMARY KEY (`idinfo_medicament`),
  KEY `fk_info_medicament_list_medicaments1_idx` (`list_medicaments_idlist_medicaments`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `liste_traitement`
--

CREATE TABLE IF NOT EXISTS `liste_traitement` (
  `idliste_traitement` int(11) NOT NULL,
  `traitement_0` varchar(45) NOT NULL,
  `traitement_1` varchar(45) NOT NULL,
  `traitement_2` varchar(45) NOT NULL,
  `traitement_3` varchar(45) NOT NULL,
  `traitement_4` varchar(45) NOT NULL,
  `traitement_5` varchar(45) NOT NULL,
  `traitement_6` varchar(45) NOT NULL,
  `carnet_sante_idcarnet_sante` int(11) NOT NULL,
  PRIMARY KEY (`idliste_traitement`),
  KEY `fk_liste_traitement_carnet_sante1_idx` (`carnet_sante_idcarnet_sante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `list_medicaments`
--

CREATE TABLE IF NOT EXISTS `list_medicaments` (
  `idlist_medicaments` int(11) NOT NULL,
  `medicament_0` varchar(45) NOT NULL,
  `medicament_01` varchar(45) DEFAULT NULL,
  `medicament_02` varchar(45) DEFAULT NULL,
  `medicament_03` varchar(45) DEFAULT NULL,
  `medicament_04` varchar(45) DEFAULT NULL,
  `liste_traitement_idliste_traitement` int(11) NOT NULL,
  PRIMARY KEY (`idlist_medicaments`),
  KEY `fk_list_medicaments_liste_traitement1_idx` (`liste_traitement_idliste_traitement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idutilisateur` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(65) NOT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `adresse` varchar(250) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `is_patient` tinyint(1) DEFAULT NULL,
  `is_medecin` tinyint(1) DEFAULT NULL,
  `is_pharmacie` tinyint(1) DEFAULT NULL,
  `centre_medical_idcentre_medical` int(11) NOT NULL,
  PRIMARY KEY (`idutilisateur`),
  KEY `fk_utilisateur_centre_medical1_idx` (`centre_medical_idcentre_medical`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idutilisateur`, `nom`, `prenom`, `mail`, `mot_de_passe`, `adresse`, `telephone`, `is_patient`, `is_medecin`, `is_pharmacie`, `centre_medical_idcentre_medical`) VALUES
(1, 'SAINT FLEUR', 'Steve', 'dj509@hotmail.fr', '123aze', '28 avenue Buffon - 95190 Goussainville', '0783718080', 0, 1, 0, 1),
(2, 'SAINT FLEUR', 'Jean Pierre', 'jp@gmail.com', '123azer', '28 avenue Buffon - 95190 Goussainville', '0651525354', 1, 0, 0, 1),
(3, 'HOCINI', 'Oualid', 'hocini.oualid@gmail.com', '123azer', '64 Avenue Georges Brassens - 95190 Goussainville', '0648636461', 1, 0, 0, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `carnet_sante`
--
ALTER TABLE `carnet_sante`
  ADD CONSTRAINT `fk_carnet_sante_utilisateur` FOREIGN KEY (`utilisateur_idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `commentaire_medicament`
--
ALTER TABLE `commentaire_medicament`
  ADD CONSTRAINT `fk_commentaire_medicament_info_medicament1` FOREIGN KEY (`critique_idinfo_medicament`) REFERENCES `info_medicament` (`idinfo_medicament`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_commentaire_medicament_utilisateur1` FOREIGN KEY (`auteur_idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `info_medicament`
--
ALTER TABLE `info_medicament`
  ADD CONSTRAINT `fk_info_medicament_list_medicaments1` FOREIGN KEY (`list_medicaments_idlist_medicaments`) REFERENCES `list_medicaments` (`idlist_medicaments`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `liste_traitement`
--
ALTER TABLE `liste_traitement`
  ADD CONSTRAINT `fk_liste_traitement_carnet_sante1` FOREIGN KEY (`carnet_sante_idcarnet_sante`) REFERENCES `carnet_sante` (`idcarnet_sante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `list_medicaments`
--
ALTER TABLE `list_medicaments`
  ADD CONSTRAINT `fk_list_medicaments_liste_traitement1` FOREIGN KEY (`liste_traitement_idliste_traitement`) REFERENCES `liste_traitement` (`idliste_traitement`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_utilisateur_centre_medical1` FOREIGN KEY (`centre_medical_idcentre_medical`) REFERENCES `centre_medical` (`idcentre_medical`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
