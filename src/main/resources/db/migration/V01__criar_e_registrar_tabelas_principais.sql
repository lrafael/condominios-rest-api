CREATE TABLE apartamento (
	id SERIAL PRIMARY KEY,
	numero BIGINT, 
	bloco VARCHAR(100),
	andar BIGINT
);

CREATE TABLE condominio (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	endereco_id BIGINT, 
	numero_blocos BIGINT, 
	numero_apartamentos_por_bloco BIGINT
);

CREATE TABLE endereco (
	id SERIAL PRIMARY KEY, 
	logradouro VARCHAR(100), 
	bairro VARCHAR(100), 
	cidade VARCHAR(100), 
	estado VARCHAR(2)
);

CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY, 
	nome VARCHAR(100), 
	cpf VARCHAR(100), 
	sexo BIGINT, 
	celular VARCHAR(14), 
	telefone VARCHAR(13), 
	data_nascimento TIMESTAMP, 
	isSindico BOOLEAN
);

CREATE TABLE chamado (
	id SERIAL PRIMARY KEY, 
	pessoa_id BIGINT, 
	condominio_id BIGINT, 
	observacao VARCHAR(500), 
	criticidade BIGINT, 
	dataCriacao TIMESTAMP, 
	ativo BOOLEAN
);