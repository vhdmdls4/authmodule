# 🔐 Projeto: Sistema de Autenticação com Spring Boot

## 📌 Descrição
Este projeto é um sistema de autenticação desenvolvido em **Java** utilizando **Spring Boot**. Ele implementa os principais conceitos de segurança, incluindo:
- **Autenticação de Usuários**
- **Gerenciamento de Roles e Permissões**
- **Geração e Validação de Tokens JWT**
- **Proteção de Rotas e Filtros de Segurança**

O projeto segue boas práticas de **Programação Orientada a Objetos (POO)** e utiliza **Spring Security** para garantir a segurança das operações.

## 🚀 Funcionalidades
- **Registro de usuários**
- **Login e geração de token JWT**
- **Validação e expiração de tokens**
- **Definição de roles (ADMIN, USER, etc.)**
- **Proteção de rotas com base nas permissões do usuário**

## 🛠️ Tecnologias Utilizadas
- **Java 17+**: Linguagem de programação
- **Spring Boot**: Framework para construção do back-end
- **Spring Security**: Mecanismo de autenticação e autorização
- **JWT (JSON Web Token)**: Gerenciamento de autenticação segura
- **Hibernate & JPA**: Persistência de dados
- **Liquibase**: Controle de versão do banco de dados
- **BCrypt**: Hash de senhas para segurança
- **MySQL/PostgreSQL**: Banco de dados relacional

## 🎯 Como Executar
1. Clone este repositório para sua máquina local.
2. Configure o banco de dados e atualize as credenciais no `application.properties`.
3. Execute o comando:
   ```sh
   mvn spring-boot:run
   ```
4. Acesse a API através de um cliente HTTP (Postman, cURL, etc.).

## 📂 Estrutura do Projeto
```
📁 auth-system
├── 📂 src/main/java/com/victorhugo/authmodule/
│   ├── 📂 model/ (Classes de modelo de dados)
│   ├── 📂 service/ (Lógica de negócios e autenticação)
│   ├── 📂 controller/ (Endpoints da API)
│   ├── 📂 repository/ (Acesso ao banco de dados)
│   ├── 📂 security/ (Configuração de segurança e filtros)
│   ├── 📂 config/ (Configurações gerais do sistema)
├── 📂 resources/
│   ├── 📄 application.properties
│   ├── 📄 db.changelog.xml (Liquibase)
├── 📄 pom.xml (Dependências do projeto)
└── 📄 README.md
```

## 💡 Possíveis Melhorias
- Implementação de autenticação OAuth2
- Suporte a multi-fator de autenticação (MFA)
- Integração com APIs externas para autenticação social (Google, Facebook, etc.)

---
Este projeto é uma implementação prática de autenticação e segurança no **Spring Boot**, garantindo boas práticas e escalabilidade para aplicações seguras. 🚀🔐