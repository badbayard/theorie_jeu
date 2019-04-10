package theorie_jeu;

public class Joueur {
    int id; // nombre joueur
    int nb_pierre;
    boolean fin = false;
    
    
    public Joueur(int _id, int _nb_pierre) {
        id = _id;
        nb_pierre = _nb_pierre;
    }

    public int aleatoire(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public int verification(int n){
        if (n > nb_pierre) {
            n = nb_pierre;
        }
        return n;
    }

}
