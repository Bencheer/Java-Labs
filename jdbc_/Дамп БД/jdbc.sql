-- phpMyAdmin SQL Dump
-- version 4.0.10
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 29 2014 г., 18:11
-- Версия сервера: 5.5.38-log
-- Версия PHP: 5.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `jdbc`
--

-- --------------------------------------------------------

--
-- Структура таблицы `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `text_mess` varchar(3000) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Дамп данных таблицы `messages`
--

INSERT INTO `messages` (`id`, `id_user`, `text_mess`, `time`) VALUES
(1, 1, 'gdfsgdsfgdsfgdfg', '2014-10-29 13:21:44'),
(2, 1, 'dfgdsfgdf', '2014-10-29 13:28:57'),
(8, 1, 'dfgdsfgdf', '2014-10-29 13:47:14'),
(9, 3, 'fgnfdlgdsfgljdfskjglkdfs', '2014-10-29 13:48:13'),
(10, 3, 'fgnfdlgdsfgljdfskjglkdfs', '2014-10-29 13:48:53'),
(11, 3, 'Привет!!!', '2014-10-29 13:58:58'),
(12, 3, 'Привет!!!', '2014-10-29 14:00:34'),
(13, 3, 'Привет!!!', '2014-10-29 14:01:45'),
(14, 3, 'Привет!!!', '2014-10-29 14:03:10');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fam` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `login` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `fam`, `name`, `login`, `password`, `time`) VALUES
(1, 'test', 'test', 'test', 'test', '2014-10-29 13:47:34'),
(3, 'test1', 'test1', '1', '1', '2014-10-29 14:03:10'),
(4, 'test2', 'test2', '2', '2', '2014-10-25 13:23:29');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
