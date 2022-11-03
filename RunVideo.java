/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perprocessing;

import java.io.IOException;



/**
 *
 * @author Ganesh
 */
public class RunVideo implements Runnable{
    String APPLICATION_FOLDER_NAME ;//= "D://TSS/VideoToImage/Application/";
    String INPUT_FILE_NAME ;//= "D://TSS/MdeiaPlayer/AVI"  
//                             +"/1.avi";
    String OUTPUT_FILE_NAME ;//= "D://TSS/MdeiaPlayer/AVI/output.mov";
    
    public RunVideo(String app_path,String input_file_path,String output_file_path){
      this.APPLICATION_FOLDER_NAME = app_path;
      this.INPUT_FILE_NAME = input_file_path;
      this.OUTPUT_FILE_NAME = output_file_path;
    }
    @Override
    public void run() {
       try{
        String command = APPLICATION_FOLDER_NAME+"ffmpeg -i "+INPUT_FILE_NAME+
                               " -vcodec mjpeg -acodec pcm_s16be -ac 2 -y "+OUTPUT_FILE_NAME+" ";
        System.out.println("Command : "+command);
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        long start = System.currentTimeMillis();
        process.waitFor();
        long time = System.currentTimeMillis() - start;
        System.out.println("Time : "+time);       
       }catch(IOException | InterruptedException ex){
           System.out.println("Exception : "+ex.getMessage());
       }
    }
    
}
