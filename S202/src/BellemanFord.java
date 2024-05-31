import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BellemanFord {
    /*Entrees :
    G un graphe oriente avec une ponderation positive des arcs (cout ou poids)
    A un sommet (depart) de G

    Debut
    L <- {} // utilisation d’une liste de noeuds a traiter
    Pour chaque sommet v de G faire
        v.valeur <- Infini
        v.parent <- Indefini
        L <- L U {v} // ajouter le sommet v a la liste L
    Fin Pour

    A.valeur <- 0
    pointFixe <- un booleen qui indique si le point fixe a ete trouve ou non

    Tant que pointFixe = faux faire
        changement <- un compteur pour le nombre de changements
        Pour chaque noeud de la liste L faire
            noeudC <- noeud // ajouter le noeud a la variable noeudC creee

            Pour chaque noeud2 de la liste L faire
                noeudSuiv <- G.suivants

                Si noeud2.destination = noeudC
                    Alors si (noeud2.cout + v.valeur(l.get(j[0]))) < v.valeur(noeudC)
                        Alors noeudC.valeur <- noeud2.valeur + poids(noeud2,noeudC)
                        noeudC.parent <- noeud2
                        changement++
                    Fin Si
                Fin Pour
            Fin Pour
            Si changement = 0
                Alors pointFixe <- vrai
            Fin Si
        Fin Pour
    Fin Tant que
    retourner v
    Fin*/
    Valeur v = new Valeur();
    Valeur resoudre(Graphe g, String depart){
        List<String> l= g.listeNoeuds();
        for(int i = 0;i<l.size();i++){
            v.setValeur(l.get(i),Double.MAX_VALUE);
        }
        v.setValeur(depart,0);
        AtomicBoolean pointFixe = new AtomicBoolean(false);
        while (!pointFixe.get()){
            int[] changement = {0};
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
