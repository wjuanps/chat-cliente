/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wjuan.cliente.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sophia
 */
public class ClienteView extends JFrame {

    private final JTextArea textArea;
    private final JTextField textField;
    private final JButton button;

    private final String nome;

    public ClienteView(String nome) {
        super(nome);
        this.nome = nome;

        final Font font = new Font("Serif", Font.PLAIN, 18);

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setFocusable(false);
        this.textArea.setFont(font);
        this.textArea.setAutoscrolls(true);
        final JScrollPane scroll = new JScrollPane(textArea);

        this.textField = new JTextField();
        this.textField.setFont(font);

        this.button = new JButton("Enviar");
        this.button.setFont(font);

        final Container c = new JPanel();
        c.setLayout(new BorderLayout());
        c.add(textField, BorderLayout.CENTER);
        c.add(button, BorderLayout.EAST);

        final Container container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(scroll, BorderLayout.CENTER);

        this.getContentPane().add(container, BorderLayout.CENTER);
        this.getContentPane().add(c, BorderLayout.SOUTH);

        URL url = this.getClass().getResource("/imagens/chatboxes.png");
        Image image = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 300));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getTextField() {
        return textField;
    }

    public String getNome() {
        return nome;
    }
}
