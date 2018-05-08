CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY, 
	nome VARCHAR(100) NOT NULL, 
	cpf VARCHAR(11) NOT NULL, 
	sexo INT, 
	celular VARCHAR(14), 
	telefone VARCHAR(13), 
	data_nascimento DATE, 
	is_sindico BOOLEAN NOT NULL,
	email VARCHAR(60) NOT NULL
);

CREATE TABLE endereco (
	id SERIAL PRIMARY KEY, 
	logradouro VARCHAR(100) NOT NULL, 
	bairro VARCHAR(100) NOT NULL, 
	cidade VARCHAR(100) NOT NULL, 
	estado VARCHAR(2) NOT NULL
);

CREATE TABLE condominio (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	endereco_id BIGINT REFERENCES endereco (id), 
	numero_blocos BIGINT, 
	numero_apartamentos_por_bloco BIGINT
);

CREATE TABLE apartamento (
	id SERIAL PRIMARY KEY,
	numero BIGINT, 
	bloco VARCHAR(50),
	andar INT,
	condominio_id BIGINT REFERENCES condominio (id)
);

CREATE TABLE chamado (
	id SERIAL PRIMARY KEY, 
	pessoa_id BIGINT REFERENCES pessoa(id), 
	condominio_id BIGINT REFERENCES condominio (id), 
	observacao VARCHAR(500), 
	criticidade BIGINT NOT NULL, 
	dataCriacao TIMESTAMP NOT NULL, 
	ativo BOOLEAN NOT NULL
);