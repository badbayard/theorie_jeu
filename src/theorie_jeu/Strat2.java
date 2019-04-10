package theorie_jeu;

public class Strat2 {
    int id;
    int nb_pierre;

    public Strat2(int _id, int nombre_pierre) {
        id = _id;
        nb_pierre = nombre_pierre;
    }

    public int lancer(int caseTroll, int nbPierreAdv) {

        int nb;
        if (id == 1) {
            nb = lancerJ1(caseTroll, nbPierreAdv);
        } else {
            nb = lancerJ2(caseTroll, nbPierreAdv);
        }
        nb = verification(nb);
        nb_pierre -= nb;
        assert (nb_pierre >= 0);

        return nb;
    }

    private int lancerJ1(int caseTroll, int nbPierreAdv){
        int nb = 1;
        switch (caseTroll) {
            case 2:
                nb = nbPierreAdv + 1;
                break;
            case 3:
                nb = aleatoire(2, 5);
                break;
            case 4:
                nb = aleatoire(1, 3);
                break;
            case 5:
                nb = aleatoire(2, 5);
                break;
            case 6:
                if (nbPierreAdv < nb_pierre) {
                    nb = nb_pierre;
                } else {
                    nb = aleatoire(1, 2);
                }
                break;
        }
        return nb;
    }
    private int lancerJ2(int caseTroll, int nbPierreAdv){
        int nb = 1;
        switch (caseTroll) {
            case 6:
                nb = nbPierreAdv + 1;
                break;
            case 5:
                nb = aleatoire(2, 5);
                break;
            case 4:
                nb = aleatoire(1, 3);
                break;
            case 3:
                nb = aleatoire(2, 5);
                break;
            case 2:
                if (nbPierreAdv < nb_pierre) {
                    nb = nb_pierre;
                } else {
                    nb = aleatoire(1, 2);
                }
                break;
        }
        return nb;
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