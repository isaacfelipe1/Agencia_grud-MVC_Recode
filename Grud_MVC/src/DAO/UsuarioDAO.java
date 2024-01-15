package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Usuario;
import conexao.Conexao;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "INSERT INTO usuario (nome, login, senha, email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getLogin());
                preparedStatement.setString(3, usuario.getSenha());
                preparedStatement.setString(4, usuario.getEmail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "UPDATE usuario SET nome = ?, login = ?, senha = ?, email = ? WHERE idusuario = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getLogin());
                preparedStatement.setString(3, usuario.getSenha());
                preparedStatement.setString(4, usuario.getEmail());
                preparedStatement.setInt(5, usuario.getIdUsuario());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(int idUsuario) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "DELETE FROM usuario WHERE idusuario = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setInt(1, idUsuario);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try (Connection conexao = Conexao.getConexao()) {
            String query = "SELECT * FROM usuario";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setIdUsuario(resultSet.getInt("idusuario"));
                        usuario.setNome(resultSet.getString("nome"));
                        usuario.setLogin(resultSet.getString("login"));
                        usuario.setSenha(resultSet.getString("senha"));
                        usuario.setEmail(resultSet.getString("email"));
                        listaUsuarios.add(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    public boolean verificarIdUsuarioExistente(int idUsuario) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE idusuario=?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
   
}
