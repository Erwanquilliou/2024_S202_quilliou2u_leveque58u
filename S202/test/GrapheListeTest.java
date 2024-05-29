import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @Test
    void getIndice() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals(1, g.getIndice("B"));
    }
    @Test
    void getIndiceDebut() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals(0, g.getIndice("A"));
    }

    @Test
    void getIndiceFin() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals(3, g.getIndice("C"));
    }

    @Test
    void getIndiceInexistant() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals(-1, g.getIndice("H"));
    }

    @Test
    void suivants() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals("[B(12.0), D(87.0)]",g.suivants("A").toString());
    }

    @Test
    void suivantsInexistant() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("C", "A", 19);

        assertEquals("[]",g.suivants("H").toString());
    }

    @Test
    void ajouterArcNoeudsInexistants() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);

        assertEquals("A",g.listeNoeuds().get(0));
        assertEquals("B",g.listeNoeuds().get(1));
    }

    @Test
    void ajouterArc() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        assertEquals("[B(12.0), D(87.0)]",g.suivants("A").toString());
        assertEquals("D",g.listeNoeuds().get(2));
    }

}