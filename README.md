# Controle de produtividade

### Resumo: 

Aplicação Back End para controle de produtividade da mão de obra. Permitindo fazer lançamentos diários de tipo de serviço que está sendo executado e o tempo (hora de início e hora fim), calculando a média e verificando se a meta foi alcançada.

Também é possível visualizar os dados resumidos por funcionário. Caso tenha diversos lançamentos ao longo do dia, o sistema agrupa e recalcula a média do volume total para cada tipo de atividade.

### Funcionalidades

- Cadastro, consulta, edição e exclusão de funcionários;
- Cadastro, consulta, edição e exclusão de tipos de serviço e metas de produção;
- Lançamento da quantidade produzida, hora de inicio e hora de término;
- Cálculo de média de produção por hora individual de cada lançamento;
- Resumo das médias de cada funcionário para cada tipo de serviço no dia;

### Tecnologias

- Java 11
- Spring Boot
- Spring Data JPA
- Maven
- REST API
- Swagger UI
- H2 Database

### Preparação do ambiente

- Instalação do JDK 11;

- Eclipse IDE for Enterprise Java and Web Developers 2021-03;

- Faça o clone do projeto na sua máquina;

- Após a instalação e execução do Eclipse, clique em "File" e em seguida "Import";

- Na janela que será aberta busque por "Existing Maven Projects" 

  </br></br>

  ![Select Import](https://github.com/eduardodcs/produtividade/blob/main/imagens-readme/Select%20Import.jpg?raw=true)

  </br></br>

- Clique em "Next" e na próxima janela clique em Browser para buscar a pasta onde foi realizado o clone;

  </br></br>

  ![Select Maven Project](https://github.com/eduardodcs/produtividade/blob/main/imagens-readme/Select%20Maven%20Project.jpg?raw=true)

  </br></br>

- Clique "Finish";

- Após a importação do projeto o Maven irá baixar todas as dependências do sistema, como Spring Boot, Spring Data JPA, H2 Database, TomCat e Swagger;

- Para subir a aplicação localize o arquivo "ProdutividadeApplication.java" no package br.com.eduardo.produtividade, clique com o botão direito do mouse sobre o arquivo, em seguinda em "Run As" e em "Java Application";

  </br></br>

  ![Run As](https://github.com/eduardodcs/produtividade/blob/main/imagens-readme/Run%20As.jpg?raw=true)

  </br></br>

- Após subir a aplicação a documentação estará disponível no endereço "http://localhost:8080/swagger-ui.html", onde estará disponível todas as End Points e as parâmetros necessários;

  </br></br>

  ![SwaggerUI](https://github.com/eduardodcs/produtividade/blob/main/imagens-readme/SwaggerUI.jpg?raw=true)

  </br></br>

- Para testar, você pode baixar o Postman e fazer as requisições conforme documentado no Swagger;

  </br></br>

  ![Postman](https://github.com/eduardodcs/produtividade/blob/main/imagens-readme/Postman.jpg?raw=true)

  </br></br>



