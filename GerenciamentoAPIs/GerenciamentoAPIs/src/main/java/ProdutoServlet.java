import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ProdutoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM produtos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            PrintWriter out = response.getWriter();
            out.println("[");
            while (rs.next()) {
                out.println("{");
                out.println("\"id\": " + rs.getInt("id") + ",");
                out.println("\"nome\": \"" + rs.getString("nome") + "\",");
                out.println("\"preco\": " + rs.getBigDecimal("preco"));
                out.println("},");
            }
            out.println("]");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
