package Views;

import java.util.Scanner;

import Model.Contato;
import Model.Usuario;
import controllers.ContatoController;
import controllers.UsuarioController;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        UsuarioController usuarioController = new UsuarioController();
        ContatoController contatoController = new ContatoController();

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoUsuario(scanner, usuarioController);
                    break;
                case 2:
                    atualizarUsuarioExistente(scanner, usuarioController);
                    break;
                case 3:
                    deletarUsuario(scanner, usuarioController);
                    break;
                case 4:
                    cadastrarNovaMensagem(scanner, contatoController);
                    break;
                case 5:
                    atualizarMensagemExistente(scanner, contatoController);
                    break;
                case 6:
                    deletarMensagem(scanner, contatoController);
                    break;
                case 7:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Atualizar usuário existente");
        System.out.println("3. Deletar usuário");
        System.out.println("4. Cadastrar nova mensagem de contato");
        System.out.println("5. Atualizar mensagem de contato existente");
        System.out.println("6. Deletar mensagem de contato");
        System.out.println("7. Sair");
        System.out.print("Opção: ");
    }

    private static void cadastrarNovoUsuario(Scanner scanner, UsuarioController usuarioController) {
        Usuario novoUsuario = new Usuario();
        System.out.print("Nome: ");
        novoUsuario.setNome(scanner.nextLine());
        System.out.print("Login: ");
        novoUsuario.setLogin(scanner.nextLine());
        System.out.print("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());
        System.out.print("Email: ");
        novoUsuario.setEmail(scanner.nextLine());

        usuarioController.cadastrarNovoUsuario(novoUsuario);
    }

    private static void atualizarUsuarioExistente(Scanner scanner, UsuarioController usuarioController) {
        System.out.print("ID do usuário a ser atualizado: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setIdUsuario(idUsuario);

        System.out.print("Novo Nome: ");
        usuarioExistente.setNome(scanner.nextLine());
        System.out.print("Novo Login: ");
        usuarioExistente.setLogin(scanner.nextLine());
        System.out.print("Nova Senha: ");
        usuarioExistente.setSenha(scanner.nextLine());
        System.out.print("Novo Email: ");
        usuarioExistente.setEmail(scanner.nextLine());

        usuarioController.atualizarUsuarioExistente(usuarioExistente);
    }

    private static void deletarUsuario(Scanner scanner, UsuarioController usuarioController) {
        System.out.print("ID do usuário a ser deletado: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        usuarioController.deletarUsuario(idUsuario);
    }

    private static void cadastrarNovaMensagem(Scanner scanner, ContatoController contatoController) {
        Contato novaMensagem = new Contato();
        System.out.print("Nome: ");
        novaMensagem.setNome(scanner.nextLine());
        System.out.print("Sobrenome: ");
        novaMensagem.setSobrenome(scanner.nextLine());
        System.out.print("Email: ");
        novaMensagem.setEmail(scanner.nextLine());
        System.out.print("Mensagem: ");
        novaMensagem.setMensagem(scanner.nextLine());

        contatoController.cadastrarNovaMensagem(novaMensagem);
    }

    private static void atualizarMensagemExistente(Scanner scanner, ContatoController contatoController) {
        System.out.print("ID da mensagem de contato a ser atualizada: ");
        int idContato = scanner.nextInt();
        scanner.nextLine();

        Contato mensagemExistente = new Contato();
        mensagemExistente.setIdContato(idContato);

        System.out.print("Novo Nome: ");
        mensagemExistente.setNome(scanner.nextLine());
        System.out.print("Novo Sobrenome: ");
        mensagemExistente.setSobrenome(scanner.nextLine());
        System.out.print("Novo E-mail: ");
        mensagemExistente.setEmail(scanner.nextLine());
        System.out.print("Nova Mensagem: ");
        mensagemExistente.setMensagem(scanner.nextLine());

        contatoController.atualizarMensagemExistente(mensagemExistente);
    }

    private static void deletarMensagem(Scanner scanner, ContatoController contatoController) {
        System.out.print("ID da mensagem de contato a ser deletada: ");
        int idContato = scanner.nextInt();
        scanner.nextLine();

        contatoController.deletarMensagem(idContato);
    }
}
