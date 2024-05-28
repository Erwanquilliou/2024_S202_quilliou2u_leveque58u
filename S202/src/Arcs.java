import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> arcs;

    /**
     * constructeur par defaut, crée une liste d'arcs vide
     */
    public Arcs (){
        arcs = new ArrayList<Arc>();
    }

    /**
     * permet d'ajouter un arc à la liste arcs
     * @param a Arc que l'on ajoute à la liste
     */
    void ajouterArc(Arc a){
        arcs.add(a);
    }

    /**
     *
     * @return Liste des arcs
     */
    List<Arc> getArcs(){
        return arcs;
    }
}
