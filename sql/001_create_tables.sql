-- =========================================================
-- BANCO DE DADOS
-- =========================================================

CREATE DATABASE IF NOT EXISTS hubgreen
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE hubgreen;


-- =========================================================
-- TABELA: ESTADO
-- =========================================================

CREATE TABLE estado (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sigla CHAR(2) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY uk_estado_sigla (sigla)
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: CIDADE
-- =========================================================

CREATE TABLE cidade (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cidade VARCHAR(150) NOT NULL,
    estado_id INT UNSIGNED NOT NULL,

    PRIMARY KEY (id),

    KEY idx_cidade_estado (estado_id),

    CONSTRAINT fk_cidade_estado
        FOREIGN KEY (estado_id)
        REFERENCES estado (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: EXPOSITOR
-- =========================================================

CREATE TABLE expositor (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    biografia TEXT NULL,

    PRIMARY KEY (id)
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: CATEGORIA
-- =========================================================

CREATE TABLE categoria (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY uk_categoria_nome (nome)
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: EVENTO
-- =========================================================

CREATE TABLE evento (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    local VARCHAR(200) NOT NULL,
    cidade_id INT UNSIGNED NOT NULL,
    data DATETIME NOT NULL,
    status ENUM(
        'em andamento',
        'finalizado',
        'cancelado'
    ) NOT NULL DEFAULT 'em andamento',
    descricao TEXT NULL,

    PRIMARY KEY (id),

    KEY idx_evento_cidade (cidade_id),
    KEY idx_evento_data (data),
    KEY idx_evento_status (status),

    CONSTRAINT fk_evento_cidade
        FOREIGN KEY (cidade_id)
        REFERENCES cidade (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: EVENTO_EXPOSITOR
-- =========================================================

CREATE TABLE evento_expositor (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    evento_id INT UNSIGNED NOT NULL,
    expositor_id INT UNSIGNED NOT NULL,
    status ENUM(
        'ativo',
        'cancelado'
    ) NOT NULL DEFAULT 'ativo',

    PRIMARY KEY (id),

    KEY idx_evento_expositor_evento (evento_id),
    KEY idx_evento_expositor_expositor (expositor_id),

    UNIQUE KEY uk_evento_expositor (
        evento_id,
        expositor_id
    ),

    CONSTRAINT fk_evento_expositor_evento
        FOREIGN KEY (evento_id)
        REFERENCES evento (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_evento_expositor_expositor
        FOREIGN KEY (expositor_id)
        REFERENCES expositor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: EXPOSITOR_IMAGENS
-- =========================================================

CREATE TABLE expositor_imagens (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    expositor_id INT UNSIGNED NOT NULL,
    caminho VARCHAR(500) NOT NULL,
    data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipo ENUM(
        'perfil',
        'outras'
    ) NOT NULL DEFAULT 'outras',

    PRIMARY KEY (id),

    KEY idx_expositor_imagens_expositor (expositor_id),
    KEY idx_expositor_imagens_tipo (tipo),

    CONSTRAINT fk_expositor_imagens_expositor
        FOREIGN KEY (expositor_id)
        REFERENCES expositor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: PRODUTO
-- =========================================================

CREATE TABLE produto (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    produto VARCHAR(200) NOT NULL,
    descricao TEXT NULL,
    expositor_id INT UNSIGNED NOT NULL,
    imagem VARCHAR(500) NULL,
    valor DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    categoria_id INT UNSIGNED NOT NULL,

    PRIMARY KEY (id),

    KEY idx_produto_expositor (expositor_id),
    KEY idx_produto_categoria (categoria_id),

    CONSTRAINT fk_produto_expositor
        FOREIGN KEY (expositor_id)
        REFERENCES expositor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;


-- =========================================================
-- TABELA: EVENTO_IMAGENS
-- =========================================================

CREATE TABLE evento_imagens (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    evento_id INT UNSIGNED NOT NULL,
    caminho VARCHAR(500) NOT NULL,
    data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    KEY idx_evento_imagens_evento (evento_id),

    CONSTRAINT fk_evento_imagens_evento
        FOREIGN KEY (evento_id)
        REFERENCES evento (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB;
