import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



    private static final String URL = "jdbc:mysql://localhost:3306/sistema_projetos";


    private static final String USUARIO = "root";


    private static final String SENHA = "sua_senha_aqui";

    public static Connection conectar() {
        try {
            // Tenta abrir a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            // Se der erro (ex: senha errada ou banco desligado), ele avisa aqui
            throw new RuntimeException("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }
}