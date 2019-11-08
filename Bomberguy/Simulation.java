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
    private List<Hindernis> hindernisse;


    public Simulation()
    {
        spieler1 = new Spieler(-140, -140);
        feld = new Spielfeld();
        tastatur = new GLTastatur();
        List<Hindernis> hindernisse = feld.gibHindernisse();
        hindernisse.toFirst();
        this.sim();
    }

    public void sim(){
        while(tastatur.alt() != true){
            System.out.println(hindernisse.getContent().getDistanceY(spieler1));
            if(spieler1.getX()<=145){
                if(tastatur.links()){
                    spieler1.movX(1);
                }
            }
            if(spieler1.getX()>=-145){
                if(tastatur.rechts()){
                    spieler1.movX(-1);
                }
            }
            if(spieler1.getY()<=145){
                if(tastatur.oben()){
                    spieler1.movY(1);
                }
            }
            if(spieler1.getY()>=-145){
                if(tastatur.unten()){
                    spieler1.movY(-1);
                }
            }
            /*if(tastatur.strg()){
                spieler.setzebombe();
            }*/
            try {
                Thread.sleep(25);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /*public boolean tstUpDown(){
        double sp = spieler1.getY();
        double lowEnd = -140;
        int k = 0;
        while(lowEnd < sp){
            
        }
    }
    
    public boolean tstDown(){}
    
    public boolean tstLeft(){}
    
    public boolean tstRight(){}*/
}
