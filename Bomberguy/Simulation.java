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
    private item[] = new item[20];
    
    public void itemvergleich(){
        for(int i=0; i<21;i++){
        spieler1.aufitem(item[i]);
        
        }
    }
    
    public Simulation()
    {
        spieler1 = new Spieler(-140, -140);
        feld = new Spielfeld();
        tastatur = new GLTastatur();
        this.sim();
    }
    
    public void sim(){
        while(tastatur.alt() != true){

            double spX = spieler1.getX();
            double spY = spieler1.getY();
            //if(this.tstUpDown(spieler1)){
            int[] arraypos = feld.findeSpieler(spieler1.getX(), spieler1.getY());
            System.out.println("ArrayPosX: "+arraypos[0] + "    ArrayPosY: "+arraypos[1]);
            System.out.println("Spieler X: " + spieler1.getX() + "      Y: " +spieler1.getY());
        
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

            if(tastatur.strg()){
                spieler1.setzebombe();
            }
            if(tastatur.enter()){
            
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
           spieler1.entferneb();
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
