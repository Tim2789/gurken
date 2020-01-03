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
        }else if(z == false){hindernis.setzeTextur("steinziegel.jpg");}
    }
    public int getDistance(double spX, double spY){

        int ret = 0;
        double hx = this.gibX();
        double hy = this.gibY();
        if(hy + 10 > spY && hy - 10 < spY){
            if(hx+10 > spX && hx + 30 < spX){
                ret = 1;
            }
            if(hx -10 < spX && hx - 30 > spX){
                ret = 2;
            }
        }
        if(hx + 10 > spX && hx - 10 < spX){
            if(hy < spY && hy + 30 > spY){
                ret = 4;
            }
            if(hy - 10 > spY && hy -30 < spY){
                ret = 3;
            }
        }
        return ret;
    }
    public void loesche(){
        hindernis.loesche();
    }
    public boolean destroyable(){
        return zerstörbar;
    }
    public boolean isBomb(){
        if(hindernis != null){
            return true;
        }else return false;
    }
}
