package ma.fstt.model;

public class Produit {
    private Long id_produit;
    private String nom;
       private String description;

    private boolean visible;
public Produit(){

}
    public Produit( Long id_produit,String nom,String description) {
        this.id_produit=id_produit;
        this.description = description;
        this.nom=nom;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }


    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", visible=" + visible +
                '}';
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}
