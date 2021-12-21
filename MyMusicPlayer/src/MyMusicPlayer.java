import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.File;
public class MyMusicPlayer extends javax.swing.JFrame {
    
    private boolean play = true;
    private boolean random = false;
    private boolean loop = false;
    private static WAVSongs player;
    /**
     * Creates new form MyMusicPlayer
     */
    public MyMusicPlayer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playAndPause = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previouisButton = new javax.swing.JButton();
        randomButton = new javax.swing.JButton();
        volume = new javax.swing.JSlider();
        songTitles = new javax.swing.JLabel();
        songPlayingText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        infoButton = new javax.swing.JButton();
        loopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        playAndPause.setText("Play");
        playAndPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAndPauseActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previouisButton.setText("Previous");
        previouisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previouisButtonActionPerformed(evt);
            }
        });

        randomButton.setText("Random");
        randomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomButtonActionPerformed(evt);
            }
        });

        volume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeStateChanged(evt);
            }
        });

        songPlayingText.setText("Press Play!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vinyl_rec.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        infoButton.setText("i");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        loopButton.setText("Loop");
        loopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(randomButton)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(songTitles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previouisButton)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(songPlayingText, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playAndPause, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(loopButton)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(infoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(infoButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(songTitles))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(songPlayingText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playAndPause)
                    .addComponent(nextButton)
                    .addComponent(previouisButton)
                    .addComponent(randomButton)
                    .addComponent(loopButton))
                .addGap(18, 18, 18)
                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAndPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAndPauseActionPerformed
        try {
            if (play) {
                player.setPlaying(true);
                player.playAndPause();
                playAndPause.setText("Pause");
            }
            else {
                player.setPlaying(false);
                player.playAndPause();
                playAndPause.setText("Play");
            }

            play = !play;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: something went wrong");
        }
    }//GEN-LAST:event_playAndPauseActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
            player.nextSong();
            String text = player.getSong();
            songPlayingText.setText(text);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: something went wrong");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previouisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previouisButtonActionPerformed
        try {
            player.previousSong();
            String text = player.getSong();
            songPlayingText.setText(text);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: something went wrong");   
        }
    }//GEN-LAST:event_previouisButtonActionPerformed

    private void randomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomButtonActionPerformed
        if (random) { 
            player.setRandom(false);
            player.randomSongs();
            randomButton.setForeground(Color.BLACK);
        }
        else { 
            player.setRandom(true);
            player.randomSongs();
            randomButton.setForeground(Color.GREEN);
        }
        random = !random;
    }//GEN-LAST:event_randomButtonActionPerformed

    private void volumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeStateChanged
        try {
            player.volumeChange(volume.getValue());  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: something went wrong");
        }
    }//GEN-LAST:event_volumeStateChanged

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        JOptionPane.showMessageDialog(null, "--Welcome to MyMusicPlay-- \nInfo:\n-NOTE! This only plays WAV files\n\nStatus: Beta");
    }//GEN-LAST:event_infoButtonActionPerformed

    private void loopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loopButtonActionPerformed
        if (loop) { 
            player.setLoop(false);
            loopButton.setForeground(Color.BLACK);
        }
        else { 
            player.setLoop(true);
            loopButton.setForeground(Color.GREEN);
        }
        loop = !loop;
    }//GEN-LAST:event_loopButtonActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        File directory;
        File[] files;
        directory = new File("Playlist");
        files = directory.listFiles();
        String[] songFiles = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            songFiles[i] = "Playlist/" + files[i].getName();
        }
        if (songFiles.length == 0) {
            JOptionPane.showMessageDialog(null, "Error: No song files were found!\nMake sure they are placed in the Playlist folder\nPlease close and move files to the folder");
        }
        player = new WAVSongs(songFiles);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyMusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyMusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyMusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyMusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyMusicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loopButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton playAndPause;
    private javax.swing.JButton previouisButton;
    private javax.swing.JButton randomButton;
    private javax.swing.JLabel songPlayingText;
    private javax.swing.JLabel songTitles;
    private javax.swing.JSlider volume;
    // End of variables declaration//GEN-END:variables
}