drop database if exists E_Match;
create database E_Match;
use E_Match;

create table if not exists Cliente
(
	id integer primary key auto_increment,
    nome_completo varchar(50) not null,
    cpf char(14) not null,
    telefone varchar(11),
    data_nascimento date,
    sexo varchar(10),
    cep char(11),
    endereco varchar(300) not null,
    cidade varchar(70) not null,
    estado char(2) not null
);

create table if not exists Usuario (
	id int auto_increment primary key unique,
	nome varchar(50) not null,
	senha varchar(30) not null,
    cpf char(14) not null
);

create table if not exists Produto  (
	id int auto_increment unique primary key ,
	nome varchar(100) not null,
	descricao varchar(250),
	valor_custo float (5,2) not null,
	valor_venda float (5,2) not null,
	tamanho char(3) not null,
    quantidade int not null
);

delimiter $
create procedure novoCliente(
	nome_completo varchar(50),
    cpf char(14),
    telefone varchar(11),
    data_nascimento date,
    sexo varchar(10),
    cep char(11),
    endereco varchar(300),
    cidade varchar(70),
    estado char(2)
)
begin
	insert into Cliente values (null, nome_completo, cpf, telefone, data_nascimento, sexo, cep, endereco, cidade, estado);
end$
delimiter ;

delimiter $
create procedure updateCliente(
	nome_completo_up varchar(50),
    cpf_up char(14),
    telefone_up varchar(11),
    data_nascimento_up date,
    sexo_up varchar(10),
    cep_up char(11),
    endereco_up varchar(300),
    cidade_up varchar(70),
    estado_up char(2)
)
begin
	update Cliente set 
    nome_completo = nome_completo_up,
    telefone = telefone_up, 
    data_nascimento = data_nascimento_up, 
    sexo = sexo_up,
    cep = cep_up,
    endereco = endereco_up, 
    cidade = cidade_up, 
    estado = estado_up
    where cpf like cpf_up;
    
end$
delimiter ;

delimiter $
create procedure novoProduto(
	nome varchar(100),
	descricao varchar(250),
	valor_custo float (5,2),
	valor_venda float (5,2),
	tamanho char(3),
    quantidade int
)
begin
	insert into Produto values (null, nome, descricao, valor_custo, valor_venda, tamanho, quantidade);
end$
delimiter ;

delimiter $
create procedure updateProduto(
	nome_up varchar(100),
	descricao_up varchar(250),
	valor_custo_up float (5,2),
	valor_venda_up float (5,2),
	tamanho_up char(3),
    quantidade_up int
)
begin
	update Produto set 
    nome = nome_up, 
    descricao = descricao_up, 
    valor_custo = valor_custo_up, 
    valor_venda = valor_venda_up,
    tamanho = tamanho_up,
    quantidade = quantidade_up;
    
end$
delimiter ;

delimiter $
create procedure novoUsuario(
	nome varchar(50),
	senha varchar(30),
    cpf char(14)
)
begin
	insert into Usuario values (null, nome, senha, cpf);
end$
delimiter ;

delimiter $
create procedure updateUsuario(
	nome_up varchar(50),
	senha_up varchar(30),
    cpf_up char(14)
)
begin
	update Usuario set 
    nome = nome_up, 
    senha = senha_up
    where cpf like cpf_up;
end$
delimiter ;
