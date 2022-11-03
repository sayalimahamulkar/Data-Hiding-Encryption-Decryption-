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
public class ImagesToVideo implements Runnable{
   String APPLICATION_FOLDER_NAME ;//= "D://TSS/VideoToImage/Application";
   String INPUT_FILE_NAME ;// = "D://TSS/VideoToImage/VideoFrames";
   String OUTPUT_FILE_NAME;// = "D://TSS/MdeiaPlayer/AVI/";
   String AUDIO_FILE_PATH_NAME;
   String VIDEO_FINAL_OUTPUT ;
   /**
    * 
    * @param application_path
    * @param input_images_fils
    * @param output_video_file 
    */
   public ImagesToVideo(String application_path,String input_images_fils,String output_video_file,
                            String audio_file_path_name,String video_final_output){
            this.APPLICATION_FOLDER_NAME = application_path;
            this.INPUT_FILE_NAME = input_images_fils;
            this.OUTPUT_FILE_NAME = output_video_file;
            this.AUDIO_FILE_PATH_NAME = audio_file_path_name;
            this.VIDEO_FINAL_OUTPUT = video_final_output;
   }
    @Override
    public void run() {
       try{
           String command = APPLICATION_FOLDER_NAME+"ffmpeg -f image2 -i "+
                   INPUT_FILE_NAME+"%d.jpg   "+
                   OUTPUT_FILE_NAME+"video9096.mp4";
           System.out.println("COMMAND : "+command);
           Runtime.getRuntime().exec(command);
           
       }catch(IOException ex){
           System.out.println("Exception : "+ex.getMessage());
       }
    }
}
