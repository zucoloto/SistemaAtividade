-- Estrutura da tabela 'tipo_atividade'
CREATE TABLE atv_tipo_atividade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome_atividade VARCHAR(100) NOT NULL,
  periodico VARCHAR(30) NULL,
  pop MEDIUMTEXT,
  PRIMARY KEY(id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'atividade'
CREATE TABLE IF NOT EXISTS atv_atividade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  tipo_atividade_id BIGINT NOT NULL,
  data_inicio DATE NULL,
  data_termino DATE NULL,
  status VARCHAR(20) NOT NULL,
  observacao TEXT,
  PRIMARY KEY(id),
  INDEX fk_atividade_tipo(tipo_atividade_id),
  FOREIGN KEY(tipo_atividade_id) REFERENCES atv_tipo_atividade(id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'fracao'
CREATE TABLE IF NOT EXISTS atv_fracao (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  nome_fracao VARCHAR(100) NOT NULL,
  fracao_pai_id BIGINT(20),
  PRIMARY KEY(id),
  INDEX fk_fracao_fracao_pai(fracao_pai_id),
  FOREIGN KEY(fracao_pai_id) REFERENCES atv_fracao(id)
) ENGINE=InnoDB;


-- Estrutura da tabela 'grupo'
CREATE TABLE IF NOT EXISTS atv_grupo (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  nome_grupo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'usuario_grupo'
CREATE TABLE IF NOT EXISTS atv_usuario_grupo (
  usuario_id BIGINT(20) NOT NULL,
  grupo_id BIGINT(20) NOT NULL,
  PRIMARY KEY (usuario_id, grupo_id),
  INDEX fk_usuario_grupo(usuario_id),
  INDEX fk_grupo_usuario(grupo_id),
  FOREIGN KEY(usuario_id) REFERENCES seg_usuario(id),
  FOREIGN KEY(grupo_id) REFERENCES atv_grupo(id)
) ENGINE=InnoDB;

