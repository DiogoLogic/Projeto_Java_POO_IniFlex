# Teste Prático Iniflex - Gerenciamento de Funcionários

Este projeto em Java usa o padrão MVC (Model-View-Controller) para gerenciar informações de funcionários em uma indústria.

## ⚙️ Funcionalidades

### CRUD de Funcionários:
- **Criação**: Adiciona novos funcionários à lista.
- **Leitura**: Exibe informações de todos os funcionários.
- **Atualização**: Aplica um aumento de 10% no salário de todos os funcionários.
- **Remoção**: Remove um funcionário específico pelo nome.

### Consultas:
- **Agrupamento por Função**: Organiza funcionários por suas funções.
- **Aniversariantes**: Filtra funcionários que fazem aniversário em outubro e dezembro.
- **Funcionário Mais Velho**: Identifica o funcionário com a maior idade.
- **Ordenação Alfabética**: Ordena a lista de funcionários por ordem alfabética.
- **Total de Salários**: Calcula a soma de todos os salários.
- **Salários em Salários Mínimos**: Mostra quantos salários mínimos cada funcionário recebe.

## 🗂️ Estrutura do Projeto (MVC)

### Model:
- `Pessoa.java`: Classe base para representar uma pessoa.
- `Funcionario.java`: Classe que herda de Pessoa, representando um funcionário.
- `GerenciadorFuncionarios.java`: Contém a lógica de negócio para os funcionários.

### View:
- `VisaoConsole.java`: Exibe as informações no console.

### Controller:
- `Principal.java`: Controla a interação entre o modelo e a visão.

## 🛠️ Pré-requisitos
- Java JDK 8 ou superior

## 🚀 Como Executar

Clone o Repositório:
```bash
git clone https://github.com/DiogoLogic/Projeto_Java_POO_IniFlex.git
