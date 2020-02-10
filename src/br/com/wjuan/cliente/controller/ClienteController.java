/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wjuan.cliente.controller;

import br.com.wjuan.cliente.model.Cliente;
import br.com.wjuan.cliente.model.ThreadServidor;
import br.com.wjuan.cliente.view.ClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sophia
 */
public class ClienteController {

    private final ClienteView clienteView;
    private final Cliente cliente;

    public ClienteController(String nome) {
        this.cliente = new Cliente();
        this.clienteView = new ClienteView(nome);

        this.clienteView.getTextField().addActionListener(this.new Listener());
        this.clienteView.getButton().addActionListener(this.new Listener());

        this.cliente.conectarServidor();
        this.cliente.run(new ThreadServidor(cliente.getScanner(), clienteView.getTextArea()));
        
        clienteView.setVisible(true);
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cliente.getPrintWriter().println(clienteView.getNome() + " diz: " + clienteView.getTextField().getText());
            cliente.getPrintWriter().flush();

            clienteView.getTextField().setText(null);
            clienteView.getTextField().requestFocus();
        }
    }
}
