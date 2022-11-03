/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perprocessing;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Ganesh
 */
public class RunVideoFile {
    /**
     * 
     * @param video_file_path 
     */
    public static void runVideoFile(String video_file_path){
        try{
//            Runtime.getRuntime().exec("\"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe\"");

//            ProcessBuilder pb = new ProcessBuilder("C://Program Files/VideoLAN/VLC/vlc.exe",
//                                                              video_file_path);
//            Process start = pb.start();
//            Thread.sleep(4000);
            File file = new File(video_file_path);
            if(file.exists()){
               Desktop.getDesktop().open(file);
            }else{
                JOptionPane.showMessageDialog(null, "Not file video file to given path.Please select correct path to video file.","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
