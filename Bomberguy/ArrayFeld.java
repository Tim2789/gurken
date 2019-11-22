import GLOOP.*;
public class ArrayFeld
{
    private double[] edges;
    private Hindernis h;
    public ArrayFeld(double pX, double pY)
    {
        edges = new double[4];
        edges[0] = pX - 10;
        edges[1] = pX + 10;
        edges[2] = pY - 10;
        edges[3] = pY + 10;
    }
    
    public Hindernis getContent(){
        if(h != null){return h;}
        else return null;
    }
    
    public void setContent(Hindernis ph){
        h = ph;
    }
    
    public double[] getEdges(){
        return edges;
    }
}
