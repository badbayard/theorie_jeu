package theorie_jeu.Strategies;

import theorie_jeu.Strategies.Strategie;

public class Strat2 extends Strategie {

    public Strat2(int numero_joueur, int nombre_pierre) {
        super(numero_joueur,nombre_pierre);
    }

    @Override
    public int lancer(int nbPierreAdv, int positionTroll) {
        int nb = (int) (1+(Math.random() * 3));
        if(nb <= nbPierre) {
            nbPierre = nbPierre - nb;
            //System.out.println("le joueur "+ numero + " lance " + nb);
            return nb;
        }else {
            nbPierre = 0;
            return nbPierre;
        }
    }

}
