package dao;

import beans.User;
import singeton.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IDao<User> {

    private static Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;

    public UserDao() {
        conn = ConnectionDB.getConn();
    }

    @Override
    public boolean ajouter(User o) {
        String sql = "INSERT INTO USER(nom, prenom,email, password) VALUES(?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getNom());
            stmt.setString(2, o.getPrenom());
            stmt.setString(3, o.getEmail());
            stmt.setString(4, o.getPassword());

            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean modifier(String email, User o) {
        String sql = "UPDATE user SET nom = ?, prenom = ?, email = ?, password = ? WHERE email = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getNom());
            stmt.setString(2, o.getPrenom());
            stmt.setString(3, o.getEmail());
            stmt.setString(4, o.getPassword());
            stmt.setString(5, email);
            stmt.executeUpdate();

            return true;
        }
        catch (SQLException exc) {
            return false;
        }
    }

    @Override
    public boolean supprimer(String email) {
        String sql = "DELETE FROM user WHERE email = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();

            return true;
        }
        catch (SQLException exc) {
            return false;
        }
    }

    @Override
    public User getObject(String email) {
        User user = new User();
        String sql = "SELECT * FROM USER WHERE email = ? LIMIT 1";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {

                user.setId(result.getInt(1));
                user.setNom(result.getString(2));
                user.setPrenom(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));

            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no user found : " , ex);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM USER";
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                User user = new User();

                user.setId(result.getInt(1));
                user.setNom(result.getString(2));
                user.setPrenom(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));

                userList.add(user);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no users list found : " , ex);
        }
        return userList;
    }
}
