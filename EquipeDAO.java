import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipeDAO {
    private Connection conexao;

    public EquipeDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarEquipe(Equipe equipe) {
        String sql = "INSERT INTO equipe (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getDescricao());

            stmt.execute();
            System.out.println("Sucesso: Equipe '" + equipe.getNome() + "' cadastrada!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar equipe: " + e.getMessage());
        }
    }
}