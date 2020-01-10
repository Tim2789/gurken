import GLOOP.*;
import java.util.Random;
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
    private item[] items = new item[20];
    private GLQuader text = new GLQuader(120,120,-10, 10, 10, 10);
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
        this.setzeHindernissezerstörbar();
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

    public void setzeHindernissezerstörbar(){
        for(int i = 0; i != 15; i++){
            for(int k = 0; k != 15; k++){
                if(i+k != 0 && i+k != 1 && i+k != 28 && i+k != 27){
                    if(a[i][k].getContent() == null){
                        a[i][k].setContent(new Hindernis(true,-140 + i*20, -140 + k*20));
                    }
                }
            }
        }
    }

    public int[] findeSpieler(double spX, double spY){
        double pX = spX;
        double pY = spY;
        int feldX = 0; 
        int feldY = 0;
        for(feldX = 0; feldX != 14; feldX++){
            double[] edges = a[feldX][0].getEdges();
            if(pX > edges[0]-1 && pX < edges[1]+1){
                break;
            }
        }
        for(feldY = 0; feldY != 14; feldY++){
            double[] edges = a[0][feldY].getEdges();
            if(pY > edges[2]-1 && pY < edges[3]+1){
                break;
            }
        }
        int[] ret = {feldX, feldY};
        return ret;
    }
    
    public void findeitem(Spieler s1, Spieler s2)
    {   
        for(int i=0;i<items.length;i++){
            if(items[i]!=null){
            int[] posi =this.findeSpieler(items[i].getX(),items[i].getY());
            int[] posS1 =this.findeSpieler(s1.getX(),s1.getY());
            int[] posS2 =this.findeSpieler(s2.getX(),s2.getY());
            if(posi[0] == posS1[0] && posi[1] == posS1[1] )
            {
                s1.itemEffekt(items[i].beispielMethode());
                items[i].removeitem();
                items[i] = null;
            }
            
            if(posi[0] == posS2[0] && posi[1] == posS2[1] )
            {
                s2.itemEffekt(items[i].beispielMethode());
                items[i].removeitem();
                items[i] = null;
            }
        }
        }
    }


    public double getMax(int d, double pX, double pY){
        int[] posSpieler = findeSpieler(pX, pY);
        double ret = 0;
        //System.out.println("posAX: "+posSpieler[0] + "    posAY: "+ posSpieler[1]);
        switch(d){
            case 1: //up
            if(posSpieler[1] < 14){
                if(a[posSpieler[0]][posSpieler[1]+1].getContent() != null){
                    ret = a[posSpieler[0]][posSpieler[1]].getEdgeTop();
                    break;
                }
                ret = 145;
            }
            ret = 145;
            break;

            case 2: //down
            if(posSpieler[1] > 0){
                if(a[posSpieler[0]][posSpieler[1]-1].getContent() != null){
                    ret = a[posSpieler[0]][posSpieler[1]].getEdgeBottom();
                    break;
                }
                ret = -145;
            }
            ret = -145;
            break;

            case 3: //right
            if(posSpieler[0] > 0){
                if(a[posSpieler[0]-1][posSpieler[1]].getContent() != null){
                    ret = a[posSpieler[0]][posSpieler[1]].getEdgeRight();
                    break;
                }
                ret = -145;
            }
            ret = -145;
            break;

            case 4: //left
            if(posSpieler[0] < 14){
                if(a[posSpieler[0]+1][posSpieler[1]].getContent() != null){
                    ret = a[posSpieler[0]][posSpieler[1]].getEdgeLeft();
                    break;
                }
                ret = 145;
            }
            ret = 145;
            break;
        }
        return ret;
    }
    
    public void testExplosion(Spieler s1, Spieler s2){
        Explosion[] explo1 = s1.getExplo();
        Explosion[] explo2 = s2.getExplo();
        for(int i = 0; i != 3; i++){
            GLObjekt[] kugeln = explo1[i].getExplo();
            for(int k = 0; k != 5; k++){
                int[] pos = this.findeSpieler(kugeln[k].gibX(), kugeln[k].gibY());
                if(a[pos[0]][pos[1]].getContent() != null){
                    explo1[i].setinteragiertfalse(k);
                    if(a[pos[0]][pos[1]].getContent().destroyable() == true){
                        if(a[pos[0]][pos[1]].getContent().getgay()!= true){
                            spawnItem(a[pos[0]][pos[1]].getContent().gibX(),a[pos[0]][pos[1]].getContent().gibY());
                        }    
                        a[pos[0]][pos[1]].getContent().loesche();
                        a[pos[0]][pos[1]].setContent(null);
                    }
                }
                int[] posS = this.findeSpieler(s1.getX(), s1.getY());
                if(posS[0] == pos[0] && posS[1] == pos[1]){
                    s1.setAlive(false);
                }
                posS = this.findeSpieler(s2.getX(), s2.getY());
                if(posS[0] == pos[0] && posS[1] == pos[1]){
                    s2.setAlive(false);
                }
            }
        }
        
        for(int i = 0; i != 3; i++){
            GLObjekt[] kugeln = explo2[i].getExplo();
            for(int k = 0; k != 5; k++){
                int[] pos = this.findeSpieler(kugeln[k].gibX(), kugeln[k].gibY());
                if(a[pos[0]][pos[1]].getContent() != null){
                    explo2[i].setinteragiertfalse(k);
                    if(a[pos[0]][pos[1]].getContent().destroyable() == true){
                        if(a[pos[0]][pos[1]].getContent().getgay()!= true){
                            spawnItem(a[pos[0]][pos[1]].getContent().gibX(),a[pos[0]][pos[1]].getContent().gibY());
                            }
                        a[pos[0]][pos[1]].getContent().loesche();
                        a[pos[0]][pos[1]].setContent(null);
                    }
                }
                int[] posS = this.findeSpieler(s1.getX(), s1.getY());
                if(posS[0] == pos[0] && posS[1] == pos[1]){
                    s1.setAlive(false);
                }
                posS = this.findeSpieler(s2.getX(), s2.getY());
                if(posS[0] == pos[0] && posS[1] == pos[1]){
                    s2.setAlive(false);
                }
            }
        }
    }
    
    public void spawnItem(int x, int y){
        Random rand = new Random();
        int n = rand.nextInt(4);
        n++;
        int m = rand.nextInt(100);
        m++;
        if(m<21){
            for(int i = 0; i != 20; i++){
                if(items[i] == null){
                    switch(n){
                        case 1: items[i] = new Speedup(x,y);  break;
                        case 2: items[i] = new Rangeup(x,y); break;
                        case 3: items[i] = new bombup(x,y); break;
                        case 4: items[i] = new Armorup(x,y); break;
                    }
                    break;
                }
            }
        }
    }
    public void setzeBombein(int x, int y){
        int[] bomb = this.findeSpieler(x ,y);
        a[bomb[0]][bomb[1]].setContent(new Hindernis(true, x, y,true)); 
        a[bomb[0]][bomb[1]].getContent().loesche();
    }
    
    public void loescheB(Bombe b){
        int[] bomb = this.findeSpieler(b.getX(), b.getY());
        a[bomb[0]][bomb[1]].setContent(null);

    }
}
