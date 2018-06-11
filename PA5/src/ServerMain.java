import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args){

        greetUser();
        String username = getUsername();

//        while (true) {
            // Create the server socket:
            ServerSocket ss = null;
            try {
                ss = new ServerSocket(1_201);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Wait for a connection from client:
            Socket socket = null;
            System.out.println("Waiting for a connection to client...");
            System.out.println();
            try {
                socket = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client connection established!");

            // Send our username to the client:
            PrintWriter nameSender = null;
            try {
                nameSender = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            nameSender.println(username);
            nameSender.flush();

            // Store the client's username:
            Scanner captureName = null;
            try {
                captureName = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String clientUsername = captureName.next();

            System.out.println("You may now chat with " + clientUsername + "!");
            System.out.println();

            // Get a Scanner on input from the server user:
            Scanner input = new Scanner(System.in);

            // Create our Runnables:
            SReceiver receiver = new SReceiver(socket, clientUsername);
            SSender sender = new SSender(socket, input);

            // Thread our Sender and Receiver objects:
            Thread rThread = new Thread(receiver);
            Thread sThread = new Thread(sender);

            // Start the threads:
            rThread.start();
            sThread.start();
//        }
    }

    private static void greetUser() {
        /*
        Greet the server user and give them some instructions.
         */

        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("Hello, welcome to your chat server application!");
        System.out.println();
        System.out.println("Your program will wait for a connection request from a client, and");
        System.out.println("when one is received, you will be able to chat with the client!");
        System.out.println();
        System.out.println("The client may exit at any time. However, if the client exits, you can");
        System.out.println("wait for connection requests from a new client.");
        System.out.println();
        System.out.println("If you wish to exit, press CTRL + C.");
        System.out.println("************************************************************************");
        System.out.println();
    }

    private static String getUsername() {
        /*
        Get a username from the server, so that the client knows who they're chatting with!
         */

        Scanner captureName = new Scanner(System.in);
        System.out.print("Please enter a username for this chat session: ");
        String name = captureName.next();
        System.out.println();
        System.out.println("Hello " + name + "!");
        System.out.println();
        return name;
    }
}