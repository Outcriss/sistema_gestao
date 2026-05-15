import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjetoDAO {
    private Connection conexao;

    public ProjetoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarProjeto(Projeto projeto) {
        // Note que salvamos o ID do gerente (Foreign Key), e não o objeto inteiro
        String sql = "INSERT INTO projeto (nome, descricao, data_inicio, data_termino, status, id_gerente) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            // Convertendo LocalDate do Java para Date do SQL
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, Date.valueOf(projeto.getDataTerminoPrevista()));
            stmt.setString(5, projeto.getStatus());
            // Pegando apenas o ID do usuário que é o gerente
            stmt.setInt(6, projeto.getGerenteResponsavel().getId());

            stmt.execute();
            System.out.println("Sucesso: Projeto '" + projeto.getNome() + "' cadastrado!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar projeto: " + e.getMessage());
        }
    }
}