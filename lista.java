
import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    int matricula;
    String dataNascimento;

    public Aluno(String nome, int matricula, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }
}

class CadastroAlunos {
    public static void main(String[] args) {
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.next();
                    System.out.print("Matrícula do aluno: ");
                    int matricula = scanner.nextInt();
                    System.out.print("Data de Nascimento do aluno: ");
                    String dataNascimento = scanner.next();
                    listaAlunos.add(new Aluno(nome, matricula, dataNascimento));
                    break;
                case 2:
                    for (Aluno aluno : listaAlunos) {
                        System.out.println("Nome: " + aluno.nome + ", Matrícula: " + aluno.matricula + ", Data de Nascimento: " + aluno.dataNascimento);
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome ou matrícula do aluno a ser pesquisado: ");
                    String pesquisa = scanner.next();
                    for (Aluno aluno : listaAlunos) {
                        if (aluno.nome.equals(pesquisa) || String.valueOf(aluno.matricula).equals(pesquisa)) {
                            System.out.println("Aluno encontrado - Nome: " + aluno.nome + ", Matrícula: " + aluno.matricula + ", Data de Nascimento: " + aluno.dataNascimento);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno a ser removido: ");
                    int matriculaRemover = scanner.nextInt();
                    listaAlunos.removeIf(aluno -> aluno.matricula == matriculaRemover);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}