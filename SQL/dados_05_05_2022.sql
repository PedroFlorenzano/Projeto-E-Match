drop database if exists E_Match;
CREATE DATABASE E_Match;
USE E_Match;

CREATE TABLE IF NOT EXISTS Cliente
(
	id integer PRIMARY KEY AUTO_INCREMENT,
    nome_completo varchar(50) not null,
    cpf char(14) not null,
    telefone varchar(10),
    data_nascimento date,
    sexo varchar(10),
    endereco varchar(300) not null,
    cidade varchar(70) not null,
    estado char(2) not null,
    email varchar(70)
);
CREATE TABLE IF NOT EXISTS Usuario (
	id int auto_increment primary key unique,
	nome varchar(50) not null,
	data_nasc date not null,
	rg char(12) not null unique,
	cpf char(14) not null unique,
	senha varchar(30) not null
);

create table if not exists Produto  (
id int auto_increment unique primary key ,
nome varchar(100) not null,
descricao varchar(250),
valor_custo float (4,2) not null,
valor_venda float (4,2) not null,
tamanho char(3) not null 
);

delimiter $
create procedure novoCliente(
	nome_completo varchar(50),
    cpf char(14),
    telefone varchar(10),
    data_nascimento date,
    sexo varchar(10),
    endereco varchar(300),
    cidade varchar(70),
    estado char(2),
    email varchar(70)
)
begin
	insert into Cliente values (null, nome_completo, cpf, telefone, data_nascimento, sexo, endereco, cidade, estado, email);
end$
delimiter ;

delimiter $
create procedure updateCliente(
	nome_completo_up varchar(50),
    cpf_up char(14),
    telefone_up varchar(10),
    data_nascimento_up date,
    sexo_up varchar(10),
    endereco_up varchar(300),
    cidade_up varchar(70),
    estado_up char(2),
    email_up varchar(70)
)
begin
	update Cliente set 
    nome_completo = nome_completo_up,
    cpf = cpf_up, 
    telefone = telefone_up, 
    data_nascimento = data_nascimento_up, 
    sexo = sexo_up, 
    endereco = endereco_up, 
    cidade = cidade_up, 
    estado = estado_up, 
    email = email_up;
end$
delimiter ;

delimiter $
create procedure novoProduto(
	nome varchar(100),
	descricao varchar(250),
	valor_custo float (4,2),
	valor_venda float (4,2),
	tamanho char(3)
)
begin
	insert into Produto values (null, nome, descricao, valor_custo, valor_venda, tamanho);
end$
delimiter ;

delimiter $
create procedure updateProduto(
	nome_up varchar(100),
	descricao_up varchar(250),
	valor_custo_up float (4,2),
	valor_venda_up float (4,2),
	tamanho_up char(3)
)
begin
	update Produto set 
    nome = nome_up, 
    descricao = descricao_up, 
    valor_custo = valor_custo_up, 
    valor_venda = valor_venda_up,
    tamanho = tamanho_up;
end$
delimiter ;

delimiter $
create procedure novoUsuario(
	nome varchar(50),
	data_nasc date,
	rg char(12),
	cpf char(14),
	senha varchar(30)
)
begin
	insert into Usuario values (null, nome, data_nasc, rg, cpf, senha);
end$
delimiter ;

delimiter $
create procedure updateUsuario(
	nome_up varchar(50),
	data_nasc_up date,
	rg_up char(12),
	cpf_up char(14),
	senha_up varchar(30)
)
begin
	update Usuario set 
    nome = nome_up, 
    data_nasc = data_nasc_up, 
    rg = rg_up, 
    cpf = cpf_up, 
    senha = senha_up;
end$
delimiter ;
