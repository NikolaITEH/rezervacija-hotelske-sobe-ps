/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import domain.Recepcioner;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private List<HandleClientThread> clients;

    public ServerThread() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/serverconfig.properties"));
        String port = properties.getProperty("port");
        serverSocket = new ServerSocket(Integer.parseInt(port));
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Cekam klijente...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");

                HandleClientThread thread = new HandleClientThread(socket, this);
                thread.start();
                synchronized (clients) {
                    clients.add(thread);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        stopAllThreads();
    }

    private void stopAllThreads() {
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void stopServer(){
        try {
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void removeClient(HandleClientThread thread) {
        synchronized (clients) {
            clients.remove(thread);
        }
    }

    public boolean isRecepcionerLoggedIn(Recepcioner recepcioner) {
        synchronized (clients) {
            for (HandleClientThread client : clients) {
                if (client.getLoggedInRecepcioner() != null && client.getLoggedInRecepcioner().equals(recepcioner)) {
                    return true;
                }
            }
        }
        return false;
    }

}
