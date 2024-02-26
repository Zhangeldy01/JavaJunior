package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static chat.server.ClientManager.clients;

public class Server {
    // Серверный сокет
    private final ServerSocket serverSocket;

    /**
     * Иициализация серверного сокета
     * @param serverSocket серверный сокет
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        try {
            while(!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключен новый клиент!");
                ClientManager clientManager = new ClientManager(socket);
                clients.add(clientManager);
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (Exception e) {
            closeSocket();
        }
    }
    /**
     * Закрытие объекта ServerSocket, в случае возникновения исключения
     */
    private void closeSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
