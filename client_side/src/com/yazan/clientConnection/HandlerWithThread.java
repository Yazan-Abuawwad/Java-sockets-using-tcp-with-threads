package com.yazan.clientConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HandlerWithThread extends Thread{

    private static Socket socket  ;

    private PrintWriter out;
    private BufferedReader in;



    public HandlerWithThread(Socket socket) {
        this.socket=socket;

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            makeConnection();
        } catch (IOException e) {
            System.out.println("Error out ,in  connection :"+e.getMessage());
            e.printStackTrace();
        }



    }

    private void makeConnection() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        try {

            while (true) {
                System.out.print("Enter message: ");
                String text=reader.readLine();
                if (text.equals("exit")){
                     stopConnection();
                    reader.close();
                    break;
                }
                 sendMessage(text);
                System.out.println("\nSERVER> " + receiveMessage());
            }

        } catch (Exception e) {
            System.out.println("error read Line");
            e.printStackTrace();

        }
    }


    public void sendMessage(String msg) {
        try {
            out.println(msg);
        } catch (Exception e) {
            System.out.println("error send Message :"+ e.getMessage());

        }

    }


    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (Exception e) {
            System.out.println("error receive Message :"+ e.getMessage());
            return null;
        }

    }


    public void stopConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("error closing :"+ e.getMessage());
        }

    }


}
