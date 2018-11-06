package homework;

import java.io.*;


public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("开始接收");
        ServerRunnable serverRunnable = new ServerRunnable();
        Thread thread = new Thread(serverRunnable);
        thread.start();



    }
}
