import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FormationTest {

    @Test
    public void testAddMatiere() {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");

        formation.addMatiere(java, 2.0);

        assertEquals(2.0, formation.getCoef(java));
    }

    @Test
    public void testRemoveMatiere() {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");

        formation.addMatiere(java, 2.0);
        formation.removeMatiere(java);

        assertEquals(0, formation.getCoef(java));
    }

    @Test
    public void testGetCoef() {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");

        formation.addMatiere(java, 3.0);

        assertEquals(3.0, formation.getCoef(java));
    }

    @Test
    public void testMatiereAbsente() {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");

        assertEquals(0, formation.getCoef(java));
    }

    @Test
    public void testGetMapMatieres() {

        Formation formation = new Formation("BUTINFO");

        Matiere java = new Matiere("Java");

        formation.addMatiere(java, 2.0);

        assertTrue(formation.getMapMatieres().containsKey(java));
    }
}