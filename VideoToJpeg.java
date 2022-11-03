/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perprocessing;

import java.io.File;

/**
 *
 * @author Ganesh
 */
public class VideoToJpeg implements Runnable {
    File file = null;
    String folder_name = null;
    String app_folder_name = null;
    String audio_file_path = null;
    public VideoToJpeg(File file , String folder_name , String app_folder_name,String audio_file_path) {
        this.file = file;
        this.folder_name = folder_name;
        this.app_folder_name = app_folder_name;
        this.audio_file_path = audio_file_path;
    }

    @Override
    public void run() {
        try {
            String filePath = file.getAbsolutePath();
            String video_name = file.getName();
            Runtime runtime = Runtime.getRuntime();
//            String command = "ffmpeg -i \""+filePath+"\" -s 640X640 \"images/"+video_name+"_%d.jpg\"";
            String command = app_folder_name+"ffmpeg -i \""+filePath+"\" \""+folder_name+""+video_name+"_%d.jpg\"";
            System.out.println("Command : "+command);
            Process process = runtime.exec(command);
            String com = app_folder_name+"ffmpeg -i "+filePath+" -vn -ab 256 "+audio_file_path+"audio.mp3";
            System.out.println("Audio Command : "+com);
            runtime.exec(com);
            System.out.println("Write Audio successfully..");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void isClearDirectory(){
        File[] folder = new File(folder_name).listFiles();
        for(int count = 0 ; count < folder.length; count++){
            File file = new File(folder[count].getPath());
            if(file.exists()){
               file.delete();
            }
        }
    }
}