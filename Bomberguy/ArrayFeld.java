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
    
    public double getEdgeTop(){
        return edges[3];
    }
    
    public double getEdgeBottom(){
        return edges[2];
    }
    
    public double getEdgeLeft(){
        return edges[1];
    }
    
    public double getEdgeRight(){
        return edges[0];
    }
    
    public double[] getEdges(){
        return edges;
    }
}
