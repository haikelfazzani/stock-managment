package dao;

import beans.Achat;
import singeton.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AchatDao implements IDao<Achat> {

    private static Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;

    public AchatDao() { conn = ConnectionDB.getConn(); }

    @Override
    public boolean ajouter(Achat o) {
        String sql = "INSERT INTO ACHAT(libelle,prix,categorie,user_id) VALUES(?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getLibelle());
            stmt.setDouble(2, o.getPrix());
            stmt.setString(3, o.getCategorie());
            stmt.setInt(4, o.getUserId());

            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean modifier(String nom, Achat o) {
        return false;
    }

    @Override
    public boolean supprimer(String nom) {
        return false;
    }

    @Override
    public Achat getObject(String nom) {
        return null;
    }

    @Override
    public List<Achat> getAll() {
        return null;
    }

    public List<Achat> getAchatsByUser(int id) {
        List<Achat> achatList = new ArrayList<>();
        String sql = "SELECT * FROM ACHAT WHERE user_id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Achat achat = new Achat();
                achat.setId(result.getInt(1));
                achat.setLibelle(result.getString(2));
                achat.setPrix(result.getDouble(3));
                achat.setCategorie(result.getString(4));
                achat.setUserId(result.getInt(5));

                achatList.add(achat);
            }
            stmt.close();
        }
        catch (Exception ex) {
            throw new RuntimeException("no achat list found : " , ex);
        }
        return achatList;
    }
}
