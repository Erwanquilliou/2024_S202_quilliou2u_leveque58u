import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> arcs;

    public Arcs (){
        arcs = new ArrayList<Arc>();
    }
    void ajouterArc(Arc a){
        arcs.add(a);
    }
    List<Arc> getArcs(){
        return arcs;
    }
}
