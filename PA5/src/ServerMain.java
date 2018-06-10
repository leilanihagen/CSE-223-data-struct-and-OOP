import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args){

        // Create the server socket:
        ServerSocket ss;
        try {
            ss = new ServerSocket(1_201);
        } catch(IOException e){
            e.printStackTrace();
        }

        // Main loop (DEMO):
        while (true) {

            Socket socket = ss.accept(); // Wait for a connection from client...

            // Get a Scanner on input from client:
            Scanner fromClient;
            try {
                fromClient = new Scanner(socket.getInputStream());
            } catch(IOException e) {
                e.printStackTrace();
            }

            // Create a PrintWriter to send through the socket:
            PrintWriter toClient = new PrintWriter(socket.getOutputStream());

        }
    }

}
