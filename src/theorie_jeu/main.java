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
        int matrix[][] = new int [3][3];
        matrix [0][0] = resRvsR;
        matrix [0][1] = resRvs1;
        matrix [0][2] = resRvs2;
        matrix [1][0] = -resRvs1;
        matrix [1][1] = res1vs1;
        matrix [1][2] = res1vs2;
        matrix [2][0] = -resRvs2;
        matrix [2][1] = -res1vs2;
        matrix [2][2] = res2vs2;
        
        System.out.println("Matrice des gains");
        printMatrix(matrix);

        switch (trouverPrudente(matrix)){
            case 0:
                System.out.println("Strategie prudente est StratRandom");
                break;
            case 1:
                System.out.println("Strategie prudente est Strat1");
                break;
            case 2:
                System.out.println("Strategie prudente est Strat2");
                break;
            default:
                assert (false);
                break;
        }

        int[] tab = new int[2];
        tab = trouverNash(matrix);
        
        System.out.println(" ");
        System.out.println("equilibre de Nash");
        System.out.println(tab[0]);
        System.out.println(tab[1]);

    }

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

}
