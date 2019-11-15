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
        feld.loescheSpawn(spieler1);
        tastatur = new GLTastatur();
        List<Hindernis> hindernisse = feld.gibHindernisse();
        hindernisse.toFirst();
        this.sim();
    }

    public void sim(){
        while(tastatur.alt() != true){
            if(this.tstUpDown(spieler1)){
                System.out.println("Spieler X: " + spieler1.getX() + "      Y: " +spieler1.getY());
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
            }
            feld.findNext(spieler1.getX(), spieler1.getY());
           if(this.tstLeftRight(spieler1)){
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
            }
            if(tastatur.strg()){
            spieler1.setzebombe();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean tstUpDown(Spieler spi){
        boolean ret;
        double sp = spi.getY();
        if(sp<0){
            sp = sp*(-1);
        }
        int k = 0;
        for(int i = 0; i*20<sp+10;i++){k = i;}
        k = k%2;
        if(k==0){ret = false;}
        else{ret = true;}
        return ret;
    }

    public boolean tstLeftRight(Spieler spi){
        boolean ret;
        double sp = spi.getX();
        if(sp<0){
            sp = sp*(-1);
        }
        int k = 0;
        for(int i = 0; i*20<sp+10;i++){k = i;} 
        k = k%2;
        if(k==0){ret = false;}
        else{ret = true;}
        return ret;
    }
}
