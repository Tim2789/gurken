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
    private int bombemax = 10;
    private int bomben = 0 ;
    private Bombe[] bombs = new Bombe[10];
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
        if(bomben <bombemax ){
            if(bomben==0){
            bombs[bomben] = new Bombe( (int)spieler[0].gibX() ,(int)spieler[0].gibY());
            erhoehebomben();
           }
        else if(setzbar()){
                   
        }else{
         bombs[bomben] = new Bombe( (int)spieler[0].gibX() ,(int)spieler[0].gibY());
         erhoehebomben();
        }
    }
    }
    
    public boolean setzbar(){
        int i = bomben;
        for(i = bomben; i>0;i--){
        if( (int)bombs[i-1].getX() == bombs[i-1].position((int)spieler[0].gibX()) &&
                  (int)bombs[i-1].getY() == bombs[i-1].position((int)spieler[0].gibY())){
                      return true;
                }
        }
        return false;
    }
    
    public void movX(int x){

        for(int i = 0; i<8; i++){
            spieler[i].verschiebe(x,0,0);
        }
    }

    public void movY(int y){
        
        for(int i = 0; i<8; i++){
            spieler[i].verschiebe(0,y,0);
        }
    }

    public void entferneb(){
        int i=0;
        while(i < bomben){
           
        if ((System.currentTimeMillis() - bombs[i].getalter()) >=3000){
        bombs[i].loescheb();
        bombs[i]= null ;
            for(int j =i; j<bomben; j++){
            bombs[j]=bombs[j+1];
            }
            if (bomben==bombemax){
            bombs[bomben]= null;
            }
        senkebomben();
        }
        else{i++;}
        }
    }
    
    
    public void aufitem(item[] a){
        for (int i= 0 ; i<21 ;i++){
            if ((int)a[i].getX() == bombs[0].position((int)spieler[0].gibX()) &&
                  (int)a[i].getY() == bombs[0].position((int)spieler[0].gibY())){
                      if(bombemax!=10){
                          erhoehebombemax();
                }
                    }
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
    
    public void senkebomben(){
        bomben--;
    }
    
    public void erhoehebombemax(){
        bombemax++;
    }
}
