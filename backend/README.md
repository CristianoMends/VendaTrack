<h1 align="center" style="font-weight: bold;">Sales Record System💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Começando</a> • 
  <a href="#routes">Endpoints da API</a> •
 <a href="#colab">Colaboradores</a> •
 <a href="#contribute">Contribuindo</a> •
 <a href="#Licença">Licença</a>
</p>

<p align="center">
    <b>O Sales Record System é uma aplicação REST desenvolvida em Java utilizando o framework Spring Boot. Este sistema permite o registro, atualização, exclusão e pesquisa de vendas. A aplicação é configurada para utilizar um banco de dados PostgreSQL e fornece uma API para interagir com os registros de vendas.
</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java
- Spring Boot 3
- PostgreSQL
- Gradle
- FlyWay Migrations

<h2 id="started">🚀 Começando</h2>

<h3>Pre-Requisitos</h3>

- [Java 17+](https://www.java.com/pt-BR/download/manual.jsp)
- [Gradle](https://gradle.org/install/)
- [Postgres](https://www.postgresql.org/)

<h3>Clonando o projeto</h3>

Cole a url abaixo para clonar o projeto
```bash
git clone https://github.com/CristianoMends/sales-record-system
```

<h3>Configure as variaveis de ambiente</h2>


```yaml
   url: ${DATABASE_URL}
   username: ${DATABASE_USERNAME}
   password: ${DATABASE_PASSWORD}
```

<h2 id="routes">📍 Endpoints da API</h2>

​
| Route                         | Description                                                                         
|-------------------------------|-------------------------------------------------------------------------------------
| <kbd>POST /sales</kbd>        | Registra uma venda. Consulte [detalhes da resposta](#save-sale)                     
| <kbd>DELETE /sales/{id}</kbd> | Exclui uma venda pelo ID. Consulte [detalhes da resposta](#delete-sale)             
| <kbd>PATCH /sales/{id}</kbd>  | Atualiza parcialmente uma venda. Consulte [detalhes da resposta](#update-sale)      
| <kbd>GET /sales</kbd>         | Lista todas as vendas registradas. Consulte [detalhes da resposta](#get-all-sales)  
| <kbd>POST /sales/search</kbd> | Pesquisa vendas com base em filtros. Consulte [detalhes da resposta](#search-sales) 

<h3 id="save-sale">POST /sales</h3>

**REQUEST**
```json
{
  "price": 100.0,
  "description": "Venda de Produto X",
  "paymentMethod": "CREDIT"
}
```

RESPONSE

```json
sale registered successfully
```
<h3 id="delete-sale">DELETE /sales/{id}</h3>

### RESPONSE

```json
sale deleted successfully

```
<h3 id="update-sale">PATCH /sales/{id}</h3>

### REQUEST

```json
{
  "description": "Venda Atualizada",
  "price": 150.0,
  "paymentMethod": "DEBIT"
}
```

### RESPONSE

```json
sale updated successfully
```
<h3 id="get-all-sales">GET /sales</h3>

### RESPONSE

```json
[
  {
    "price": 100.0,
    "description": "Venda de Produto X",
    "paymentMethod": "CREDIT",
    "date": "2024-08-21T14:45:00"
  },
  {
    "price": 50.0,
    "description": "Venda de Produto Y",
    "paymentMethod": "DEBIT",
    "date": "2024-08-21T15:00:00"
  }
]
```
<h3 id="search-sales">POST /sales/search</h3>

### REQUEST

```json
{
  "description": "Produto X",
  "minPrice": 50.0,
  "maxPrice": 200.0,
  "startDate": "2024-08-01T00:00:00",
  "endDate": "2024-08-31T23:59:59",
  "paymentMethod":"PIX"
}
```
### RESPONSE

```json
[
  {
    "price": 100.0,
    "description": "Venda de Produto X",
    "paymentMethod": "PIX",
    "date": "2024-08-21T14:45:00"
  }
]
```
<h2 id="colab">🤝 Colaboradoes</h2>

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

<h2 id="contribute">📫 Contribuindo</h2>


1. `git clone https://github.com/CristianoMends/sales-record-system`
2. `git checkout -b feature/NOME-DA-FUNCIONALIDADE`
3. Siga os padrões de commit.
4. Abra um Pull Request explicando o problema resolvido ou recurso realizado, se existir, anexe screenshot das modificações visuais e aguarde a revisão!

## Licença
Este projeto é licenciado sob os termos da [MIT Licence](license).