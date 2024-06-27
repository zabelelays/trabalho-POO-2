# Nome do Projeto

Este é um projeto Spring Boot que usa PostgreSQL como banco de dados. Este arquivo README fornece instruções sobre como configurar e executar o projeto.

## Pré-requisitos

- Java 8 ou superior
- Maven
- Docker e Docker Compose

## Configuração do Banco de Dados

Este projeto usa PostgreSQL como banco de dados. Você pode subir um container do PostgreSQL usando o Docker Compose com o seguinte comando:

```bash
docker-compose up -d
```
## Construção do Projeto
Para construir o projeto, navegue até o diretório raiz do projeto e execute o seguinte comando:
```bash
mvn install
```
## Execução do Projeto
Após a construção bem-sucedida do projeto, você pode executar o projeto com o seguinte comando:
```bash
mvn spring-boot:run
```

## Execução via .jar
Você também pode executar o projeto gerando um arquivo .jar e executando-o com o seguinte comando:
```bash
mvn package
java -jar target/sge-market-0.0.1-SNAPSHOT.jar
```