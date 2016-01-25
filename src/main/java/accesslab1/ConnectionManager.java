package accesslab1;

/**
 * Created by lucky on 1/25/16.
 */
public class ConnectionManager {

    private static final int MAX_CONNECTIONS = 5;
    private static int numConnections = 0;
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];

    public static void establishConnection(String ipAddress, String portNumber){
        if (numConnections == connections.length){
            System.out.println("Unable to establish new connection.  Connection capacity reached.");
            return;
        }

        System.out.println("Establishing Connection");
        connections[numConnections] = new Connection(ipAddress, portNumber);
        numConnections++;
    }

    public static Connection removeConnection(String ipAddress){
        for(int i = 0; i<numConnections ; i++)
            if(connections[i].getIpAddress().equals(ipAddress)) {
                Connection tempConnection = connections[i];
                for (int j = i; j < numConnections-1; j++)
                    connections[j] = connections[j+1];
                numConnections--;
                System.out.println("Removing Connection");
                return tempConnection;
            }
        return null;
    }

    public static void printConnections(){
        String out = "";
        for(int i = 0; i<numConnections ;i++)
            out += connections[i].getIpAddress()+"\n";

        System.out.print("Number of Connections: " + numConnections + "\nConnections\n================\n"+out);
    }

    public static int getNumberOfConnections(){
        return numConnections;
    }


}

class Connection {

    private String ipAddress;
    private String portNumber;

    Connection(String ipAddress, String portNumber) {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    String getIpAddress() {
        return ipAddress;
    }

    void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    String getPortNumber() {
        return portNumber;
    }

    void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public String toString() {
        return "IP Address: " + ipAddress + "\nPort Number: " + portNumber;
    }
}


