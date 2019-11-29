
/**
 * @author 
 * @version 
 */
public class BomberClient extends Client
{

    private String serverIP;
    private int serverPort;
    private String handlung;
    public BomberClient(String pServerIP)
    {
        super(pServerIP, 2222);
    }

    public void send(String pNachricht)
    {
        super.send(pNachricht);
    }

    public void processMessage(String pMessage){
        handlung = pMessage;
    }

    public int getMessage(){
        int ret = 0;
        if(handlung != null && handlung != ""){
            ret = Integer.parseInt(handlung);
        }
        handlung = "";
        return ret;
    }
}
