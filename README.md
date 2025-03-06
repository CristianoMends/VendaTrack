# Arquitetura Hexagoal 💻

<div align="center">
    <img src="https://engsoftmoderna.info/artigos/figs/hex-ports-adapters.svg" height="250px">
</div>

## 📌 Sobre o Projeto
O **Sales Record System** é uma aplicação REST desenvolvida em **Java** com **Spring Boot** para registro, exclusão e pesquisa de vendas. Utiliza **PostgreSQL** como banco de dados e segue a **Arquitetura Hexagonal**, visando estudo e aplicação de boas práticas.

## 🚀 Tecnologias
- Java 17+
- Spring Boot 3
- PostgreSQL
- Gradle
- Flyway Migrations

## ⚙️ Arquitetura
O sistema segue a Arquitetura Hexagonal (Ports and Adapters), permitindo a separação clara entre as regras de negócio e a infraestrutura, tornando o código mais modular e testável.

## 📍 Endpoints da API
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/sale` | Registra uma venda |
| DELETE | `/sale/{id}` | Exclui uma venda pelo ID |
| GET | `/sale` | Lista todas as vendas |

## 🤝 Colaborador
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/CristianoMends">
        <img src="https://avatars.githubusercontent.com/u/116528159?v=4" width="100px;" alt="Cristiano Mendes Profile Picture"/><br>
        <sub>
          <b>Cristiano Mendes</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## 📝 Licença
Este projeto está sob a [Licença MIT](license).

