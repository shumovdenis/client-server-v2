import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        out.println("Please, write your name!");
        final String username = in.readLine();
        out.println(String.format("Welcome, %s! \nAre you child? (yes/no)", username));
        String input = in.readLine();
        switch (input){
            case "yes": out.println(String.format("Welcome to the kids area, %s! Let's play!", username) );
            case "no": out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username) );
        }
    }
}
