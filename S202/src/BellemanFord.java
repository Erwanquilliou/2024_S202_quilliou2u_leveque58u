import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BellemanFord {
    Valeur v = new Valeur();
    Valeur resoudre(Graphe g, String depart){
        List<String> l= g.listeNoeuds();
        for(int i = 0;i<l.size();i++){
            v.setValeur(l.get(i),Double.MAX_VALUE);
        }
        v.setValeur(depart,0);
        AtomicBoolean pointFixe = new AtomicBoolean(true);
        while (pointFixe.get()){
            for(int i = 0;i<l.size();i++){
                String noeudC = l.get(i);
                for(int[]  j = {0};j[0]<l.size();j[0]++){
                    List<Arc> noeudSuiv = g.suivants(l.get(j[0]));
                    noeudSuiv.forEach(noeud -> {
                        if(noeud.getDest() == noeudC){
                            if(noeud.getCout()+v.getValeur(l.get(j[0])) < v.getValeur(noeudC)){
                                v.setValeur(noeudC,noeud.getCout()+v.getValeur(l.get(j[0])));
                                pointFixe.set(false);
                            }
                        }
                    });
                }
            }
        }
        return v;

    }
}
