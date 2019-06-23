package theorie_jeu.Strategies;

import theorie_jeu.Strategies.Strategie;

public class StratRandom extends Strategie {
    
    public StratRandom(int numero_joueur, int nombre_pierre) {
        super(numero_joueur, nombre_pierre);
    }

    @Override
    public int lancer(int nbPierreAdv, int positionTroll) {
        int nb = (int) (1+(Math.random() * (nbPierre - 1)));
        if(nb <= nbPierre) {
            nbPierre = nbPierre - nb;
            //System.out.println("le joueur "+ numero + " lance " + nb);
            return nb;
        }else {
            return 0;
        }
    }

}
