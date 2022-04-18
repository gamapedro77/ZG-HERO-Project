CREATE TABLE candidatos(
	id SERIAL PRIMARY KEY,
	nome CHARACTER VARYING(24) NOT NULL,
	sobrenome CHARACTER VARYING (24) NOT NULL,
	data_nascimento DATE NOT NULL,
	email CHARACTER VARYING(50) NOT NULL,
	CPF CHAR(11) NOT NULL,
	pais CHARACTER VARYING(50) NOT NULL,
	CEP CHAR(8) NOT NULL,
	descricao TEXT NOT NULL,
	senha VARCHAR(50) NOT NULL
);

CREATE TABLE empresas(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	CNPJ CHAR(14) NOT NULL,
	email VARCHAR(50) NOT NULL,
	descricao TEXT NOT NULL,
	pais VARCHAR(20) NOT NULL,
	CEP CHAR(8) NOT NULL,
	senha VARCHAR(50) NOT NULL
);

CREATE TABLE competencias(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE vagas(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao TEXT NOT NULL,
	empresa_id INT REFERENCES empresas(id) NOT NULL,
	local VARCHAR(50)
);

CREATE TABLE vagas_competencias(
	id_vaga INT REFERENCES vagas(id) NOT NULL,
	id_competencia INT REFERENCES competencias(id) NOT NULL,
	nivel VARCHAR(50) NOT NULL	
);

CREATE TABLE candidatos_competencias(
	id_candidato INT REFERENCES candidatos(id) NOT NULL,
	id_competencia INT REFERENCES competencias(id) NOT NULL,
	nivel VARCHAR(50) NOT NULL
);

CREATE TABLE curtidas(
	id_candidato INT REFERENCES candidatos(id) NOT NULL,
	id_empresa INT REFERENCES empresas(id) NOT NULL,
	candidato BOOLEAN NOT NULL,
	empresa BOOLEAN NOT NULL
);

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, CPF, pais, CEP, descricao, senha)
	VALUES ('Joao', 'Alberto', '1999-08-10', 'joao@email.com', '11122233345', 'Brasil', '12345678', 'Programador', 'poxavida24');
	
INSERT INTO empresas (nome, CNPJ, email, descricao, pais, CEP, senha)
	VALUES ('Tecnologia LTDA', '11222333444566', 'tecnologia@email.com', 'empresa de tecnologia', 'Brasil', '12345678', 'olhaquelegal38');


SELECT * FROM candidatos;
SELECT * FROM empresas;
