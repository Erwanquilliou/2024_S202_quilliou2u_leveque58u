import java.util.List;

public interface Graphe {
    /**
     * methode listeNoeuds
     * @return tous les noeuds du graphe (sous la forme d'une liste de String)
     */
    public List<String> listeNoeuds();

    /**
     * methode suivants
     * @param n noeud
     * @return liste des arcs partant du nœud n passe en param`etre
     */
    public List<Arc> suivants(String n);
}
