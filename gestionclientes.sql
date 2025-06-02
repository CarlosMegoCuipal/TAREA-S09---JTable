-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2025 a las 06:13:42
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionclientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) NOT NULL,
  `apellido` varchar(64) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `telefono` varchar(16) DEFAULT NULL,
  `direccion` varchar(128) DEFAULT NULL,
  `correo` varchar(128) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fecha_creada` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `dni`, `telefono`, `direccion`, `correo`, `estado`, `fecha_creada`) VALUES
(1, 'Carlos Eduardo ', 'Mego Cuipal', '75210179', '964920352', 'Jr. Libertad 598', 'carloseduadomegocuipal@gmail.com', 1, '2025-05-22 12:54:50'),
(2, 'Williams Jhonatan', 'Lozano Paico', '98765432', '964920352', 'libertad 230', 'lozano@gmail.com', 1, '2025-05-27 12:31:50'),
(3, 'Eduardo', 'Cuipal', '75210179', '999999999', 'Libertad 598', 'eduardo@gmail.com', 0, '2025-05-27 12:55:21'),
(4, 'Clever', 'Loyaga Rivera', '77777777', '999999999', '', '', 1, '2025-05-27 12:55:47');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) NOT NULL,
  `categoria` varchar(64) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `fecha_creada` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `categoria`, `precio`, `stock`, `fecha_creada`) VALUES
(1, 'Zanahoria', 'Verdura', 1, 100, '2025-06-01 23:05:10'),
(2, 'Papa', 'verdura', 2.5, 20, '2025-06-01 23:05:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `id` int(11) NOT NULL,
  `nombres` varchar(64) NOT NULL,
  `apellidos` varchar(64) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `correo` varchar(128) NOT NULL,
  `fecha_creada` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`id`, `nombres`, `apellidos`, `dni`, `correo`, `fecha_creada`) VALUES
(1, 'Carlos', 'Mego', '75210179', 'carlos@gmail.com', '2025-06-01 23:06:07'),
(2, 'Eduardo', 'Cuipal', '75210777', 'eduardo@gmail.com', '2025-06-01 23:06:43'),
(3, 'Jhonatan', 'Lozano', '75210777', 'Jhonatan@gmail.com', '2025-06-01 23:06:45');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
