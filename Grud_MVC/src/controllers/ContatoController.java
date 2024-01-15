package controllers;
import DAO.ContatoDAO;
import Model.Contato;
public class ContatoController {
    private ContatoDAO contatoDAO;

    public ContatoController() {
        this.contatoDAO = new ContatoDAO();
    }

    public void cadastrarNovaMensagem(Contato novaMensagem) {
        contatoDAO.enviarMensagem(novaMensagem);
        System.out.println("Mensagem de contato cadastrada com sucesso!");
    }

    public void atualizarMensagemExistente(Contato mensagemExistente) {
        if (contatoDAO.verificarIdUsuarioExistente(mensagemExistente.getIdContato())) {
            contatoDAO.atualizarMensagem(mensagemExistente);
            System.out.println("Mensagem de contato atualizada com sucesso!");
        } else {
            System.out.println("ID de contato não encontrado. A atualização não foi realizada.");
        }
    }

    public void deletarMensagem(int idContato) {
        contatoDAO.deletarMensagem(idContato);
        System.out.println("Mensagem de contato deletada com sucesso!");
    }
}
