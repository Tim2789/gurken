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
    private Spieler spieler1, spieler2;
    private GLTastatur tastatur;
    private List<Hindernis> hindernisse;
    private item[] items = new item[20];

    public Simulation()
    {
        spieler1 = new Spieler("grun.jpg",-140, -140);
        spieler2 = new Spieler("rot.jpg",140, 140);
        feld = new Spielfeld();
        tastatur = new GLTastatur();
        this.sim();
    }

    public void itemvergleich(){
        spieler1.aufitem(items);  
        spieler2.aufitem(items);
    }

    public void sim(){
        while(tastatur.alt() != true){
            double spX = spieler1.getX();
            double spY = spieler1.getY();
            double sp2X = spieler2.getX();
            double sp2Y = spieler2.getY();
            int[] arraypos = feld.findeSpieler(spieler1.getX(), spieler1.getY());
            System.out.println("ArrayPosX: "+arraypos[0] + "    ArrayPosY: "+arraypos[1]);
            System.out.println("Spieler X: " + spieler1.getX() + "      Y: " +spieler1.getY());
            //-----------------------------Spieler1--------------------------------------------------------
            if(tastatur.links()){
                if(feld.getMax(4, spX, spY)-4 > spX){
                    spieler1.movX(1);
                }
            }
            if(tastatur.rechts()){
                if(feld.getMax(3, spX, spY)+4 < spX){
                    spieler1.movX(-1);
                }
            }
            if(tastatur.oben()){
                if(feld.getMax(1, spX, spY)-4 > spY){
                    spieler1.movY(1);
                }
            }
            if(tastatur.unten()){
                if(feld.getMax(2, spX, spY)+4 < spY){
                    spieler1.movY(-1);
                }
            }
            if(tastatur.strg()){
                spieler1.setzebombe();
            }
            
            
            //-----------------------------Spieler2--------------------------------------------------------
            
            
            if(tastatur.istGedrueckt('a')){
                if(feld.getMax(4, sp2X, sp2Y)-4 > sp2X){
                    spieler2.movX(1);
                }
            }
            if(tastatur.istGedrueckt('d')){
                if(feld.getMax(3, sp2X, sp2Y)+4 < sp2X){
                    spieler2.movX(-1);
                }
            }
            if(tastatur.istGedrueckt('w')){
                if(feld.getMax(1, sp2X, sp2Y)-4 > sp2Y){
                    spieler2.movY(1);
                }
            }
            if(tastatur.istGedrueckt('s')){
                if(feld.getMax(2, sp2X, sp2Y)+4 < sp2Y){
                    spieler2.movY(-1);
                }
            }
            if(tastatur.istGedrueckt('e')){
                spieler2.setzebombe();
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
}
