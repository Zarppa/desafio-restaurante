# Desafio votação Restaurante

Api desenvolvida para contemplar as seguintes estórias:

Estória 01 
Eu como profissional faminto Quero votar no meu restaurante favorito Para que eu consiga democraticamente levar meus colegas a comer onde eu gosto. 
Critério de Aceitação 
•Um profissional só pode votar em um restaurante por dia. 
 
Estória 2 
Eu como facilitador do processo de votação Quero que um restaurante não possa ser repetido durante a semana Para que não precise ouvir reclamações infinitas! 
Critério de Aceitação 
•O mesmo restaurante não pode ser escolhido mais de uma vez durante a semana. 
 
Estória 3 
Eu como profissional faminto Quero saber qual foi o restaurante escolhido Para que eu possa me despir de preconceitos e preparar o psicológico. 
Critério de Aceitação 
•Mostrar de alguma forma o resultado da votação. 


Para elaboração do projeto foi usado Java 8 com Spring Boot e Spring Data, o banco de dados utilizado foi o MySQL junto com o XAMPP.

Para facilitar o uso da API, foi criado um serviço que é chamado automaticamente para criar o banco de dados e popular a lista de restaurantes e funcionarios.


Restaurantes:

(1, 'Av. Cristóvão Colombo, 1971 - Floresta, Porto Alegre', 'Palatos'),
(2, ' Prédio 41 - PUCRS - Avenida Ipiranga, 6681 - Praia de Belas, Porto Alegre', 'Panorama Gastronomico'),
(3, ' R. da República, 509 - Cidade Baixa, Porto Alegre', 'Via Imperatore'),
(4, 'PUCRS, Av. Ipiranga, 6881 - Partenon, Porto Alegre', 'Restaurante Sabor Familia'),
(5, 'Vila Joao Pessoa, Porto Alegre', 'Silva Lanches');


Funcionários:

(1, 'guilherme.palma@dbserver.com.br', 'Guilherme Palma'),
(2, 'joao.silva@dbserver.com.br', 'João da Silva'),
(3, 'fernanda.martins@dbserver.com.br', 'Fernanda Martins'),
(4, 'ana.maia@dbserver.com.br', 'Ana Maia'),
(5, 'lucas.gomes@dbserver.com.br', 'Lucas Gomes'),
(6, 'leticia.glass@dbserver.com.br', 'Leticia Glass'),
(7, 'eduardo.santos@dbserver.com.br', 'Eduardo Santos');


A documentação da API foi customizada usando Swagger na versao 2.7, ao startar a aplicação ficará disponivel em:
http://localhost:8080/swagger-ui.html


