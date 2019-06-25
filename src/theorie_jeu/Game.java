package theorie_jeu;

import theorie_jeu.Strategies.Strat1;
import theorie_jeu.Strategies.StratRandomBorne;
import theorie_jeu.Strategies.Strategie;

public class Game {

    Strategie j1;
    Strategie j2;
    Terrain terrain;


    public Game(Strategie strategiej1, Strategie strategiej2, Terrain terrainjeu) {
        j1 = strategiej1;
        j2 = strategiej2;
        terrain = terrainjeu;
    }

    private void init() {
        terrain.init();
        j1.init();
        j2.init();
    }

    public int play(boolean verbose) {

        init();

        if(verbose){
            System.out.println("la position du troll initial " + terrain.getPosition_troll() );
        }

        while(true) {
            //CHOIX DES JOUEURS
            int nbPierreJ1debutTour = j1.getNbPierre();
            int nbPierreJ2debutTour = j2.getNbPierre();
            int pierre_j1 = j1.lancer(nbPierreJ2debutTour, terrain.getPosition_troll());
            int pierre_j2 = j2.lancer(nbPierreJ1debutTour, terrain.getPosition_troll());

            if(verbose){
                System.out.println("j1 lance " + pierre_j1 );
                System.out.println("j2 lance " + pierre_j2 );
            }


            //MODIFICATION DU POSITIONEMENT DU TROLL
            if (pierre_j1 > pierre_j2){
                terrain.changePosition_troll(1);
            }
            else if(pierre_j2 > pierre_j1){
                terrain.changePosition_troll(-1);
            }

            //INFO
            if(verbose) {
                System.out.println("la position du troll est : " + terrain.getPosition_troll());
                System.out.println("nombre de pierre j1 est : " + j1.getNbPierre());
                System.out.println("nombre de pierre j2 est : " + j2.getNbPierre());
            }

            //TEST DE FIN DE JEU
            if (terrain.getPosition_troll() == terrain.getCaseMax()){
                if(verbose){
                    System.out.println("j1 gagne");
                }
                return 1;
            }
            if (terrain.getPosition_troll() == terrain.getCaseMin()) {
                if(verbose){
                    System.out.println("j2 gagne");
                }
                return 2;
            }
            if (j1.getNbPierre() == 0 && j2.getNbPierre() == 0) {
                if(terrain.getPosition_troll() < 3) {
                    if(verbose){
                        System.out.println("j2 gagne");
                    }
                    return 2;
                }
                else if (terrain.getPosition_troll() > 3) {
                    if(verbose){
                        System.out.println("j1 gagne");
                    }
                    return 1;
                }
                if(verbose){
                    System.out.println("egalite");
                }
                return 0;
            }
            if (j2.getNbPierre() == 0){
                if(terrain.getPosition_troll() + j1.getNbPierre() > 3){
                    if(verbose){
                        System.out.println("j1 gagne");
                    }
                    return 1;
                }
                if(terrain.getPosition_troll() + j1.getNbPierre() < 3){
                    if(verbose){
                        System.out.println("j2 gagne");
                    }
                    return 2;
                }
                if(verbose){
                    System.out.println("egalite");
                }
                return 0;
            }
            if (j1.getNbPierre() == 0){
                if(terrain.getPosition_troll() - j2.getNbPierre() > 3){
                    if(verbose){
                        System.out.println("j1 gagne");
                    }
                    return 1;
                }
                if(terrain.getPosition_troll() - j2.getNbPierre() < 3){
                    if(verbose){
                        System.out.println("j2 gagne");
                    }
                    return 2;
                }
                if(verbose){
                    System.out.println("egalite");
                }
                return 0;
            }

        }
    }



}
