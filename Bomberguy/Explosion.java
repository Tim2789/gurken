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
    private double x =500;
    private double y=500;
    private double z =-8;
    private long alter = 0;
    /**
     * Konstruktor für Objekte der Klasse Explosion
     */
    public Explosion()
    {
     
     explo = new GLObjekt[5];   
     int lauf =20;
     
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
        x=xp;
        y=yp;
        explo[0].setzePosition(xp,yp,z);
        explo[1].setzePosition(xp+20,yp,z);
        explo[2].setzePosition(xp,yp+20,z);
        explo[3].setzePosition(xp-20,yp,z);
        explo[4].setzePosition(xp,yp-20,z);    
         
    }
    
    public void step(int j){
        int lauf =20;
        explo[0].setzePosition(500,500,z);
        explo[1].setzePosition((x+lauf*j),y,z);
        explo[2].setzePosition(x,(y+lauf*j),z);
        explo[3].setzePosition((x-lauf*j),y,z);
        explo[4].setzePosition(x,(y-lauf*j),z);
        } 
    
    
    public void hide(){
        x=500;
        y=500;
        verschiebExplo(x,y);
    }
}