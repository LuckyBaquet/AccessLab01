package accesslab1;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by lucky on 1/25/16.
 */
public class ConnectionManagerTest {

    @Test
    public void establishConnectionTest(){

        ConnectionManager.establishConnection("50.73.209.90","999");

        assertEquals("These should be equal",1, ConnectionManager.getNumberOfConnections());

        ConnectionManager.establishConnection("50.73.210.22","888");

        assertEquals("These should be equal",2, ConnectionManager.getNumberOfConnections());

        ConnectionManager.establishConnection("50.73.209.11","777");

        assertEquals("These should be equal",3, ConnectionManager.getNumberOfConnections());

        ConnectionManager.establishConnection("50.73.209.87","666");

        assertEquals("These should be equal",4, ConnectionManager.getNumberOfConnections());

        ConnectionManager.establishConnection("50.73.209.115", "222");

        assertEquals("These should be equal",5, ConnectionManager.getNumberOfConnections());

        ConnectionManager.establishConnection("50.73.209.255","999");

        assertEquals("These should be equal",5, ConnectionManager.getNumberOfConnections());


        ConnectionManager.removeConnection("50.73.209.11");

        assertEquals("These should be equal", 4 , ConnectionManager.getNumberOfConnections());

        ConnectionManager.removeConnection("50.73.209.90");

        assertEquals("These should be equal", 3 , ConnectionManager.getNumberOfConnections());

        ConnectionManager.printConnections();



    }


}