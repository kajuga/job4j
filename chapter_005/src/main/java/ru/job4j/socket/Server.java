package ru.job4j.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {
    public static void main(String[] args) {
        int port = 5000; //1025 - 65535

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ждем подключения к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketInpStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInpStream);
            DataOutputStream out = new DataOutputStream(socketOutStream);

            String str = null;

            while (true) {

                str = in.readUTF();
                System.out.println("Мы получили следующее сообщение " + str);
                System.out.println("Отправка обратно");
                out.writeUTF(str);
                out.flush();
            }







        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}






















