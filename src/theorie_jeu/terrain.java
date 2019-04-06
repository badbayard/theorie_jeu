package theorie_jeu;

public class terrain {
    int nb_cases;
    int position_troll;
    
    public terrain(int case_terrain, int position) {
        nb_cases = case_terrain;
        position_troll = position;
    }
    
    public void set_nb_cases(int nbcase) {
        nb_cases = nbcase;
    }
    
    public void set_position_troll(int position_c) {
        position_troll = position_troll + (position_c);
    }
    
    public void position_troll_init(int position) {
        position_troll = position;
    }
    
    public int get_nb_cases() {
        return nb_cases;
    }
    
    public int get_position_troll() {
        return position_troll;
    }
    
}
