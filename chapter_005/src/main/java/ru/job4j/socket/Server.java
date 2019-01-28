package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String ask;
        do {
            ask = in.readLine();
            if ("hello, Oracle".equals(ask)) {
                out.println("Hello, dear friend, I'm a Oracle.");
                out.println("");
            }
        } while (!"exit".equals(ask));
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(6666);
    }
}