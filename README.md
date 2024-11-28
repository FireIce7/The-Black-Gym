# **AcademiaApp**

Este repositório contém o código-fonte de um sistema de gerenciamento para uma academia de ginástica, desenvolvido em **Java**. O projeto foi criado como parte da disciplina de **Programação Orientada a Objetos** da Universidade Veiga de Almeida (UVA), **Campus Barra da Tijuca**.

---

## **Índice**
- [Descrição Geral](#descrição-geral)
- [Funcionalidades](#funcionalidades)
  - [Administrador](#administrador)
  - [Professor](#professor)
  - [Aluno](#aluno)
  - [Recepcionista](#recepcionista)
  - [Funcionário de Limpeza](#funcionário-de-limpeza)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
  - [Passos de Instalação](#passos-de-instalação)
  - [Dependências](#dependências)

---

## **Descrição Geral**

O **AcademiaApp** é um aplicativo de console que simula o funcionamento de uma academia, permitindo a gestão de usuários, treinos, aulas, máquinas e equipamentos de manutenção. O sistema foi desenvolvido com foco em **orientação a objetos**, utilizando classes e métodos para representar as diferentes entidades e funcionalidades.

---

## **Funcionalidades**

### **Administrador**
- **Gerenciar Usuários**: Listar, alterar e remover usuários do sistema.
- **Revisar Dados Financeiros**: Analisar informações financeiras da academia.
- **Revisar Manutenções**: Visualizar manutenções realizadas nos equipamentos.
- **Gerenciar Máquinas**:
  - Listar, adicionar, modificar e remover máquinas.
  - Garantir IDs únicos ao adicionar.
- **Gerenciar Equipamentos de Manutenção**:
  - Listar, adicionar, modificar e remover equipamentos.
  - Registrar motivo para remoções.

### **Professor**
- **Criar Treino**: Desenvolver treinos personalizados (máquinas, séries, repetições).
- **Atribuir Treino a Aluno**.
- **Criar Aula**: Organizar aulas com nome, capacidade e horário.

### **Aluno**
- **Consultar Treino**.
- **Pagar Mensalidade**.
- **Agendar e Cancelar Aula**: Seguindo regras de antecedência.
- **Alterar Plano**: Modificar assinatura após vencimento.

### **Recepcionista**
- **Cadastrar Novo Aluno**.
- **Cancelar Matrícula**: Com confirmação.
- **Gerenciar Pagamentos**.

### **Funcionário de Limpeza**
- **Registrar Manutenção**:
  - Utilizando ID dos equipamentos.
  - Registrar horário atual do sistema.

---

## **Estrutura do Projeto**

```plaintext
src/
├── main/
│   └── AcademiaApp.java           # Classe principal que inicia o aplicativo
└── model/
    ├── Administrador.java         # Classe para o usuário Administrador
    ├── Aluno.java                 # Classe para o usuário Aluno
    ├── Aula.java                  # Classe que representa uma Aula
    ├── Exercicio.java             # Classe que representa um Exercicio
    ├── Frequencia.java            # Classe que representa a Frequencia
    ├── FuncionarioLimpeza.java    # Classe para o usuário FuncionárioLimpeza
    ├── Manutencao.java            # Classe que representa uma Manutencao
    ├── Maquina.java               # Classe que representa uma Maquina (aparelho da academia)
    ├── Mensalidade.java           # Classe que representa a Mensalidade
    ├── Professor.java             # Classe para o usuário Professor
    ├── Recepcionista.java         # Classe para o usuário Recepcionista
    ├── Treino.java                # Classe que representa um Treino
    ├── Usuario.java               # Classe base para todos os demais usuários
```

## **Como Executar**

### **Dependências**

**Java 17 ou superior**.
IDE recomendada: **IntelliJ IDEA** ou **VS Code** com extensão para Java.

### **Passos de Instalação**


1. **Clone o repositório**:

> git clone https://github.com/seu-usuario/AcademiaApp.git

*Importe o projeto para sua IDE preferida*

2. **Configure o JDK**:

Certifique-se de que o JDK 17 ou superior está configurado corretamente na IDE.
No Vs Code Digite **java -version** & **javac -version**, caso não der erro está correto.

3. **Abra a pasta do projeto na sua IDE**

4. **Compile o projeto**:

> javac model/*.java main/AcademiaApp.java

*(Isso no Vs Code)*

5. **Execute o projeto**

> java Main.AcademiaApp

