import GLOOP.*;
/**
 * Write a description of class Spieler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spieler
{
    private GLObjekt[] spieler ;
    public Spieler(int x, int y)
    {
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
        spieler = new GLObjekt[8];
        spieler[0] = new GLKugel(x,y,-8, 8,"weis.jpg" );
        spieler[1] = new GLKugel(x,y,-21, 6,"weis.jpg" );
        spieler[2] = new GLKugel(x,y,-29, 3,"weis.jpg" );
        spieler[3] = new GLKugel(x-2,y+2,-29, 1,"schwarz.jpg" );
        spieler[4] = new GLKugel(x+2,y+2,-29, 1,"schwarz.jpg" );
        spieler[5] = new GLZylinder(x,y,-35,3,5,"grun.jpg");
        spieler[6] = new GLZylinder(x,y,-32,5,1,"grun.jpg");
    }

    public void movX(int x){
        for(int i = 0; i<7; i++){
            spieler[i].verschiebe(x,0,0);
        }
    }

    public void movY(int y){
        for(int i = 0; i<7; i++){
            spieler[i].verschiebe(0,y,0);

        }
    }

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public double getX(){
        return spieler[0].gibX();
    }

    public double getY(){
        return spieler[0].gibY();
    }
}
