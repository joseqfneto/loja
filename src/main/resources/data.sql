-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.27 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para loja
CREATE DATABASE IF NOT EXISTS `loja` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loja`;

-- Copiando estrutura para tabela loja.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` bigint NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.categoria: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nome`) VALUES
	(11, 'Alimentos'),
	(12, 'Limpeza'),
	(13, 'Utilidades');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.hibernate_sequence: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(26);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.perfil
CREATE TABLE IF NOT EXISTS `perfil` (
  `id` bigint NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.perfil: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`id`, `nome`) VALUES
	(18, 'Admin'),
	(19, 'Supervisor');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.perfil_permissoes
CREATE TABLE IF NOT EXISTS `perfil_permissoes` (
  `perfil_id` bigint NOT NULL,
  `permissoes_id` bigint NOT NULL,
  KEY `FKlg80ct21mc8m42bmycqbecg7g` (`permissoes_id`),
  KEY `FK7pe70lfoju3xhmrqj64kdqsuo` (`perfil_id`),
  CONSTRAINT `FK7pe70lfoju3xhmrqj64kdqsuo` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FKlg80ct21mc8m42bmycqbecg7g` FOREIGN KEY (`permissoes_id`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.perfil_permissoes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `perfil_permissoes` DISABLE KEYS */;
INSERT INTO `perfil_permissoes` (`perfil_id`, `permissoes_id`) VALUES
	(18, 2),
	(18, 3),
	(18, 4),
	(18, 5),
	(18, 6),
	(18, 7),
	(18, 8),
	(18, 9),
	(18, 10),
	(18, 20),
	(19, 2),
	(19, 3),
	(19, 10),
	(19, 20);
/*!40000 ALTER TABLE `perfil_permissoes` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.permissao
CREATE TABLE IF NOT EXISTS `permissao` (
  `id` bigint NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.permissao: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` (`id`, `descricao`, `nome`) VALUES
	(2, '', 'produto_edit'),
	(3, '', 'produto_delete'),
	(4, '', 'perfil_edit'),
	(5, '', 'perfil_delete'),
	(6, '', 'permissao_edit'),
	(7, '', 'permissao_delete'),
	(8, '', 'usuario_edit'),
	(9, '', 'usuario_delete'),
	(10, '', 'categoria_edit'),
	(20, '', 'categoria_delete');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlnwh01s82c3yle784ra0kbdi8` (`usuario_id`),
  CONSTRAINT `FKlnwh01s82c3yle784ra0kbdi8` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.pessoa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` bigint NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `quantidade` int NOT NULL,
  `valor` float NOT NULL,
  `categoria_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKopu9jggwnamfv0c8k2ri3kx0a` (`categoria_id`),
  CONSTRAINT `FKopu9jggwnamfv0c8k2ri3kx0a` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.produto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`id`, `nome`, `quantidade`, `valor`, `categoria_id`) VALUES
	(14, 'Produto 1', 20, 2.5, 11),
	(15, 'Produto 2', 15, 1.5, 12),
	(16, 'Produto 3', 11, 0.95, 13);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `perfil_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9po12ytp6krwvwht1kmd0qgxf` (`perfil_id`),
  CONSTRAINT `FK9po12ytp6krwvwht1kmd0qgxf` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela loja.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `password`, `username`, `perfil_id`) VALUES
	(1, '$2a$10$oFRmnHas80QkklqrBXjk1./8/WJdz23AmRoeYpK4SP6S1CFjW8ks.', 'jneto', 18),
	(25, '$2a$10$r2zTdsVAtr67dLmiirYXWOPLRcu2RbOZMnAsx8yULsnpcdS1nkdee', 'maria', 19);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
