SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `carnet_sante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `poids` int(11) DEFAULT NULL,
  `traitements_en_cours` varchar(250) DEFAULT NULL,
  `idutilisateur` int(11) NOT NULL,
  `groupe_sanguin` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `centre_medical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medecin_gerant` varchar(100) NOT NULL,
  `adresse_centre` varchar(250) NOT NULL,
  `nb_patients` int(11) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `centre_medical` (`id`, `medecin_gerant`, `adresse_centre`, `nb_patients`, `telephone`) VALUES
(1, 'Dr Kalanithi Jeevanath', '4 Boulevard De La Vie - 75011 PARIS', 1, '0139383736');

CREATE TABLE IF NOT EXISTS `commentaire_medicament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` text,
  `date_envoi` datetime DEFAULT NULL,
  `auteur_idutilisateur` int(11) NOT NULL,
  `critique_idinfo_medicament` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `info_medicament` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `fabriquant` varchar(45) NOT NULL,
  `date_production` date NOT NULL,
  `date_peremption` date NOT NULL,
  `note` int(11) DEFAULT NULL,
  `reference` varchar(10) DEFAULT NULL,
  `list_medicaments_idlist_medicaments` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `liste_traitement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `traitement_0` varchar(45) NOT NULL,
  `traitement_1` varchar(45) NOT NULL,
  `traitement_2` varchar(45) NOT NULL,
  `traitement_3` varchar(45) NOT NULL,
  `traitement_4` varchar(45) NOT NULL,
  `traitement_5` varchar(45) NOT NULL,
  `traitement_6` varchar(45) NOT NULL,
  `carnet_sante_idcarnet_sante` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `list_medicaments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicament_0` varchar(45) NOT NULL,
  `medicament_01` varchar(45) DEFAULT NULL,
  `medicament_02` varchar(45) DEFAULT NULL,
  `medicament_03` varchar(45) DEFAULT NULL,
  `medicament_04` varchar(45) DEFAULT NULL,
  `liste_traitement_idliste_traitement` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_list_medicaments_liste_traitement1_idx` (`liste_traitement_idliste_traitement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(65) NOT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `adresse` varchar(250) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `statut_user` tinyint(1) DEFAULT NULL,
  `centre_medical_idcentre_medical` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `mail`, `mot_de_passe`, `adresse`, `telephone`, `statut_user`, `centre_medical_idcentre_medical`) VALUES
(1, 'SAINT FLEUR', 'Jules', 'jules@hotmail.fr', '123aze', '28, Avenue des Roses', '0651525354', 3, 1),
(2, 'SAINT FLEUR', 'Steve', 'ssf@hotmail.fr', '123aze', '28, Avenue des Roses', '0648636461', 1, 1),
(3, 'Kalanithi', 'Jeevanath', 'jk@hotmail.fr', 'azerty', '123 rue bidon -95700 Roissy en France', '0123568974', 2, 1),
(4, 'guhvbiodnjk', 'Jeanne', 'null', '[C@63c9dd1b', 'ihbovfjnkp - 95190GOUSS', '0139929456', 1, 1),
(5, 'guhvbiodnjk', 'Jeanne', 'null', '[C@45291a9', 'ihbovfjnkp - 95190GOUSS', '0139929456', 1, 1),
(6, 'hfcgvbl', 'fcghkvlbj', 'null', '[C@5e90dcb8', 'rxtcvbykul - txrcyvubio tryvtubiyou', '0139929456', 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
