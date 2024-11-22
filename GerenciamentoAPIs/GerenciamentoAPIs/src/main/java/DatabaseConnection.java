import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciamento";
    private static final String USER = "root";
    private static final String PASSWORD = "Pn24121110!";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Certifique-se de que o driver está no classpath
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
