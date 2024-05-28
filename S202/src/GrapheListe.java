import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    //ATTRIBUTS
    //a liste des noeuds du graphe (un noeud = un String)
    private ArrayList<String> noeuds;
    //a liste des Arcs partant de chaque noeud du graphe
    private ArrayList<Arcs> adjacence;

    /**
     * methode getIndice qui renvoie l indice du noeud passe en parametre
     * @param n noeud
     * @return indice du noeud passe en parametre
     */
    public int getIndice(String n) {
        boolean trouve = false;
        int i = 0;
        int indiceN = 0;
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
        return this.adjacence.get(indice).getArcs();
    }

    /**
     * methode ajouterArc qui permet d ajouter des noeuds et des arcs a un objet de type GrapheListe
     * @param depart noeud de depart
     * @param destination noeud de destination
     * @param cout cout de l arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        
    }

    /**
     * methode toString
     * @return l affichage du contenu d un objet GrapheListe
     */
    public String toString() {
        String affichage = "";
        return affichage;
    }

}
