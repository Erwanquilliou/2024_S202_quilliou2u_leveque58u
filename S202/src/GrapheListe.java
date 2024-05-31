import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    //ATTRIBUTS
    //a liste des noeuds du graphe (un noeud = un String)
    private ArrayList<String> noeuds;
    //a liste des Arcs partant de chaque noeud du graphe
    private ArrayList<Arcs> adjacence;

    /**
     * Constructeur par défaut
     */
    public GrapheListe(){
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    /**
     * constructeur par Fichier
     * @param nomFich chemin d'accès vers un fichier graphe
     */
    public GrapheListe(String nomFich){
        FileReader fich;
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
        try {
            fich = new FileReader(nomFich);
            BufferedReader read = new BufferedReader(fich);
            String ligne = read.readLine();
            while(ligne != null){
                String[] car = ligne.split("\t");
                this.ajouterArc(car[0],car[1], Double.parseDouble(car[2]));
                ligne = read.readLine();
            }

        }catch(FileNotFoundException e){
            System.out.println("fichier introuvable");
        }catch(IOException e){
            System.out.println("jsp");
        }

    }

    /**
     * methode getIndice qui renvoie l indice du noeud passe en parametre
     * @param n noeud
     * @return indice du noeud passe en parametre
     */
    public int getIndice(String n) {
        boolean trouve = false;
        int i = 0;
        int indiceN = -1;
        while ((!trouve)&&(i<this.noeuds.size())) {
            if (this.noeuds.get(i).compareTo(n) == 0) {
                trouve = true;
                indiceN = i;
            }
            i++;
        }
        return indiceN;
    }

    /**
     *
     * @return la liste des noeuds du graphe
     */
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     *
     * @param n noeud dont on veut connaitre les successeurs
     * @return Les successeurs du noeud n
     */
    @Override
    public List<Arc> suivants(String n) {
        int indice = this.getIndice(n);
        if (indice == -1) {
            return new ArrayList<Arc>();
        } else {
            return this.adjacence.get(indice).getArcs();
        }
    }

    /**
     * methode ajouterArc qui permet d ajouter des noeuds et des arcs a un objet de type GrapheListe
     * @param depart noeud de depart
     * @param destination noeud de destination
     * @param cout cout de l arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        //si le noeud depart n existe pas
        if (this.getIndice(depart) == -1) {
            //l ajouter a this.noeuds
            this.noeuds.add(depart);
            //creer une liste vide correspondant a l indice du noeud de depart
            Arcs listeArcs = new Arcs();
            this.adjacence.add(listeArcs);
        }

        //si le noeud de destination n existe pas
        if (this.getIndice(destination) == -1) {
            //l ajouter a this.noeuds
            this.noeuds.add(destination);
            //creer une liste vide correspondant a l indice du noeud de depart
            Arcs listeArcs = new Arcs();
            this.adjacence.add(listeArcs);
        }

        //chercher l indice i du noeud de depart
        int indiceDep = this.getIndice(depart);
        //ajouter le noeud de destination a l indice i
        Arc arc1 = new Arc(destination, cout);
        this.adjacence.get(indiceDep).getArcs().add(arc1);
    }

    /**
     * methode toString
     * @return l affichage du contenu d un objet GrapheListe
     */
    public String toString() {
        String affichage = "";
        final int[] i = {0};
        noeuds.forEach(noeud->
        {
            System.out.print(noeud+" -> ");
            adjacence.get(i[0]).getArcs().forEach(arc -> System.out.print(arc));
            i[0]++;
            System.out.println("");
        });
        return affichage;
    }

}
