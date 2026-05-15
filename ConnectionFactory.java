import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // O endereço do seu banco de dados na sua própria máquina (localhost)
    // "sistema_projetos" será o nome do banco que vamos criar no MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_projetos";

    // O usuário padrão do MySQL
    private static final String USUARIO = "root";

    // Aqui você vai colocar a senha que escolher na hora de instalar o MySQL
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