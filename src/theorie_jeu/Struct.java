package theorie_jeu;

public class Struct {

    public float[][][] GoptTable;

    public Struct() {

        GoptTable = new float [16][16][7];

        //On remplit le tableau n'importe comment
        for (int x = 0; x <= 15; x++) {
            for (int y = 0; y <= 15; y++) {
                for (int t = 0; t < 7; t++) {
                    GoptTable[x][y][t] = 1337.0f;
                }
            }
        }
    }

    public void init() {
        //LES CAS DE BASE
        // Si x = 0 est que le troll est entre 1 et 5 => -1
        for (int y = 0; y <= 15; y++){
            for (int t = 1; t <= 5; t++){
                GoptTable[0][y][t] = -1.0f;
            }
        }
        // Si y = 0 est que le troll est entre 1 et 5 => 1
        for (int x = 0; x <= 15; x++){
            for (int t = 1; t <= 5; t++){
                GoptTable[x][0][t] = 1.0f;
            }
        }
        // Si x = y et t = 3 => égalité 0
        for (int tmp = 0; tmp <= 15; tmp++) {
            GoptTable[tmp][tmp][3] = 0;
        }

        //Si le troll est sur une case chateau
        for(int x = 0; x <= 15; x++){
            for(int y = 0; y <= 15; y++) {
                GoptTable[x][y][6] = 1.0f;
                GoptTable[x][y][0] = -1.0f;
            }
        }

        GoptTable[0][0][0] = -1.0f;
        GoptTable[0][0][1] = -1.0f;
        GoptTable[0][0][2] = -1.0f;
        GoptTable[0][0][3] = 0.0f;
        GoptTable[0][0][4] = 1.0f;
        GoptTable[0][0][5] = 1.0f;
        GoptTable[0][0][6] = 1.0f;
    }

    public float calcul(int x, int y, int t) {

        float total = 0.0f;
        int cpt = 0;

        float valeur = GoptTable[x][y][t];

        if(valeur != 1337.0){
            //System.out.println("res   pour " + x + " " + y + " " + t + " : " + valeur);
            return valeur;
        } else {

            for (int u = 1; u <= x; u++){ //Tout les nb pierre a envoyé par J1
                for (int v = 1; v <= y; v++){
                    if(u == v){
                        total += calcul(x-u,y-v,t);
                        cpt++;
                    }
                    if(u > v){
                        if(u > y){
                            //Rien
                        }else{
                            total += calcul(x-u, y-v, t+1);
                            cpt++;
                        }
                    }
                    if(v > u){
                        if(v > x) {
                            //Rien
                        } else {
                            total += calcul(x-u, y-v, t-1);
                            cpt++;
                        }
                    }
                }
            }

            //System.out.println("Total pour " + x + " " + y + " " + t + " : " + total);
            //System.out.println("Cpt   pour " + x + " " + y + " " + t + " : " + cpt);
            float res;
            if(cpt > 0){
                res = total/cpt;
            } else {
                res = 1337.0f;
                System.out.println("clal pour " + x + " " + y + " " + t + " : " + res);
            }
            GoptTable[x][y][t] = res;
            //System.out.println("clal pour " + x + " " + y + " " + t + " : " + res);

            return res;
        }
    }

    public void printGopt() {
        int nontraite = 0;
        for (int x = 0; x <= 15; x++) {
            for (int y = 0; y <= 15; y++) {
                for (int t = 0; t < 7; t++) {
                    System.out.println(x + " " + y + " " + t);
                    System.out.println(GoptTable[x][y][t]);
                    if(GoptTable[x][y][t] == 1337.0f){
                        nontraite++;
                    }
                }
            }
        }
        System.out.println(nontraite);
    }
}
