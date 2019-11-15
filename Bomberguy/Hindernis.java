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
        int ret =404;
        double dX = x / spX;
        double dY = y / spY;
      /*  if(disX < -10 && disX > -30){
        if(disY < -10 && disY > -30){ret = 1;}
        else if(disY > 10 && disY < 30){ret = 2;}
    }else if(disX > 10 && disX < 30){
        if(disY < -10 && disY > -30){ret = 3;}
        if(disY > 10 && disY < 30){ret = 4;}
    }*/
        ret = (int)(dX + dY);
        //System.out.println("ret Hindernis:" + ret);
        //System.out.println("SpielerX: "+spX+ "   SpielerY: "+spY+"   HX: "+ this.gibX() + "   HY: " + this.gibY()+ "    ret: "+ret);
        return ret;
    }
    public void loesche(){
        hindernis.loesche();
    }
}
