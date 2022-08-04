import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        final int port = 23444;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String msg;
                while ((msg = in.readLine()) != null) { //если то, что написал клиент не null
                    if (msg.equals("end")) break; // Выход если от клиента получили end
                    int m = Integer.parseInt(msg);
                    out.println(getFibonaciNumber(m)); // Пишем ответ
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

// расчет n-го члена Фибоначи
    public static int getFibonaciNumber(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return getFibonaciNumber(n-1) + getFibonaciNumber(n-2);
    }
}
