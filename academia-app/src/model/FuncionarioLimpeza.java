package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioLimpeza extends Usuario {

    public FuncionarioLimpeza(int id, String nome, String login, String senha) {
        super(id, nome, login, senha, "Funcionário de Limpeza");
    }

    public void registrarManutencao(ArrayList<Maquina> equipamentos, ArrayList<Manutencao> manutencoes, Scanner scanner) {
        System.out.println("Equipamentos disponíveis para manutenção:");
        for (Maquina equipamento : equipamentos) {
            System.out.println("ID: " + equipamento.getId() + " - " + equipamento.getNome());
        }
        System.out.print("Digite o ID do equipamento para manutenção: ");
        int idEquipamento = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n' restante

        Maquina equipamentoSelecionado = null;
        for (Maquina equipamento : equipamentos) {
            if (equipamento.getId() == idEquipamento) {
                equipamentoSelecionado = equipamento;
                break;
            }
        }

        if (equipamentoSelecionado != null) {
            System.out.print("Descrição da manutenção: ");
            String descricao = scanner.nextLine();
            Manutencao manutencao = new Manutencao(equipamentoSelecionado.getNome(), descricao, this, LocalDateTime.now());
            manutencoes.add(manutencao);
            System.out.println("Manutenção registrada para " + equipamentoSelecionado.getNome() + " às " +
                               LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        } else {
            System.out.println("Equipamento não encontrado.");
        }
    }
}
