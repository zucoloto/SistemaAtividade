/* Base de Dados: 'mapa_atividade' */
CREATE DATABASE IF NOT EXISTS mapa_atividade;
USE mapa_atividade;

/* Cria o usuário e senha */
CREATE USER 'user_mapa_ativ'@'localhost' IDENTIFIED BY '008516';

/* Libera as permissões */
GRANT ALL PRIVILEGES ON mapa_atividade.* TO 'user_mapa_ativ'@'localhost' WITH GRANT OPTION;
