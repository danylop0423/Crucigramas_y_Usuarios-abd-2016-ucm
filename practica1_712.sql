-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2016 a las 14:12:20
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `practica1_712`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aficiones`
--

CREATE TABLE IF NOT EXISTS `aficiones` (
  `usuario` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `aficion` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE IF NOT EXISTS `amigos` (
  `usuario1` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usuario2` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invitacion`
--

CREATE TABLE IF NOT EXISTS `invitacion` (
  `id_mensaje` int(10) NOT NULL,
  `n_pregunta` int(10) NOT NULL,
  `msj_xdefecto` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '"tienes una invitacion"'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE IF NOT EXISTS `mensajes` (
  `id` int(10) NOT NULL,
  `emisor` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `receptor` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `leido` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje_texto`
--

CREATE TABLE IF NOT EXISTS `mensaje_texto` (
  `id_mensaje` int(10) NOT NULL,
  `texto` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `numero` int(10) NOT NULL,
  `pregunta` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responden`
--

CREATE TABLE IF NOT EXISTS `responden` (
  `usuario` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `n_pregunta` int(10) NOT NULL,
  `n_respuesta` int(10) NOT NULL,
  `relevancia` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE IF NOT EXISTS `respuestas` (
  `id` int(10) NOT NULL,
  `numero` int(10) NOT NULL,
  `n_pregunta` int(10) NOT NULL,
  `respuesta` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_amistad`
--

CREATE TABLE IF NOT EXISTS `solicitud_amistad` (
  `id_mensaje` int(10) NOT NULL,
  `msj_xdefecto` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '"Tienes una Solicitud de Amistad"'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genero` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genero_buscado` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha_nacimiento` timestamp NULL DEFAULT NULL,
  `foto` blob,
  `descripcion` varchar(146) COLLATE utf8mb4_unicode_ci NOT NULL,
  `latitud` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `longitud` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aficiones`
--
ALTER TABLE `aficiones`
  ADD PRIMARY KEY (`usuario`,`aficion`);

--
-- Indices de la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD PRIMARY KEY (`usuario1`,`usuario2`), ADD KEY `usuario2` (`usuario2`);

--
-- Indices de la tabla `invitacion`
--
ALTER TABLE `invitacion`
  ADD PRIMARY KEY (`id_mensaje`), ADD KEY `n_pregunta` (`n_pregunta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`), ADD KEY `emisor` (`emisor`), ADD KEY `receptor` (`receptor`);

--
-- Indices de la tabla `mensaje_texto`
--
ALTER TABLE `mensaje_texto`
  ADD PRIMARY KEY (`id_mensaje`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`numero`);

--
-- Indices de la tabla `responden`
--
ALTER TABLE `responden`
  ADD PRIMARY KEY (`usuario`,`n_pregunta`,`n_respuesta`), ADD KEY `n_respuesta` (`n_respuesta`), ADD KEY `n_pregunta` (`n_pregunta`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id`), ADD KEY `n_pregunta` (`n_pregunta`), ADD KEY `numero` (`numero`);

--
-- Indices de la tabla `solicitud_amistad`
--
ALTER TABLE `solicitud_amistad`
  ADD PRIMARY KEY (`id_mensaje`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `numero` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aficiones`
--
ALTER TABLE `aficiones`
ADD CONSTRAINT `aficiones_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `amigos`
--
ALTER TABLE `amigos`
ADD CONSTRAINT `amigos_ibfk_1` FOREIGN KEY (`usuario1`) REFERENCES `usuarios` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `amigos_ibfk_2` FOREIGN KEY (`usuario2`) REFERENCES `usuarios` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `invitacion`
--
ALTER TABLE `invitacion`
ADD CONSTRAINT `invitacion_ibfk_1` FOREIGN KEY (`id_mensaje`) REFERENCES `mensajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `invitacion_ibfk_2` FOREIGN KEY (`n_pregunta`) REFERENCES `preguntas` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
ADD CONSTRAINT `mensajes_ibfk_1` FOREIGN KEY (`emisor`) REFERENCES `usuarios` (`email`) ON UPDATE CASCADE,
ADD CONSTRAINT `mensajes_ibfk_2` FOREIGN KEY (`receptor`) REFERENCES `usuarios` (`email`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensaje_texto`
--
ALTER TABLE `mensaje_texto`
ADD CONSTRAINT `mensaje_texto_ibfk_1` FOREIGN KEY (`id_mensaje`) REFERENCES `mensajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `responden`
--
ALTER TABLE `responden`
ADD CONSTRAINT `responden_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `responden_ibfk_2` FOREIGN KEY (`n_respuesta`) REFERENCES `respuestas` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `responden_ibfk_3` FOREIGN KEY (`n_pregunta`) REFERENCES `respuestas` (`n_pregunta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`n_pregunta`) REFERENCES `preguntas` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitud_amistad`
--
ALTER TABLE `solicitud_amistad`
ADD CONSTRAINT `solicitud_amistad_ibfk_1` FOREIGN KEY (`id_mensaje`) REFERENCES `mensajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
