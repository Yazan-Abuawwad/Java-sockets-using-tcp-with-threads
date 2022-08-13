package com.yazan.serverConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    private static ServerSocket serverSocket;
    private static final int PORT = 9330;




    public static void startConnection() {
        System.out.println("Opening port�\n");
        try {
            serverSocket = new ServerSocket(PORT); //Step 1.

        } catch (IOException ioEx) {
            System.out.println("Unable to attach to port! "+ioEx.getMessage());
            System.exit(1);
        }

        while (true) {
            try {
                new   HandlerWithThread(serverSocket.accept()).start();
            } catch (IOException e) {
                System.out.println( e.getMessage());
                e.printStackTrace();
            }
        }




    }



}
