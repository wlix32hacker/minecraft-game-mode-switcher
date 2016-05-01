/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft.game.switcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import minecraft.game.switcher.bean.NbtPorperties;
import org.jnbt.CompoundTag;
import org.jnbt.IntTag;
import org.jnbt.NBTInputStream;
import org.jnbt.NBTOutputStream;
import org.jnbt.Tag;

/**
 *
 * @author Elvis
 */
public class MainFrame extends javax.swing.JFrame {
    private Map<String, Object> treeItens;
    private CompoundTag tree;
    private final FileSelector fileSelector;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        // setup file chooser
        fileSelector = new FileSelector(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("selected file");
                                            JFileChooser f = (JFileChooser) e.getSource();
                                            datFilePath.setText(f.getSelectedFile().getAbsolutePath());
                                            loadNbtProperties();
                                        }
                                    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        slcGameMode = new javax.swing.JComboBox();
        btnSaveGameMode = new javax.swing.JButton();
        datFilePath = new javax.swing.JTextField();
        btnChooseFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minecraft Game Switcher 0.1");

        jLabel1.setText("Game mode");

        slcGameMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Survivor", "Creative" }));
        slcGameMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slcGameModeActionPerformed(evt);
            }
        });

        btnSaveGameMode.setText("save");
        btnSaveGameMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGameModeActionPerformed(evt);
            }
        });

        btnChooseFile.setText("choose file");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseFile)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveGameMode))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slcGameMode, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slcGameMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnSaveGameMode)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slcGameModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slcGameModeActionPerformed
        System.out.println("selecionou: " + slcGameMode.getSelectedItem());
    }//GEN-LAST:event_slcGameModeActionPerformed

    private void btnSaveGameModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameModeActionPerformed
        System.out.println("saving nbt....");
        saveGameMode();
        NBTOutputStream nbtOutputStream;
        try {
            System.out.println(tree);
            nbtOutputStream = new NBTOutputStream(new FileOutputStream(datFilePath.getText()));
            nbtOutputStream.writeTag(tree);
            nbtOutputStream.close();
        } catch (IOException ex) {
            System.out.println("error at saving nbt...");
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveGameModeActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        System.out.println("Abrindo file chooser");
        fileSelector.fs.showOpenDialog(this);
    }//GEN-LAST:event_btnChooseFileActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnSaveGameMode;
    private javax.swing.JTextField datFilePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox slcGameMode;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Load all nbt options on app
     */
    private void loadNbtProperties() {
        try {
            System.out.println("loading nbt properties....");
            final NBTInputStream nbtStream = new NBTInputStream(new FileInputStream(datFilePath.getText()));
            tree = (CompoundTag) nbtStream.readTag();
            nbtStream.close();
            treeItens = (Map<String, Object>) tree.getValue().get(NbtPorperties.DATA_KEY).getValue();
            loadGameMode();
            System.out.println("all loaded");
        } catch (IOException ex) {
            System.out.println("fail loading nbt file:");
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Load current game mode on screen
     */
    private void loadGameMode() throws FileNotFoundException, IOException {
        System.out.println("loading game mode...");
        IntTag gameMode = (IntTag) treeItens.get(NbtPorperties.GAME_TYPE_KEY);
        System.out.println("game type: " + gameMode);
        slcGameMode.getModel().setSelectedItem(slcGameMode.getModel().getElementAt(gameMode.getValue()));
    }

    private void saveGameMode() {
        System.out.println("setting game mode: " + slcGameMode.getSelectedIndex() + ": " + slcGameMode.getModel().getSelectedItem());
        final int index = slcGameMode.getSelectedIndex();
        final Map<String, Tag> player = ((CompoundTag) treeItens.get(NbtPorperties.PLAYER_KEY)).getValue();
        treeItens.put(NbtPorperties.GAME_TYPE_KEY, new IntTag(NbtPorperties.GAME_TYPE_KEY, index)); 
        player.put(NbtPorperties.PLAYER_GAME_TYPE_KEY, new IntTag(NbtPorperties.PLAYER_GAME_TYPE_KEY, index));
        
    }
}
