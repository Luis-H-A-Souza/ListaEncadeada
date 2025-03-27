package ListaEncadeadaPkg;

import java.util.Scanner;

public class TestaListaEncadeada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEncadeada listaContatos = new ListaEncadeada();
        int opcao;

        do {
            System.out.println("\n=== MENU DE CONTATOS ===");
            System.out.println("1 - Adicionar novo contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Editar contato");
            System.out.println("4 - Exibir todos os contatos");
            System.out.println("5 - Buscar contato por ID");
            System.out.println("0 - Sair do programa");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    listaContatos.addContato();
                    break;
                    
                case 2:
                    System.out.print("Digite o ID do contato a remover: ");
                    int idRemover = sc.nextInt();
                    listaContatos.removerContato(idRemover);
                    break;
                    
                case 3:
                    listaContatos.editarContato();
                    break;
                    
                case 4:
                    System.out.println("\n=== LISTA DE CONTATOS ===");
                    listaContatos.listarContatos();
                    break;
                    
                case 5:
                    System.out.print("Digite o ID do contato a buscar: ");
                    int idBuscar = sc.nextInt();
                    Contato contato = listaContatos.procurarId(idBuscar);
                    if (contato != null) {
                        System.out.println("\nContato encontrado:");
                        System.out.println("ID: " + contato.getId());
                        System.out.println("Nome: " + contato.getNome());
                        System.out.println("Matrícula: " + contato.getMatricula());
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                    
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
            }
            
        } while (opcao != 0);

        sc.close();
    }
}