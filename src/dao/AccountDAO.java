package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

    private int getAccountId(String accountNumber) {

        String query =
                "SELECT account_id FROM accounts WHERE account_number = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, accountNumber);

            java.sql.ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("account_id");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public boolean createAccount(int userId,
                                 String accountNumber) {

        String query =
                "INSERT INTO accounts(user_id, account_number, balance) VALUES (?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setString(2, accountNumber);
            ps.setDouble(3, 0.0);

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean depositMoney(String accountNumber,
                                double amount) {

        String query =
                "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                TransactionDAO transactionDAO =
                        new TransactionDAO();

                int accountId =
                        getAccountId(accountNumber);

                transactionDAO.addTransaction(
                        accountId,
                        "DEPOSIT",
                        amount
                );

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean withdrawMoney(String accountNumber,
                                 double amount) {

        String query =
                "UPDATE accounts SET balance = balance - ? WHERE account_number = ? AND balance >= ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);
            ps.setDouble(3, amount);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                TransactionDAO transactionDAO =
                        new TransactionDAO();

                int accountId =
                        getAccountId(accountNumber);

                transactionDAO.addTransaction(
                        accountId,
                        "WITHDRAW",
                        amount
                );

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean transferMoney(String sender,
                                 String receiver,
                                 double amount) {

        try {

            Connection con =
                    DBConnection.getConnection();

            con.setAutoCommit(false);

            String withdrawQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_number = ? AND balance >= ?";

            PreparedStatement withdraw =
                    con.prepareStatement(withdrawQuery);

            withdraw.setDouble(1, amount);
            withdraw.setString(2, sender);
            withdraw.setDouble(3, amount);

            int rows =
                    withdraw.executeUpdate();

            if(rows == 0) {
                con.rollback();
                return false;
            }

            String depositQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

            PreparedStatement deposit =
                    con.prepareStatement(depositQuery);

            deposit.setDouble(1, amount);
            deposit.setString(2, receiver);

            deposit.executeUpdate();

            con.commit();

            return true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}