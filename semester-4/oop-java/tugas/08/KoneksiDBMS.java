import java.sql.*;

public class KoneksiDBMS {
    String driverdbms = "com.mysql.jdbc.Driver";
    String database = "jdbc:mysql://localhost:8081/dbfarhan06476";
    String user = "farhan06476";
    String password = "";

    public KoneksiDBMS() {
    }

    public Connection BukaCn() throws SQLException {
        Connection condbms = null;
        try {
            Class.forName(driverdbms);
            condbms = DriverManager.getConnection(database, user, password);

            return condbms;
        } catch (SQLException se) {
            System.out.println("SQL Error!");
            return null;
        } catch (Exception ex) {
            System.out.println("Database Connection failed!");
            return null;
        }
    }
}
