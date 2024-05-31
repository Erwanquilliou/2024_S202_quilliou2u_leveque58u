
public class Main {

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);
        Dijkstra d =new Dijkstra();
        BellemanFord b = new BellemanFord();
        Valeur v = d.resoudre(g,"A");
        Valeur v2 = b.resoudre(g,"A");
        System.out.println(v);
        System.out.println(v2);

    }
}
