import GLOOP.*;
/**
 * Write a description of class Spieler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spieler
{
    private GLObjekt[] spieler ;
    private int bombemax = 1;
    private int bomben = 0 ;
    public Spieler(int x, int y)
    {
        
        spieler = new GLObjekt[9];

        spieler[0] = new GLKugel(x,y,-8, 8,"weis.jpg" );
        spieler[1] = new GLKugel(x,y,-21, 6,"weis.jpg" );
        spieler[2] = new GLKugel(x,y,-29, 3,"weis.jpg" );
        spieler[3] = new GLKugel(x-2,y+2,-29, 1,"schwarz.jpg" );
        spieler[4] = new GLKugel(x+2,y+2,-29, 1,"schwarz.jpg" );
        spieler[5] = new GLZylinder(x,y,-35,3,5,"grun.jpg");
        spieler[6] = new GLZylinder(x,y,-32,5,1,"grun.jpg");

        spieler[7] = new GLKegel(x,y+3,-28,1,3, "orange.jpg");
        spieler[7].setzeDrehung(90,0,0);
    }
       
    public void setzebombe(){
        if(bomben!=bombemax){
        new Bombe( (int)spieler[0].gibX() ,(int)spieler[0].gibY());
    }
    }
    public void movX(int x){

        for(int i = 0; i<7; i++){
            spieler[i].verschiebe(x,0,0);
        }
    }

    public void movY(int y){

        for(int i = 0; i<7; i++){
            spieler[i].verschiebe(0,y,0);
        }
    }

    public double getX(){
        return spieler[0].gibX();
    }

    public double getY(){
        return spieler[0].gibY();
    }
    
    public double getbomben(){
        return (bomben) ;
    }
    
    public double getbombemax(){
        return bombemax ;
    }
    
    public void erhoehebomben(){
        bomben++;
    }
    
    public void erhoehebombemax(){
        bombemax++;
    }
}
