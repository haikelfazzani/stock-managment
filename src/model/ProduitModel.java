package model;

import beans.Produit;
import dao.ProduitDao;

import java.util.List;

public class ProduitModel {

    private Produit produit = null;
    private ProduitDao dao = null;
    private String libelle = "";

    public ProduitModel() {
        produit = new Produit();
        dao = new ProduitDao();
    }
    // Crud
    public boolean ajouter() { return dao.ajouter(produit); }
    public boolean modifier() { return dao.modifier(libelle, produit); }
    public boolean supprimer() { return dao.supprimer(libelle); }
    public List<Produit> getProduits() { return dao.getAll(); }

    // Getter and setter


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}


