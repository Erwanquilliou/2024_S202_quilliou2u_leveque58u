import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BellmanFordTest {
    @Test
    public void resoudre(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);
        BellmanFord b =new BellmanFord();
        Valeur v = b.resoudre(g,"A");
        assertEquals(v.getValeur("E"),23);
        assertEquals(v.getValeur("A"),0);
        assertEquals(v.getValeur("B"),12);
        assertEquals(v.getValeur("C"),76);
        assertEquals(v.getValeur("D"),66);
    }
}
