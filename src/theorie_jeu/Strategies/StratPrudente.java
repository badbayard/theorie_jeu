package theorie_jeu.Strategies;

import theorie_jeu.Struct;

public class StratPrudente extends Strategie {

    Struct struct;

    public StratPrudente(int numero_joueur, int nombre_pierre) {
        super(numero_joueur,nombre_pierre);
        struct = new Struct();
        struct.init();
    }

    @Override
    public int lancer(int nbPierreAdv, int positionTroll) {
        struct.calcul(nbPierre, nbPierreAdv, positionTroll);
        int nb = struct.SoptTable[nbPierre][nbPierreAdv][positionTroll];
        //System.out.println("le joueur "+ numero + " lance " + nb);
        if(nb <= nbPierre) {
            nbPierre = nbPierre - nb;
            //System.out.println("le joueur "+ numero + " lance " + nb);
        }else {
            nb = 0;
        }

        return nb;
    }
}
