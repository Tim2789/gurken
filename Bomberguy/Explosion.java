import GLOOP.*;
/**
 * Beschreiben Sie hier die Klasse Explosion.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Explosion
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private GLObjekt[] explo ;
    private double x =0;
    private double y=0;
    private double z =-8;
    private long alter = 0;
    private boolean interagiert[]= {true,true,true,true,true} ;
    /**
     * Konstruktor für Objekte der Klasse Explosion
     */
    public Explosion()
    {
     
     explo = new GLObjekt[5];   
     int lauf =40;
     
        explo[0]= new GLKugel(x,y,z,8,"gelb.jpg");
        explo[1]= new GLKugel(x+lauf,y,z,8,"gelb.jpg");
        explo[2]= new GLKugel(x,y+lauf,z,8,"gelb.jpg");
        explo[3]= new GLKugel(x-lauf,y,z,8,"gelb.jpg");
        explo[4]= new GLKugel(x,y-lauf,z,8,"gelb.jpg"); 
    }
    
    public void setalter(long a){
    alter=a;
    }
    
    public long getalter(){
    return(alter);
    }
    
    public float getX(){
    return explo[0].gibX();
    }
    
    
    public void verschiebExplo(double xp, double yp){
        for (int i =0; i<5;++i){
        interagiert[i]= true;
        }

        x=xp;
        y=yp;
        explo[0].setzePosition(xp,yp,z);
        richtung(1,xp+20,yp);
        richtung(2,xp,yp+20);
        richtung(3,xp-20,yp);
        richtung(4,xp,yp-20);   
    }
    
    public void step(int j){
        int lauf =20;
        explo[0].setzePosition(0,0,z);
        richtung(1,(x+lauf*j),y);
        richtung(2,x,(y+lauf*j));
        richtung(3,(x-lauf*j),y);
        richtung(4,x,(y-lauf*j));
        }
    
    public void richtung (int index, double x ,double y){
        if(interagiert[index] && (x<150) && (x>-150) && (y<150) && (y>-150) ){
        explo[index].setzePosition(x,y,z);
        }else{
        explo[index].setzePosition(0,0,z);
        }
    }
        
    public void hide(){
        x=0;
        y=0;
        explo[0].setzePosition(x,y,z);
        richtung(1,x+40,y);
        richtung(2,x,y+40);
        richtung(3,x-40,y);
        richtung(4,x,y-40); 
    }
    
    public void setinteragiertfalse(int index){
    interagiert[index]=false;
    }

    public GLObjekt[] getExplo(){
        return explo;
    }

}
