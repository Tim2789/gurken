import GLOOP.*;
/**
 * Write a description of class Bombe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bombe
{
    // instance variables - replace the example below with your own
    private GLObjekt[] bomb;
    private long alter;
    /**
     * Constructor for objects of class Bombe
     */
    public Bombe(int x, int y)
    {   
        bomb= new GLObjekt[2];
        bomb[0]= new GLQuader(position(x),position(y),-8,8,8,8,"tnt.jpeg");
        alter = System.currentTimeMillis();
    }
    
    public int position(int xy)
    {
        if(xy>0){
            if((xy-(xy%10))% 20 ==0){
                return((xy-(xy%10)));
            }
            return((xy-(xy%10)+10));
        }else{
            if((xy-(xy%10))%20 ==0){
            return((xy-(xy%10)));
            }
            return((xy-(xy%10))-10);
        }
    }
    
    public void loescheb (){
        bomb[0].loesche();
    }
    
    public double getX(){
        return bomb[0].gibX();
    }

    public double getY(){
        return bomb[0].gibY();
    }
    
    public long getalter(){
        return alter;
    }
    
}
