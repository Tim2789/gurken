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
    private void setTexture(boolean z){
        if(z == true){
            hindernis.setzeTextur("ziegel.jpg");
        }else{hindernis.setzeTextur("steinziegel.jpg");}
    }
    public int getDistance(double spX, double spY){

        int ret = 0;
        double hx = this.gibX();
        double hy = this.gibY();
        if(hx + 10 < spX && hx +30 > spX){
            if(hy +10 >= spY && hy -10 <= spY){ret = 1;}
        }
        if(hy +10 < spY && hy + 30 > spY){
            if(hx +10 >= spX && hx -10 <= spX){ret = 2;}
        }
        return ret;
    }
    public void loesche(){
        hindernis.loesche();
    }
}
