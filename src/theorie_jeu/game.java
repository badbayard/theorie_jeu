package theorie_jeu;

public class game {

    
    public game () {
        
    }
    public int play() {
        random j1 = new random(1,15);
        random j2 = new random(2,15);
        terrain t1 = new terrain(7,4);
        int pierre_j1 = 0 ;
        int pierre_j2 = 0;
        int a = 0;
        int b = 0;
        boolean f = false;
        System.out.println("la position du trol initial "+t1.position_troll );
        while(true) {
            System.out.println("le tour de j1");
            pierre_j1 = j1.lancer_random();
            System.out.println("le tour de j2");
            pierre_j2 = j2.lancer_random();
            if (pierre_j1 > pierre_j2){
                //t1.set_position_troll(1);
                t1.position_troll++;
            }
            if(pierre_j2 > pierre_j1){
                //t1.set_position_troll(-1);
                t1.position_troll = t1.position_troll -1;
            }
            if (pierre_j1 == pierre_j2) {
                System.out.println("egalite");
            }
            
            System.out.println("la position du trol est "+t1.position_troll );
            System.out.println("nombre de pierre j1 est : "+j1.get_nb_pierre() );
            System.out.println("nombre de pierre j2 est : "+j2.get_nb_pierre() );
            
            if (j2.get_nb_pierre()==0 || t1.get_position_troll() == 7){
                System.out.println("j1 gagne");
                // j1.set_fin();
                j1.fin = true;
                return j1.get_nb_joueur();
            }
            if (j1.get_nb_pierre() == 0 || t1.get_position_troll() == 0){
                System.out.println("j2 gagne");
                // j2.set_fin();
                j2.fin = true;
                return j2.get_nb_joueur();
            }
            
        }
    }

}
