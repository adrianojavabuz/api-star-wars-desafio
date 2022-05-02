# api-star-wars-desafio
## Introdução
Utilizando a API Star Wars(https://swapi.dev/), cria uma API na linguagem que preferir que cumpra certos requisitos.

### Requisitos
* Ao subir a aplicação, deverá ser carregado em memória a lista de filmes;
* Criar um endpoint onde é possivel alterar a descrição de um filme em memória;
* Criar um endpoint onde é possivel listar os filmes da saga;
* Criar um endpoint onde é possivel exibir detalhes de um filme;
* Criar um endpoint onde é possivel detalhar um filme especifico;
* Criar um mecanismo de controle de alteração onde toda vez que uma descrição é alterada, o campo versão do filme deve ser alterado de forma incremental
* A versão do filme devera retornar junto com a lista do filme.

### Versão Java
A versão utilizada para esse projeto é:
```sql
11 Oracle OpenJDK version 11.0.14
```

### Execução do Projeto
Executar o comando na pasta target, nome dor arquivo: api-star-wars-desafio-0.0.1-SNAPSHOT.jar
```sql
java -jar api-star-wars-desafio-0.0.1-SNAPSHOT.jar
```

### Ducomentação API
A documentação da api pode ser acessada pelo endereço: [**Swagger**](http://localhost:8088/swagger-ui.html)


## Postman Collection
Aplicação irá subir na porta: 8088
Collection de requisições do Postman disponível no seguinte caminho:  [**Desafio SWAPI.postman_collection**](src/main/resources/Desafio%20SWAPI.postman_collection.json)

