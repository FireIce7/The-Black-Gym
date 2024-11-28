package Main;

import model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class AcademiaApp {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Aula> aulasDisponiveis = new ArrayList<>();
    static ArrayList<Treino> treinosDisponiveis = new ArrayList<>();
    static ArrayList<Maquina> maquinasDisponiveis = new ArrayList<>();
    static ArrayList<Maquina> equipamentosManutencao = new ArrayList<>();
    static ArrayList<Manutencao> manutencoes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar diferentes usuários para cada tipo de conta
        Mensalidade mensalidade = new Mensalidade(1, 200.0f, LocalDateTime.now().plusMonths(1), "Boleto");
        usuarios.add(new Administrador(1, "Carlos", "admin", "1234"));
        usuarios.add(new Aluno(2, "João", "joao123", "senha123", 0, mensalidade));
        usuarios.add(new Recepcionista(3, "Maria", "maria", "4567"));
        usuarios.add(new Professor(4, "Paulo", "professor", "abcd", "Musculação"));
        usuarios.add(new FuncionarioLimpeza(5, "José", "jose", "limpeza123"));

        // Máquinas disponíveis
        maquinasDisponiveis.add(new Maquina(1, "Supino Reto"));
        maquinasDisponiveis.add(new Maquina(2, "Agachamento Livre"));
        maquinasDisponiveis.add(new Maquina(3, "Leg Press"));

        // Equipamentos de manutenção
        equipamentosManutencao.add(new Maquina(101, "Esteira"));
        equipamentosManutencao.add(new Maquina(102, "Bicicleta Ergométrica"));

        // Criar aulas pré-definidas
        Aula aula1 = new Aula(1, "Yoga", 10, "15/12/2023 10:00");
        Aula aula2 = new Aula(2, "Pilates", 8, "16/12/2023 14:00");
        aulasDisponiveis.add(aula1);
        aulasDisponiveis.add(aula2);

        // Criar treino pré-definido
        Treino treinoPredefinido = new Treino(1, "Treino Iniciante", 2, LocalDateTime.now());

        Exercicio ex1 = new Exercicio(new Maquina(1, "Supino Reto"), 3, 10);
        Exercicio ex2 = new Exercicio(new Maquina(2, "Agachamento Livre"), 3, 12);

        treinoPredefinido.adicionarExercicio(ex1);
        treinoPredefinido.adicionarExercicio(ex2);

        treinosDisponiveis.add(treinoPredefinido);

        // Menu de login
        System.out.println("\nBem-vindo ao sistema de academia! Por favor, faça login.");
        System.out.print("Digite seu login: ");
        String login = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();

        Usuario usuarioLogado = autenticarUsuario(login, senha);
        if (usuarioLogado != null) {
            System.out.println("\nLogin bem-sucedido. Bem-vindo, " + usuarioLogado.getNome() + "!\n");
            mostrarMenuUsuario(usuarioLogado, scanner);
        } else {
            System.out.println("\nLogin falhou. Usuário ou senha incorretos.");
        }

        scanner.close();
    }

    public static Usuario autenticarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(login, senha)) {
                return usuario;
            }
        }
        return null;
    }

    public static void mostrarMenuUsuario(Usuario usuario, Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            if (usuario instanceof Administrador) {
                Administrador admin = (Administrador) usuario;
                System.out.println("\nOpções disponíveis para Administrador:");
                System.out.println("1. Gerenciar Usuários");
                System.out.println("2. Revisar Dados Financeiros");
                System.out.println("3. Revisar Manutenções");
                System.out.println("4. Gerenciar Máquinas");
                System.out.println("5. Gerenciar Equipamentos de Manutenção");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o '\n' restante
                System.out.println();

                if (opcao == 1) {
                    admin.gerenciarUsuarios(usuarios, scanner);
                } else if (opcao == 2) {
                    admin.revisarDadosFinanceiros();
                } else if (opcao == 3) {
                    admin.revisarManutencoes(manutencoes, scanner);
                } else if (opcao == 4) {
                    admin.gerenciarMaquinas(maquinasDisponiveis, scanner);
                } else if (opcao == 5) {
                    admin.gerenciarEquipamentos(equipamentosManutencao, scanner);
                } else if (opcao == 6) {
                    continuar = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                System.out.println("\nOpções disponíveis para Professor:");
                System.out.println("1. Criar Treino");
                System.out.println("2. Atribuir Treino a Aluno");
                System.out.println("3. Criar Aula");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o '\n' restante
                System.out.println();

                if (opcao == 1) {
                    System.out.print("Nome do Treino: ");
                    String nome = scanner.nextLine();
                    System.out.print("Frequência Semanal Mínima: ");
                    int frequencia = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n' restante
                    Treino treino = professor.criarTreino(treinosDisponiveis.size() + 1, nome, frequencia, LocalDateTime.now());

                    System.out.print("Quantas máquinas farão parte deste treino? ");
                    int numMaquinas = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n' restante

                    for (int i = 0; i < numMaquinas; i++) {
                        System.out.println("Máquinas disponíveis:");
                        for (Maquina maquina : maquinasDisponiveis) {
                            System.out.println("ID: " + maquina.getId() + " - " + maquina.getNome());
                        }
                        System.out.print("Digite o ID da máquina " + (i + 1) + ": ");
                        int maquinaId = scanner.nextInt();
                        scanner.nextLine(); // Consumir o '\n' restante

                        Maquina maquinaSelecionada = null;
                        for (Maquina maquina : maquinasDisponiveis) {
                            if (maquina.getId() == maquinaId) {
                                maquinaSelecionada = maquina;
                                break;
                            }
                        }

                        if (maquinaSelecionada != null) {
                            System.out.print("Número de séries: ");
                            int series = scanner.nextInt();
                            System.out.print("Número de repetições: ");
                            int repeticoes = scanner.nextInt();
                            scanner.nextLine(); // Consumir o '\n' restante

                            Exercicio exercicio = new Exercicio(maquinaSelecionada, series, repeticoes);
                            treino.adicionarExercicio(exercicio);
                        } else {
                            System.out.println("Máquina não encontrada.");
                            i--; // Repetir a iteração atual
                        }
                    }

                    treinosDisponiveis.add(treino);
                    System.out.println("Treino " + nome + " criado com sucesso!\n");
                } else if (opcao == 2) {
                    if (!treinosDisponiveis.isEmpty()) {
                        // Listar alunos
                        ArrayList<Aluno> listaAlunos = new ArrayList<>();
                        System.out.println("Selecione um aluno para atribuir o treino:");
                        int index = 1;
                        for (Usuario u : usuarios) {
                            if (u instanceof Aluno) {
                                System.out.println(index + ". " + u.getNome());
                                listaAlunos.add((Aluno) u);
                                index++;
                            }
                        }
                        if (listaAlunos.isEmpty()) {
                            System.out.println("Nenhum aluno cadastrado.\n");
                            continue;
                        }
                        System.out.print("Digite o número do aluno: ");
                        int alunoIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consumir o '\n' restante

                        if (alunoIndex >= 0 && alunoIndex < listaAlunos.size()) {
                            Aluno aluno = listaAlunos.get(alunoIndex);
                            // Listar treinos
                            System.out.println("Selecione um treino para atribuir:");
                            for (int i = 0; i < treinosDisponiveis.size(); i++) {
                                System.out.println((i + 1) + ". " + treinosDisponiveis.get(i).getNome());
                            }
                            System.out.print("Digite o número do treino: ");
                            int treinoIndex = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consumir o '\n' restante

                            if (treinoIndex >= 0 && treinoIndex < treinosDisponiveis.size()) {
                                Treino treino = treinosDisponiveis.get(treinoIndex);
                                professor.atribuirTreino(aluno, treino);
                            } else {
                                System.out.println("Opção de treino inválida.\n");
                            }
                        } else {
                            System.out.println("Opção de aluno inválida.\n");
                        }
                    } else {
                        System.out.println("Nenhum treino disponível para atribuir.\n");
                    }
                } else if (opcao == 3) {
                    System.out.print("Nome da Aula: ");
                    String nome = scanner.nextLine();
                    System.out.print("Capacidade Máxima: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n' restante
                    System.out.print("Horário (formato dd/MM/yyyy HH:mm): ");
                    String horario = scanner.nextLine();
                    Aula aula = professor.criarAula(aulasDisponiveis.size() + 1, nome, capacidade, horario);
                    aulasDisponiveis.add(aula);
                    System.out.println("Aula " + nome + " criada com sucesso!\n");
                } else if (opcao == 4) {
                    continuar = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                System.out.println("\nOpções disponíveis para Aluno:");
                System.out.println("1. Consultar Treino");
                System.out.println("2. Pagar Mensalidade");
                System.out.println("3. Agendar Aula");
                System.out.println("4. Cancelar Aula");
                System.out.println("5. Alterar Plano");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o '\n' restante
                System.out.println();

                if (opcao == 1) {
                    aluno.consultarTreino();
                    System.out.println();
                } else if (opcao == 2) {
                    aluno.pagarMensalidade();
                    System.out.println();
                } else if (opcao == 3) {
                    if (aulasDisponiveis.isEmpty()) {
                        System.out.println("Não há aulas disponíveis para agendar no momento.\n");
                    } else {
                        System.out.println("Aulas disponíveis para agendar:");
                        for (int i = 0; i < aulasDisponiveis.size(); i++) {
                            Aula aula = aulasDisponiveis.get(i);
                            System.out.println((i + 1) + ". " + aula.getNome() + " - Horário: " + aula.getHorario());
                        }
                        System.out.print("Selecione o número da aula que deseja agendar: ");
                        int aulaIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consumir o '\n' restante
                        if (aulaIndex >= 0 && aulaIndex < aulasDisponiveis.size()) {
                            aluno.agendarAula(aulasDisponiveis.get(aulaIndex));
                        } else {
                            System.out.println("Opção inválida.\n");
                        }
                    }
                } else if (opcao == 4) {
                    if (aluno.getAulasAgendadas().isEmpty()) {
                        System.out.println("Você não agendou nenhuma aula.\n");
                    } else {
                        System.out.println("Aulas agendadas:");
                        for (int i = 0; i < aluno.getAulasAgendadas().size(); i++) {
                            Aula aula = aluno.getAulasAgendadas().get(i);
                            System.out.println((i + 1) + ". " + aula.getNome() + " - Horário: " + aula.getHorario());
                        }
                        System.out.print("Selecione o número da aula que deseja cancelar: ");
                        int aulaIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consumir o '\n' restante
                        if (aulaIndex >= 0 && aulaIndex < aluno.getAulasAgendadas().size()) {
                            // Verificar o prazo de cancelamento
                            Aula aula = aluno.getAulasAgendadas().get(aulaIndex);
                            LocalDateTime horarioAula = aula.getHorarioLocalDateTime();
                            LocalDateTime agora = LocalDateTime.now();

                            if (horarioAula.minusHours(2).isAfter(agora)) {
                                aluno.cancelarAula(aula);
                                System.out.println("Aula " + aula.getNome() + " cancelada com sucesso.\n");
                            } else {
                                System.out.println("Cancelamento não permitido. Deve ser feito com, no mínimo, 2 horas de antecedência.\n");
                            }
                        } else {
                            System.out.println("Opção inválida.\n");
                        }
                    }
                } else if (opcao == 5) {
                    aluno.alterarPlano(scanner);
                    System.out.println();
                } else if (opcao == 6) {
                    continuar = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (usuario instanceof Recepcionista) {
                Recepcionista recepcionista = (Recepcionista) usuario;
                System.out.println("\nOpções disponíveis para Recepcionista:");
                System.out.println("1. Cadastrar Novo Aluno");
                System.out.println("2. Cancelar Matrícula");
                System.out.println("3. Gerenciar Pagamentos");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o '\n' restante
                System.out.println();

                if (opcao == 1) {
                    System.out.print("Nome do Aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Login do Aluno: ");
                    String loginAluno = scanner.nextLine();
                    System.out.print("Senha do Aluno: ");
                    String senhaAluno = scanner.nextLine();

                    System.out.println("Selecione o Plano:");
                    System.out.println("1. Mensal - R$289");
                    System.out.println("2. Anual - R$189 por mês");
                    System.out.print("Escolha uma opção: ");
                    int planoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n' restante

                    float valorMensalidade;
                    if (planoOpcao == 1) {
                        valorMensalidade = 289.0f;
                    } else if (planoOpcao == 2) {
                        valorMensalidade = 2268.0f;
                    } else {
                        System.out.println("Opção inválida. Usando plano mensal por padrão.");
                        valorMensalidade = 289.0f;
                    }

                    System.out.println("Tipo de Pagamento:");
                    System.out.println("1. Cartão de Crédito");
                    System.out.println("2. Boleto");
                    System.out.print("Escolha uma opção: ");
                    int pagamentoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir o '\n' restante

                    String tipoPagamento;
                    if (pagamentoOpcao == 1) {
                        tipoPagamento = "Cartão de Crédito";
                    } else if (pagamentoOpcao == 2) {
                        tipoPagamento = "Boleto";
                    } else {
                        System.out.println("Opção inválida. Usando Boleto por padrão.");
                        tipoPagamento = "Boleto";
                    }

                    Mensalidade novaMensalidade = new Mensalidade(usuarios.size() + 1, valorMensalidade, LocalDateTime.now().plusMonths(1), tipoPagamento);
                    Aluno novoAluno = recepcionista.cadastrarAluno(usuarios.size() + 1, nome, loginAluno, senhaAluno, novaMensalidade);
                    usuarios.add(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso.\n");
                } else if (opcao == 2) {
                    recepcionista.cancelarMatricula(usuarios, scanner);
                } else if (opcao == 3) {
                    recepcionista.gerenciarPagamentos(usuarios, scanner);
                } else if (opcao == 4) {
                    continuar = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (usuario instanceof FuncionarioLimpeza) {
                FuncionarioLimpeza limpeza = (FuncionarioLimpeza) usuario;
                System.out.println("\nOpções disponíveis para Funcionário de Limpeza:");
                System.out.println("1. Registrar Manutenção");
                System.out.println("2. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o '\n' restante
                System.out.println();

                if (opcao == 1) {
                    limpeza.registrarManutencao(equipamentosManutencao, manutencoes, scanner);
                    System.out.println();
                } else if (opcao == 2) {
                    continuar = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Tipo de usuário desconhecido.");
                continuar = false;
            }
        }
    }
}
