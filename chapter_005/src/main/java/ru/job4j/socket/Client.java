package ru.job4j.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

public class Client {

    public static void main(String[] args) {

        int servPort = 5000;

        String intetAdress = "127.0.0.1";

        try {

            InetAddress inetAddress = InetAddress.getByName(intetAdress);
            System.out.println("Подключаемся к данному серверу: " +  servPort);
            Socket socket = new Socket(intetAdress, servPort);

            InputStream socketInpStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInpStream);
            DataOutputStream out = new DataOutputStream(socketOutStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            System.out.println("Введите фразу для передачи серверу:");

            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Сервер прислал ответ: " + string);
                System.out.println("Введите фразу для отправки на сервер:");

            }














        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}































