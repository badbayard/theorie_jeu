#include <iostream>
#include <vector>
#include <stdlib.h>
#include <cstdlib>

using namespace std;

class joueur{
    private:
        int nb_joueur;
        int nb_pierre;
        

    public:
        bool fin =false;
        joueur(int nombre , int nombre_pierre){
            nb_joueur = nombre;
            nb_pierre = nombre_pierre;
            // fin = false;
        }

        void set_fin(){
            fin = true;
        }

        void set_nb_joueur(int chiffre){
            nb_joueur = chiffre;
        }

        void set_nb_pierre(int other_chiffre){
            nb_pierre = other_chiffre;
        }

        int get_nb_joueur(){
            return nb_joueur;
        }

        int get_nb_pierre(){
            return nb_pierre;
        }

        bool get_fin(){
            return fin;
        }

       int lancer(int nombre_pierre){
           if(nombre_pierre <= nb_pierre){
               nb_pierre = nb_pierre - nombre_pierre;
               return nombre_pierre;
           }else
           {
               return 0;
           }   
       }

       int lancer_alea(){
           int p = rand()%3;

           if (p < nb_pierre){
               nb_pierre = nb_pierre - p;
               return p;
           }
       }
};

class terrain{
    public:
        int nbCase;
        int position_trol;

        terrain(int case_terrain, int position){
            nbCase = case_terrain;
            position_trol = position;
        }

        void set_nb_cases(int nb_case){
            nbCase = nb_case;
        }

        void set_position_troll(int position_c){
            position_trol =position_trol + (position_c);
        }

        void position_troll_init(int position){
            position_trol = position;
        }

        int get_nb_cases(){
            return nbCase;
        }

        int get_position_trol(){
            return position_trol;
        }
        
};

void test_fin(joueur j1, joueur j2,terrain t1){
     if (j2.get_nb_pierre()==0 || t1.get_position_trol() == 7){
         cout << "j1 gagne"<<endl;
         j1.set_fin();
     }
     if (j1.get_nb_pierre() == 0 || t1.get_position_trol() == 0){
         cout <<"j2 gagne"<<endl;
         j2.set_fin();
     }
}

int main (void){
    joueur j1(1,15);
    joueur j2(2,15);
    terrain t1(7,4);
    int pierre_j1 = 0;
    int pierre_j2 = 0;
    int a = 0;
    int b = 0;
    bool f = false;


    do{
        // pierre_j1 = j1.lancer_alea();
        // pierre_j2 = j2.lancer_alea();
        cout <<"nombre de pierre pour j1"<<endl;
        cin >> a;
        pierre_j1 = j1.lancer(a);
        cout <<" nombre de pierre pour j2"<<endl;
        cin >> b;
        pierre_j2 = j2.lancer(b);

        if (pierre_j1 > pierre_j2){
            t1.set_position_troll(1);
        }else if(pierre_j2 < pierre_j1){
            t1.set_position_troll(-1);           
        }
        
        cout <<"la position du trol est : " <<t1.get_position_trol()<<endl;
        cout <<"nombre de pierre j1 est : "<< j1.get_nb_pierre()<<endl;
        cout <<"nombre de pierre j2 est : "<< j2.get_nb_pierre()<<endl;
        // test_fin(j1,j2,t1);

        if (j2.get_nb_pierre()==0 || t1.get_position_trol() == 7){
            cout << "j1 gagne"<<endl;
            // j1.set_fin();
            j1.fin = true;
            break;
        }
        if (j1.get_nb_pierre() == 0 || t1.get_position_trol() == 0){
            cout <<"j2 gagne"<<endl;
            // j2.set_fin();
            j2.fin = true;
            break;
        }

    }while(j1.fin == false || j2.fin == false);
    
}