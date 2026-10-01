import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupeTest {

    @BeforeEach
    void setUp() {
        // Initialisation
        etu1 = new Etudiant("nom1", "prenom1", "1");
        etu2 = new Etudiant("nom2", "prenom2", "2");
        etu3 = new Etudiant("nom3", "prenom3", "3");
        etu4 = new Etudiant("nom4", "prenom4", "4");
        formation = new Formation(0);
        formation.addCoefMatiere("mat1", 1);
        formation.addCoefMatiere("mat2", 2);
        // Etudiant Formation
        etu1.associerFormation(formation);
        etu2.associerFormation(formation);
        etu3.associerFormation(formation);
        etu4.associerFormation(formation);
        groupe1 = new Groupe(formation, etu1, etu2, etu3, etu4);
        // Etudiant Groupe
        groupe1.setFormation(formation);
        etu1.setGroupe(groupe1);
        etu2.setGroupe(groupe1);
        etu3.setGroupe(groupe1);
        etu4.setGroupe(groupe1);
    }

    @Test
    void testTriAlpha()
    {
        groupe1.triAlpha();

        assertEquals(groupe1.getEtudiants().get(0).getNom(), etu1.getNom());
        assertEquals(groupe1.getEtudiants().get(1).getNom(), etu2.getNom());
    }

    @Test
    void testTriAntiAlpha()
    {
        groupe1.triAntiAlpha();

        assertEquals(groupe1.getEtudiants().get(0).getNom(), etu4.getNom());
        assertEquals(groupe1.getEtudiants().get(1).getNom(), etu3.getNom());
    }

    @Test
    void testTriParMerite()
    {
        groupe1.triParMerite();

        assertEquals(groupe1.getEtudiants().getFirst().getNom(), etu3.getNom());
    }

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