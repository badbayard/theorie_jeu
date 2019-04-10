package theorie_jeu;

public class game {

    int nb_case;
    int case_troll;

    public game () {
        nb_case = 7;
        case_troll = 4;
    }

    public int play() {

        Strat2 j1 = new Strat2(1, 15);
        Strat2 j2 = new Strat2(2, 15);

        while (case_troll != 1 && case_troll != 7 && j1.nb_pierre > 0 && j2.nb_pierre > 0) {
            int pierre_j1 = j1.lancer(case_troll, j2.nb_pierre);
            int pierre_j2 = j2.lancer(case_troll, j1.nb_pierre);
            if (pierre_j1 > pierre_j2) {
                case_troll++;
            } else if (pierre_j2 > pierre_j1) {
                case_troll--;
            } else {
            }
        }

        if (case_troll == 7) {
            return 1;
        }
        if (case_troll == 1) {
            return 2;
        }


        if (j1.nb_pierre == 0 && j2.nb_pierre == 0) {

        } else if (j1.nb_pierre == 0) {

            while (case_troll == 1 || j2.nb_pierre == 0) {
                case_troll--;
            }
        } else if (j2.nb_pierre == 0) {
            while (case_troll == 7 || j1.nb_pierre == 0) {
                case_troll--;
            }
        }
        if (case_troll > 4) {
            return 1;
        }
        if (case_troll < 4) {
            return 2;
        }
        if (case_troll == 4) {
            return 0;
        }
        System.out.println("> " + case_troll + " - J1 : " + j1.nb_pierre + " - J2 : " + j2.nb_pierre);
        return -1;
    }
}
