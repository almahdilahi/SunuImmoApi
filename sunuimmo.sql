-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Jeu 08 Août 2019 à 02:02
-- Version du serveur: 5.5.27
-- Version de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `sunuimmo`
--

-- --------------------------------------------------------

--
-- Structure de la table `bailleur`
--

CREATE TABLE IF NOT EXISTS `bailleur` (
  `idBa` int(11) NOT NULL AUTO_INCREMENT,
  `nomBa` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `tel` int(9) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`idBa`),
  UNIQUE KEY `tel` (`tel`),
  KEY `type` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `bailleur`
--

INSERT INTO `bailleur` (`idBa`, `nomBa`, `adresse`, `tel`, `type`) VALUES
(1, 'Khadim', 'hlm', 771456732, 1),
(2, 'Niass', 'Dakar', 77689509, 2);

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

CREATE TABLE IF NOT EXISTS `bien` (
  `idB` int(11) NOT NULL AUTO_INCREMENT,
  `nomB` varchar(100) NOT NULL,
  `prix` int(254) NOT NULL,
  `photo1` longblob,
  `photo2` longblob,
  `photo3` longblob,
  `photo4` longblob,
  `etat` int(11) NOT NULL,
  `proprietaire` int(11) DEFAULT NULL,
  PRIMARY KEY (`idB`),
  KEY `proprietaire` (`proprietaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `bien`
--

INSERT INTO `bien` (`idB`, `nomB`, `prix`, `photo1`, `photo2`, `photo3`, `photo4`, `etat`, `proprietaire`) VALUES
(1, 'Ordinateur', 400000, NULL, NULL, NULL, NULL, 0, NULL),
(2, 'sunupetrole', 400000, NULL, NULL, NULL, NULL, 0, NULL),
(3, 'delete', 100000, NULL, NULL, NULL, NULL, 0, NULL),
(5, 'TRY', 8000, NULL, NULL, NULL, NULL, 0, NULL),
(6, 'OOOO', 1000, NULL, NULL, NULL, NULL, 0, NULL),
(7, 'NIASS', 5000, NULL, NULL, NULL, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `INE` int(255) NOT NULL,
  `nomcomplet` varchar(100) NOT NULL,
  `tel` int(9) NOT NULL,
  `profession` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `datenaiss` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `photo` longblob,
  PRIMARY KEY (`idC`),
  UNIQUE KEY `INE` (`INE`,`tel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idC`, `INE`, `nomcomplet`, `tel`, `profession`, `adresse`, `datenaiss`, `email`, `photo`) VALUES
(1, 199677345, 'Limamou Laye Ka', 781376646, 'Développeur', 'Malika Est', '1996-10-07', 'almahdilaye@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `idL` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `bien` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  `bailleur` int(11) DEFAULT NULL,
  PRIMARY KEY (`idL`),
  KEY `bien` (`bien`,`client`,`bailleur`),
  KEY `client` (`client`),
  KEY `bailleur` (`bailleur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `idP` int(11) NOT NULL,
  `idL` int(11) NOT NULL,
  `typePaiement` int(11) NOT NULL,
  `montant` int(100) NOT NULL,
  PRIMARY KEY (`idP`),
  KEY `idL` (`idL`,`typePaiement`),
  KEY `typePaiement` (`typePaiement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typebailleur`
--

CREATE TABLE IF NOT EXISTS `typebailleur` (
  `idTB` int(11) NOT NULL AUTO_INCREMENT,
  `nomTB` varchar(100) NOT NULL,
  PRIMARY KEY (`idTB`),
  UNIQUE KEY `nomTB` (`nomTB`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `typebailleur`
--

INSERT INTO `typebailleur` (`idTB`, `nomTB`) VALUES
(2, 'simple'),
(1, 'special');

-- --------------------------------------------------------

--
-- Structure de la table `typepaiement`
--

CREATE TABLE IF NOT EXISTS `typepaiement` (
  `idTP` int(11) NOT NULL,
  `nomTP` varchar(100) NOT NULL,
  PRIMARY KEY (`idTP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `bailleur`
--
ALTER TABLE `bailleur`
  ADD CONSTRAINT `bailleur_ibfk_1` FOREIGN KEY (`type`) REFERENCES `typebailleur` (`idTB`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `bien_ibfk_1` FOREIGN KEY (`proprietaire`) REFERENCES `bailleur` (`idBa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`idC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`bien`) REFERENCES `bien` (`idB`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `location_ibfk_3` FOREIGN KEY (`bailleur`) REFERENCES `bailleur` (`idBa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`typePaiement`) REFERENCES `typepaiement` (`idTP`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paiement_ibfk_2` FOREIGN KEY (`idL`) REFERENCES `location` (`idL`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
