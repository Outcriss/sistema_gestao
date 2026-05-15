import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarefaDAO {
    private Connection conexao;

    public TarefaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (titulo, descricao, status, id_responsavel, id_projeto) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setInt(4, tarefa.getUsuarioResponsavel().getId());
            stmt.setInt(5, tarefa.getIdProjeto());

            stmt.execute();
            System.out.println("Sucesso: Tarefa '" + tarefa.getTitulo() + "' criada!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tarefa: " + e.getMessage());
        }
    }
}