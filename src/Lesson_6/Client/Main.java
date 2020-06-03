package Lesson_6.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        try (Socket socket = new Socket(localhost, 8189)) {
            try (Scanner in = new Scanner(socket.getInputStream()); Scanner scan = new Scanner(System.in);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                Thread t1 = new Thread(() -> {
                    while (true) {
                        try {
                            String str1 = in.nextLine();
                            System.out.println("Сервер: " + str1);
                        } catch (NoSuchElementException e) {
                            System.out.println("Сервер нас покинул... Досвидания!");
                            System.exit(0);
                        }
                    }
                });
                t1.setDaemon(true);
                t1.start();
                while (true) {
                    String str2 = scan.nextLine();
                    if (str2.equals("/end")) {
                        return;
                    }
                    out.println(str2);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

