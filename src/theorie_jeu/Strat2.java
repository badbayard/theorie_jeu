package theorie_jeu;

public class Strat2 {
    int id;
    int nb_pierre;

    public Strat2(int _id, int nombre_pierre) {
        id = _id;
        nb_pierre = nombre_pierre;
    }

    public int get_nb_pierre() {
        return nb_pierre;
    }

    public int lancer(int caseTroll, int nbPierreAdv) {

        int nb;
        if (id == 1) {
            nb = lancerJ1(caseTroll, nbPierreAdv);
        } else {
            nb = lancerJ2(caseTroll, nbPierreAdv);
        }

        nb_pierre -= nb;
        assert (nb_pierre >= 0);

        return nb;
    }

    private int lancerJ1(int caseTroll, int nbPierreAdv){
        int nb = 1;
        int Min;
        int Max;
        switch (caseTroll) {
            case 2:
                nb = nbPierreAdv + 1;
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 3:
                Min = 1;
                Max = 5;
                nb = Min + (int)(Math.random() * ((Max - Min) + 1));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 4:
                Min = 1;
                Max = 3;
                nb = Min + (int)(Math.random() * ((Max - Min) + 1));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 5:
                if (nbPierreAdv < nb_pierre) {
                    nb = nb_pierre;
                }
                break;
        }
        return nb;
    }
    private int lancerJ2(int caseTroll, int nbPierreAdv){
        int nb = 1;
        int Min;
        int Max;
        switch (caseTroll) {
            case 5:
                nb = nbPierreAdv + 1;
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 4:
                Min = 1;
                Max = 5;
                nb = Min + (int)(Math.random() * ((Max - Min) + 1));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 3:
                Min = 1;
                Max = 3;
                nb = Min + (int)(Math.random() * ((Max - Min) + 1));
                if (nb <= nb_pierre) {
                } else {
                    nb = nb_pierre;
                }
                break;
            case 2:
                if (nbPierreAdv < nb_pierre) {
                    nb = nb_pierre;
                }
                break;
        }
        return nb;
    }
}