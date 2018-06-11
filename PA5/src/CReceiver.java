import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client-side message receiver.
 *
 * @date 2018-06-10
 * @author Leilani Hagen
 * @assignment PA5 - CSE223
 */
public class CReceiver implements Runnable {

    private Socket socket;
    private String serverUsername;

    public CReceiver(Socket socket, String serverUsername) {
        /*
        Mandatory constructor.
         */

        this.socket = socket;
        this.serverUsername = serverUsername;
    }

    @Override
    public void run(){

        Scanner fromServer = null;
        try {
            fromServer = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Couldn't access the input stream from the server!");
            e.printStackTrace();
        }

        while (fromServer.hasNextLine()) {

            // Print the new line of message received fromm the server:
            System.out.println(serverUsername + ": <" + fromServer.nextLine() + ">");
        }
        fromServer.close();
    }
}
