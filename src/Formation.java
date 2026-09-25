import java.util.HashMap;
import java.util.Map;

public class Formation {
    
    private String id;
    private Map<Matiere, Double> matieres;

    public Formation(String id) {
        this.id = id;
        this.matieres = new HashMap<>();
    }

    public void addMatiere(Matiere mat, Double coef) {
        this.matieres.put(mat, coef);
    }

    public void removeMatiere(Matiere mat) {
        this.matieres.remove(mat);
    }

    public float getCoef(Matiere mat) {
        // verifier si la matiere existe
        if (this.matieres.containsKey(mat)) {
            return this.matieres.get(mat).floatValue();
        } else {
            return 0;
        }
    }

}
