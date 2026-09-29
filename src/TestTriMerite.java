import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTriMerite {

    @Test
    public void testTriParMerite() throws Exception {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");
        formation.addMatiere(java, 1.0);

        Etudiant e1 = new Etudiant(
                new Identite("1", "schorsch", "maxime"),
                formation
        );

        Etudiant e2 = new Etudiant(
                new Identite("2", "saez", "aidan"),
                formation
        );

        Etudiant e3 = new Etudiant(
                new Identite("3", "Dupont", "dupont"),
                formation
        );

        e1.ajouterNote(java, 12);
        e2.ajouterNote(java, 18);
        e3.ajouterNote(java, 15);

        Groupe groupe = new Groupe(formation);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);

        groupe.triParMerite();

        assertEquals(e2, groupe.getEtudiants().get(0));
        assertEquals(e3, groupe.getEtudiants().get(1));
        assertEquals(e1, groupe.getEtudiants().get(2));
    }
}