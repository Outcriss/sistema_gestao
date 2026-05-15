import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    // A conexão com o banco que será passada para esta classe (Lembrar disso)
    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método que recebe um Objeto Java e o transforma em uma linha no SQL
    public void cadastrarUsuario(Usuario usuario) {
        // A query SQL com pontos de interrogação (?) para evitar SQL Injection (segurança)
        String sql = "INSERT INTO usuario (nome_completo, cpf, email, cargo, login, senha, perfil) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Trocando os (?) pelos dados do objeto Java
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCargo());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getPerfil());

            // Executando o comando no banco de dados (LEMBRA DISSO BURRO)
            stmt.execute();
            System.out.println("Sucesso: Usuário " + usuario.getNomeCompleto() + " salvo no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }
}