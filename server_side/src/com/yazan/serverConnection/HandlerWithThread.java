package com.yazan.serverConnection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public   class HandlerWithThread extends Thread {

  //  private static ServerSocket serverSocket;


    private static Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public HandlerWithThread(Socket socket) {
        this.clientSocket = socket;
    }


    public  void run( ) {

        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));;


            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true); //Step 3.

            //int numMessages = 0;
            String text  ;

            while (true) {

                text = input.readLine();
                System.out.println("Message received by :"+clientSocket.getInetAddress().getHostName());
                System.out.println(text);
                output.println(text.toUpperCase()); //Step 4.
            }

        } catch (IOException ioEx) {
            System.out.println(  ioEx.getMessage());
            ioEx.printStackTrace();
        }
            finally {
                try {
                    System.out.println("\n* Closing connection� *");
                    clientSocket.close(); //Step 5.
                } catch (IOException ioEx) {
                    System.out.println("\"Unable to disconnect!\""+ioEx.getMessage());
                    System.exit(1);
                }
            }
    }




    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("error closing :"+ e.getMessage());
        }

    }




}
