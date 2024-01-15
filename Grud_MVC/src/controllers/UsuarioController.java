package controllers;

import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarNovoUsuario(Usuario novoUsuario) {
        usuarioDAO.cadastrarUsuario(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void atualizarUsuarioExistente(Usuario usuarioExistente) {
        if (usuarioDAO.verificarIdUsuarioExistente(usuarioExistente.getIdUsuario())) {
            usuarioDAO.atualizarUsuario(usuarioExistente);
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("ID de usuário não encontrado. A atualização não foi realizada.");
        }
    }

    public void deletarUsuario(int idUsuario) {
        usuarioDAO.deletarUsuario(idUsuario);
        System.out.println("Usuário deletado com sucesso!");
    }
}
