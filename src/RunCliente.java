
import br.com.wjuan.cliente.controller.ClienteController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sophia
 */
public class RunCliente {
    /**
     * Define o visual do sistema.
     */
    static {
        try {
            for (UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                    | InstantiationException 
                    | IllegalAccessException 
                    | UnsupportedLookAndFeelException ex) {}
    }

    public static void main(String[] args) {
        String nome = "";
        try {
            do {
                nome = JOptionPane.showInputDialog(null, "Informe o seu nome");
            } while (nome.isEmpty());
        } catch (NullPointerException n) {
            System.exit(0);
        }

        new ClienteController(nome);
    }
}
