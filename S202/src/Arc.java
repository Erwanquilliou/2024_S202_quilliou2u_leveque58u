public class Arc {
    private String dest;
    private double cout;

    /**
     *Constructeur, crée un arc avec une destination et un cout
     * @param d String représentant la destination de l'arc
     * @param c Réel positif représentant le cout de l'arc
     */
    public Arc(String d,double c){
        this.dest = d;
        if (c>0)
            this.cout = c;
        else
            this.cout = 1;
    }

    public String toString(){
        return dest + "(" + cout + ")";
    }


}
