/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perprocessing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ganesh
 */
public class AudioVideoMix implements Runnable{
    String APPLICATION_FOLDER_NAME;
    String OUTPUT_VIDEO_FILE_NAME;
    String AUDIO_FILE_PATH_NAME;
    String VIDEO_FINAL_OUTPUT;
    
    /**
     * 
     * @param application_folder_path
     * @param output_frames_path
     * @param audio_file_path
     * @param video_output_path 
     */
    public AudioVideoMix(String application_folder_path,String output_frames_path,
                 String audio_file_path,String video_output_path){
        this.APPLICATION_FOLDER_NAME = application_folder_path;
        this.OUTPUT_VIDEO_FILE_NAME = output_frames_path;
        this.AUDIO_FILE_PATH_NAME = audio_file_path;
        this.VIDEO_FINAL_OUTPUT = video_output_path;
    }
    @Override
    public void run() {
        try {
            // -acodec copy -vcodec copy
           String audioVedioCommand = APPLICATION_FOLDER_NAME+"ffmpeg -i "+AUDIO_FILE_PATH_NAME+"audio.mp3  -i  "+OUTPUT_VIDEO_FILE_NAME+
                   "video9096.mp4   -shortest "+VIDEO_FINAL_OUTPUT+"output.mp4";
           System.out.println(audioVedioCommand);
           Runtime runTime = Runtime.getRuntime();
           runTime.exec(audioVedioCommand);
           System.out.println("Audio-Video mixed Successfully..");
        } catch (IOException ex) {
            Logger.getLogger(AudioVideoMix.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
