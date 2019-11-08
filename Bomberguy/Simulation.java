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
    private GLTastatur tastatur;

    public Simulation()
    {
        spieler1 = new Spieler(-140, -140);
        feld = new Spielfeld();
        tastatur = new GLTastatur();
        this.sim();
    }

    public void sim(){
        while(tastatur.alt() != true){
            if(spieler1.getY() <= 145 && spieler1.getY() >= -145){
                if(spieler1.getX() <= 145 && spieler1.getX() >= -145){
                    if(tastatur.links()){
                        spieler1.movX(1);
                    }
                    if(tastatur.rechts()){
                        spieler1.movX(-1);
                    }
                    if(tastatur.oben()){
                        spieler1.movY(1);
                    }
                    if(tastatur.unten()){
                        spieler1.movY(-1);
                    }
                }
                else{
                    if(spieler1.getX() <= 145){
                        spieler1.movX(1);
                    }
                    else{
                        spieler1.movX(-1);
                    }
                }
            }
            else{
                    if(spieler1.getY() <= 145){
                        spieler1.movY(1);
                    }
                    else{
                        spieler1.movY(-1);
                    }
                }
            try {
                Thread.sleep(25);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
