package theorie_jeu;

import theorie_jeu.Strategies.Strat1;
import theorie_jeu.Strategies.StratRandomBorne;
import theorie_jeu.Strategies.StratPrudente;
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
                new StratRandomBorne(2, 15),
                new Terrain(7));

        ////////

        Game game1vs1 = new Game(
                new Strat1(1, 15),
                new Strat1(2, 15),
                new Terrain(7));

        Game game1vs2 = new Game(
                new Strat1(1, 15),
                new StratRandomBorne(2, 15),
                new Terrain(7));

        ////////

        Game game2vs2 = new Game(
                new StratRandomBorne(1, 15),
                new StratRandomBorne(2, 15),
                new Terrain(7));

        ///////

        Game gameSPvsR = new Game(
                new StratPrudente(1, 15),
                new StratRandom(2, 15),
                new Terrain(7));

        Game gameSPvs1 = new Game(
                new StratPrudente(1, 15),
                new Strat1(2, 15),
                new Terrain(7));

        Game gameSPvs2 = new Game(
                new StratPrudente(1, 15),
                new StratRandomBorne(2, 15),
                new Terrain(7));

        ////

        int resRvsR = playGame(gameRvsR,1000, false);
        int resRvs1 = playGame(gameRvs1,1000, false);
        int resRvs2 = playGame(gameRvs2,1000, false);
        int res1vs1 = playGame(game1vs1,1000, false);
        int res1vs2 = playGame(game1vs2,1000, false);
        int res2vs2 = playGame(game2vs2,1000, false);
        int resSPvsR = playGame(gameSPvsR, 1000, false);
        int resSPvs1 = playGame(gameSPvs1, 1000, false);
        int resSPvs2 = playGame(gameSPvs2, 1000, false);
        //pas de SP vs SP parceque SP est config pour J1

        int matrix[][] = new int [4][4];
        matrix [0][0] = resRvsR;
        matrix [0][1] = resRvs1;
        matrix [0][2] = resRvs2;
        matrix [1][0] = -resRvs1;
        matrix [1][1] = res1vs1;
        matrix [1][2] = res1vs2;
        matrix [2][0] = -resRvs2;
        matrix [2][1] = -res1vs2;
        matrix [2][2] = res2vs2;
        matrix [0][3] = -resSPvsR;
        matrix [1][3] = -resSPvs1;
        matrix [2][3] = -resSPvs2;
        //matrix [3][3] = -;
        matrix [3][0] = resSPvsR;
        matrix [3][1] = resSPvs1;
        matrix [3][2] = resSPvs2;

        printMatrix(matrix);

        playGame(gameSPvs1, 1, true);

    }


    static int playGame(Game g, int nbGame, boolean verbose){

        int nbVictoireJ1 = 0;
        int nbVictoireJ2 = 0;
        int nbEgalite = 0;
        ArrayList<Integer> tab = new ArrayList<>();

        for (int i=0 ; i< nbGame ;i++) {
            tab.add(g.play(verbose));
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
        if(verbose){
            System.out.println("egalité     " + nbEgalite);
            System.out.println("victoire j1 " + nbVictoireJ1);
            System.out.println("victoire j2 " + nbVictoireJ2);
        }

        return nbVictoireJ1 - nbVictoireJ2;
    }

    public static void printMatrix(int[][] m){
        try{
            int rows = m.length;
            int columns = m[0].length;
            String str = "|\t";

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    str += m[i][j] + "\t";
                }

                System.out.println(str + "|");
                str = "|\t";
            }

        }catch(Exception e){System.out.println("Matrix is empty!!");}
    }

    /*
    private static int trouverPrudente(int[][] matrix) {
        int ligne = -1;
        int total;
        int max;

        int rows = matrix.length;
        int columns = matrix[0].length;

        max = 0;
        for(int i=0;i<rows;i++){
            total = 0;
            for(int j=0;j<columns;j++){
                total += matrix[i][j];
            }
            if(total > max){
                max = total;
                ligne = i;
            }
        }



        return ligne;
    }

    private static int[] trouverNash(int[][] matrix) {

        int min;
        int total;
        int ligne = -1;

        int rows = matrix.length;
        int columns = matrix[0].length;

        min = -1;
        for(int i=0;i<columns;i++){
            total = 0;
            for(int j=0;j<rows;j++){
                total += matrix[i][j];
            }
            if(total > min || min == -1){
                min = total;
                ligne = i;
            }
        }

        int[] tab = new int[2];
        tab[0] = trouverPrudente(matrix);
        tab[1] = ligne;
        return tab;
    }

     */

}
