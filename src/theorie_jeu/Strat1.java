package theorie_jeu;

public class Strat1 {
    int nb_joueur; // nombre joueur
    int nb_pierre;
    boolean fin = false;

    public Strat1(int numero_joueur, int nombre_pierre) {
        nb_joueur = numero_joueur;
        nb_pierre = nombre_pierre;
    }


    public int get_nb_pierre() {
        return nb_pierre;
    }


    public int lancer(int caseTroll, int nbPierreAdv) {
        int nb = 1;

        if (caseTroll == 6) {
            nb = nbPierreAdv + 1;
            if (nb <= nb_pierre) {
            } else {
                nb = nb_pierre;
            }
        } else {
            nb = (int) (1 + (Math.random() * (3)));
            if (nb <= nb_pierre) {
            } else {
                nb = nb_pierre;
            }
        }

        /*MISE A JOUR ET VALIDATION*/
        nb_pierre -= nb;
        assert (nb_pierre >= 0);

        return nb;
    }
}