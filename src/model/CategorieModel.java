package model;

import beans.Categorie;
import dao.CategorieDao;

import java.util.List;

public class CategorieModel {

    private Categorie categorie = null;
    private CategorieDao dao = null;
    private String idCat = "";

    public CategorieModel() {
        categorie = new Categorie();
        dao = new CategorieDao();
    }

    // Crud
    public boolean ajouter() { return dao.ajouter(categorie); }
    public boolean modifier() { return dao.modifier(idCat, categorie); }
    public boolean supprimer() { return dao.supprimer(idCat); }
    public List<Categorie> getCategories() { return dao.getAll(); }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getIdCat() {
        return idCat;
    }

    public void setIdCat(String idCat) {
        this.idCat = idCat;
    }
}
