import java.util.ArrayList;
import java.util.Collections;

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
    public double moyenneMatiere(Matiere matiere) throws Exception {

        double somme = 0;

        for (Etudiant etudiant : etudiants) {
            somme += etudiant.moyenneMatiere(matiere);
        }

        return somme / etudiants.size();
    }
    public double moyenneGenerale() throws Exception {

        double somme = 0;

        for (Etudiant etudiant : etudiants) {
            somme += etudiant.moyenneGenerale();
        }

        return somme / etudiants.size();
    }

    public void triAlpha() {
        Collections.sort(this.etudiants);
    }

    public void triAntiAlpha() {
        Collections.sort(this.etudiants, Collections.reverseOrder());
    }
}