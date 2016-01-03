-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-01-2016 a las 23:11:21
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
  PRIMARY KEY (`nombre_componente`),
  UNIQUE KEY `nombre_componente` (`nombre_componente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `componente`
--

INSERT INTO `componente` (`nombre_componente`) VALUES
('button_cancelar'),
('button_salir'),
('button_save'),
('menu_item_acercade'),
('menu_item_salir'),
('tableViewTodo');

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
('ADMINISTRADOR', b'1'),
('DESARROLLADOR', b'1'),
('TESTER', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_ventana_componente`
--

CREATE TABLE IF NOT EXISTS `perfil_ventana_componente` (
  `nom_com_vpc` varchar(40) NOT NULL,
  `nom_per_vpc` varchar(40) NOT NULL,
  `nom_ven_vpc` varchar(40) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`nom_com_vpc`,`nom_per_vpc`,`nom_ven_vpc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil_ventana_componente`
--

INSERT INTO `perfil_ventana_componente` (`nom_com_vpc`, `nom_per_vpc`, `nom_ven_vpc`, `estado`) VALUES
('button_cancelar', 'ADMINISTRADOR', 'NUEVO_USUARIO', b'1'),
('button_cancelar', 'TESTER', 'NUEVO_USUARIO', b'1'),
('button_salir', 'TESTER', 'NUEVO_USUARIO', b'1'),
('button_save', 'TESTER', 'NUEVO_USUARIO', b'1');

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
  PRIMARY KEY (`nom_componente`,`nom_ventana`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventana_componente`
--

INSERT INTO `ventana_componente` (`nom_componente`, `nom_ventana`) VALUES
('button_cancelar', 'ADMINISTRAR_VENTANAS_A_PERFIL'),
('button_cancelar', 'CREAR_PERFIL'),
('button_cancelar', 'NUEVO_USUARIO'),
('button_salir', 'CREAR_PERFIL'),
('button_salir', 'NUEVO_USUARIO'),
('button_save', 'CREAR_PERFIL'),
('button_save', 'NUEVO_USUARIO'),
('menu_item_acercade', 'ADMINISTRAR_VENTANAS_A_PERFIL'),
('menu_item_salir', 'PANTALLA_PRINCIPAL'),
('tableViewTodo', 'ADMINISTRAR_VENTANAS_A_PERFIL'),
('tableViewTodo', 'PANTALLA_PRINCIPAL');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
