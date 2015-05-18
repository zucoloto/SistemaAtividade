CREATE TABLE grupo (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome_grupo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE tipo_atividade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome_atividade VARCHAR(100) NOT NULL,
  periodico VARCHAR(30) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE fracao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  fracao_pai_id BIGINT NULL,
  nome_fracao VARCHAR(100) NOT NULL,
  PRIMARY KEY(id),
  INDEX fk_fracao_fracao_pai(fracao_pai_id),
  FOREIGN KEY(fracao_pai_id)
    REFERENCES fracao(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
TYPE=InnoDB;

CREATE TABLE usuario (
  id BIGINT NOT NULL AUTO_INCREMENT,
  fracao_id BIGINT NOT NULL,
  identidade VARCHAR(10) UNIQUE KEY NOT NULL,
  nome_usuario VARCHAR(100) NOT NULL,
  email VARCHAR(255) UNIQUE KEY NOT NULL,
  status_usuario VARCHAR(20) NOT NULL,
  senha VARCHAR(10) NULL,
  PRIMARY KEY(id),
  INDEX fk_usuario_fracao(fracao_id),
  FOREIGN KEY(fracao_id)
    REFERENCES fracao(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
TYPE=InnoDB;

CREATE TABLE usuario_grupo (
  usuario_id BIGINT NOT NULL,
  grupo_id BIGINT NOT NULL,
  PRIMARY KEY(usuario_id, grupo_id),
  INDEX fk_usuario_grupo(usuario_id),
  INDEX fk_grupo_usuario(grupo_id),
  FOREIGN KEY(usuario_id)
    REFERENCES usuario(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(grupo_id)
    REFERENCES grupo(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
TYPE=InnoDB;

CREATE TABLE atividade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  usuario_id BIGINT NOT NULL,
  tipo_atividade_id BIGINT NOT NULL,
  data_inicio DATE NULL,
  data_termino DATE NULL,
  status_atividade VARCHAR(20) NOT NULL,
  observacao TEXT NULL,
  PRIMARY KEY(id),
  INDEX fk_atividade_tipo(tipo_atividade_id),
  INDEX fk_atividade_usuario(usuario_id),
  FOREIGN KEY(tipo_atividade_id)
    REFERENCES tipo_atividade(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(usuario_id)
    REFERENCES usuario(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
)
TYPE=InnoDB;


