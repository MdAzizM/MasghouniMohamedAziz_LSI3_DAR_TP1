package ACT3;

// C'EST LE SOURCE CODE DE CLIENT MAIS DANS UN AUTRE MACHINE VIRTUELLE QUE LE SERVEUR

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            int port = 8000;
            String serverIP = "192.168.100.148";
            InetAddress serverAddr = InetAddress.getByName(serverIP);
            Socket socket = new Socket(serverAddr,port);
            System.out.println("Client connected on "+serverAddr.getHostAddress()+" : "+port+" !");

            //Client Input
            Scanner scn = new Scanner(System.in);
            System.out.print("put a number: ");
            String reqNumbers = scn.nextLine();
            System.out.print("put the operator: ");
            String reqOp = scn.next();
            String reqResult = reqNumbers+" "+reqOp;

            //Sending the CLIENT's data
            PrintWriter os = new PrintWriter(socket.getOutputStream(), true);
            os.println(reqResult);

            //Recieving the Server results
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nb = is.readLine();
            System.out.println("Result: \t"+nb);

            socket.close();
            System.out.println("connection closed !");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
