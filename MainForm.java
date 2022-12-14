/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gui;

import com.algorithm.AVCAlgo;
import com.algorithm.RC6;
import com.constant.Constant;
import static com.constant.Constant.APPLICATION_PATH;
import static com.constant.Constant.VIDEO_FRAMES_FOLDER_PATH;
import com.fileinfo.FileInfo;
import com.fileinfo.FileOperation;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import perprocessing.AudioVideoMix;
import perprocessing.ImagesToVideo;
import perprocessing.RunVideoFile;
import perprocessing.VideoToJpeg;

/**
 *
 * @author Ganesh
 */
public class MainForm extends javax.swing.JFrame implements Constant{

    String user_select_file_name;
    File file ; 
    /**
     * Creates new form MainForm
     */
    public MainForm() {
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

        jPanel1 = new javax.swing.JPanel();
        add_video_button = new javax.swing.JButton();
        create_frames_button = new javax.swing.JButton();
        play_video_button = new javax.swing.JButton();
        ecrypt_frames_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        file_desc_table = new javax.swing.JTable();
        progressbar = new javax.swing.JProgressBar();
        decrypt_image_button = new javax.swing.JButton();
        embbededButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Hiding");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.Color.pink);
        jPanel1.setForeground(new java.awt.Color(150, 121, 121));

        add_video_button.setBackground(new java.awt.Color(255, 153, 204));
        add_video_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/browse_file.png"))); // NOI18N
        add_video_button.setText("Add");
        add_video_button.setToolTipText("Open Video File");
        add_video_button.setBorderPainted(false);
        add_video_button.setContentAreaFilled(false);
        add_video_button.setFocusPainted(false);
        add_video_button.setFocusTraversalPolicyProvider(true);
        add_video_button.setSelected(true);
        add_video_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_video_buttonActionPerformed(evt);
            }
        });

        create_frames_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/video_to_images.png"))); // NOI18N
        create_frames_button.setText("Frames");
        create_frames_button.setToolTipText("Create Video Frames");
        create_frames_button.setContentAreaFilled(false);
        create_frames_button.setFocusPainted(false);
        create_frames_button.setRequestFocusEnabled(false);
        create_frames_button.setRolloverEnabled(false);
        create_frames_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_frames_buttonActionPerformed(evt);
            }
        });

        play_video_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/play_video.png"))); // NOI18N
        play_video_button.setText("Play");
        play_video_button.setToolTipText("Play video");
        play_video_button.setBorderPainted(false);
        play_video_button.setContentAreaFilled(false);
        play_video_button.setDefaultCapable(false);
        play_video_button.setFocusPainted(false);
        play_video_button.setRolloverEnabled(false);
        play_video_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_video_buttonActionPerformed(evt);
            }
        });

        ecrypt_frames_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/encrypt.png"))); // NOI18N
        ecrypt_frames_button.setText("Encrypt");
        ecrypt_frames_button.setToolTipText("Encrypt Video");
        ecrypt_frames_button.setBorderPainted(false);
        ecrypt_frames_button.setContentAreaFilled(false);
        ecrypt_frames_button.setFocusPainted(false);
        ecrypt_frames_button.setFocusable(false);
        ecrypt_frames_button.setRequestFocusEnabled(false);
        ecrypt_frames_button.setRolloverEnabled(false);
        ecrypt_frames_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecrypt_frames_buttonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(java.awt.Color.pink);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 51, 204));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Video View", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 51, 153));
        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(java.awt.Color.pink);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Video Specification", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Schoolbook", 1, 14))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 51, 153));

        file_desc_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Duration", "Video Size ", "Codec Name", "Width & Height", "Video Format", "FPS"
            }
        ));
        jScrollPane2.setViewportView(file_desc_table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        decrypt_image_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/decrypt.png"))); // NOI18N
        decrypt_image_button.setText("Decrypt");
        decrypt_image_button.setToolTipText("Decrypt Video");
        decrypt_image_button.setBorderPainted(false);
        decrypt_image_button.setContentAreaFilled(false);
        decrypt_image_button.setFocusPainted(false);
        decrypt_image_button.setRequestFocusEnabled(false);
        decrypt_image_button.setRolloverEnabled(false);
        decrypt_image_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrypt_image_buttonActionPerformed(evt);
            }
        });

        embbededButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/embeddeddata.png"))); // NOI18N
        embbededButton.setText("Embbed Data");
        embbededButton.setToolTipText("Embbed Data");
        embbededButton.setBorderPainted(false);
        embbededButton.setContentAreaFilled(false);
        embbededButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embbededButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add_video_button, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(create_frames_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ecrypt_frames_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(embbededButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(decrypt_image_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(play_video_button)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 10, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_video_button)
                    .addComponent(create_frames_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ecrypt_frames_button)
                    .addComponent(play_video_button)
                    .addComponent(embbededButton)
                    .addComponent(decrypt_image_button, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void create_frames_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_frames_buttonActionPerformed
        
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    progressbar.setIndeterminate(true);
                    VideoToJpeg videoToJpeg = new VideoToJpeg(file, VIDEO_FRAMES_FOLDER_PATH, APPLICATION_PATH, AUDIO_FILE);
                    videoToJpeg.isClearDirectory();
                    videoToJpeg.run();
                    progressbar.setIndeterminate(false);
                }catch(Exception ex){
                    System.out.println("Exception : run() :"+ex.getMessage());
                }
            }
        });
        if(file != null){
            thread.start();
        }else{
           JOptionPane.showMessageDialog(null, "Please select file!", "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
         
    }//GEN-LAST:event_create_frames_buttonActionPerformed

    private void add_video_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_video_buttonActionPerformed
        //Browse video file 
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setFileFilter(new FileFilter() {

                            @Override
                            public boolean accept(File f) {
                                String name = f.getName();
                                return f.isDirectory() || name.endsWith("mp4") || name.endsWith("avi") || name.endsWith("3gp") || name.endsWith("mov");
                            }

                            @Override
                            public String getDescription() {
                                return "Video Files";
                            }
                        });
                        int status = fileChooser.showOpenDialog(fileChooser);
                        if(status == JFileChooser.APPROVE_OPTION) {
                                progressbar.setIndeterminate(true);
                                file = fileChooser.getSelectedFile();
                                if(!file.exists() || file.isDirectory()) {
                                    System.err.println("Choose Image File.");
                                    JOptionPane.showMessageDialog(null, "Choose Video File.");
                                }
                                ArrayList<String> fileDesc = FileInfo.getFileInfo(file);
                                if(!fileDesc.isEmpty()){
                                    String[] rows = new String[fileDesc.size()];
                                    for(int count = 0;count < fileDesc.size();count++){
                                        rows[count] = fileDesc.get(count);
                                    }
                                    DefaultTableModel dmodel;
                                    dmodel = (DefaultTableModel) file_desc_table.getModel();
                                    dmodel.addRow(rows);
                                }
                         }
                        progressbar.setIndeterminate(false);
                    }catch(HeadlessException ex){
                        System.out.println("Exception : "+ex.getMessage());
                        progressbar.setIndeterminate(false);
                    }        
            }
        });
        thread.start();
    }//GEN-LAST:event_add_video_buttonActionPerformed

    private void ecrypt_frames_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecrypt_frames_buttonActionPerformed
        try{
                String user_key = showInputDialog("Encryption Key");
                System.out.println("User Key : "+user_key+" User Key Size : "+user_key.length());
                if(user_key.length() == 0){
                    JOptionPane.showMessageDialog(null, "Please enter key.","ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(user_key.length() < 8 && user_key.length() > 16){
                    JOptionPane.showMessageDialog(null, "Please enter key into 8 to 16 characters only.","ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                File[] files = new File(VIDEO_FRAMES_FOLDER_PATH).listFiles();
                byte[] key = user_key.getBytes();
                File keyFile = new File(ENCRYPT_KEY_FILE_NAME);
                FileOutputStream keyFileOutputStream = new FileOutputStream(keyFile);
                ObjectOutputStream keyOut = new ObjectOutputStream(keyFileOutputStream);
                keyOut.writeObject(key);
                keyOut.close();
                System.out.println("Files Size : "+files.length);
                String[] list = new String[files.length];
                System.out.println("Total All List : "+list.length);
                for(int fileCount = 0 ; fileCount < files.length; fileCount++){
                    for(int count = 0;count < files.length;count++){
                        String[] file_name = files[count].getPath().split("_");
                        int last_item = (file_name.length-1);
                        String fileLastName  = file_name[last_item];
                        String[] numberStr = fileLastName.split("\\.");
                        int fileNumber = Integer.parseInt(numberStr[0]);
                        if(fileCount == fileNumber){
                            list[fileCount] = files[count].getPath();
                        }
                    }
                }
                ArrayList<ArrayList<Byte>> frameByteList = new ArrayList<ArrayList<Byte>>();
                for(int i = 1 ; i < list.length;i++){
                    File file = new File(list[i]);
                    byte[] encrypt = RC6.getImageEncryptByteData(file,key);
                    ArrayList<Byte> l = new ArrayList<Byte>();
                    for(int count = 0; count < encrypt.length;count++){
                        l.add(encrypt[count]);
                    }
                    frameByteList.add(l);
                }
                // create object file
                File file = new File(ENCRYPT_FRAMES_FILE_NAME);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
                out.writeObject(frameByteList);
                out.close();
                
        }catch(IOException ex){
            System.out.println("Encryption : "+ex.getMessage());
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_ecrypt_frames_buttonActionPerformed

    private void decrypt_image_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrypt_image_buttonActionPerformed
        try{
            progressbar.setIndeterminate(true);
            String user_key = showInputDialog("Video Decryption Key");
            if(user_key.length() < 8 && user_key.length() > 16){
                JOptionPane.showMessageDialog(null, "Please enter key string in between 8 to 16.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            String videoEncryptKey = FileOperation.readObjectFile(ENCRYPT_FILE_DIRECTORY+ENCRYPT_KEY_FILE_NAME);
            if(videoEncryptKey.length() < 8 && videoEncryptKey.length() > 16){
                JOptionPane.showMessageDialog(null, "Please enter key string in between 8 to 16.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!user_key.equals(videoEncryptKey)){
                JOptionPane.showMessageDialog(null, "You enter wrong video encryption key.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println("User Key : "+user_key+" File Key : "+videoEncryptKey);
            String embedded_key = showInputDialog("Embedded Data Decryption Key ");
            String embeddedEncrptionKey = FileOperation.readObjectFile(ENCRYPT_FILE_DIRECTORY+DATA_HIDING_KEY);
            if(!embedded_key.equals(embeddedEncrptionKey)){
                JOptionPane.showMessageDialog(null, "You enter wrong data embedded encryption key.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println("Embedded Data Decryption Key : "+embedded_key+" File Key : "+embeddedEncrptionKey);
            byte[] videoKeyByte = videoEncryptKey.getBytes();
            byte[] embeddedKeyByte = embeddedEncrptionKey.getBytes();
            ArrayList<ArrayList<Byte>> framesBytes = FileOperation.readObjectFramesFile(ENCRYPT_FILE_DIRECTORY+ENCRYPT_FRAMES_FILE_NAME);
            System.out.println("Get All Data From Database : "+framesBytes.size());
            for(int row = 0 ; row < framesBytes.size(); row++){
                byte[] frameBytes = new byte[framesBytes.get(row).size()];
                for(int col = 0 ; col < framesBytes.get(row).size(); col++){
                    frameBytes[col] = framesBytes.get(row).get(col);
                    System.out.print(framesBytes.get(row).get(col)+" ");
                }
                byte[] decrypt = RC6.decrypt(frameBytes, videoKeyByte);
                System.out.println(decrypt.length);
                ByteArrayInputStream in = new ByteArrayInputStream(decrypt);
                BufferedImage bufferedImage = ImageIO.read(in);
                if(bufferedImage!= null){
                    ImageIO.write(bufferedImage, "jpg", new File(OUTPUT_VIDEO_FRAMES+(row+1)+".jpg"));
                    System.out.println("\nFile write successully...");
                }else{
                    System.out.println("Image is null..");
                } 
                System.out.println();
            } // end for - Image decryption
            // create video file again...
            ImagesToVideo imagesToVideo = new ImagesToVideo(APPLICATION_PATH, OUTPUT_VIDEO_FRAMES, OUTPUT_VIDEO_FILE_PATH,AUDIO_FILE,FINAL_OUTPUT);
            imagesToVideo.run();
            String message_str = FileOperation.getEmbeddedMessage(ENCRYPT_FILE_DIRECTORY+DATA_HIDING_MESSAGE);
            System.out.println("READ FILE BINARY BITSTREAM IS.."+message_str);
            byte[] message = AVCAlgo.decodingAvcAlgorithm(message_str);
            System.out.println("Convert bitstream into byte[] : "+message.length);
            byte[] decryptMessage = RC6.decrypt(message, embeddedKeyByte);
            String embeddedMessage = new String(decryptMessage);
            DisplayEmbeddedData.toDisplayEmbeddedData(embeddedMessage);
            //Audio and video combine...
            AudioVideoMix audioVideoMix = new AudioVideoMix(APPLICATION_PATH, OUTPUT_VIDEO_FILE_PATH, AUDIO_FILE, FINAL_OUTPUT);
            audioVideoMix.run();
            System.out.println("Audio and Video mixed successfully....");
            progressbar.setIndeterminate(false);
        }catch(Exception ex){
            System.out.println("Exception : "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_decrypt_image_buttonActionPerformed

    private void embbededButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embbededButtonActionPerformed
       try{
        EmbeddedDataForm embeddedDataForm = new EmbeddedDataForm();
        embeddedDataForm.setVisible(true);
       }catch(Exception ex){
           System.out.println("Exception "+ex.getMessage());
       }
    }//GEN-LAST:event_embbededButtonActionPerformed

    private void play_video_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_video_buttonActionPerformed
        RunVideoFile.runVideoFile(FINAL_OUTPUT+"output.mp4");
    }//GEN-LAST:event_play_video_buttonActionPerformed
public String showInputDialog(String message){
    String user_key = null;
    JPasswordField pf = new JPasswordField();
    int ok = JOptionPane.showConfirmDialog(null, pf,message,JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(ok == JOptionPane.OK_OPTION){
            user_key = new String(pf.getPassword());
        }else{
            user_key="";
        }
    return user_key;
}
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_video_button;
    private javax.swing.JButton create_frames_button;
    private javax.swing.JButton decrypt_image_button;
    private javax.swing.JButton ecrypt_frames_button;
    private javax.swing.JButton embbededButton;
    private javax.swing.JTable file_desc_table;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton play_video_button;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables
}
