package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Administrador extends Usuario {

    public Administrador(int id, String nome, String login, String senha) {
        super(id, nome, login, senha, "Administrador");
    }

    public void gerenciarUsuarios(ArrayList<Usuario> usuarios, Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciar Usuários ===");
            System.out.println("1. Listar Usuários");
            System.out.println("2. Alterar Usuário");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n' restante

            switch (opcao) {
                case 1:
                    listarUsuarios(usuarios);
                    break;
                case 2:
                    alterarUsuario(usuarios, scanner);
                    break;
                case 3:
                    removerUsuario(usuarios, scanner);
                    break;
                case 4:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void listarUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("\n=== Lista de Usuários ===");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", Cargo: " + u.getCargo());
        }
    }

    private void alterarUsuario(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do usuário que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            System.out.print("Novo nome (atual: " + usuario.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo login (atual: " + usuario.getLogin() + "): ");
            String novoLogin = scanner.nextLine();
            System.out.print("Nova senha: ");
            String novaSenha = scanner.nextLine();
            System.out.print("Novo cargo (atual: " + usuario.getCargo() + "): ");
            String novoCargo = scanner.nextLine();

            usuario.setNome(novoNome);
            usuario.setLogin(novoLogin);
            usuario.setSenha(novaSenha);
            usuario.setCargo(novoCargo);

            System.out.println("Usuário atualizado com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void removerUsuario(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do usuário que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Usuario usuarioRemover = null;
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarioRemover = u;
                break;
            }
        }

        if (usuarioRemover != null) {
            usuarios.remove(usuarioRemover);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void revisarDadosFinanceiros() {
        System.out.println("Revisando dados financeiros da academia.");
        // Implementação adicional conforme necessário
    }

    public void revisarManutencoes(ArrayList<Manutencao> manutencoes, Scanner scanner) {
        System.out.println("\n=== Revisar Manutenções ===");
        System.out.print("Digite o dia (formato dd/MM/yyyy) que deseja revisar: ");
        String dataStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate data = LocalDate.parse(dataStr, formatter);
            boolean encontrou = false;
            for (Manutencao m : manutencoes) {
                if (m.getData().toLocalDate().equals(data)) {
                    System.out.println("\nEquipamento: " + m.getEquipamento());
                    System.out.println("Descrição: " + m.getDescricao());
                    System.out.println("Funcionário: " + m.getFuncionario().getNome());
                    System.out.println("Data e Hora: " + m.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhuma manutenção encontrada para esta data.");
            }
        } catch (Exception e) {
            System.out.println("Data em formato inválido.");
        }
    }

    // Novo método para gerenciar máquinas
    public void gerenciarMaquinas(ArrayList<Maquina> maquinas, Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciar Máquinas ===");
            System.out.println("1. Listar Máquinas");
            System.out.println("2. Adicionar Máquina");
            System.out.println("3. Modificar Máquina");
            System.out.println("4. Remover Máquina");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n' restante

            switch (opcao) {
                case 1:
                    listarMaquinas(maquinas);
                    break;
                case 2:
                    adicionarMaquina(maquinas, scanner);
                    break;
                case 3:
                    modificarMaquina(maquinas, scanner);
                    break;
                case 4:
                    removerMaquina(maquinas, scanner);
                    break;
                case 5:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void listarMaquinas(ArrayList<Maquina> maquinas) {
        System.out.println("\n=== Lista de Máquinas ===");
        for (Maquina m : maquinas) {
            System.out.println("ID: " + m.getId() + ", Nome: " + m.getNome());
        }
    }

    private void adicionarMaquina(ArrayList<Maquina> maquinas, Scanner scanner) {
        System.out.print("Nome da Máquina: ");
        String nomeMaquina = scanner.nextLine();
        System.out.print("ID da Máquina: ");
        int idMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        // Verificar se já existe uma máquina com este ID
        boolean existe = false;
        for (Maquina m : maquinas) {
            if (m.getId() == idMaquina) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Já existe uma máquina com este ID.");
        } else {
            Maquina novaMaquina = new Maquina(idMaquina, nomeMaquina);
            maquinas.add(novaMaquina);
            System.out.println("Máquina adicionada com sucesso.");
        }
    }

    private void modificarMaquina(ArrayList<Maquina> maquinas, Scanner scanner) {
        System.out.print("Digite o ID da máquina que deseja modificar: ");
        int idMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Maquina maquinaModificar = null;
        for (Maquina m : maquinas) {
            if (m.getId() == idMaquina) {
                maquinaModificar = m;
                break;
            }
        }

        if (maquinaModificar != null) {
            System.out.print("Novo nome da Máquina: ");
            String novoNome = scanner.nextLine();

            // Atualizar os dados da máquina
            maquinaModificar.setNome(novoNome);

            System.out.println("Máquina modificada com sucesso.");
        } else {
            System.out.println("Máquina não encontrada.");
        }
    }

    private void removerMaquina(ArrayList<Maquina> maquinas, Scanner scanner) {
        System.out.print("Digite o ID da máquina que deseja remover: ");
        int idMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Maquina maquinaRemover = null;
        for (Maquina m : maquinas) {
            if (m.getId() == idMaquina) {
                maquinaRemover = m;
                break;
            }
        }

        if (maquinaRemover != null) {
            System.out.print("Motivo da remoção: ");
            String motivo = scanner.nextLine();

            maquinas.remove(maquinaRemover);
            System.out.println("Máquina removida com sucesso. Motivo: " + motivo);
        } else {
            System.out.println("Máquina não encontrada.");
        }
    }

    // Novo método para gerenciar equipamentos de manutenção
    public void gerenciarEquipamentos(ArrayList<Maquina> equipamentos, Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== Gerenciar Equipamentos de Manutenção ===");
            System.out.println("1. Listar Equipamentos");
            System.out.println("2. Adicionar Equipamento");
            System.out.println("3. Modificar Equipamento");
            System.out.println("4. Remover Equipamento");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n' restante

            switch (opcao) {
                case 1:
                    listarEquipamentos(equipamentos);
                    break;
                case 2:
                    adicionarEquipamento(equipamentos, scanner);
                    break;
                case 3:
                    modificarEquipamento(equipamentos, scanner);
                    break;
                case 4:
                    removerEquipamento(equipamentos, scanner);
                    break;
                case 5:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void listarEquipamentos(ArrayList<Maquina> equipamentos) {
        System.out.println("\n=== Lista de Equipamentos ===");
        for (Maquina e : equipamentos) {
            System.out.println("ID: " + e.getId() + ", Nome: " + e.getNome());
        }
    }

    private void adicionarEquipamento(ArrayList<Maquina> equipamentos, Scanner scanner) {
        System.out.print("Nome do Equipamento: ");
        String nomeEquipamento = scanner.nextLine();
        System.out.print("ID do Equipamento: ");
        int idEquipamento = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        // Verificar se já existe um equipamento com este ID
        boolean existe = false;
        for (Maquina e : equipamentos) {
            if (e.getId() == idEquipamento) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Já existe um equipamento com este ID.");
        } else {
            Maquina novoEquipamento = new Maquina(idEquipamento, nomeEquipamento);
            equipamentos.add(novoEquipamento);
            System.out.println("Equipamento adicionado com sucesso.");
        }
    }

    private void modificarEquipamento(ArrayList<Maquina> equipamentos, Scanner scanner) {
        System.out.print("Digite o ID do equipamento que deseja modificar: ");
        int idEquipamento = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Maquina equipamentoModificar = null;
        for (Maquina e : equipamentos) {
            if (e.getId() == idEquipamento) {
                equipamentoModificar = e;
                break;
            }
        }

        if (equipamentoModificar != null) {
            System.out.print("Novo nome do Equipamento: ");
            String novoNome = scanner.nextLine();

            // Atualizar os dados do equipamento
            equipamentoModificar.setNome(novoNome);

            System.out.println("Equipamento modificado com sucesso.");
        } else {
            System.out.println("Equipamento não encontrado.");
        }
    }

    private void removerEquipamento(ArrayList<Maquina> equipamentos, Scanner scanner) {
        System.out.print("Digite o ID do equipamento que deseja remover: ");
        int idEquipamento = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Maquina equipamentoRemover = null;
        for (Maquina e : equipamentos) {
            if (e.getId() == idEquipamento) {
                equipamentoRemover = e;
                break;
            }
        }

        if (equipamentoRemover != null) {
            System.out.print("Motivo da remoção: ");
            String motivo = scanner.nextLine();

            equipamentos.remove(equipamentoRemover);
            System.out.println("Equipamento removido com sucesso. Motivo: " + motivo);
        } else {
            System.out.println("Equipamento não encontrado.");
        }
    }
}
