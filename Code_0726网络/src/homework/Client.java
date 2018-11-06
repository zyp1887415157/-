package homework;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7890);
        OutputStream out = socket.getOutputStream();
        InputStream in = new FileInputStream("/Users/dllo/Desktop/219995DD2C8E861519B4645EFE249EF0.jpg");
        PrintStream p = new PrintStream(out);
        byte[] bytes = new byte[1024 * 1024];

        int line = 0;
        while ((line = in.read(bytes)) != -1) {
            out.write(bytes, 0, line);
        }
        p.println("传输完成");
        socket.close();

    }
}
