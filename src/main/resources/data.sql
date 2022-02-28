INSERT INTO `categoria` (`id`, `nome`) VALUES
	(11, 'Alimentos'),
	(12, 'Limpeza'),
	(13, 'Utilidades');

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(26);

INSERT INTO `perfil` (`id`, `nome`) VALUES
	(18, 'Admin'),
	(19, 'Supervisor');

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

INSERT INTO `produto` (`id`, `nome`, `quantidade`, `valor`, `categoria_id`) VALUES
	(14, 'Produto 1', 20, 2.5, 11),
	(15, 'Produto 2', 15, 1.5, 12),
	(16, 'Produto 3', 11, 0.95, 13);

INSERT INTO `usuario` (`id`, `password`, `username`, `perfil_id`) VALUES
	(1, '$2a$10$oFRmnHas80QkklqrBXjk1./8/WJdz23AmRoeYpK4SP6S1CFjW8ks.', 'jneto', 18),
	(25, '$2a$10$r2zTdsVAtr67dLmiirYXWOPLRcu2RbOZMnAsx8yULsnpcdS1nkdee', 'maria', 19);