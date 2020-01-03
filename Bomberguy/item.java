import GLOOP.*;
/**
 * Write a description of class item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class item
{
    // instance variables - replace the example below with your own
    private GLObjekt[] getbomb;
    /**
     * Constructor for objects of class item
     */
   
    
    
    public item(int x, int py,String a)
    {   
        getbomb= new GLObjekt[2];
        getbomb[0]= new GLQuader(randpos(x),randpos(py),-8,8,8,8, a);
    }
    public int randpos(int xy)
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
    
    public void removeitem()
    {
       getbomb[0].loesche();
    }
    
    public double getX(){
        return getbomb[0].gibX();
    }
    
    public double getY(){
        return getbomb[0].gibY();
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public int beispielMethode()
    {
        // tragen Sie hier den Code ein
        return 0 ;
    }
}
