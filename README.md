# Person Management API  

Uma aplicação desenvolvida em Java 21 para gerenciar entidades do tipo **Person**, utilizando uma estrutura baseada em camadas (Controller, Service, Repository, Model) e o banco de dados MySQL para persistência.  

## Tecnologias Utilizadas  

- **Java 21**  
- **Spring Boot** (versão mais recente)  
- **JPA/Hibernate** (para persistência de dados)  
- **MySQL** (banco de dados relacional)  

## Estrutura do Projeto  

O projeto segue uma arquitetura em camadas, garantindo organização e facilidade de manutenção:  

- **Model**: Representa a entidade `Person` e seus atributos.  
- **Repository**: Interface para gerenciar operações de persistência relacionadas à entidade `Person`.  
- **Service**: Contém a lógica de negócio para a manipulação da entidade `Person`.  
- **Controller**: Exposição de endpoints REST para interagir com a aplicação.  

## Configuração do Banco de Dados  

Antes de executar o projeto, configure o MySQL:  

1. Crie um banco de dados no MySQL:  
   ```sql
   CREATE DATABASE course_erudio;
