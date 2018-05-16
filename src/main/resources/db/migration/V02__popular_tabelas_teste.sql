--Pessoa
INSERT INTO pessoa (nome, cpf, sexo, celular, telefone, data_nascimento, is_sindico, email) values ('Ainsley', '08477818606', 1, '88-91408-7840', '33-4779-6839', '12/04/2017', false, 'elit.erat@auctorMaurisvel.org');
INSERT INTO pessoa (nome, cpf, sexo, celular, telefone, data_nascimento, is_sindico, email) values ('Damian', '80254766854', 0, '83-99885-9634', '46-7833-9432', '04/06/2017', true, 'eget@velmauris.edu');
INSERT INTO pessoa (nome, cpf, sexo, celular, telefone, data_nascimento, is_sindico, email) values ('McKenzie', '87639848814', 0, '56-90069-1937', '54-7809-2975', '02/09/2017', false, 'fermentum.arcu@commodo.com');
INSERT INTO pessoa (nome, cpf, sexo, celular, telefone, data_nascimento, is_sindico, email) values ('Aiko', '75264482330', 0, '73-97333-5978', '99-2665-6821', '08/11/2017', true, 'nibh@Aliquamrutrumlorem.com');

--Endereço
INSERT INTO endereco (logradouro, bairro, cidade, estado) values ('Rua Maria Teresa Dias da Silva, 224', 'Loteamento Residencial Barão do Café', 'Campinas', 'SP');
INSERT INTO endereco (logradouro, bairro, cidade, estado) values ('Rua Irmã Serafina, 919', 'Centro', 'Campinas', 'SP');
INSERT INTO endereco (logradouro, bairro, cidade, estado) values ('Avenida Dr. Moraes Sales, 1630', 'Centro', 'Campinas', 'SP');
INSERT INTO endereco (logradouro, bairro, cidade, estado) values ('Rua Santa Rita do Passa Quatro, 575', 'Parque Prado', 'Campinas', 'SP');

--Condominio
INSERT INTO condominio (nome, endereco_id, numero_blocos, numero_apartamentos_por_bloco) values ('Barão do Café', 1, 1, 100);
INSERT INTO condominio (nome, endereco_id, numero_blocos, numero_apartamentos_por_bloco) values ('Itatiaia', 2, 4, 12);
INSERT INTO condominio (nome, endereco_id, numero_blocos, numero_apartamentos_por_bloco) values ('Luis XV', 3, 2, 15);

--Apartamento
INSERT INTO apartamento (numero, bloco, andar, condominio_id) values (10, 'B', 1, 1);
INSERT INTO apartamento (numero, bloco, andar, condominio_id) values (21, 'A', 2, 1);
INSERT INTO apartamento (numero, bloco, andar, condominio_id) values (44, 'D', 4, 2);
INSERT INTO apartamento (numero, bloco, andar, condominio_id) values (101, 'C2', 10, 3);

--Chamado
INSERT INTO chamado (pessoa_id, condominio_id, observacao, criticidade, dataCriacao, ativo) values (1, 3, 'vazamento no banheiro', 4, '02/05/2018', true);
INSERT INTO chamado (pessoa_id, condominio_id, observacao, criticidade, dataCriacao, ativo) values (2, 1, 'mato na calçada', 1, '03/05/2018', true);
INSERT INTO chamado (pessoa_id, condominio_id, observacao, criticidade, dataCriacao, ativo) values (3, 2, 'luz do elevador queimada', 3, '04/05/2018', false);
