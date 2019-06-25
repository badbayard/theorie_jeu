package theorie_jeu.Strategies;

import theorie_jeu.Strategies.Strategie;

public class Strat1 extends Strategie {

    public Strat1(int numero_joueur, int nombre_pierre) {
        super(numero_joueur,nombre_pierre);
    }

    @Override
    public int lancer(int nbPierreAdv, int positionTroll) {
        int nb = 1;

        boolean plusDePierre = (nbPierreAdv < nbPierre);
        int difPierre = nbPierre - nbPierreAdv;

        int urgence;
        if (numero == 1) {
            urgence = 6 - positionTroll;
        } else {
            urgence = positionTroll;
        }

        switch (urgence) {
            case 1:
                if (plusDePierre) {
                    nb = nbPierre;
                } else {
                    nb = 1;
                }
            break;
            case 2:
                if (plusDePierre) {
                    nb = 1;
                } else {
                    nb = 2;
                }
                break;
            case 3:
                if (plusDePierre) {
                    nb = 2;
                } else {
                    nb = 2;
                }
                break;
            case 4:
                if (plusDePierre) {
                    nb = 3;
                } else {
                    nb = 2;
                }
                break;
            case 5:
                if (plusDePierre) {
                    nb = nbPierreAdv;
                } else {
                    nb = nbPierre;
                }
                break;
            default:
                assert (false);
                break;
        }


        if(nb <= nbPierre) {
            nbPierre = nbPierre - nb;
            return nb;
        }else {
            nbPierre = 0;
            return nbPierre;
        }
    }

}
