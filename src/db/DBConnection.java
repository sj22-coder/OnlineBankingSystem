package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/banking_system";

    private static final String USER = "root";

    private static final String PASSWORD = "**********";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        try {

            Connection con = getConnection();

            if (con != null) {
                System.out.println(
                        "Connected to MySQL successfully!"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}