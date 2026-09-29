import java.util.ArrayList;

public class Groupe {

    private Formation formation;
    private ArrayList<Etudiant> etudiants;

    public Groupe(Formation formation) {
        this.formation = formation;
        this.etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) throws Exception {

        if (etudiant.getFormation() != formation) {
            throw new Exception("Formation différente");
        }

        etudiants.add(etudiant);
    }

    public void supprimerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }
}