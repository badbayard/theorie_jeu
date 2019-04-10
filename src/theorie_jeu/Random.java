package theorie_jeu;

public class Random extends Joueur{
    
    public Random(int _id, int _nb_pierre) {
        super(_id, _nb_pierre);
    }

    public int lancer(int x, int y) {
        int nb = (int) (1+(Math.random() * (nb_pierre - 1)));
        if(nb <= nb_pierre) {
            nb_pierre = nb_pierre - nb;
            return nb;
        }else {
            return 0;
        }

    }

}
