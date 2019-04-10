package theorie_jeu;

import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {

        int NB_GAME = 100;

        System.out.println("debut");
        int i ;
        int total_0 = 0;
        int total_1 = 0;
        int total_2 = 0;
        int total_3 = 0;

        ArrayList<Integer> tab = new ArrayList<Integer>();
        
        for(i = 0 ; i < NB_GAME ; i++) {
            game g = new game();
            int res = g.play();
            if(res == 0) { total_0++; }
            else if (res == 1) { total_1++; }
            else if (res == 2) { total_2++; }
            else { total_3++; }
        }

        System.out.println("eg = " + (float)total_0/NB_GAME * 100 + "% (" + total_0 + ") ");
        System.out.println("j1 = " + (float)total_1/NB_GAME * 100 + "% (" + total_1 + ") ");
        System.out.println("j2 = " + (float)total_2/NB_GAME * 100 + "% (" + total_2 + ") ");
        System.out.println("er = " + (float)total_3/NB_GAME * 100 + "% (" + total_3 + ") ");
    }
}
