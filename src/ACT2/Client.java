package ACT2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",8080);
            System.out.println("Client connected on port 8080 !");

            Scanner scn = new Scanner(System.in);
            System.out.println("put a number: ");
            int x = scn.nextInt();
            OutputStream os = socket.getOutputStream();
            os.write(x);

            InputStream is = socket.getInputStream();
            int nb = is.read();
            System.out.println("the multiplied number is: "+nb);

            socket.close();
            System.out.println("connection closed !");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
