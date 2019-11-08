import GLOOP.*;
/**
 * Write a description of class Simulation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulation
{
    private Spielfeld feld;
    private Spieler spieler1;
    
    public Simulation()
    {
        feld = new Spielfeld();
        spieler1 = new Spieler(-140, -140);
    }
}
