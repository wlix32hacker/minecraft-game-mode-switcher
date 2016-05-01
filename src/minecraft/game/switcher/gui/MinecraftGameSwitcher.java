/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft.game.switcher.gui;

/**
 *
 * @author Elvis
 */
public class MinecraftGameSwitcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
