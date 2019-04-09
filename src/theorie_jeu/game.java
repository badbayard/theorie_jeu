package theorie_jeu;

public class game {

    int nb_case = 7;
    int case_troll = 4;

    public game () {
        
    }
    public int play() {
        //CREATION DES JOUEURS
        Strat2 j1 = new Strat2(1,15);
        Strat2 j2 = new Strat2(2,15);

        int pierre_j1 = 0 ;
        int pierre_j2 = 0;

        while(true) {
            pierre_j1 = j1.lancer(case_troll, j2.get_nb_pierre());
            pierre_j2 = j2.lancer(case_troll, j1.get_nb_pierre());
            if (pierre_j1 > pierre_j2){
                case_troll++;
            } else if(pierre_j2 > pierre_j1){
                case_troll--;
            } else {}
            
            //System.out.println("la position du trol est "+t1.position_troll );
            //System.out.println("nombre de pierre j1 est : "+j1.get_nb_pierre() );
            //System.out.println("nombre de pierre j2 est : "+j2.get_nb_pierre() );

            //QUI GAGNE ?
            if(case_troll == 1) {
                return 2;
            } else if (case_troll == 7) {
                return 1;
            } else if (j1.get_nb_pierre() == 0 && j2.get_nb_pierre() == 0) {
                return 0;
            } else if (j2.get_nb_pierre() == 0){
                return 1;
            } else if (j1.get_nb_pierre() == 0){
                return 2;
            }
        }
    }

}
