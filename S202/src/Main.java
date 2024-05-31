
public class Main {

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe("Graphes/Graphe905.txt");
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);

        BellmanFord b = new BellmanFord();

        Valeur v = b.resoudre(g,"A");
        System.out.println(v.calculerChemin("C"));
        System.out.println(v);
    }
}
