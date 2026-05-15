import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Equipe> listaEquipes = new ArrayList<>();
        List<Projeto> listaProjetos = new ArrayList<>();

        System.out.println("==================================================");
        System.out.println("   BEM-VINDO AO SISTEMA DE GESTÃO DE PROJETOS   ");
        System.out.println("==================================================");

        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar novo Usuário");
            System.out.println("2 - Cadastrar nova Equipe");
            System.out.println("3 - Cadastrar novo Projeto");
            System.out.println("4 - Cadastrar nova Tarefa");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Erro evitado: Você digitou uma letra ou um número muito extenso.");
                System.out.println("Por favor, digite apenas os números do menu (0 a 4).");
                scanner.nextLine(); // ME ESQUECI PARA QUE SERVE, NAO MEXA
                continue; // Volta imediatamente para o início do menu
            }

            if (opcao == 1) {
                System.out.println("\n--- TELA DE CADASTRO DE USUÁRIO ---");
                System.out.print("Nome Completo: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Cargo (Ex: Analista de Dados): ");
                String cargo = scanner.nextLine();

                System.out.println("Escolha o Perfil do Usuário:");
                System.out.println("1 - ADMINISTRADOR | 2 - GERENTE | 3 - COLABORADOR");
                System.out.print("Opção: ");

                int opPerfil = 3;
                try {
                    opPerfil = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("❌ Opção inválida. Perfil definido como COLABORADOR por padrão.");
                    scanner.nextLine();
                }

                String perfil = "COLABORADOR";
                if (opPerfil == 1) perfil = "ADMINISTRADOR";
                else if (opPerfil == 2) perfil = "GERENTE";

                Usuario novoUsuario = new Usuario(nome, cpf, "email@teste.com", cargo, "login", "senha", perfil);
                listaUsuarios.add(novoUsuario);

                System.out.println("\n✅ Usuário cadastrado com sucesso!");

            } else if (opcao == 2) {
                System.out.println("\n--- TELA DE CADASTRO DE EQUIPE ---");
                System.out.print("Nome da Equipe: ");
                String nomeEquipe = scanner.nextLine();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();

                Equipe novaEquipe = new Equipe(nomeEquipe, descricao);
                listaEquipes.add(novaEquipe);

                System.out.println("\n✅ Equipe cadastrada com sucesso!");

            } else if (opcao == 3) {
                System.out.println("\n--- TELA DE CADASTRO DE PROJETO ---");

                if (listaUsuarios.isEmpty()) {
                    System.out.println("❌ Erro: Você precisa cadastrar pelo menos um Usuário antes de criar um Projeto!");
                } else {
                    System.out.print("Nome do Projeto: ");
                    String nomeProj = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descProj = scanner.nextLine();

                    System.out.println("Selecione o Gerente Responsável:");
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println(i + " - " + listaUsuarios.get(i).getNomeCompleto());
                    }
                    System.out.print("Digite o número do gerente: ");

                    try {
                        int indiceGerente = scanner.nextInt();
                        scanner.nextLine();

                        Usuario gerenteEscolhido = listaUsuarios.get(indiceGerente);

                        Projeto novoProjeto = new Projeto(nomeProj, descProj, LocalDate.now(), LocalDate.now().plusMonths(1), "PLANEJADO", gerenteEscolhido);
                        listaProjetos.add(novoProjeto);

                        System.out.println("\n✅ Projeto '" + novoProjeto.getNome() + "' criado com o gerente " + gerenteEscolhido.getNomeCompleto() + "!");

                    } catch (InputMismatchException e) {
                        System.out.println("\n❌ Erro: Você não digitou um número válido. Cadastro de projeto cancelado.");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\n❌ Erro: Esse número não existe na lista. Cadastro de projeto cancelado.");
                    }
                }

            } else if (opcao == 4) {
                System.out.println("\n--- TELA DE CADASTRO DE TAREFA ---");
                if (listaProjetos.isEmpty() || listaUsuarios.isEmpty()) {
                    System.out.println("❌ Erro: Você precisa de pelo menos 1 Projeto e 1 Usuário para criar uma tarefa!");
                } else {
                    System.out.print("Título da Tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();

                    Usuario responsavel = listaUsuarios.get(0);
                    Tarefa novaTarefa = new Tarefa(titulo, desc, "A_FAZER", responsavel, 1);
                    System.out.println("\n✅ Tarefa '" + novaTarefa.getTitulo() + "' alocada com sucesso!");
                }

            } else if (opcao == 0) {
                System.out.println("\nEncerrando o sistema... Até logo!");
            } else {
                System.out.println("\n❌ Opção inválida! Escolha um número de 0 a 4.");
            }
        }

        scanner.close();
    }
}