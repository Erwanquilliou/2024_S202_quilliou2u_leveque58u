import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    //ATTRIBUTS
    //a liste des noeuds du graphe (un noeud = un String)
    private ArrayList<String> noeuds;
    //a liste des Arcs partant de chaque noeud du graphe
    private ArrayList<Arcs> adjacence;


    public GrapheListe(){
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    /**
     * methode getIndice qui renvoie l indice du noeud passe en parametre
     * @param n noeud
     * @return indice du noeud passe en parametre
     */
    public int getIndice(String n) {
        boolean trouve = false;
        int i = 0;
        int indiceN = -1;
        while ((!trouve)&&(i<this.noeuds.size())) {
            if (this.noeuds.get(i).compareTo(n) == 0) {
                trouve = true;
                indiceN = i;
            }
            i++;
        }
        return indiceN;
    }
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    @Override
    public List<Arc> suivants(String n) {
        int indice = this.getIndice(n);
        if (indice == -1) {
            return new ArrayList<Arc>();
        } else {
            return this.adjacence.get(indice).getArcs();
        }
    }

    /**
     * methode ajouterArc qui permet d ajouter des noeuds et des arcs a un objet de type GrapheListe
     * @param depart noeud de depart
     * @param destination noeud de destination
     * @param cout cout de l arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        //si le noeud depart n existe pas
        if (this.getIndice(depart) == -1) {
            //l ajouter a this.noeuds
            this.noeuds.add(depart);
            //creer une liste vide correspondant a l indice du noeud de depart
            Arcs listeArcs = new Arcs();
            this.adjacence.add(listeArcs);
        }

        //si le noeud de destination n existe pas
        if (this.getIndice(destination) == -1) {
            //l ajouter a this.noeuds
            this.noeuds.add(destination);
            //creer une liste vide correspondant a l indice du noeud de depart
            Arcs listeArcs = new Arcs();
            this.adjacence.add(listeArcs);
        }

        //chercher l indice i du noeud de depart
        int indiceDep = this.getIndice(depart);
        //ajouter le noeud de destination a l indice i
        Arc arc1 = new Arc(destination, cout);
        this.adjacence.get(indiceDep).getArcs().add(arc1);
    }

    /**
     * methode toString
     * @return l affichage du contenu d un objet GrapheListe
     */
    public String toString() {
        String affichage = "";
        final int[] i = {0};
        noeuds.forEach(noeud->
        {
            System.out.print(noeud+" -> ");
            adjacence.get(i[0]).getArcs().forEach(arc -> System.out.print(arc));
            i[0]++;
            System.out.println("");
        });
        return affichage;
    }

}
