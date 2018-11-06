package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunnable implements Runnable {

    @Override
    public void run() {
        ServerSocket server = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            server = new ServerSocket(7890);
            socket = server.accept();
            inputStream = socket.getInputStream();
            OutputStream outputStream = null;
            outputStream = new FileOutputStream("/Users/dllo/Desktop/我.jpg");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            byte [] bytes = new byte[1024*1024];

            int line = 0;
            while ((line=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,line);
            }

            String s = reader.readLine();
            System.out.println(s);


            outputStream.flush();
            socket.close();
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

