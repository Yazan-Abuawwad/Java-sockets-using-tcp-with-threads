package com.yazan.clientConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.RandomAccess;


public class ClientTCP {


    private static InetAddress ip;
    private static final int PORT = 9330;
    private Socket socket  ;



    public ClientTCP( ) {  }


    public void startConnection()   {

        try {
            final String TOKENID=InetAddress.getLocalHost().getHostName();
            ip=InetAddress.getLocalHost();
            socket= new Socket(ip,PORT);

            new HandlerWithThread(socket).start();

        } catch (UnknownHostException e) {
            System.out.println("Unknown ip Host :"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error Socket connection :"+e.getMessage());
            e.printStackTrace();
        }


    }







}
