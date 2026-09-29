import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GroupeMoyennesTest {

    @Test
    public void testMoyenneMatiere() throws Exception {

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

        e1.ajouterNote(java, 10);
        e2.ajouterNote(java, 14);

        Groupe groupe = new Groupe(formation);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);

        assertEquals(12, groupe.moyenneMatiere(java));
    }

    @Test
    public void testMoyenneGenerale() throws Exception {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");
        Matiere anglais = new Matiere("Anglais");

        formation.addMatiere(java, 2.0);
        formation.addMatiere(anglais, 1.0);

        Etudiant e1 = new Etudiant(
                new Identite("1", "schorsch", "maxime"),
                formation
        );

        Etudiant e2 = new Etudiant(
                new Identite("2", "saez", "aidan"),
                formation
        );

        e1.ajouterNote(java, 15);
        e1.ajouterNote(anglais, 12);

        e2.ajouterNote(java, 9);
        e2.ajouterNote(anglais, 15);

        Groupe groupe = new Groupe(formation);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);

        assertEquals(12.5, groupe.moyenneGenerale());
    }
}