package ACT1;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket serveur = new ServerSocket(8080);
            System.out.println("server online on prot 8080, waiting for clients!");
            while (true){
                Socket socketClient = serveur.accept();
                System.out.println("New Client connected!");
                socketClient.close();
                System.out.println("connection closed");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
