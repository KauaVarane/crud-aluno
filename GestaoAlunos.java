import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestaoAlunos {
    Aluno aluno[] = new Aluno[50];

    public void criar() {
        boolean vagaEncontrada = false;
        System.out.println("Criando aluno...");
        for (int i = 0; i < 50; i++) {
            if (aluno[i] == null) {
                aluno[i] = new Aluno();
                aluno[i].setId(i + 1);
                aluno[i].setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Nascimento (aaaa-mm-dd): ")));
                aluno[i].setRa("00" + (i + 10));
                aluno[i].setNome(JOptionPane.showInputDialog("Digite o nome do aluno: "));
                vagaEncontrada = true;
                break;
            } else if (vagaEncontrada == false) {
                System.out.println("Vaga ja ocupada");
            }

        }
    }

    public void exibir() {
        System.out.println("Exibindo aluno...");
        boolean alunoEncontrado = false;
        String procurarRa = JOptionPane.showInputDialog("Digite o RA do aluno que deseja procurar: ");
        for (int i = 0; i < 50; i++) {
            if (aluno[i] != null && aluno[i].getRa() != null && aluno[i].getRa().equals(procurarRa)) {
                System.out.println("Aluno encontrado: " + aluno[i].toString());
                alunoEncontrado = true;
                break;
            }
        }
        if (alunoEncontrado == false) {
            System.out.println("Aluno não encontrado");
        }
    }

    public void remover() {
        System.out.println("Removendo aluno...");
        boolean alunoEncontrado = false;
        String procurarRa = JOptionPane.showInputDialog("Digite o RA do aluno que deseja remover: ");
        for (int i = 0; i < 50; i++) {
            if (aluno[i] != null && aluno[i].getRa() != null && aluno[i].getRa().equals(procurarRa)) {
                System.out.println("Aluno encontrado: " + aluno[i].toString());
                aluno[i] = null;
                System.out.println("Aluno removido com sucesso");
                alunoEncontrado = true;
                break;
            }
        }
        if (alunoEncontrado == false) {
            System.out.println("Aluno não encontrado");
        }
    }

    public void atualizar() {
        System.out.println("Atualizando aluno...");
        boolean alunoEncontrado = false;
        String procurarRa = JOptionPane.showInputDialog("Digite o RA do aluno que deseja atualizar: ");
        for (int i = 0; i < 50; i++) {
            if (aluno[i] != null && aluno[i].getRa() != null && aluno[i].getRa().equals(procurarRa)) {
                System.out.println("Aluno encontrado: " + aluno[i].toString());
                aluno[i].setId(i + 1);
                aluno[i].setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Nascimento (aaaa-mm-dd): ")));
                aluno[i].setRa("00" + (i + 10));
                aluno[i].setNome(JOptionPane.showInputDialog("Digite o nome do aluno: "));
                System.out.println("Aluno atualizado com sucesso");
                alunoEncontrado = true;
                break;
            }
        }
        if (alunoEncontrado == false) {
            System.out.println("Aluno não encontrado");
        }
    }

    public void menu() {

        GestaoAlunos skeep = new GestaoAlunos();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "==========================================================================================================================================");
            System.out.println(
                    "|            ESCOLHA UMA AÇÃO :                                                                                                           |");
            System.out.println(
                    "|                                                                                                                                         |");
            System.out.println(
                    "|     (C)riar           (E)xibir         (R)emover                                                                                        |");
            System.out.println(
                    "|                                                                                                                                         |");
            System.out.println(
                    "|            (A)tualizar          (S)air                                                                                                  |");
            System.out.println(
                    "|                                                                                                                                         |");
            System.out.println(
                    "==========================================================================================================================================");

            String textoMaiusculo = scan.nextLine().toUpperCase();
            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'C':
                    skeep.criar();
                    break;
                case 'E':
                    skeep.exibir();
                    break;
                case 'R':
                    skeep.remover();
                    break;
                case 'A':
                    skeep.atualizar();
                    break;
                case 'S':
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ação inválida!");
            }

        }
    }

    public static void main(String[] args) {

        GestaoAlunos gestao = new GestaoAlunos();
        gestao.menu();
    }

}
