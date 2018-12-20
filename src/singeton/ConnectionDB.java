package singeton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionprod" , "root" , "");
            System.out.println("connected");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("not connected ", e);
        }
    }

    public static Connection getConn() {
        return connection;
    }

}
