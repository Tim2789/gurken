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
        spieler = new GLObjekt[8];
        spieler[0] = new GLKugel(x,y,-8, 8,"weis.jpg" );
        spieler[1] = new GLKugel(x,y,-21, 6,"weis.jpg" );
        spieler[2] = new GLKugel(x,y,-29, 3,"weis.jpg" );
        spieler[3] = new GLKugel(x-2,y+2,-29, 1,"schwarz.jpg" );
        spieler[4] = new GLKugel(x+2,y+2,-29, 1,"schwarz.jpg" );
        spieler[5] = new GLZylinder(x,y,-35,3,5,"grun.jpg");
        spieler[6] = new GLZylinder(x,y,-32,5,1,"grun.jpg");
    }
    
    public void movUp(){
        spieler[0].verschiebe(5,0,0);
    }
    
    public void movDown(){
        spieler[0].verschiebe(-5,0,0);
    }
    
    public void movLeft(){
        spieler[0].verschiebe(0,-5,0);
    }
    
    public void movRight(){
        spieler[0].verschiebe(0,5,0);
    }
    
    public double getX(){
        return spieler[0].gibX();
    }
    
    public double getY(){
        return spieler[0].gibY();
    }
}
