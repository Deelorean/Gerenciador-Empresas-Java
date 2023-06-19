# Documentação do Programa Java de Gerenciamento de Empresas

O programa Java de Gerenciamento de Empresas é composto por três classes: `Empresa`, `EmpresaDAO` e `MenuPrincipal`. O objetivo desse programa é permitir o cadastro, remoção, listagem e atualização de informações sobre empresas.

A seguir, será apresentada uma documentação detalhada de cada classe, incluindo suas funcionalidades, métodos e atributos.

## Classe Empresa

A classe `Empresa` representa uma entidade que contém informações sobre uma empresa. Ela possui os seguintes atributos:

- `id` `(int)`: Identificador único da empresa.
- `nome` `(String)`: Nome da empresa.
- `cnpj` `(String)`: CNPJ da empresa.
- `quantidadeFuncionarios` `(int)`: Quantidade de funcionários da empresa.
- `nomeGerente` `(String)`: Nome do gerente responsável pela empresa.
- `areaAtuacao` `(String)`: Área de atuação da empresa.

A classe `Empresa` possui um construtor para inicializar os atributos e métodos getters e setters para acessar e modificar os valores dos atributos.

Métodos principais da classe `Empresa`:

- `toString()`: Retorna uma representação em formato de string dos atributos da empresa.

## Classe EmpresaDAO

A classe `EmpresaDAO` é responsável pela comunicação com o banco de dados e contém os métodos para adicionar, remover, listar e atualizar empresas. A conexão com o banco de dados é estabelecida usando o driver JDBC e uma conexão MySQL.

A classe `EmpresaDAO` possui os seguintes atributos estáticos para configuração do banco de dados:

- `URL` (String): URL de conexão com o banco de dados.
- `USUARIO` (String): Usuário de acesso ao banco de dados.
- `SENHA` (String): Senha de acesso ao banco de dados.

Métodos principais da classe `EmpresaDAO`:

- `adicionarEmpresa(Empresa empresa)`: Adiciona uma empresa ao banco de dados.
- `removerEmpresa(int id)`: Remove uma empresa do banco de dados com base no ID.
- `listarEmpresas()`: Retorna uma lista com todas as empresas cadastradas no banco de dados.
- `buscarEmpresa(int id)`: Busca uma empresa no banco de dados com base no ID.
- `atualizarEmpresa(Empresa empresa)`: Atualiza os dados de uma empresa no banco de dados.

## Classe MenuPrincipal

A classe `MenuPrincipal` é responsável por exibir um menu interativo para o usuário, onde ele pode escolher as opções de adicionar, remover, listar e atualizar empresas. Essa classe utiliza a classe `EmpresaDAO` para executar as operações no banco de dados.

Métodos principais da classe `MenuPrincipal`:

- `main(String[] args)`: O ponto de entrada do programa. Exibe o menu principal e executa as ações escolhidas pelo usuário.
- `exibirMenu()`: Exibe o menu para o usuário e retorna a opção selecionada.
- `adicionarEmpresa()`: Permite ao usuário adicionar uma nova empresa.
- `removerEmpresa()`: Permite ao usuário remover uma empresa existente.
- `listarEmpresas()`: Lista todas as empresas cadastradas.
- `atualizarEmpresa()`: Permite ao usuário atualizar os dados de uma empresa existente.

## Banco de dados

O banco de dados relacional utilizado no código foi criado através do MySQL e hospedado no [PlanetScale](https://app.planetscale.com/). Os dados para conexão não serão informados devido ao PlanetScale ter uma automação que automaticamente derruba a conexão caso seja detectada as credenciais em algum repositório no GitHub.

CREATE DATABASE **PROJETOA3**;

CREATE TABLE **empresa** (  
**id** `INT` PRIMARY KEY AUTO_INCREMENT,  
  **nome** `VARCHAR(255)` NOT NULL,  
  **cnpj** `VARCHAR(14)` NOT NULL,  
  **quantidade_funcionarios** `INT` NOT NULL,  
  **nome_gerente** `VARCHAR(255)` NOT NULL,  
  **area_atuacao** `VARCHAR(255)` NOT NULL  
);

## Utilização do Programa

O programa permite as seguintes interações com as empresas:

1. Adicionar uma nova empresa:
   - O usuário pode adicionar uma nova empresa fornecendo todas as informações necessárias, como nome, CNPJ, quantidade de funcionários, nome do gerente e área de atuação.

2. Remover uma empresa existente:
   - O usuário pode remover uma empresa informando o ID da empresa que deseja remover. Essa ação resultará na exclusão permanente dos dados da empresa no banco de dados.

3. Listar todas as empresas:
   - O usuário pode listar todas as empresas cadastradas no banco de dados. Essa ação exibirá na tela as informações de todas as empresas, como nome, CNPJ, quantidade de funcionários, nome do gerente e área de atuação.

4. Atualizar os dados de uma empresa:
   - O usuário pode atualizar os dados de uma empresa existente fornecendo o ID da empresa e as novas informações. Isso permitirá a modificação dos dados da empresa no banco de dados.

Ao executar o programa, será exibido um menu principal com as opções disponíveis. O usuário poderá escolher uma das opções digitando o número correspondente e pressionando Enter. O programa irá executar a ação desejada e, em seguida, retornará ao menu principal para que o usuário possa realizar outras operações.
