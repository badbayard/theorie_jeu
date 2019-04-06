package theorie_jeu;

public class random{
    int nb_joueur; // nombre joueur
    int nb_pierre;
    boolean fin = false;
    
    public random(int numero_joueur, int nombre_pierre) {
        nb_joueur = numero_joueur;
        nb_pierre = nombre_pierre;
    }
    
    public void set_fin() {
        fin = true;
    }
    
    public void set_nb_joueur(int chiffre) {
        nb_joueur = chiffre;
    }
    
    public void set_nb_pierre(int other_chiffre) {
        nb_pierre = other_chiffre;
    }
    
    public int get_nb_joueur() {
        return nb_joueur;
    }
    
    public int get_nb_pierre() {
        return nb_pierre;
    }
    
    public boolean get_fin() {
        return fin;
    }
    
    public int lancer_random() {
        int nb = (int) (1+(Math.random() * (nb_pierre - 1)));
        if(nb <= nb_pierre) {
            nb_pierre = nb_pierre - nb;
            System.out.println("le joueur "+ nb_joueur + " lance " + nb);
            return nb;
        }else {
            return 0;
        }

    }

}
