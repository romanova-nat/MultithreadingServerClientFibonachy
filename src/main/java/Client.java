import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 23444;
        Socket clientSocket = new Socket(host, port);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

             Scanner scanner = new Scanner(System.in)) {

            String msg;
            while (true) {
                System.out.println("Введите число для расчета n-го члена Фибоначи");
                msg = scanner.nextLine();
                out.println(msg); //пишем серверу
                if ("end".equals(msg)) break;
                System.out.println("Ответ: " + in.readLine()); //читаем что пришло
            }
        }
    }
}