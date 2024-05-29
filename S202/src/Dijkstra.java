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
    public void resoudre(GrapheListe g, String depart) {
        Valeur v = new Valeur();
        List<String> listeNoeuds = g.listeNoeuds();
        for (int i=0; i<listeNoeuds.size(); i++) {
            v.setValeur(listeNoeuds.get(i),Double.MAX_VALUE);
        }
        v.setValeur(depart,0);

        while (listeNoeuds.size() > 0) {
            double min = v.getValeur(listeNoeuds.get(0));
            String sommetMin = listeNoeuds.get(0);
            for (int j=0; j<listeNoeuds.size(); j++) {
                if (v.getValeur(listeNoeuds.get(j))< min) {
                    min = v.getValeur(listeNoeuds.get(j));
                    sommetMin = listeNoeuds.get(j);
                }
            }
            listeNoeuds.remove(sommetMin);

            //on regarde les suivants du sommetMin
            List<Arc> suivantsMin = g.suivants(sommetMin);
            List<String> suivantsMinNom;
            for(int j=0; j<listeNoeuds.size(); j++){
                if(v.getValeur(listeNoeuds.get(j) == ))
            }
            //pour chaque suivant du sommetMin
            double distance = 0;
            for (int k=0; k<suivantsMin.size(); k++) {
                // on calcule le cout du chemin avec le sommetMin et on le compare au chemin sauvegardé dans Valeur
                distance = v.getValeur(sommetMin) + suivantsMin.get(k).getCout();
                if (distance < v.getValeur(suivantsMin.get(k)));
            }

        }

    }
}
