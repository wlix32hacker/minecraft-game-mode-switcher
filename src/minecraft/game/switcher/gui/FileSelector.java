/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft.game.switcher.gui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Elvis
 */
public class FileSelector extends javax.swing.JPanel {
    public final JFileChooser fs;
    private final ActionListener actionListener;

    /**
     * Creates new form FileSelector
     */
    public FileSelector(ActionListener actionListener) {
        this.actionListener = actionListener;
        initComponents();
        fs = fileSelector;
        final String windowsPath = System.getenv("APPDATA");
        final String unixPath = System.getProperty("user.home");
        String path;
        if(SystemUtils.IS_OS_WINDOWS){
            System.out.println("path no windows");
            path = windowsPath;
        }else{
            System.out.println("path in unix-like");
            path = unixPath;
        }
        File fPath = new File(path + "/.minecraft/saves");
        if(!fPath.exists()){
            System.out.println("path not exists, trying home:" + fPath.getAbsolutePath());
            fPath = new File(System.getProperty("user.home"));
        }
        fs.setCurrentDirectory(fPath);
        fs.setAcceptAllFileFilterUsed(true);
        fs.setFileFilter(new FileNameExtensionFilter("NTB Files", "dat"));
//        fs.addChoosableFileFilter(new FileNameExtensionFilter("NTB Files", "dat"));
        fs.setVisible(true);
        System.out.println("ok....");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSelector = new javax.swing.JFileChooser();

        fileSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fileSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSelectorActionPerformed
        // TODO add your handling code here:
        if(!"CancelSelection".equals(evt.getActionCommand())){
            this.actionListener.actionPerformed(evt);
            fs.setCurrentDirectory(fs.getSelectedFile());
        }else{
            System.out.println("selection canceled");
        }

    }//GEN-LAST:event_fileSelectorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileSelector;
    // End of variables declaration//GEN-END:variables
}
