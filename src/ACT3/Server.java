package ACT3;
// C'EST LE SOURCE CODE DE SERVER MAIS DANS UN AUTRE MACHINE VIRTUELLE QUE LE CLIENT
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            int port = 8000;
            String hostIP = "192.168.100.148";
            InetAddress ADDR = InetAddress.getByName(hostIP);

            ServerSocket serveur = new ServerSocket();
            serveur.bind(new InetSocketAddress(ADDR, port));
            System.out.println("server online on "+hostIP+" : "+port);
            while (true){
                Socket socketClient = serveur.accept();
                System.out.println("New Client connected!\nClient IP: "+socketClient.getInetAddress());

                //declaring variables
                PrintWriter os = new PrintWriter(socketClient.getOutputStream(), true);
                BufferedReader is = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

                String req = is.readLine();
                System.out.println("Printing Client Request: "+req);

                //transforming list of strings numbers into doubles and spliting by space, selecting the operator
                String[] list = req.trim().split(" ");

                String operator = list[list.length-1];
                char op = operator.charAt(0);
                System.out.println(op+operator);
                double[] numbers = new double[list.length-1];
                for (int i =0; i< list.length-1;i++){numbers[i]=Double.parseDouble(list[i]);}

                //selecting OPERATOR
                double result = 0;
                switch(op){
                    case '+': result = Calculator.add(numbers); break;
                    case '-': result = Calculator.subtract(numbers); break;
                    case '*': result = Calculator.multiply(numbers); break;
                    case '/': result = Calculator.divide(numbers); break;
                    default:
                        System.out.println("unknow operation");
                }
                System.out.println("res: "+result);
                os.println(result);

                socketClient.close();
                System.out.println("connection closed");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
