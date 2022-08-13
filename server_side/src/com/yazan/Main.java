package com.yazan;

import com.yazan.serverConnection.HandlerWithThread;
import com.yazan.serverConnection.ServerTCP;

public class Main {

    public static void main(String[] args) {
      ServerTCP serverTCP=new ServerTCP();
      serverTCP.startConnection();
    }
}
