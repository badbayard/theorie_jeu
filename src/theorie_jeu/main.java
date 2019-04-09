package theorie_jeu;

import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {

        int NB_GAME = 1000;

        System.out.println("debut");
        int i ;
        int total_0 = 0;
        int total_1 = 0;
        int total_2 = 0;
        int total_3 = 0;
        game g = new game();
        ArrayList<Integer> tab = new ArrayList<Integer>();
        
        for (i=0 ; i< NB_GAME ;i++) {
            tab.add(g.play());
        }
        
        for(i = 0 ; i < tab.size(); i++) {
            //System.out.println(tab.get(i)); liste des matchs gagne
            if(tab.get(i) == 0) {
                total_0++;
            }
            else if (tab.get(i)== 1) {
                total_1++;
            }else if (tab.get(i) == 2){
                total_2++;
            } else {
                total_3++;
            }
        }

        System.out.println("eg = " + (float)total_0/NB_GAME * 100 + "% (" + total_0 + ") ");
        System.out.println("j1 = " + (float)total_1/NB_GAME * 100 + "% (" + total_1 + ") ");
        System.out.println("j2 = " + (float)total_2/NB_GAME * 100 + "% (" + total_2 + ") ");
        System.out.println("er = " + (float)total_3/NB_GAME * 100 + "% (" + total_3 + ") ");



        //ONE GAME
        /*
        game g = new game();
        System.out.println("Le joueur : " + g.play() + "gagne");
        */
    }
}
