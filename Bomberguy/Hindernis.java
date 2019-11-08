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
    public double getDistanceX(Spieler s){
        double ret = s.getX()-this.gibX();
        return ret;
    }
    public double getDistanceY(Spieler s){
        double ret = 404;
        double sp = s.getY();
        double hi = this.gibY();
        ret = sp*hi /2;
        return ret;
    }
}
