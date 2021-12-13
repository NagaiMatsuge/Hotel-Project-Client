package com.example.hotel;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) throws Exception{
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 5001);
        String response = client.sendMessage("{\"target\":\"get_users\"}");}}
