-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-12-2015 a las 14:14:51
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `generaldb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `componente`
--

CREATE TABLE IF NOT EXISTS `componente` (
  `nombre_componente` varchar(40) NOT NULL,
  PRIMARY KEY (`nombre_componente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `componente`
--

INSERT INTO `componente` (`nombre_componente`) VALUES
('button_cancelar'),
('button_save'),
('jose'),
('menu_item_conf'),
('nuevoPermiso_fieldNombre'),
('pepe'),
('peperulo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE IF NOT EXISTS `perfil` (
  `nombre_perfil` varchar(40) NOT NULL,
  `estado_perfil` bit(1) DEFAULT NULL,
  PRIMARY KEY (`nombre_perfil`),
  UNIQUE KEY `nombre_perfil` (`nombre_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`nombre_perfil`, `estado_perfil`) VALUES
('administrador', b'0'),
('desarrollador', b'1'),
('tester', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_ventana_componente`
--

CREATE TABLE IF NOT EXISTS `perfil_ventana_componente` (
  `nom_per_vpc` varchar(40) NOT NULL,
  `nom_ven_vpc` varchar(40) NOT NULL,
  `nom_com_vpc` varchar(40) NOT NULL,
  `estado` bit(1) DEFAULT b'0',
  PRIMARY KEY (`nom_per_vpc`,`nom_com_vpc`,`nom_ven_vpc`),
  KEY `fk_nom_com_cp_idx` (`nom_com_vpc`),
  KEY `fk_nom_ven_cp_idx` (`nom_ven_vpc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventana`
--

CREATE TABLE IF NOT EXISTS `ventana` (
  `nombre_ventana` varchar(40) NOT NULL,
  PRIMARY KEY (`nombre_ventana`),
  UNIQUE KEY `nombre_ventana` (`nombre_ventana`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventana`
--

INSERT INTO `ventana` (`nombre_ventana`) VALUES
('ADMINISTRAR_PERMISO_EN_VENTANA'),
('ADMINISTRAR_VENTANAS_A_PERFIL'),
('ASIGNAR_COMPONENTE_A_VENTANA'),
('CREAR_PERFIL'),
('LISTAR_COMPONENTES'),
('LISTA_USUARIOS'),
('NUEVA_VENTANA'),
('NUEVO_COMPONENTE'),
('NUEVO_USUARIO'),
('PANTALLA_PRINCIPAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventana_componente`
--

CREATE TABLE IF NOT EXISTS `ventana_componente` (
  `nom_componente` varchar(40) NOT NULL,
  `nom_ventana` varchar(40) NOT NULL,
  PRIMARY KEY (`nom_componente`,`nom_ventana`),
  KEY `fk_comp_ventana_idx` (`nom_ventana`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventana_componente`
--

INSERT INTO `ventana_componente` (`nom_componente`, `nom_ventana`) VALUES
('button_cancelar', 'NUEVO_USUARIO'),
('button_save', 'NUEVO_USUARIO'),
('jose', 'NUEVO_USUARIO'),
('button_save', 'PANTALLA_PRINCIPAL');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `perfil_ventana_componente`
--
ALTER TABLE `perfil_ventana_componente`
  ADD CONSTRAINT `fk_nom_com_cp` FOREIGN KEY (`nom_com_vpc`) REFERENCES `componente` (`nombre_componente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_nom_pef_cp` FOREIGN KEY (`nom_per_vpc`) REFERENCES `perfil` (`nombre_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_nom_ven_cp` FOREIGN KEY (`nom_ven_vpc`) REFERENCES `ventana` (`nombre_ventana`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventana_componente`
--
ALTER TABLE `ventana_componente`
  ADD CONSTRAINT `fk_comp_cp` FOREIGN KEY (`nom_componente`) REFERENCES `componente` (`nombre_componente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_vent_cp` FOREIGN KEY (`nom_ventana`) REFERENCES `ventana` (`nombre_ventana`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
