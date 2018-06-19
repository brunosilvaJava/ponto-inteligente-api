CREATE TABLE IF NOT EXISTS `empresa` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `razao_social` varchar(50) NOT NULL,
  `cnpj` int(18) NOT NULL,
  `data_criacao` date NOT NULL,
  `data_atualizacao` date NOT NULL
);

CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(8) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `valor_hora` decimal(19,2) NOT NULL,
  `qtd_horas_trabalho_dia` float NOT NULL,
  `qtd_horas_almoco` float DEFAULT NULL,
  `tipo_perfil` int(11) NOT NULL,
  `data_criacao` date NOT NULL,
  `data_atualizacao` date NOT NULL,
  `id_empresa` bigint(20) NOT NULL,
   CONSTRAINT funcionario_id_empresa FOREIGN KEY (id_empresa) REFERENCES empresa(id)
);

CREATE TABLE IF NOT EXISTS `lancamento` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `data` date NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `localizacao` varchar(50) NOT NULL,
  `data_criacao` date NOT NULL,
  `data_atualizacao` date NOT NULL,
  `tipo` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  CONSTRAINT `lancamento_id_funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`)
);


