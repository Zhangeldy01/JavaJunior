package chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clients.add(this);
            // TODO: ...
            name = bufferedReader.readLine();
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (Exception e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        //Удаление клиента из коллекции
        removeClient();
        try {
            //Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            //Завершаем работу буфера на запись данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            //Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление клиента из коллекции
     */
    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    /**
     * Отправка сообщения всем слушателям или личного сообщения
     * @param message сообщение
     */
    private void broadcastMessage(String message) {
        if (message.startsWith(("@"))) { // Если сообщение начинается с @, значит это личное сообщение
            String[] parts = message.split(" ", 2); // Разделяем на части по пробелу
            if (parts.length >= 2) {
                String recipientName = parts[0].substring(1); // Получаем имя получателя без @
                String privateMessage = name + " (private): " + parts[1]; // Формируем личное сообщение
                sendPrivateMessage(privateMessage, recipientName); // Отправляем личное сообщение
            }
        } else { // Обычное сообщение для всех
            for (ClientManager client : clients) {
                try {
                    if (!client.equals(this) && message != null) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                } catch (Exception e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }
    }

    // Метод для отправки личного сообщения конкретному клиенту
    private void sendPrivateMessage(String message, String recipientName) {
        for (ClientManager client : clients) {
            try {
                if (client.name.equals(recipientName)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (Exception e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (!socket.isClosed()) {
            try {
                // Чтение данных
                messageFromClient = bufferedReader.readLine();
                // Отправка данных всем слушателям
                broadcastMessage(messageFromClient);
            } catch (Exception e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                //break;
            }
        }
    }
}

