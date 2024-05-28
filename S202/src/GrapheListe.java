import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    //ATTRIBUTS
    //a liste des noeuds du graphe (un noeud = un String)
    private ArrayList<String> noeuds;
    //a liste des Arcs partant de chaque noeud du graphe
    private ArrayList<Arcs> adjacence;
    @Override
    public List<String> listeNoeuds() {
        return null;
    }

    @Override
    public List<Arc> suivants(String n) {
        return null;
    }



}
