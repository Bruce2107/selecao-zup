# SELEÇÃO ZUP
API em SpringBoot com Kotlin

**Banco de dados**: POSTGRESQL:9.6
1. Porta: 5432
2. Senha: secret
3. User: postegres
4. DATABASE_NAME: selecao
  - `CREATE DATABASE selecao;`
5. TABLE: person
  - `CREATE TABLE person(id serial not null, name varchar(75) not null, cpf varchar(11) not null, address varchar(200) not null, nasc date);`
