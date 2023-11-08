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

##	Configurações de pastas do projeto:

##  Folder project:

- A pasta **src** tem a seguinte estrutura informada, **test** --> **java** --> **ModulosAPI**, **Test**, para cada funcionalidade da API.

## Testes Automatizados

- Teste para  buscar o status da aplicação - ok


- Teste para buscar usuário para autenticação - Expected status code <201> but was <200>.


- Teste para a criação de token para Autenticação -ok


- Teste para buscar produtos com autenticação - ok


- Teste para buscar todos os produtos na documentação no Request não precisa informar o token, mas precisa informar o token, realizei o teste informando o token e foi sucesso!


- Teste para validar o cadastro de um produto novo. Seguindo os padrões da regra de negócio - ok


- Cadastrar/adicionar um produto novo.
Na documentação o Response - 201 OK
No teste realizado o Response - 200 OK, diferente da documentação da API.
  Expected status code <201> but was <200>.


- Consultar produtos cadastrados, atraves do seu ID - ok

## Observação - Como executar
- O saldo atual das contas sera exibido no momento da execução.
- Para clonar o projeto BugBank em seu computador e executar, realize estes passos abaixo :
- - Open Git Bash here
- - Digitar: git clone https://gitlab.com/projeto-de-teste-automatizado/desafiotecnicoqasicredi.git
- - Projeto sera clonado no seu computador.
- Para executar o projeto, realize estes passo :
- - Maven no IntelliJ
- - Reload all Maven Project
- - Executar a funcão na pasta **src** -> **test** -> **java** -->  **ModulosAPI** -->  BuscarApenasUmProdutoPorIdTest , BuscarProdutosComAutenticacaoTest, BuscarStatusDaAplicacaoTest, BuscarTodosOsProdutosTest, BuscarUsuarioParaAutenticacaoTest, CriacaoDeTokenParaAutenticacaoTest, CriarProdutoTest  

- Caso não conseguir executar o projeto com sucesso, realize os passos abaixo:
- - mvn clean
- - mvn install
## Notas Gerais

- Neste projeto fizemos o uso do JUnit 5, o que nos da possibilidade de usar anotações DisplayName para dar descrições em português para nossos testes.
- Armazenamos os dados que são enviados para API através de uso de classes POJO.
- Testes exploratórios em API Rest, eurística VADER.

   
  
    
 
