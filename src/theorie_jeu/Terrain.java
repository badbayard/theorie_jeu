package theorie_jeu;

public class Terrain {
    private int nb_cases;
    private int position_troll;
    private int caseMax;
    private int caseMin;
    private int caseDepart;

    public Terrain(int case_terrain) {
        nb_cases = case_terrain;
        caseMax = nb_cases - 1;
        caseMin = 0;
        caseDepart = (nb_cases / 2);
    }

    public void init() {
        position_troll = caseDepart;
    }

    public void changePosition_troll(int x) {
        position_troll += x;
    }

    public int getPosition_troll() {
        return position_troll;
    }

    public int getCaseMax() {
        return caseMax;
    }

    public int getCaseMin() {
        return caseMin;
    }

}
