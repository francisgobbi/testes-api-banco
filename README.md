# Desafio técnico de QA para o Sicredi 

Este é um repositório que contém a automação de alguns testes de API Rest de uma aplicação com as seguintes funcionalidades:
- #### GET /test - Buscar o status da aplicação
- #### GET /users - Buscar usuário para autenticação
- #### POST /auth/login - Criação de token para Autenticação
- #### GET /auth/products - Buscar produtos com autenticação
- #### POST /products/add - Criação de produto
- #### GET /products - Buscar todos os produtos
- #### GET /products/{id} - Buscar apenas um produto por id

. Os sub tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.


## Tecnologia Utilizadas

- Java
  https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html
- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.2
- RestAssured
  https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0
- Maven
  https://maven.apache.org/
- Postman
  https://www.postman.com/


## Testes Automatizados

Teste para  buscar o status da aplicação
ok

Teste para buscar usuário para autenticação
ok

Teste para a criação de token para Autenticação
ok

Teste para buscar produtos com autenticação


Teste para validar o cadastro de um produto novo. Seguindo os padrões da regra de negócio.
OK

Cadastrar/adicionar um produto novo.
** Na documentação o Response - 201 OK
No teste realizado o Response - 200 OK, diferente da docuementação.

Consultar produtos cadastrados, atraves do seu ID
OK

## Notas Gerais

- Neste projeto fizemos o uso do JUnit 5, o que nos da possibilidade de usar anotações DisplayName para dar descrições em português para nossos testes.
- Armazenamos os dados que são enviados para API através de uso de classes POJO.
- Testes exploratórios em API Rest, eurística VADER.

   
  
    
 
