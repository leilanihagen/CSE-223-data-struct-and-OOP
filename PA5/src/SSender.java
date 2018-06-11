import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Server-side message sender.
 *
 * @date 2018-06-09
 * @author Leilani Hagen
 * @assignment PA5 - CSE223
 */
public class SSender implements Runnable {

    private Socket socket;
    private Scanner input;

    public SSender(Socket socket, Scanner scanner){
        /*
        Mandatory constructor.
         */

        this.socket = socket;
        this.input = scanner;
    }

    @Override
    public void run() {
        /*
        Send-messages loop.
         */

        // Create a PrintWriter to send messages through the socket:
        PrintWriter toClient = null;
        try {
            toClient = new PrintWriter(socket.getOutputStream());
        } catch (IOException e){
            System.out.println("Couldn't connect to the output stream of the client!");
            e.printStackTrace();
        }

        // While new messages, send them through the socket:
        while (input.hasNextLine()){

            // Send the last line from input through the socket:
            toClient.println(input.nextLine());
            toClient.flush(); // Force last line to send...
        }
        toClient.close();
    }
}
