package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;


public class UserDAO {

    public boolean registerUser(User user) {

        String query =
                "INSERT INTO users(username, password, full_name) VALUES (?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean loginUser(String username,
                         String password) {

    String query =
            "SELECT * FROM users WHERE username = ? AND password = ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs =
                ps.executeQuery();

        return rs.next();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}