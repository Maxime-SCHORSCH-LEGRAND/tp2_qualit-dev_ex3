import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Etudiant implements Comparable<Etudiant> {

    private Identite identite;
    private Formation formation;
    private Map<Matiere, ArrayList<Double>> notes;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    public void ajouterNote(Matiere matiere, double note)
            throws Exception {

        if (note < 0 || note > 20) {
            throw new Exception("La note doit être entre 0 et 20");
        }

        if (!formation.getMapMatieres().containsKey(matiere)) {
            throw new Exception("La matière n'est pas dans la formation");
        }

        if (!notes.containsKey(matiere)) {
            notes.put(matiere, new ArrayList<>());
        }

        notes.get(matiere).add(note);
    }

    public double moyenneMatiere(Matiere matiere)
            throws Exception {

        if (!formation.getMapMatieres().containsKey(matiere)) {
            throw new Exception("La matière n'est pas dans la formation");
        }

        if (!notes.containsKey(matiere)) {
            throw new Exception("Aucune note pour cette matière");
        }

        double somme = 0;

        for (double note : notes.get(matiere)) {
            somme += note;
        }

        return somme / notes.get(matiere).size();
    }

    public double moyenneGenerale()
            throws Exception {

        double somme = 0;
        double totalCoef = 0;

        for (Matiere matiere : notes.keySet()) {

            double moyenne = moyenneMatiere(matiere);
            double coef = formation.getCoef(matiere);

            somme += moyenne * coef;
            totalCoef += coef;
        }

        if (totalCoef == 0) {
            throw new Exception("Aucune note");
        }

        return somme / totalCoef;
    }

    public int compareTo(Etudiant e) {
        return this.identite.getNom().compareTo(e.identite.getNom());
    }
}   