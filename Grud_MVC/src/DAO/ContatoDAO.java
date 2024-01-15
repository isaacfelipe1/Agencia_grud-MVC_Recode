package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Contato;
import conexao.Conexao;

public class ContatoDAO {

    public void enviarMensagem(Contato contato) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "INSERT INTO contato (nome, sobrenome, email, mensagem) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, contato.getNome());
                preparedStatement.setString(2, contato.getSobrenome());
                preparedStatement.setString(3, contato.getEmail());
                preparedStatement.setString(4, contato.getMensagem());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarMensagem(Contato contato) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "UPDATE contato SET nome = ?, sobrenome = ?, email = ?, mensagem = ? WHERE idcontato = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, contato.getNome());
                preparedStatement.setString(2, contato.getSobrenome());
                preparedStatement.setString(3, contato.getEmail());
                preparedStatement.setString(4, contato.getMensagem());
                preparedStatement.setInt(5, contato.getIdContato());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarMensagem(int idContato) {
        try (Connection conexao = Conexao.getConexao()) {
            String query = "DELETE FROM contato WHERE idcontato = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setInt(1, idContato);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> listarMensagens() {
        List<Contato> listaMensagens = new ArrayList<>();
        try (Connection conexao = Conexao.getConexao()) {
            String query = "SELECT * FROM contato";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Contato contato = new Contato();
                        contato.setIdContato(resultSet.getInt("idcontato"));
                        contato.setNome(resultSet.getString("nome"));
                        contato.setSobrenome(resultSet.getString("sobrenome"));
                        contato.setEmail(resultSet.getString("email"));
                        contato.setMensagem(resultSet.getString("mensagem"));
                        listaMensagens.add(contato);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMensagens;
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
