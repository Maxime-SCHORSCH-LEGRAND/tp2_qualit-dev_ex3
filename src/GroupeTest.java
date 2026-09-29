import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GroupeTest {

    @Test
    public void testAjouterEtudiant() throws Exception {

        Formation formation = new Formation("BUTINFO");

        Identite identite = new Identite("123", "schorsch", "maxime");
        Etudiant etudiant = new Etudiant(identite, formation);

        Groupe groupe = new Groupe(formation);

        groupe.ajouterEtudiant(etudiant);

        assertEquals(1, groupe.getEtudiants().size());
    }

    @Test
    public void testSupprimerEtudiant() throws Exception {

        Formation formation = new Formation("BUTINFO");

        Identite identite = new Identite("123", "schorsch", "maxime");
        Etudiant etudiant = new Etudiant(identite, formation);

        Groupe groupe = new Groupe(formation);

        groupe.ajouterEtudiant(etudiant);
        groupe.supprimerEtudiant(etudiant);

        assertEquals(0, groupe.getEtudiants().size());
    }

    @Test
    public void testFormationDifferent() {

        Formation formation1 = new Formation("BUTINFO");
        Formation formation2 = new Formation("BUTINFO2");

        Identite identite = new Identite("123", "schorsch", "maxime");
        Etudiant etudiant = new Etudiant(identite, formation2);

        Groupe groupe = new Groupe(formation1);

        assertThrows(Exception.class, () -> {
            groupe.ajouterEtudiant(etudiant);
        });
    }
}