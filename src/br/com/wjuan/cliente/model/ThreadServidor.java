/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wjuan.cliente.model;

import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sophia
 */
public class ThreadServidor implements Runnable {

    private final Scanner scanner;
    private final JTextArea textArea;

    public ThreadServidor(Scanner scanner, JTextArea textArea) {
        this.scanner = scanner;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        String mensagem;
        try {
            while ((mensagem = scanner.nextLine()) != null) {
                textArea.append(mensagem + "\n");
            }
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Não foi possivei fazer a conexão com o servidor");
            System.exit(0);
        } catch (NoSuchElementException ns) {
            textArea.append("~::System diz: Servidor desconectado...");
        }
    }
}
