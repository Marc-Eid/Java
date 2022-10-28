public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	//activate the network
    	Network objNetwork = new Network();           
    	objNetwork.start();

    	//start server one
    	Server serverOne = new Server("Server Thread One");
    	serverOne.start();

    	//start server two
    	Server serverTwo = new Server("Server Thread Two");
    	serverTwo.start();

    	//Server serverThree = new Server("Server Thread Three");
    	//serverThree.start();
    	
    	
    	//start the sending client
    	Client objClient1 = new Client("sending");         
    	objClient1.start();

    	//start the receiving client
    	Client objClient2 = new Client("receiving");      
    	objClient2.start();

     
    }
    
 }

