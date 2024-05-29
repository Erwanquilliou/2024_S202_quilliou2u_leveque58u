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

        assertEquals("B",g.suivants("A").)
    }
/*
    @Test
    void ajouterArc() {
    }

    @Test
    void testToString() {
    }

 */
}