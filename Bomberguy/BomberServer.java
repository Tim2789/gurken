import java.util.*;
public class BomberServer extends Server{
    private int port1, port2;
    private String ip1, ip2;
  public BomberServer () {
    super(2222);
    System.out.println("BomberServer gestartet.");
  try{
            System.out.println("Server gestartet.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
  }

  public void processNewConnection(String clientIP, int clientPort) {
      System.out.println(clientIP + " Ist mit dem ChatServer verbunden.");
      if(ip1 != null && ip1 != ""){
          ip1 = clientIP;
          port1 = clientPort;
        }else{
            ip2 = clientIP;
            port2 = clientPort;
        }
  }

  public void processMessage(String clientIP,int clientPort, String message) {
     if(clientIP.equals(ip1)){
         super.send(ip2, port2, message);
        }
     else{
        super.send(ip1, port1, message);
        }
    }

  public void processClosingConnection(String clientIP, int clientPort) {
  }
}
