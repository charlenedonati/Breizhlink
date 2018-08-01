-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 01 Août 2018 à 14:32
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `project_breizhlink`
--

-- --------------------------------------------------------

--
-- Structure de la table `url`
--

CREATE TABLE `url` (
  `id_url` int(11) NOT NULL,
  `url` varchar(50) NOT NULL,
  `url_racc` varchar(50) NOT NULL,
  `date_crea` date NOT NULL,
  `nb_vues` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `url`
--

INSERT INTO `url` (`id_url`, `url`, `url_racc`, `date_crea`, `nb_vues`) VALUES
(1, 'http://localhost/phpmyadmin/sql.php', 'https://aaabaacgda.com', '2018-08-01', 10),
(2, 'http://www.google.fr', 'https://aaaaaaacgb.com', '2018-08-01', 5),
(3, 'https://www.sitescu.fr', 'https://aaaaacdehe.com', '2018-08-01', 2),
(24, 'http://www.applicationBreizhlink.fr', 'https://aaaaaacgga.com', '2018-08-01', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`login`, `email`, `password`) VALUES
('Admin', 'admin@admin.fr', 'admin'),
('Test', 'test@test.fr', 'test');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `url`
--
ALTER TABLE `url`
  ADD PRIMARY KEY (`id_url`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `url`
--
ALTER TABLE `url`
  MODIFY `id_url` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
