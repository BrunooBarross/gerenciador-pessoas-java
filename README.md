<p align="center">
  <h1 align="center">
    Teste tecnico Eloware - Gerenciador de Pessoas
  </h1>
</p>

## 💻 Tecnologias Utilizadas

- Java
- Spring boot
- Api Rest
- Maven
- H2
- JPA

---

## 👨🏻‍💻 Instalação

```bash
$ git clone https://github.com/BrunooBarross/gerenciador-pessoas-java

$ Na sua IDE importe um novo projeto maven existente e selecione a pasta gerenciador-pessoas-java

$ Dê run as Spring Boot App na classe MainApplication 

```

```
- Para acessar o console do banco em memória acesse em um navegador a url: http://localhost:8080/h2-console

```

## 🚀 API:

- Caminho das rotas - http://localhost:8080

- Nota: Na pasta Insomnia possui um arquivo para importação no programa Insomnia. 
- Leia: https://docs.insomnia.rest/insomnia/import-export-data

```yml
POST /persons
    - Rota para cadastro de pessoas
    - headers: {}
    - body: {
        "name": String - Min 3 caracteres Max 45 caracteres,
        "birthDate": Formato - 2000-01-01 (yyyy-MM-dd)
    }
```

```yml
GET /persons
    - Rota que retorna os todos os usuários e endereços
    - headers: {}
    - body: {}
```

```yml
GET /persons/{id}
    - Rota que retorna uma determinada pessoa por seu id
    - headers: {}
    - body: {}
```

```yml
PUT /persons/{id} 
    - Rota destinada a atualizar dados de uma pessoa via id enviador por parametro
    - headers: {}
    - body: {
        <Optional>"name":  String - Min 3 caracteres Max 45 caracteres,
        <Optional>"birthDate": Formato - 2000-01-01 (yyyy-MM-dd)
    }
```

```yml
POST /address
    - Rota que cadastra endereços de uma pessoa
    - headers: { "personId": "{id}" }
    - body: {
        "logradouro": String Min 3 caracteres Max 100 caracteres,
        "cep":  String Min 3 caracteres Max 20 caracteres,
        "typeAddress": ENUM -> 0 para endereço principal e 1 para endereço secundario 
              (O usuário pode ter somente um endereço principal, caso tente adicionar mais de um o último adicionado prevalecerá como principal),
        "numero":  Valor maximo 5000,
        "cidade":  String Min 3 caracteres Max 40 caracteres
    }
```

```yml
PUT /address/main/{id} 
    - Rota que atualiza o endereço principal de um usuário - parametro id do endereço
    - headers: { "personId": "{id}" }
    - body: {}
```