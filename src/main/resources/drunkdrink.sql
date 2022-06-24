-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Jun-2022 às 06:56
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `drunkdrink`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bar`
--

CREATE TABLE `bar` (
  `id_bar` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `avaliacao` double NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `id_pessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `bar`
--

INSERT INTO `bar` (`id_bar`, `nome`, `telefone`, `descricao`, `cep`, `cnpj`, `avaliacao`, `email`, `senha`, `id_pessoa`) VALUES
(2, 'Bar Zé', '213456', 'lorem ipsum', '30170003', '65648941312', 0, 'exem@gmail.com', '123456', 4),
(3, 'Bar X', '31982356147', 'lorem ipsum... lorem', '31204788', '1234567891', 0, 'exemplo12@gmail.com', '123456789', 18);

-- --------------------------------------------------------

--
-- Estrutura da tabela `bartender`
--

CREATE TABLE `bartender` (
  `id_bartender` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `bartender`
--

INSERT INTO `bartender` (`id_bartender`) VALUES
(2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contratante`
--

CREATE TABLE `contratante` (
  `contratante_evento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `contratante`
--

INSERT INTO `contratante` (`contratante_evento_id`) VALUES
(1),
(11),
(13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE `evento` (
  `id_evento` int(11) NOT NULL,
  `id_bar_evento` int(11) DEFAULT NULL,
  `id_contratante_evento` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `hora_inicio` varchar(9) NOT NULL,
  `quant_participantes` int(11) NOT NULL,
  `duracao` double NOT NULL,
  `data_evento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`id_evento`, `id_bar_evento`, `id_contratante_evento`, `nome`, `endereco`, `hora_inicio`, `quant_participantes`, `duracao`, `data_evento`) VALUES
(2, 2, 1, 'Evento X', 'lorem ipsum', '11:04:54', 50, 2, ''),
(3, 2, 13, 'Evento realeza', 'Rua realeza', '11:34:13', 500, 2, ''),
(4, NULL, 1, 'lorem', 'lorem', '12', 500, 2, '21/06/2022');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `avaliacao` double NOT NULL,
  `dados_bancarios` varchar(200) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `cnpj_bar` int(11) DEFAULT NULL,
  `preco_hora` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`avaliacao`, `dados_bancarios`, `descricao`, `id_funcionario`, `cnpj_bar`, `preco_hora`) VALUES
(5, 'lorem ipsun', 'lorem ipsun', 2, 2, 50),
(4.2, 'lorem ipsum', 'lorem ipsum', 3, NULL, 20),
(50, 'lorem ipsum', 'lorem ipsum', 10, 3, 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `id_remetente` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL,
  `id_pagamento` int(11) NOT NULL,
  `valor` double NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`id_remetente`, `id_destinatario`, `id_pagamento`, `valor`, `tipo`) VALUES
(1, 2, 2, 200, ''),
(1, 2, 3, 200, 'PIX'),
(1, 3, 4, 200, 'CARTÃO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `data_registro` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `nome`, `cpf`, `senha`, `endereco`, `telefone`, `email`, `data_registro`) VALUES
(1, 'Pablo', '132', '123', 'Rua ABC', '123456', 'pablo@gmail.com', NULL),
(2, 'Augusto', '234', '234', 'Rua DEF', '654321', 'augusto@gmail.com', NULL),
(3, 'Carneiro', '567', '567', 'Rua GHI', '789132', 'carneiro@gmail.com', NULL),
(4, 'Exem', '123456', '123456', 'lorem ipsum', '123456', 'exem@gmail.com', NULL),
(7, 'Magalhães', '45612378912', '123456789', 'lorem ipsum, lorem...', '3198378197', 'magalhaes@gmail.com', '16/06/2022'),
(8, 'Carlos', '65904316901', 'carlinhos123', 'lorem ipsum, loremm', '953261782', 'carlinhosll@gmail.com', NULL),
(9, 'Sid', '25634789104', 'sideradogelo', 'lorem ipsum, lorem', '978341697', 'sid@gmail.com', NULL),
(10, 'Bin', '39712574681', 'mainstreet', 'lorem ipsum, loremmmm', '925971486', 'bindams@gmail.com', NULL),
(11, 'Renato', '12345678912', 'alaska007', 'Every Leasson Learned..', '987456321', 'froid@gmail.com', NULL),
(12, 'exemplo', '12345678911', '132456789', 'lorem ipsum, lorem', '31987456321', 'exemplo@gmail.com', NULL),
(13, 'exemplo1', '45678912369', '123456789', 'lorem ipsum...... lorem', '31784526985', 'exexmple1@gmail.com', NULL),
(15, 'exemplo2', '12345678901', '123456789', 'asdasdasdasdsasdasdasd', '321456985', 'exemplo2@gmail.com', NULL),
(16, 'exemplofor', '12345678911', 'asjdalksdlkas', 'asdasdasdasdassdasdas', '31925634785', 'exemplofor@gmail.com', NULL),
(17, 'xxxxxxxxxx', '123456789101', 'xxxxxxxxxxx', 'lorem ipsum...', '3214569874', 'xxxxx@gmail.com', NULL),
(18, 'exemplo12', '14523698712', '123456789', 'lorem ipsum....., lorem', '31987452361', 'exemplo12@gmail.com', NULL),
(19, 'aaaaaaaaa', '12345678911', 'aaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaaaaaaaaa', '123456789', 'aaaaaaaaaa@ggasda.com', '16/06/2022');

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposta`
--

CREATE TABLE `proposta` (
  `id_proposta` int(11) NOT NULL,
  `id_contratante` int(11) DEFAULT NULL,
  `id_bar` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 2,
  `id_evento` int(11) DEFAULT NULL,
  `id_func` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `proposta`
--

INSERT INTO `proposta` (`id_proposta`, `id_contratante`, `id_bar`, `descricao`, `status`, `id_evento`, `id_func`) VALUES
(5, 1, 2, 'aaaaaaaaaaaaaa', 0, 4, NULL),
(6, NULL, 3, 'aaaaaaaa', 1, NULL, 10),
(7, NULL, 2, 'aaaaaaaaaaaaaa', 0, NULL, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`id_bar`),
  ADD UNIQUE KEY `cnpj` (`cnpj`),
  ADD KEY `id_pessoa` (`id_pessoa`);

--
-- Índices para tabela `bartender`
--
ALTER TABLE `bartender`
  ADD KEY `id_bartender` (`id_bartender`);

--
-- Índices para tabela `contratante`
--
ALTER TABLE `contratante`
  ADD PRIMARY KEY (`contratante_evento_id`);

--
-- Índices para tabela `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_contratante_evento` (`id_contratante_evento`),
  ADD KEY `id_bar_evento` (`id_bar_evento`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`),
  ADD KEY `cnpj_bar` (`cnpj_bar`);

--
-- Índices para tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`id_pagamento`),
  ADD KEY `id_destinatario` (`id_destinatario`),
  ADD KEY `id_remetente` (`id_remetente`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`);

--
-- Índices para tabela `proposta`
--
ALTER TABLE `proposta`
  ADD PRIMARY KEY (`id_proposta`),
  ADD KEY `id_contratante` (`id_contratante`),
  ADD KEY `id_bar` (`id_bar`),
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `id_func` (`id_func`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bar`
--
ALTER TABLE `bar`
  MODIFY `id_bar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `contratante`
--
ALTER TABLE `contratante`
  MODIFY `contratante_evento_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `evento`
--
ALTER TABLE `evento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `id_pagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `proposta`
--
ALTER TABLE `proposta`
  MODIFY `id_proposta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `bar`
--
ALTER TABLE `bar`
  ADD CONSTRAINT `bar_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `bartender`
--
ALTER TABLE `bartender`
  ADD CONSTRAINT `bartender_ibfk_1` FOREIGN KEY (`id_bartender`) REFERENCES `funcionario` (`id_funcionario`);

--
-- Limitadores para a tabela `contratante`
--
ALTER TABLE `contratante`
  ADD CONSTRAINT `contratante_ibfk_1` FOREIGN KEY (`contratante_evento_id`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `evento_ibfk_2` FOREIGN KEY (`id_contratante_evento`) REFERENCES `contratante` (`contratante_evento_id`),
  ADD CONSTRAINT `evento_ibfk_3` FOREIGN KEY (`id_bar_evento`) REFERENCES `bar` (`id_bar`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `pessoa` (`id_pessoa`),
  ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`cnpj_bar`) REFERENCES `bar` (`id_bar`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`id_destinatario`) REFERENCES `funcionario` (`id_funcionario`),
  ADD CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`id_remetente`) REFERENCES `contratante` (`contratante_evento_id`);

--
-- Limitadores para a tabela `proposta`
--
ALTER TABLE `proposta`
  ADD CONSTRAINT `proposta_ibfk_1` FOREIGN KEY (`id_contratante`) REFERENCES `contratante` (`contratante_evento_id`),
  ADD CONSTRAINT `proposta_ibfk_2` FOREIGN KEY (`id_bar`) REFERENCES `bar` (`id_bar`),
  ADD CONSTRAINT `proposta_ibfk_3` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`),
  ADD CONSTRAINT `proposta_ibfk_4` FOREIGN KEY (`id_func`) REFERENCES `funcionario` (`id_funcionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
