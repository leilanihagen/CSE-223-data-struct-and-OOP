import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client chat application!
 *
 * @date 2018-06-10
 * @author Leilani Hagen
 * @assignment PA5 - CSE223
 */
public class ClientMain {

    public static void main(String args[]){

        greetUser();
        String username = getUsername();

        // Create our socket for receiving messages:
        Socket socket = null;
        try {
            socket = new Socket("localhost", 1_201);
        } catch (IOException e){
            e.printStackTrace();
        }

        // Send our username to the server:
        PrintWriter nameSender = null;
        try {
            nameSender = new PrintWriter(socket.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        nameSender.println(username);
        nameSender.flush();

        System.out.println("Server connection established!");
        // At this point we have sent a username, so must have a connection...

        // Store the server's username:
        Scanner captureName = null;
        try {
            captureName = new Scanner(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        String serverUsername = captureName.next();


        System.out.println("You may now chat with " + serverUsername + "!");
        System.out.println();

        // Create a Scanner on System.in to capture input from the client:
        Scanner input = new Scanner(System.in);

        // Create our Runnables:
        CReceiver receiver = new CReceiver(socket, serverUsername);
        CSender sender = new CSender(socket, input, serverUsername);

        // Thread our Runnables:
        Thread rThread = new Thread(receiver);
        Thread sThread = new Thread(sender);

        // Start our Threads:
        rThread.start();
        sThread.start();
    }

    private static void greetUser() {
        /*
        Greet the server user and give them some instructions.
         */

        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("Hello, welcome to your chat client application!");
        System.out.println();
        System.out.println("When there is a chat server running, the client application will");
        System.out.println("attempt to connect to the chat server. Once connection is established,");
        System.out.println("you will be able to chat with the user on the server side.");
        System.out.println();
        System.out.println("You may exit the chat at any time by typing 'x!' on a blank line.");
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
