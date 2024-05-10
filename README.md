# Atividade Complementar AV2 Sistemas Distribuidos

### Discente: João Vitor Mendes Pinto dos Santos

Este repositório é para a atividade complementar 2 da disciplina de Sistemas Distribuidos.

##### Objetivo

O projeto da unidade envolve a criação de uma aplicação distribuída que simula um quiz de perguntas e respostas. Deve-se implementar um servidor usando RPC ou Socket, o qual gerenciará as regras do jogo e permitirá que múltiplas aplicações clientes se conectem para participar.

##### Implementação

Foram escolhidas as duas linguagens vistas em sala, java para o servidor e python para o cliente. O protocolo escolhido para a comunicação foi o RPC. Para auxilar no desenvolvimento do codigo em java foi utilizado o gestor de dependencias do maven, bem como as bibliotecas de xlmrpc-server e sqlite-jdbc. Enquanto no python foi apenas necessário utilizar a biblioteca xmlrpc.client. 

|Versão|
|------|
|[![java](https://badge.ttsalpha.com/api?label=java&status=21&color=dark&labelColor=red)](https://example.com)|
|[![java](https://badge.ttsalpha.com/api?label=python&status=3.12.3&color=dark&labelColor=green)](https://example.com)|

A arquitetura dos pacotes de java foram divididos em três categorias o servidor com uma única classe app, os controladores que que fizeram o gerencimento das informações, onde o QuizHandler é a classe que esta sendo utilizada para receber as chamadas dos metodos por parte do cliente, instanciada no servidor RPC. A classe DataBaseHandler é o controlador responsável por interagir com o banco de dados e realizar as consultas e inserções desejadas. Os três modelos são apenas as representações dos objetos desejados para o quiz, as questões, as respostas e os jogadores.

![Screenshot from 2024-05-09 23-59-54](https://github.com/juauzitor/atividade-2-SD/assets/55886077/74f2b253-12f7-4ab7-87d7-58b26a13f2bc)

O banco dados existe para registrar um ranking dos jogadores com suas pontuações e armazenar as questões. É uma implementação bem simples utilizando o sqlite 3, onde a entidade de questoes possue a pergunta com modo TEXT, respostas é uma tabela com relação de n para 1 com questoes, e cada questão pode ter mais de uma respota, entretanto as respostas corretas estaram marcadas. ranking não se liga com nenguma outra tabela pois apenas precisa receber o valor inserido das funções em DataBaseHandler.

![Screenshot from 2024-05-10 00-22-24](https://github.com/juauzitor/atividade-2-SD/assets/55886077/007d84f5-7030-4823-ba60-cf9ec8868779)

A Aplicação cliente é responsável em conectar no servidor RPC e interagir com as funções em QuizHandler. Ela permite duas opções jogar o quiz ou ver o ranking dos jogadores. Toda a aplicação é em CLI. Para jogar é só colocar seu nome e depois responder as questões que aparecem. Ao final das questões os resultados são devolvidos e avaliados pelo servidor, o resultado é inserido no banco de dados e retorna para o cliente, permitindo que o jogador saiba sua pontuação.

![Screenshot from 2024-05-09 23-59-35](https://github.com/juauzitor/atividade-2-SD/assets/55886077/4a01ffd8-a8b6-4d81-be2d-e161ea71b63c)

