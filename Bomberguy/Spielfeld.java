import GLOOP.*;
/**
 * Write a description of class Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Spielfeld
{
    private GLQuader feld;
    private GLLicht licht;
    private GLEntwicklerkamera kamera;
    private List l;
    Spielfeld()
    {
        feld = new GLQuader(0,0,0,15*20,15*20,2);
        feld.setzeTextur("cobble.jpg");
        licht = new GLLicht(0,0,-230);
        kamera = new GLEntwicklerkamera();
        kamera.setzePosition(0,0,-300);
        l = new List<Hindernis>();
        this.setzeHindernisse();
    }
    
    public void setzeHindernisse(){
        for(int i = 0; i != 7; i++){
            for(int k = 0; k != 7; k++){
                Hindernis h = new Hindernis(false, (-120+(k*40)), (-120+(i*40)));
                l.append(h);
            }
        }
    }
    
    public List<Hindernis> gibHindernisse(){
        return l;
    }
}
