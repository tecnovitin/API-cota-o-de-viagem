# API de Cotação de Viagens


## Sobre o Projeto

Esta é uma API RESTful para um sistema de cotação de viagens. O projeto foi desenvolvido com foco em boas práticas de desenvolvimento, utilizando o ecossistema Spring para criar uma aplicação robusta, bem estruturada e com código limpo.

O objetivo principal é gerenciar clientes, destinos, cotações e pagamentos, oferecendo uma solução completa para agências de viagem ou plataformas de turismo.



## Funcionalidades


A API oferece os seguintes recursos:

Gerenciamento de Clientes:

Cadastro de novos clientes.

Listagem de todos os clientes.

Busca de cliente por e-mail.

Atualização de dados de clientes.

Gerenciamento de Destinos:

Cadastro de novos destinos turísticos com preço por pessoa.

Listagem de todos os destinos.

Busca de destino por ID.

Atualização e remoção de destinos.

Cotações de Viagem:

Criação de novas cotações, associando um cliente e um destino.

Cálculo automático do valor total da cotação com base no número de pessoas e no preço do destino.

Listagem e detalhamento de cotações.

Remoção de cotações.

Gerenciamento de Pagamentos:

Registro, listagem, atualização e remoção de pagamentos associados a uma cotação.

Cálculo de Descontos:

Aplicação de descontos com base em regras de negócio, como destinos específicos e períodos de baixa temporada.




## Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

Backend:

Java 21

Spring Boot 3.2.2: Framework principal para a construção da aplicação.

Spring Data JPA: Para persistência de dados e comunicação com o banco de dados.

PostgreSQL: Banco de dados relacional utilizado no projeto.

Lombok: Para reduzir código boilerplate nas entidades e DTOs.

MapStruct: Para o mapeamento eficiente entre DTOs e Entidades.


## Testes:

JUnit 5: Para a criação e execução de testes unitários.

Mockito: Para a criação de mocks nos testes.


## Documentação:

SpringDoc (Swagger/OpenAPI): Para a geração automática da documentação da API.
