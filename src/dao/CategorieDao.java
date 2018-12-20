package dao;

import beans.Categorie;
import beans.Produit;
import singeton.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieDao implements IDao<Categorie> {

    private static Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;

    public CategorieDao() { conn = ConnectionDB.getConn(); }

    @Override
    public boolean ajouter(Categorie o) {
        String sql = "INSERT INTO CATEGORIE VALUES(?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getIdCat());
            stmt.setString(2, o.getDescription());
            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean modifier(String nom, Categorie o) {
        String sql = "UPDATE CATEGORIE SET description = ? WHERE id_cat = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getDescription());
            stmt.setString(2, nom);
            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean supprimer(String idCat) {
        String sql = "DELETE  FROM CATEGORIE WHERE id_cat = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idCat);
            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Categorie getObject(String nom) {
        return null;
    }

    @Override
    public List<Categorie> getAll() {
        List<Categorie> categorieList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIE";
        try {
            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Categorie categorie = new Categorie();
                String id = resultSet.getString(1);

                categorie.setIdCat(id);
                categorie.setDescription(resultSet.getString(2));
                categorie.setProduitList(getProduitsByCategorie(id));

                categorieList.add(categorie);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no categorie list found : " , ex);
        }
        return categorieList;
    }

    public List<Produit> getProduitsByCategorie(String idCat) {
        List<Produit> produitList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUIT WHERE ID_CAT = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idCat);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Produit p = new Produit();
                p.setIdProduit(result.getInt(1));
                p.setLibelle(result.getString(2));
                p.setPrixUnitaire(result.getDouble(3));

                produitList.add(p);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no produits list found : " , ex);
        }
        return produitList;
    }
}
