package theorie_jeu;

import theorie_jeu.Strategies.Strat1;
import theorie_jeu.Strategies.Strat2;
import theorie_jeu.Strategies.StratRandom;

import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {

        Game gameRvsR = new Game(
                new StratRandom(1, 15),
                new StratRandom(2, 15),
                new Terrain(7));

        Game gameRvs1 = new Game(
                new StratRandom(1, 15),
                new Strat1(2, 15),
                new Terrain(7));

        Game gameRvs2 = new Game(
                new StratRandom(1, 15),
                new Strat2(2, 15),
                new Terrain(7));

        ////////

        Game game1vs1 = new Game(
                new Strat1(1, 15),
                new Strat1(2, 15),
                new Terrain(7));

        Game game1vs2 = new Game(
                new Strat1(1, 15),
                new Strat2(2, 15),
                new Terrain(7));

        ////////

        Game game2vs2 = new Game(
                new Strat2(1, 15),
                new Strat2(2, 15),
                new Terrain(7));

        int resRvsR = playGame(gameRvsR);
        int resRvs1 = playGame(gameRvs1);
        int resRvs2 = playGame(gameRvs2);
        int res1vs1 = playGame(game1vs1);
        int res1vs2 = playGame(game1vs2);
        int res2vs2 = playGame(game2vs2);

        System.out.println(resRvsR + "    " + resRvs1 + "    " + resRvs2);
        System.out.println(-resRvs1 + "    " + res1vs1 + "    " + res1vs2);
        System.out.println(-resRvs2 + "    " + -res1vs2 + "    " + res2vs2);

    }


    static int playGame(Game g){

        int nbVictoireJ1 = 0;
        int nbVictoireJ2 = 0;
        int nbEgalite = 0;
        ArrayList<Integer> tab = new ArrayList<>();

        for (int i=0 ; i< 200 ;i++) {
            tab.add(g.play());
        }

        for(int i = 0 ; i < tab.size(); i++) {
            //System.out.println(tab.get(i)); liste des matchs gagne
            if (tab.get(i)== 1) {
                nbVictoireJ1++;
            }else if (tab.get(i) == 2){
                nbVictoireJ2++;
            } else {
                nbEgalite++;
            }
        }
        //System.out.println("egalité     " + nbEgalite);
        //System.out.println("victoire j1 " + nbVictoireJ1);
        //System.out.println("victoire j2 " + nbVictoireJ2);

        return nbVictoireJ1 - nbVictoireJ2;
    }

}
