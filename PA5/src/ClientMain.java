import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String args[]){

        // Create our socket for receiving messages:
        Socket socket = new Socket(localhost, 1_201);

        // Create a Scanner on System.in to capture input from the client:
        Scanner input = new Scanner(System.in);

        // Main loop:
        while (input.hasNextLine()) {

            // Send messages to the server:
            PrintWriter toServer = null;
            try {
                toServer = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (toServer != null) {
                toServer.print(input.hasNextLine());
            }

            // Receive input from the server:
            Scanner fromServer;
            try {
                fromServer = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // code to receive messages...


        }



    }


}
