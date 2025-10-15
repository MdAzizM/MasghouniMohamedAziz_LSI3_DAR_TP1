package ACT1;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",8080);
            System.out.println("Client connected on port 8080 !");
            socket.close();
            System.out.println("connection closed !");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
