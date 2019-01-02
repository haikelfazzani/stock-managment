package beans;

public class Achat {

    private int id;
    private String libelle;
    private Double prix;
    private String categorie;
    private int userId;

    public Achat() {
    }

    public Achat(int id, String libelle, Double prix, String categorie, int userId) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.categorie = categorie;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
