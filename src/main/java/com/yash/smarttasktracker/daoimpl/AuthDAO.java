package com.yash.smarttasktracker.daoimpl;

import com.yash.smarttasktracker.entity.User;
import com.yash.smarttasktracker.enums.Role;
import com.yash.smarttasktracker.utils.JDBCUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;


public class AuthDAO {


    // Register user with hashed password
    public boolean registerUser(String name, String email, String password, Role role) {
        String sql = "INSERT INTO users (name, email, password_hash, role, created_at) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = JDBCUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            String hashedPassword = hashPassword(password);

            stmt.setString(1, name);
            stmt.setString(2, email.toLowerCase());
            stmt.setString(3, hashedPassword);
            stmt.setString(4, role.toString());
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Authenticate user login
    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (
                Connection conn = JDBCUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email.toLowerCase());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password_hash");

                // Verify password
                if (BCrypt.checkpw(password,storedHash)) {
                    // Update last login
                    updateLastLogin(rs.getInt("id"));


                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            Role.valueOf(rs.getString("role"))


                    );
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    // Hash a plain password (BCrypt internally manages salt)
    public static String hashPassword(String plainPassword) {
        // The "12" here is the log rounds (work factor), you can adjust this
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Verify a plain password against a hashed one
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }










    // Update last login timestamp
    private void updateLastLogin(int userId) {
        String sql = "UPDATE users SET last_login = ? WHERE id = ?";
        try (   Connection connection=JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

