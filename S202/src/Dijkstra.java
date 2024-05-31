import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    /*Entrees :
    G un graphe oriente avec une ponderation positive des arcs (cout ou poids)
    A un sommet (depart) de G
    Debut
    Q <- {} // utilisation d’une liste de noeuds a traiter
    Pour chaque sommet v de G faire
    v.valeur <- Infini
    v.parent <- Indefini
    Q <- Q U {v} // ajouter le sommet v a la liste Q
    Fin Pour
    A.valeur <- 0
    Tant que Q est un ensemble non vide faire
    u <- un sommet de Q telle que u.valeur est minimal
    // enlever le sommet u de la liste Q
    Q <- Q \ {u}
    Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
    d <- u.valeur + poids(u,v)
    Si d < v.valeur
    // le chemin est plus interessant
    Alors v.valeur <- d
    v.parent <- u
    Fin Si
    Fin Pour
    Fin Tant que
    Fin*/
    public Valeur resoudre(GrapheListe g, String depart) {
        Valeur v = new Valeur();
        List<String> listeNoeuds = new ArrayList<String>();
        g.listeNoeuds().forEach(noeud -> listeNoeuds.add(noeud));
        for (int i=0; i<listeNoeuds.size(); i++) {
            v.setValeur(listeNoeuds.get(i),Double.MAX_VALUE);
            //on initialise la valeur de tous les sommets à Double.MAX_VALUE, correspondant à +infini
        }
        v.setValeur(depart,0);
        //on initialise la valeur du sommet départ à 0
        while (listeNoeuds.size() > 0) {
            //on continue tant que tous les noeuds n'ont pas été traités
            double min = v.getValeur(listeNoeuds.get(0));
            String sommetMin = listeNoeuds.get(0);
            for (int j=0; j<listeNoeuds.size(); j++) {
                if (v.getValeur(listeNoeuds.get(j))< min) {
                    min = v.getValeur(listeNoeuds.get(j));
                    sommetMin = listeNoeuds.get(j);
                }
            }
            //on recherche le sommet avec la valeur minimal, c'est le principe de l'algorithme de dijkstra
            listeNoeuds.remove(sommetMin);
            //on regarde les successeurs de sommetMin
            List<Arc> suivantsMin = g.suivants(sommetMin);
            double distance = 0;
            for (int k=0; k<suivantsMin.size(); k++) {
                //pour chaque suivant du sommetMin
                distance = v.getValeur(sommetMin) + suivantsMin.get(k).getCout();
                // on calcule le cout du chemin avec le sommetMin et on le compare au chemin sauvegardé dans Valeur
                if (distance < v.getValeur(suivantsMin.get(k).getDest())){
                    v.setValeur(suivantsMin.get(k).getDest(),distance);
                    v.setParent(suivantsMin.get(k).getDest(),sommetMin);
                }
            }

        }
        return v;

    }
}
