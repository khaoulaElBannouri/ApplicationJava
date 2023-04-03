package ma.fstt.model;

public class Commande {
    private String Date_debut;
    private String Date_fin;
    private String Distance;
    private String Nom_client;
    private boolean visible;

    public Commande() {

    }

    public Commande(String Date_debut, String Date_fin, String Distance, String Nom_client ){
        this.Date_debut=Date_debut;
        this.Date_fin=Date_fin;
        this.Distance=Distance;
        this.Nom_client=Nom_client;
    }

    public String getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(String date_debut) {
        Date_debut = date_debut;
    }

    public String getDate_fin() {
        return Date_fin;
    }

    public void setDate_fin(String date_fin) {
        Date_fin = date_fin;
    }

    public String getDistance() {
        return Distance;
    }

    public String getNom_client() {
        return Nom_client;
    }

    public void setNom_client(String nom_client) {
        Nom_client = nom_client;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Date_debut='" + Date_debut + '\'' +
                ", Date_fin='" + Date_fin + '\'' +
                ", Distance='" + Distance + '\'' +
                ", Nom_client='" + Nom_client + '\'' +
                '}';
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}
