AcademiaApp
Este repositório contém o código-fonte de um sistema de gerenciamento para uma academia de ginástica, desenvolvido em Java. O sistema permite que diferentes tipos de usuários (Administrador, Professor, Aluno, Recepcionista e Funcionário de Limpeza) interajam com a plataforma, executando tarefas específicas de acordo com seus papéis.

Índice
Descrição Geral
Funcionalidades
Administrador
Professor
Aluno
Recepcionista
Funcionário de Limpeza
Estrutura do Projeto
Como Executar
Dependências
Contribuição
Licença
Descrição Geral
O AcademiaApp é um aplicativo de console que simula o funcionamento de uma academia, permitindo a gestão de usuários, treinos, aulas, máquinas e equipamentos de manutenção. O sistema foi desenvolvido com foco em orientação a objetos, utilizando classes e métodos para representar as diferentes entidades e funcionalidades.

Funcionalidades
Administrador
Gerenciar Usuários: Listar, alterar e remover usuários do sistema.
Revisar Dados Financeiros: Analisar informações financeiras da academia.
Revisar Manutenções: Visualizar manutenções realizadas nos equipamentos.
Gerenciar Máquinas:
Listar Máquinas: Visualizar todas as máquinas disponíveis.
Adicionar Máquina: Incluir novas máquinas, garantindo que o ID seja único.
Modificar Máquina: Alterar as informações de uma máquina existente.
Remover Máquina: Excluir máquinas, informando o motivo da remoção.
Gerenciar Equipamentos de Manutenção:
Listar Equipamentos: Visualizar todos os equipamentos de manutenção.
Adicionar Equipamento: Incluir novos equipamentos, garantindo que o ID seja único.
Modificar Equipamento: Alterar as informações de um equipamento existente.
Remover Equipamento: Excluir equipamentos, informando o motivo da remoção.
Professor
Criar Treino: Desenvolver treinos personalizados, incluindo máquinas, séries e repetições para cada exercício.
Atribuir Treino a Aluno: Designar treinos para alunos específicos.
Criar Aula: Organizar aulas com nome, capacidade e horário.
Aluno
Consultar Treino: Visualizar detalhes do treino atribuído.
Pagar Mensalidade: Realizar o pagamento da mensalidade.
Agendar Aula: Inscrever-se em aulas disponíveis.
Cancelar Aula: Cancelar a inscrição em aulas, seguindo as regras de antecedência.
Alterar Plano: Modificar o plano de assinatura após o vencimento do plano atual, com informações sobre o plano atual e validade.
Recepcionista
Cadastrar Novo Aluno: Registrar novos alunos no sistema.
Cancelar Matrícula: Encerrar a matrícula de alunos, com confirmação.
Gerenciar Pagamentos: Processar pagamentos de mensalidades dos alunos.
Funcionário de Limpeza
Registrar Manutenção: Anotar manutenções realizadas nos equipamentos, utilizando o ID dos equipamentos e registrando o horário atual do sistema.
Estrutura do Projeto
bash
Copiar código
src/
├── main/
│   └── AcademiaApp.java       # Classe principal que inicia o aplicativo
└── model/
    ├── Administrador.java     # Classe para o usuário Administrador
    ├── Aluno.java             # Classe para o usuário Aluno
    ├── Aula.java              # Classe que representa uma Aula
    ├── Exercicio.java         # Classe que representa um Exercício
    ├── FuncionarioLimpeza.java# Classe para o usuário Funcionário de Limpeza
    ├── Maquina.java           # Classe que representa uma Máquina
    ├── Manutencao.java        # Classe que representa uma Manutenção
    ├── Mensalidade.java       # Classe que representa uma Mensalidade
    ├── Professor.java         # Classe para o usuário Professor
    ├── Recepcionista.java     # Classe para o usuário Recepcionista
    ├── Treino.java            # Classe que representa um Treino
    └── Usuario.java           # Classe base para todos os usuários
Como Executar
Clonar o Repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/academia-app.git
cd academia-app/src
Compilar o Código:

bash
Copiar código
javac model/*.java main/AcademiaApp.java
Executar o Aplicativo:

bash
Copiar código
java main.AcademiaApp
Credenciais de Login Padrão:

Administrador:
Login: admin
Senha: 1234
Professor:
Login: professor
Senha: abcd
Aluno:
Login: joao123
Senha: senha123
Recepcionista:
Login: maria
Senha: 4567
Funcionário de Limpeza:
Login: jose
Senha: limpeza123
Dependências
Java 8 ou superior: Certifique-se de ter o JDK instalado em sua máquina.
