public class Matiere {
    
    private String nom;

    @Override 
    public int hashCode() {
        return this.nom.hashCode();
    }

    @Override 
    public boolean equals(Object obj) {
        Matiere m = (Matiere) obj;
        return this.nom.equals(m.nom);
    }
}
