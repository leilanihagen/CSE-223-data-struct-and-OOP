import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Server-side message receiver.
 *
 * @date 2018-06-09
 * @author Leilani Hagen
 * @assignment PA5 - CSE223
 */
public class SReceiver implements Runnable {

    private Socket socket;
    private String clientUsername;

    public SReceiver(Socket socket, String clientUsername){
        /*
        Mandatory constructor.
         */

        this.socket = socket;
        this.clientUsername = clientUsername;
    }

    @Override
    public void run(){

        Scanner fromClient = null;
        try {
            fromClient = new Scanner(socket.getInputStream());
        } catch(IOException e){
            e.printStackTrace();
        }

        while (fromClient.hasNextLine()) {

            String clientMessage = fromClient.nextLine();

            // Specialized exit-message:
            if (clientMessage.equals("EXIT_MESSAGE_FLAG")) {
                System.out.println(clientUsername + " left the chat. Goodbye!");
                System.out.println();
                break;
            } else {
                // Send the received message to stdout:
                System.out.println(clientUsername + ": <" + clientMessage + ">");
            }
        }
        fromClient.close();
    }
}