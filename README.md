-----

# FórumHub API | Challenge Alura + ONE 🚀

API REST desenvolvida no Challenge Back End da **Alura + Oracle Next Education** para simular um fórum com múltiplos recursos, validações e autenticação JWT.

-----

## 📋 Tabela de Conteúdos

1. [Sobre o Projeto](#1-sobre-o-projeto)
2. [Funcionalidades Principais](#2-funcionalidades-principais)
3. [Tecnologias](#3-tecnologias)
4. [Estrutura do Banco de Dados](#4-estrutura-do-banco-de-dados)
5. [Configuração e Execução](#5-configuração-e-execução)
6. [Documentação da API](#6-documentação-da-api)
7. [Créditos e Licença](#7-créditos-e-licença)

-----

## 1\. Sobre o Projeto

O **FórumHub** é uma API que replica o backend de um fórum de discussões. O objetivo é permitir que usuários criem, consultem, atualizem e deletem tópicos de discussão, tudo de forma segura e seguindo as melhores práticas do modelo REST. O projeto implementa um sistema de autenticação e autorização para proteger as rotas e garantir que os usuários possam gerenciar apenas seus próprios conteúdos.

-----

## 2\. Funcionalidades Principais

  - **CRUD Completo** para usuários, tópicos, cursos e respostas via REST:

      - `POST`: Criar um novo recurso.
      - `GET`: Consultar/listar recursos.
      - `PUT`: Atualizar um recurso existente.
      - `DELETE`: Deletar um recurso.

  - **Perfis de Usuário** com diferentes níveis de permissão:

      - **Administradores**: Acesso total para criar, atualizar e deletar qualquer recurso.
      - **Usuários Comuns**: Podem criar tópicos/respostas e gerenciar apenas os recursos de sua autoria.

  - **Autenticação via JWT**: Todos os endpoints (exceto `/login` e `/usuarios` para cadastro) são protegidos e exigem um token de autenticação válido.

  - **Validações de Entrada**: Regras de negócio aplicadas para garantir a consistência e integridade dos dados.

  - **Persistência de Dados** em um banco relacional.

-----

## 3\. Tecnologias

  - Java 17+
  - Spring Boot 3
  - Spring Data JPA
  - Spring Security JWT
  - MySQL (Banco Relacional)
  - Flyway
  - Maven
  - Swagger/OpenAPI

-----

## 4\. Estrutura do Banco de Dados

**Diagrama Entidade-Relacionamento (ERD):**

![Diagrama do Banco de Dados](docs/diagrama-db.png)

**Tabelas:**

  - `cursos(id, nome, categoria)`
  - `usuarios(id, nome, email, senha)`
  - `perfis(id, nome)`
  - `usuarios_perfis(usuario_id, perfil_id)`
  - `topicos(id, titulo, mensagem, data_criacao, status, autor_id, curso_id)`
  - `respostas(id, mensagem, data_criacao, solucao, topico_id, autor_id)`

-----

## 5\. Configuração e Execução

### Pré-requisitos

  - Git
  - JDK 17 ou superior
  - Maven 3.8+
  - MySQL 8.0+

### Passo a Passo

**1. Clone o repositório:**

```bash
git clone <url-do-seu-repositorio>
cd <nome-do-repositorio>
```

**2. Crie o banco de dados no MySQL:**

```sql
CREATE DATABASE forum_hub_api;
```

**3. Configure as variáveis de ambiente:**

  - No arquivo `application.properties`, configure as variáveis para acesso ao banco de dados e para a chave secreta do JWT. É recomendado o uso de variáveis de ambiente para segurança.

<!-- end list -->

```properties
# Configurações do Banco de Dados
spring.datasource.url=${DATASOURCE_URL}
spring.datasource.username=${DATASOURCE_USERNAME}
spring.datasource.password=${DATASOURCE_PASSWORD}

# Chave secreta para a geração do Token JWT
api.security.token.secret=${JWT_SECRET}
```

**4. Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

  - A API estará disponível em `http://localhost:8080`.

### Autenticação

  - Para acessar os endpoints protegidos, primeiro realize o login via `POST /login` para obter um token JWT.
  - Envie o token obtido no cabeçalho `Authorization` de suas requisições:

<!-- end list -->

```
Authorization: Bearer <SEU_TOKEN_JWT>
```

-----

## 6\. Documentação da API

A documentação completa e interativa de todos os endpoints está disponível via Swagger UI. Após iniciar a aplicação, acesse:

**[http://localhost:8080/swagger-ui/index.html](https://www.google.com/search?q=http://localhost:8080/swagger-ui/index.html)**

-----

## 7\. Créditos e Licença

Este projeto foi proposto como desafio pelo programa:

  - [Oracle Next Education (ONE)](https://www.oracle.com/br/education/oracle-next-education/)
  - [Alura - Cursos Online de Tecnologia](https://www.alura.com.br/)

O projeto é de uso educacional, livre para estudos e modificações.

-----
Desenvolvido com ❤️ por Janyelle Oliveira
