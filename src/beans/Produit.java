package beans;

public class Produit {

    private int idProduit;
    private String libelle;
    private double prixUnitaire;
    private Categorie categorie;

    public Produit() { }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
