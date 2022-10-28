

public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();
        Server objServer = new Server();        
        /* Complete here the code for the main method ...*/
        
        Client objClientSend = new Client("sending");
        objClientSend.start();
        
        objServer.start();
        
        Client objClientRec = new Client("receiving");
        objClientRec.start();
        
        
        /*
         Changing the buffer size increases the performance, mainly the running time of the client
         sending thread. it decreases by 11ms. This is because the sending client thread reads all the transactions
         and then tries to send them all, but it stops after the buffer get full or 
         another thread takes over the cpu.
         
         On the other hand, the other two threads are not affected as much because as soon as 
         there are transactions in the input buffer the server
         starts processing them and sends them one by one to the output buffer which 
         in turn are taken by the receiving thread without necessarily jamming the output buffer. 
         
         
         
          */
        
    }
}


