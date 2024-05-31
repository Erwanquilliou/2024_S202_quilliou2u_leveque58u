import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DijkstraTest {

    @Test
    public void resoudreDistance(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);
        Dijkstra d =new Dijkstra();
        Valeur v = d.resoudre(g,"A");
        assertEquals(v.getValeur("E"),23);
        assertEquals(v.getValeur("A"),0);
        assertEquals(v.getValeur("B"),12);
        assertEquals(v.getValeur("C"),76);
        assertEquals(v.getValeur("D"),66);
    }
    @Test
    public void resoudreParents(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);
        Dijkstra d =new Dijkstra();
        Valeur v = d.resoudre(g,"A");
        assertEquals(v.getParent("E"),"B");
        assertEquals(v.getParent("A"),null);
        assertEquals(v.getParent("B"),"A");
        assertEquals(v.getParent("C"),"D");
        assertEquals(v.getParent("D"),"E");
    }
}
