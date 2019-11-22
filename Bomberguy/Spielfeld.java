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
    private GLKamera kamera;
    private List<Hindernis> l, lZ;
    private GLHimmel h;
    private ArrayFeld[][] a;
    Spielfeld()
    {
        feld = new GLQuader(0,0,0,15*20,15*20,2);
        feld.setzeTextur("cobble.jpg");
        h = new GLHimmel("himmel.jpg");
        licht = new GLLicht(0,0,-230);
        kamera = new GLKamera();
        kamera.setzePosition(0,0,-300);
        a = new ArrayFeld[15][15];
        l = new List<Hindernis>();
        lZ = new List<Hindernis>();
        this.setzeHindernisse();
        //this.setzeHindernisseZ();
    }

    public void setzeHindernisse(){
        for(int i = 0; i != 15; i++){
            for(int k = 0; k != 15; k++){
                a[i][k] = new ArrayFeld(-140 + i*20, -140 + k*20);
                if(k % 2 == 1 && i % 2 == 1){
                    a[i][k].setContent(new Hindernis(false,-140 + i*20,-140 + k*20));
                }
            }
        }
    }
    
    public int[] findeSpieler(double pX, double pY){
        int feldX = 0; 
        int feldY = 0;
        for(feldX = 0; feldX != 15; feldX++){
            double[] edges = a[feldX][0].getEdges();
            if(pX > edges[0] && pX < edges[1]){
                break;
            }
        }
        for(feldY = 0; feldY != 15; feldY++){
            double[] edges = a[0][feldY].getEdges();
            if(pY > edges[2] && pY < edges[3]){
                break;
            }
        }
        int[] ret = {feldX, feldY};
        return ret;
    }
    
    public double getMax(int d, double pX, double pY){
        int[] posSpieler = findeSpieler(pX, pY);
        double ret = 0;
        
        switch(d){
            case 1: //up
            if(posSpieler[1] > 0 && posSpieler[1] < 13)
                if(a[posSpieler[0]][posSpieler[1]+1].getContent() != null){
                    double[] edges = a[posSpieler[0]][posSpieler[1]+1].getEdges();
                    ret = edges[2];
                }
                else ret = 145;
                else ret = 145;
                break;
            case 2: //down
            if(posSpieler[1] > 0 && posSpieler[1] < 13)
                if(a[posSpieler[0]][posSpieler[1]-1].getContent() != null){
                    double[] edges = a[posSpieler[0]][posSpieler[1]-1].getEdges();
                    ret = edges[3];
                }
                else ret = -145;
                else ret = -145;
            case 3: //right
            if(posSpieler[0] > 0 && posSpieler[0] < 13)
                if(a[posSpieler[0]-1][posSpieler[1]].getContent() != null){
                    double[] edges = a[posSpieler[0]-1][posSpieler[1]].getEdges();
                    ret = edges[1];
                }
                else ret = -145;
                else ret = -145;
            case 4:
            if(posSpieler[0] != 0 && posSpieler[0] != 13)
                if(a[posSpieler[0]+1][posSpieler[1]].getContent() != null){
                    double[] edges = a[posSpieler[0]+1][posSpieler[1]].getEdges();
                    ret = edges[0];
                }
                else ret = 145;
                else ret = 145;
        }
        return ret;
    }
}
