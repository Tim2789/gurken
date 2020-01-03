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
    private int bombemax = 3;
    private int bomben = 0 ;
    private Bombe[] bombs = new Bombe[5];
    private Explosion[] ep;
    private int Explosionlvl =4;
    boolean alive;
    
    public Spieler(String farbe ,int x, int y, boolean palive)
    {
        ep= new Explosion[3];
        for(int i=0; i<3;++i){
        ep[i]= new Explosion();
        }
        spieler = new GLObjekt[9];
        alive = palive;
        spieler[0] = new GLKugel(x,y,-8, 8,"weis.jpg" );
        spieler[1] = new GLKugel(x,y,-21, 6,"weis.jpg" );
        spieler[2] = new GLKugel(x,y,-29, 3,"weis.jpg" );
        spieler[3] = new GLKugel(x-2,y+2,-29, 1,"schwarz.jpg" );
        spieler[4] = new GLKugel(x+2,y+2,-29, 1,"schwarz.jpg" );
        spieler[5] = new GLZylinder(x,y,-35,3,5,farbe);
        spieler[6] = new GLZylinder(x,y,-32,5,1,farbe);
        spieler[7] = new GLKegel(x,y+3,-28,1,3, "orange.jpg");
        spieler[7].setzeDrehung(90,0,0);
    }
       
    public void setzebombe(){
        if(bomben <bombemax && !setzbar()){
            
            bombs[bomben] = new Bombe( (int)spieler[0].gibX() ,(int)spieler[0].gibY());
            erhoehebomben();
           
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

    public void entferneb(Spielfeld f){
        int i=0;
        int k=0;
        while(i < bomben){
        if ((System.currentTimeMillis() - bombs[i].getalter()) >=3000){
            anfangexplo(i);          
            
            f.loescheB(bombs[i]);
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
    
    public void anfangexplo(int i){ 
            for(int j=0; j < 6; ++j){
                if(ep[j].getalter() ==0){
                ep[j].verschiebExplo(bombs[i].getX(),bombs[i].getY());
                ep[j].setalter(System.currentTimeMillis());
                break;
            }
            }
    }
    
    public Explosion[] getExplo(){
        return ep;
    }


    public void ablaufExplo(){
        long temp ;
        long zeit ;
        for(int i =0;i<3;i++){
            zeit = (System.currentTimeMillis() - ep[i].getalter());
            for(temp =Explosionlvl; temp>0; --temp){
                if(ep[i].getalter() !=0 && zeit >=200*temp){
                    ep[i].step((int)temp);
                    break;
                }
            }
             if(ep[i].getalter()!=0 && zeit >= 200*((long)(Explosionlvl+1))){
                ep[i].hide();
                ep[i].setalter(0);
                }
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
    
    public void setXY(int x , int y){
    float temp ; 
    for(int i = 0; i<8; i++){
            temp=spieler[i].gibZ();
            spieler[i].setzePosition(x,y,temp);
        }
    
    }
    
    public void setAlive (boolean b){
    alive= b ;
    }
    
    public boolean getAlive(){
    return alive;
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
