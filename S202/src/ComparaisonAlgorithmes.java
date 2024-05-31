public class ComparaisonAlgorithmes {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("E", "D", 43);

        BellmanFord b = new BellmanFord();
        Dijkstra d = new Dijkstra();
        long date_debutB = System.nanoTime () ;
        Valeur v = b.resoudre(g, "A");
        long date_finB = System.nanoTime () ;

        long date_debutD = System.nanoTime () ;
        Valeur v2 = d.resoudre(g,"A");
        long date_finD = System.nanoTime () ;

        System.out.println(date_finD -date_debutD );
        System.out.println(date_finB - date_debutB );



        GrapheListe g2 = new GrapheListe("Graphes/Graphe905.txt");

        long date_debutB2 = System.nanoTime () ;
        Valeur v3 = b.resoudre(g2, "1");
        long date_finB2 = System.nanoTime () ;

        long date_debutD2 = System.nanoTime () ;
        Valeur v4 = d.resoudre(g2,"1");
        long date_finD2 = System.nanoTime () ;

        long temps1 = date_finD2 -date_debutD2 ;
        long temps2 = date_finB2 - date_debutB2 ;

        System.out.println("l'algorithme de dijkstra à fini en : " + temps1);
        System.out.println("l'algorithme de Bellmon-Ford à fini en : " + temps2);


    }

}
