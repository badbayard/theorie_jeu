package theorie_jeu;

public class Strat2 {
    int nb_joueur; // nombre joueur
    int nb_pierre;
    boolean fin = false;

    public Strat2(int numero_joueur, int nombre_pierre) {
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

    public int lancer(int caseTroll, int nbPierreAdv) {
        int nb = 1;

        switch (caseTroll){
            case 2:
                nb = nbPierreAdv + 1;
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 3:
                nb = (int) (1 + (Math.random() * (3)));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 4:
                nb = (int) (1 + (Math.random() * (5)));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 5:
                if(nbPierreAdv < nb_pierre){
                    nb = nb_pierre;
                }
                break;
        }


        /*MISE A JOUR ET VALIDATION*/
        nb_pierre -= nb;
        assert (nb_pierre >= 0);

        return nb;
    }
}