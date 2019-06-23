package theorie_jeu.Strategies;

public abstract class Strategie {
    protected int numero;
    protected int nbPierre;
    protected int nbPierreDepart;
    protected int nbPierreAdv;

    public Strategie(int numero_joueur, int nombre_pierre) {
        numero = numero_joueur;
        nbPierreDepart = nombre_pierre;
    }

    public abstract int lancer(int nbPierreAdv, int positionTroll);

    public int getNbPierre() {
        return nbPierre;
    }

    public void init() {
        nbPierre = nbPierreDepart;
    }
}
