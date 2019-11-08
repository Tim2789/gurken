import GLOOP.*;
/**
 * Write a description of class Spieler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spieler
{
    private GLKegel spieler;
    public Spieler(int x, int y)
    {
        spieler = new GLKegel(x,y,0, 20, 20);
        spieler.setzeTextur("grun.jpg");
    }
    
    public void movUp(){
        spieler.verschiebe(5,0,0);
    }
    
    public void movDown(){
        spieler.verschiebe(-5,0,0);
    }
    
    public void movLeft(){
        spieler.verschiebe(0,-5,0);
    }
    
    public void movRight(){
        spieler.verschiebe(0,5,0);
    }
    
    public double getX(){
        return spieler.gibX();
    }
    
    public double getY(){
        return spieler.gibY();
    }
}
