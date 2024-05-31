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
        AtomicBoolean pointFixe = new AtomicBoolean(false);
        while (!pointFixe.get()){
            int[] changement = {0}; // j'initialise une liste de 1 élément égal pour m'en
            //servir en tant que compteur pour la suite, si il 
            for(int i = 0;i<l.size();i++){
                String noeudC = l.get(i);
                for(int[]  j = {0};j[0]<l.size();j[0]++){
                    List<Arc> noeudSuiv = g.suivants(l.get(j[0]));
                    noeudSuiv.forEach(noeud -> {
                        if(noeud.getDest() == noeudC){
                            if(noeud.getCout()+v.getValeur(l.get(j[0])) < v.getValeur(noeudC)){
                                v.setValeur(noeudC,noeud.getCout()+v.getValeur(l.get(j[0])));
                                v.setParent(noeudC,l.get(j[0]));
                                changement[0]++;
                            }
                        }
                    });
                }
            }
            if (changement[0]==0){
                pointFixe.set(true);
            }
        }
        return v;

    }
}
