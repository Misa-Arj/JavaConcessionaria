create table clientes(
id bigint not null auto_increment,
nome_completo varchar(100) not null,
email varchar(100) not null unique,
cpf varchar(11) not null unique,
telefone varchar(11) not null,
marca varchar(50) not null,
chassi varchar(8) not null unique,
placa varchar(7) not null unique,
modelo varchar(50) not null,
ano_fabricacao varchar(4) not null,
ano_modelo varchar(4) not null,
cor char(50) not null,
quilometragem_atual bigint not null,

primary key(id)

);