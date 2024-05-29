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
        for (int sommet=0; sommet<listeNoeuds.size(); sommet++) {
            v.setValeur(listeNoeuds.get(sommet),Double.MAX_VALUE);
        }
        v.setValeur(depart,0);


    }
}
