import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    //ATTRIBUTS
    //a liste des noeuds du graphe (un noeud = un String)
    private ArrayList<String> noeuds;
    //a liste des Arcs partant de chaque noeud du graphe
    private ArrayList<Arcs> adjacence;

    /**
     * methode getIndice
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



}
