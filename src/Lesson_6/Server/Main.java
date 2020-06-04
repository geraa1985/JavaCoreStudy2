package Lesson_6.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int PORT = 8189;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Клиент подключился");
                try (Scanner in = new Scanner(socket.getInputStream()); Scanner scan = new Scanner(System.in);
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    Thread t1 = new Thread(() -> {
                        while (true) {
                            try {
                                String str1 = in.nextLine();
                                System.out.println("Клиент: " + str1);
                            } catch (NoSuchElementException e) {
                                System.out.println("Единственный клиент нас покинул... Досвидания!");
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
