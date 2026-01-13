# 🛠️ Order Service API

API REST desenvolvida em Java com Spring Boot para gerenciamento de Ordens de Serviço, permitindo o controle de clientes, técnicos e o ciclo de vida das ordens.

---

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

---

## 📌 Funcionalidades
- Cadastro de clientes
- Cadastro de técnicos
- Criação de ordens de serviço
- Listagem de ordens
- Atualização de status da ordem
  - ABERTA
  - EM_ANDAMENTO
  - FINALIZADA
- Registro automático de:
  - Data de abertura
  - Data de fechamento

---

## 🧱 Arquitetura
O projeto segue boas práticas de separação de camadas:

- **Controller** → Exposição dos endpoints REST
- **Service** → Regras de negócio
- **Repository** → Persistência com JPA
- **DTO / Mapper** → Transferência e conversão de dados
- **Entity** → Modelo das tabelas

---

## 🗄️ Banco de Dados
PostgreSQL

Exemplo de configuração (`application.properties`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/orderService
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
📮 Endpoints Principais
Criar Cliente
POST


/clientes
Criar Técnico
POST


/tecnicos
Criar Ordem de Serviço
POST


/ordens-servico
json
Copiar código
{
  "descricao": "Troca de equipamento",
  "cliente": { "id": 1 },
  "tecnico": { "id": 1 }
}
Listar Ordens
GET


/ordens-servico
Buscar Ordem por ID
GET


/ordens-servico/{id}
Atualizar Status da Ordem
PATCH


/ordens-servico/{id}/status?status=EM_ANDAMENTO
bash
Copiar código
/ordens-servico/{id}/status?status=FINALIZADA
🧪 Testes
Os endpoints foram testados utilizando o Postman, validando:

Criação de entidades

Atualização de status

Persistência no banco PostgreSQL

👨‍💻 Autor
César Henrique
Desenvolvedor Java Jr