package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionDAO {

    public boolean addTransaction(int accountId,
                            String type,
                            double amount) {

        String query =
                "INSERT INTO transactions(account_id, transaction_type, amount) VALUES (?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, accountId);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void viewTransactions() {

    String query = "SELECT * FROM transactions";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            System.out.println(
                "ID: " + rs.getInt("transaction_id")
                + " | Account ID: " + rs.getInt("account_id")
                + " | Type: " + rs.getString("transaction_type")
                + " | Amount: " + rs.getDouble("amount")
                + " | Date: " + rs.getTimestamp("transaction_date")
            );
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}
public ResultSet getTransactions() {

    String query =
            "SELECT * FROM transactions";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(query);

        return ps.executeQuery();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}
}