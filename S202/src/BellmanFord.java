import java.util.List;

public class BellmanFord {
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
            // on initialise la valeur de chaque noeud a la valeur maximale
        }
        v.setValeur(depart,0);
        //on met la valeur du noeud départ à 0
        Boolean pointFixe = false;
        while (!pointFixe){
            int[] changement = {0}; // j'initialise une liste de 1 élément égal pour m'en
                                    //servir en tant que compteur pour la suite, si je découvre un chemin plus court
                                    //pour l'un de mes noeuds, j'incrémente le compteur
            for(int i = 0;i<l.size();i++){
                String noeudC = l.get(i); // noeudC est mon noeud courant, je vais
                                            // pour chaque noeud, regarder si il existe un chemin plus court à un moment donné
                for(int[]  j = {0};j[0]<l.size();j[0]++){//utilise une liste d'entier j de 1 élément
                                                         //pour pouvoir utiliser l'entier dans lambda
                    List<Arc> noeudSuiv = g.suivants(l.get(j[0]));
                    // je prend la liste des noeuds successeur de chaque noeud un par un.
                    // l'objectif est de trouver les Antécedents de notre noeudC en regardant
                    //quel noeud à pour successeur noeudC
                    noeudSuiv.forEach(noeud -> {
                        if(noeud.getDest() == noeudC){
                            //si on retrouve notre noeud courant dans les successeurs d'un noeud, alors
                            //, ce noeud est antécedent du noeud courant.
                            if(noeud.getCout()+v.getValeur(l.get(j[0])) < v.getValeur(noeudC)){
                                //on regarde si le chemin jusqu'a notre antécédent + la valeur de son arc
                                // vers notre noeud courant, a une distance plus petite que la valeur
                                // enregistrée
                                v.setValeur(noeudC,noeud.getCout()+v.getValeur(l.get(j[0])));
                                v.setParent(noeudC,l.get(j[0]));
                                changement[0]++;
                            }
                        }
                    });
                }
            }
            if (changement[0]==0){
                pointFixe = true;
            }
        }
        return v;

    }
}
