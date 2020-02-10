/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wjuan.cliente.model;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Sophia
 */
public class Cliente {

    private Socket socket;
    private PrintWriter printWriter;
    private Scanner scanner;
    
    public Cliente() {
    }

    public void conectarServidor() {
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000);
            printWriter = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(socket.getInputStream());
        } catch (Exception e) {}
    }
    
    public void run(Runnable runnable) {
        new Thread(runnable).start();
    }
    
    public Socket getSocket() {
        return socket;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}
