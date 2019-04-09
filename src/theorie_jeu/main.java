package theorie_jeu;

import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {
        System.out.println("debut");
        int i ;
        int total_0 = 0;
        int total_1 = 0;
        int total_2 = 0;
        game g = new game();
        ArrayList<Integer> tab = new ArrayList<Integer>();
        
        for (i=0 ; i< 200 ;i++) {
            tab.add(g.play());
        }
        
        for(i = 0 ; i < tab.size(); i++) {
            //System.out.println(tab.get(i)); liste des matchs gagne
            if (tab.get(i)== 1) {
                total_1++;
            }else if (tab.get(i) == 2){
                total_2++;
            } else {
                total_0++;
            }
        }
        System.out.println("egalité     " + total_0);
        System.out.println("victoire j1 " + total_1);
        System.out.println("victoire j2 " + total_2);


    }
}
