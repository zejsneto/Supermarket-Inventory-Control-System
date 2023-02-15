# Supermarket-Inventory-Control-System

## ℹ️ Description

A supermarket inventory control system developed with Java language, using object-oriented concepts, MVC pattern, GUI and PostgreSQL.

The system has a login screen, but it is necessary to create the user 'admin' and its password (in this case, I chose '1234') in the PostgreSQL database to perform the first login.

Only the administrator can register and deactivate market employees and generate transaction reports (.txt or .csv file).

Both the administrator and the registered and active employee will be able to
register new products, product categories and move inventory.

Both the administrator and the registered and active employee will be able to
add, change or delete providers.

Both the administrator and the employee will be able to consult the stock through
of filters and view the product inventory.

---

## 👁️‍🗨️ Preview
<p align="center" >
  <img width="50%" src="/repository-imgs/img01.png" />
</p>
<p align="center">
Login Screen
</p><p align="center" >
  <img width="50%" src="/repository-imgs/img02.png" />
</p>
<p align="center">
Error to Login Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img03.png" />
</p>
<p align="center">
Register a Transaction Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img04.png" />
</p>
<p align="center">
Employee List Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img05.png" />
</p>
<p align="center">
Transaction Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img06.png" />
</p>
<p align="center">
Transaction report (.txt file) 
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img07.png" />
</p>
<p align="center">
Consult Transaction Screen (Query)
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img08.png" />
</p>
<p align="center">
Supplier List Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img09.png" />
</p>
<p align="center">
Edit existing Supplier Screen
</p>
<p align="center" >
  <img width="50%" src="/repository-imgs/img10.png" />
</p>
<p align="center">
Products and Category Screen
</p>

---

## ⚙️ **Configuration**

Here are the codes to create the exact same tables of the project:

* CREATE TABLE movimentacao(
dataMovimentacao DATE,
tipo VARCHAR(10),
codigoProduto VARCHAR(10),
nome VARCHAR(30),
preco REAL,
quantidade INT,
precoTotal REAL
);

* CREATE TABLE fornecedores (
codigoFornecedor INT,
cnpj VARCHAR(20),
nomeEmpresa VARCHAR(20),
endereço VARCHAR(30),
nomeContato VARCHAR(20),
telefoneContato VARCHAR(20)
);

* CREATE TABLE categorias (
codigo INT,
nome VARCHAR(20),
descricao VARCHAR(30)
);

* CREATE TABLE produtos (
codigo VARCHAR(10),
nome VARCHAR(20),
categoria INT,
descricao VARCHAR(20),
fornecedor VARCHAR(20)
);

* CREATE TABLE usuarios (
nome VARCHAR(30),
usuario VARCHAR(20),
senha VARCHAR(20),
tipo VARCHAR(20),
status boolean
);

---

## 🛠️ **Technologies**

![Java](https://img.shields.io/badge/-Java-05122A?style=flat&logo=Java)&nbsp;
![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-05122A?style=flat&logo=PostgreSQL&logoColor=1572B6)&nbsp;
