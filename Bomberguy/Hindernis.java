import GLOOP.*;
public class Hindernis
{
    private GLQuader hindernis;
    private boolean zerstörbar;
    private int x,y,z;
    public Hindernis(boolean pZ, int px, int py)
    {
        zerstörbar = pZ;
        x = px;
        y = py;
        hindernis = new GLQuader(x,y,-10, 20, 20, 20);
        this.setTexture(zerstörbar);
    }
    public int gibX(){
        return x;
    }
    public int gibY(){
        return y;
    }
    public void setTexture(boolean z){
        if(z == true){
            hindernis.setzeTextur("ziegel.jpg");
        }else{hindernis.setzeTextur("steinziegel.jpg");}
    }
}
