import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client-side message sender.
 *
 * @date 2018-06-10
 * @author Leilani Hagen
 * @assignment PA5 - CSE223
 */
public class CSender implements Runnable {

    private Socket socket;
    private Scanner scanner;
    private String serverUsername;

    public CSender(Socket socket, Scanner scanner, String serverUsername) {
        /*
        Mandatory constructor.
         */

        this.socket = socket;
        this.scanner = scanner;
        this.serverUsername = serverUsername;
    }

    @Override
    public void run() {

        PrintWriter toServer = null;
        try {
            toServer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Couldn't connect to the output stream of the server!");
            e.printStackTrace();
        }

        // While new messages, send them though the socket:
        while (scanner.hasNextLine()) {

            String lastMessage = scanner.nextLine();

            // Exit if user enters "x!" at the beginning of a line:
            String checkExit = lastMessage.substring(0, 2);
            if (checkExit.equals("x!")){
                toServer.println("EXIT_MESSAGE_FLAG");
                toServer.flush();
                break;
            } // else:
            // Send last line to the server:
            toServer.println(lastMessage);
            toServer.flush();
        }
        toServer.close();
    }
}
