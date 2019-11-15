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

    /**
     * Constructor for objects of class Bombe
     */
    public Bombe(int x, int y)
    {   
        bomb= new GLObjekt[2];
        bomb[0]= new GLQuader(position(x),position(y),-8,8,8,8,"tnt.jpeg");
        
        
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
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
