package com.yazan;

import com.yazan.clientConnection.ClientTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientTCP clientTCP= new ClientTCP();
        clientTCP.startConnection();
    }
}
