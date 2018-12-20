package dao;

import beans.Categorie;
import beans.Produit;
import singeton.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao implements IDao<Produit> {

    private static Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;

    public ProduitDao() { conn = ConnectionDB.getConn(); }

    @Override
    public boolean ajouter(Produit o) {
        String sql = "INSERT INTO Produit(libelle, prix_unitaire, id_cat) VALUES(?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getLibelle());
            stmt.setDouble(2, o.getPrixUnitaire());
            stmt.setString(3, o.getCategorie().getIdCat());

            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean modifier(String nom, Produit o) {
        String sql = "UPDATE PRODUIT SET libelle = ?, prix_unitaire = ?, id_cat = ? WHERE libelle = ?";
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, o.getLibelle());
            stmt.setDouble(2, o.getPrixUnitaire());
            stmt.setString(3, o.getCategorie().getIdCat());
            stmt.setString(4, nom);

            stmt.executeUpdate();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean supprimer(String libelle) {
        String sql = "DELETE  FROM PRODUIT WHERE libelle = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, libelle);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Produit getObject(String nom) {
        return null;
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produitList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUIT";
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Produit p = new Produit();
                int id = result.getInt(1);

                p.setIdProduit(id);
                p.setLibelle(result.getString(2));
                p.setPrixUnitaire(result.getDouble(3));
                p.setCategorie(getCategorieByProduit(id));

                produitList.add(p);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no produits list found : " , ex);
        }
        return produitList;
    }

    public Categorie getCategorieByProduit(int id) {
        Categorie categorie = new Categorie();
        String sql = "SELECT * FROM CATEGORIE";
        try {
            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                categorie.setIdCat(resultSet.getString(1));
                categorie.setDescription(resultSet.getString(2));
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("no categorie found : " , ex);
        }
        return categorie;
    }
}
