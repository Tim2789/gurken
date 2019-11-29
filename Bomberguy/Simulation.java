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
    private item[] items = new item[20];
    private GLMaus maus;
    private Sys s;
    private boolean online, host;
    private BomberServer bs;
    private BomberClient bc;
    public Simulation()
    {
        feld = new Spielfeld();
        tastatur = new GLTastatur();
        maus = new GLMaus();
        s = new Sys();
        this.menu();
        //this.sim();
    }

    public void itemvergleich(){
        spieler1.aufitem(items);  
        spieler2.aufitem(items);
    }

    public void sim(){
        if(spieler1 == spieler2){
            spieler1 = new Spieler("grun.jpg",-140, -140);
            spieler2 = new Spieler("rot.jpg",140, 140);
        }
        while(tastatur.esc() != true){
            double spX = spieler1.getX();
            double spY = spieler1.getY();
            double sp2X = spieler2.getX();
            double sp2Y = spieler2.getY();
            int[] arraypos = feld.findeSpieler(spieler1.getX(), spieler1.getY());
            //-----------------------------Spieler1--------------------------------------------------------
            int bew1 = this.spieler1Bewegung();
            if(bew1 == 3){
                if(feld.getMax(4, spX, spY)-4 > spX){
                    spieler1.movX(1);
                }
            }
            if(bew1 == 4){
                if(feld.getMax(3, spX, spY)+4 < spX){
                    spieler1.movX(-1);
                }
            }
            if(bew1 == 1){
                if(feld.getMax(1, spX, spY)-4 > spY){
                    spieler1.movY(1);
                }
            }
            if(bew1 == 2){
                if(feld.getMax(2, spX, spY)+4 < spY){
                    spieler1.movY(-1);
                }
            }
            if(bew1 == 5){
                spieler1.setzebombe();
            }

            //-----------------------------Spieler2--------------------------------------------------------
            int bew2 = this.spieler2Bewegung();
            if(bew2 == 3){
                if(feld.getMax(4, sp2X, sp2Y)-4 > sp2X){
                    spieler2.movX(1);
                }
            }
            if(bew2 == 4){
                if(feld.getMax(3, sp2X, sp2Y)+4 < sp2X){
                    spieler2.movX(-1);
                }
            }
            if(bew2 == 1){
                if(feld.getMax(1, sp2X, sp2Y)-4 > sp2Y){
                    spieler2.movY(1);
                }
            }
            if(bew2 == 2){
                if(feld.getMax(2, sp2X, sp2Y)+4 < sp2Y){
                    spieler2.movY(-1);
                }
            }
            if(bew2 == 5){
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
            spieler2.entferneb();
            
        }
    }

    public int spieler1Bewegung(){
        int ret = 0;
        if(tastatur.links()){
            ret = 3;
        }
        if(tastatur.rechts()){
            ret = 4;
        }
        if(tastatur.oben()){
            ret = 1;
        }
        if(tastatur.unten()){
            ret = 2;
        }
        if(tastatur.strg()){
            ret = 5;
        }
        if(online == true){
            bc.send(""+ret);
        }
        return ret;
    }

    public int spieler2Bewegung(){
        int ret = 0;
        if(online == false){
            if(tastatur.istGedrueckt('a')){
                ret = 3;
            }
            if(tastatur.istGedrueckt('d')){
                ret = 4;
            }
            if(tastatur.istGedrueckt('w')){
                ret = 1;
            }
            if(tastatur.istGedrueckt('s')){
                ret = 2;
            }
            if(tastatur.istGedrueckt('e')){
                ret = 5;
            }
        }else{ret = bc.getMessage();}
        return ret;
    }

    public void menu(){
        GLQuader menus = new GLQuader(0,0,-50,15*20,15*20,2,"logo.jpg");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        menus.setzeTextur("Menu.jpg");
        while(tastatur.esc() != true){
            int mausX = maus.gibX();
            int mausY = maus.gibY();
            if(maus.gedruecktLinks() == true){
                if(mausX < 1190 && mausX > 760 && mausY < 500 && mausY > 350){
                    menus.loesche();
                    online = false;
                    this.sim();
                }else if(mausX < 1190 && mausX > 730 && mausY < 720 && mausY > 590){
                    menus.loesche();
                    online = true;
                    this.multiplayerAbfrage();
                }
            }
        }
    }

    public void multiplayerAbfrage(){
        GLQuader menus = new GLQuader(0,0,-50,15*20,15*20,2,"ipAbfrage.jpg");
        GLTafel t = new GLTafel(0,-70,-51, 70, 30);
        t.setzeAutodrehung(true);
        boolean host = false;
        String ip = "";
        while(tastatur.enter() != true){
            int mausX = maus.gibX();
            int mausY = maus.gibY();
            System.out.println("mausX: "+mausX+"    mausY:" +mausY);
            //------------------------IP---------------------------------------
            if(maus.gedruecktLinks() == true){
                if(mausX > 540 && mausX < 630 && mausY > 300 && mausY < 430){
                    ip = ip + "0";
                }else if(mausX > 660 && mausX < 760 && mausY > 300 && mausY < 430){
                    ip = ip + "1";
                }else if(mausX > 785 && mausX < 885 && mausY > 300 && mausY < 430){
                    ip = ip + "2";
                }else if(mausX > 920 && mausX < 1010 && mausY > 300 && mausY < 430){
                    ip = ip + "3";
                }else if(mausX > 1035 && mausX < 1140 && mausY > 300 && mausY < 430){
                    ip = ip + "4";
                }else if(mausX > 540 && mausX < 630 && mausY > 480 && mausY < 615){
                    ip = ip + "5";
                }else if(mausX > 660 && mausX < 760 && mausY > 480 && mausY < 615){
                    ip = ip + "6";
                }else if(mausX > 785 && mausX < 885 && mausY > 480 && mausY < 615){
                    ip = ip + "7";
                }else if(mausX > 920 && mausX < 1010 && mausY > 480 && mausY < 615){
                    ip = ip + "8";
                }else if(mausX > 1035 && mausX < 1140 && mausY > 480 && mausY < 615){
                    ip = ip + "9";
                }else if(mausX > 1200 && mausX < 1255 && mausY > 560 && mausY < 615){
                    ip = ip + ".";
                }else if(mausX > 1340 && mausX < 1400 && mausY > 890 && mausY < 950){
                    if(host == false){
                        host = true;
                        menus.setzeTextur("ipAbfrageHost.jpg");
                    }
                    else{
                        host = false;
                        menus.setzeTextur("ipAbfrage.jpg");
                    }
                }
                if(ip.length()>0){
                    if(mausX > 1250 && mausX < 1425 && mausY > 320 && mausY < 450){
                        ip = ip.substring(0,ip.length()-1);
                    }
                }
                t.setzeText(ip, 20);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        menus.loesche();
        t.loesche();
        if(host == true){
            bs = new BomberServer();
            spieler1 = new Spieler("grun.jpg",-140, -140);
            spieler2 = new Spieler("rot.jpg",140, 140);
        }
        else{
            spieler1 = new Spieler("rot.jpg",140, 140);
            spieler2 = new Spieler("grun.jpg",-140, -140);
        }
        bc = new BomberClient(ip);
        this.sim();
    }
}
