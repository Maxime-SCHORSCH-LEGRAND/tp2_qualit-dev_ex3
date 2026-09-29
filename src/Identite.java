public class Identite {
    private String id;
    private String nom;
    private String prenom;

    public Identite(String nip, String nom, String prenom) {
        this.id= nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getid() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + id + ")";
    }
}