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
        spieler = new GLKegel(x,y,-10, 10, 10);
        spieler.setzeTextur("grun.jpg");
    }
    
    public void movX(int x){
        spieler.verschiebe(x,0,0);
    }
    
    public void movY(int y){
        spieler.verschiebe(0,y,0);
    }
    
    public double getX(){
        return spieler.gibX();
    }
    
    public double getY(){
        return spieler.gibY();
    }
}
