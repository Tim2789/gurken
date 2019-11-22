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
    public item(int x, int y)
    {   
        getbomb= new GLObjekt[2];
        getbomb[0]= new GLQuader(randpos(x),randpos(y),-8,8,8,8,"schwarz.jpg");
    }
    public double getRandom(double min, double max)
    {
        max = 150;
        min = -150;
        double xy = (Math.random()*((max-min)+1))+min;
        return xy;
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
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
