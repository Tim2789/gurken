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
    Spielfeld()
    {
        feld = new GLQuader(0,0,0,15*20,15*20,2);
        feld.setzeTextur("cobble.jpg");
        h = new GLHimmel("himmel.jpg");
        licht = new GLLicht(0,0,-230);
        kamera = new GLKamera();
        kamera.setzePosition(0,0,-300);
        l = new List<Hindernis>();
        lZ = new List<Hindernis>();
        this.setzeHindernisse();
        //this.setzeHindernisseZ();
    }

    public void setzeHindernisse(){
        for(int i = 0; i != 7; i++){
            for(int k = 0; k != 7; k++){
                Hindernis h = new Hindernis(false, (-120+(k*40)), (-120+(i*40)));
                l.append(h);
            }
        }
    }

    public void setzeHindernisseZ(){
        for(int i = 0; i != 15; i++){
            for(int k = 0; k != 15; k++){
                Hindernis h = new Hindernis(true, (-140+(k*20)), (-140+(i*20)));
                lZ.append(h);
            }
        }
    }

    public List<Hindernis> gibHindernisse(){
        return l;
    }

    public List<Hindernis> gibHindernisseZ(){
        return lZ;
    }

    public void loescheSpawn(Spieler spi){
        lZ.toFirst();
        double spX = spi.getX();
        double spY = spi.getY();
        Hindernis h = null;
        while(lZ.hasAccess()){
            h = lZ.getContent();
            if(h.gibX() == spX && h.gibY() == spY){h.loesche();}
            else if(h.gibX() + 20 == spX && h.gibY() +20 == spY){h.loesche();}
            else if(h.gibX() - 20 == spX && h.gibY() -20 == spY){h.loesche();}
            else if(h.gibX() + 20 == spX && h.gibY() -20 == spY){h.loesche();}
            else if(h.gibX() - 20 == spX && h.gibY() +20 == spY){h.loesche();}

        }
    }
    public Hindernis returnH(int nummer){
        l.toFirst();
        for(int i = 1; i<nummer; i++){l.next();}
        return l.getContent();
    }
    
    public String findNext(double pX, double pY){
        l.toFirst();
        String ret = null;
        
        int i = 1;
        while(l.hasAccess()){
            switch(l.getContent().getDistance(pX, pY)){
                case 1: /*System.out.println(i+". Objekt: 1, d.h. rechts u links blockiert.");*/ ret = ret+"1,"+ this.getDouble(1,l.getContent()); break;//System.out.print("   spX: " + pX+" spY: "+pY);break;
                case 2: /*System.out.println(i+".Objekt : 2, d.h. oben u unten blockiert.");*/ ret = ret+"2,"+ this.getDouble(2,l.getContent()); break;
                case 0: ret = "0"; break;
                default: System.out.println(404); ret = ret +"0"; break;
            }
            l.next();
            i++;
        }
        return ret;
    }
    
    public String getDouble(int i, Hindernis h){
        String ret = null;
        if(i == 1){
            ret = Integer.toString((int)h.gibX()+15);
            ret = ret + ","+Integer.toString((int)h.gibX()+25);
        }else if(i == 2){
            ret = Integer.toString((int)h.gibY()+15);
            ret = ret + ","+Integer.toString((int)h.gibX()+25);
        }
        return ret;
    }
}
