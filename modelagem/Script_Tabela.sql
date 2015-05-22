-- Estrutura da tabela 'fracao'
CREATE TABLE IF NOT EXISTS fracao (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_fracao VARCHAR(100) NOT NULL,
  fracao_pai_id BIGINT(20),
  CONSTRAINT fk_fracao_fracao_pai FOREIGN KEY (fracao_pai_id) REFERENCES fracao (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'atividade'
CREATE TABLE IF NOT EXISTS atividade (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_atividade VARCHAR(200) NOT NULL,
  data_inicio DATE,
  data_termino DATE,
  status VARCHAR(20) NOT NULL,
  observacao TEXT,  
  fracao_id BIGINT(20) NOT NULL,
  CONSTRAINT fk_atividade_fracao FOREIGN KEY (fracao_id) REFERENCES fracao (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'usuario'
CREATE TABLE IF NOT EXISTS usuario (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_usuario VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE KEY,
  senha VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

-- Estrutura da tabela 'grupo'
CREATE TABLE IF NOT EXISTS grupo (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_grupo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

-- Estrutura da tabela 'usuario_grupo'
CREATE TABLE IF NOT EXISTS usuario_grupo (
  usuario_id BIGINT(20) NOT NULL,
  grupo_id BIGINT(20) NOT NULL,
  PRIMARY KEY (usuario_id, grupo_id),
  CONSTRAINT fk_usuario_grupo FOREIGN KEY (usuario_id) REFERENCES usuario (id),
  CONSTRAINT fk_grupo_usuario FOREIGN KEY (grupo_id) REFERENCES grupo (id)
) ENGINE=InnoDB;

