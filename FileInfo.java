/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fileinfo;

import com.constant.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileInfo implements Constant{
    
    public static ArrayList<String> getFileInfo(File file){
        ArrayList<String> fileDetails = new ArrayList<>();
        JSONObject jsonObj ;
        JSONArray jsonArray ;
        try{
            String command = APPLICATION_PATH+"ffprobe  -v quiet -print_format json -show_format -show_streams "+file.getAbsolutePath()+" ";
            System.out.println("Command : "+command);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            BufferedReader fileDesc = new BufferedReader(new InputStreamReader(
                                                              process.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = fileDesc.readLine())!= null){
                sb.append(line);
                System.out.println(line);
            }
            System.out.println("Line size "+sb.length());
            try {
                if(sb.length()!=0){
                jsonObj = new JSONObject(sb.toString());
                JSONObject ja = jsonObj.getJSONObject("format");
                String file_name = ja.getString("filename");
                String duration = ja.getString("duration");
                double d_time = Double.parseDouble(duration);
                d_time = (d_time/60);
                String file_size = ja.getString("size");
                fileDetails.add(file_name);
                fileDetails.add(d_time+"");
                fileDetails.add(file_size);
                jsonArray = jsonObj.getJSONArray("streams");
                for(int count = 0 ; count < jsonArray.length();count++){
                    JSONObject c = jsonArray.getJSONObject(count);
                    int video_index = c.getInt("index");
                    if(video_index == 0){
                      String codec_name = c.getString("codec_name");
                      String codec_width_height = c.getInt("coded_width")+"*"+
                                                  c.getInt("coded_height");
                      String codec_type = c.getString("codec_type");
                      String frame_per_second = c.getString("r_frame_rate");
                      fileDetails.add(codec_name);
                      fileDetails.add(codec_width_height);
                      fileDetails.add(codec_type);
                      fileDetails.add(frame_per_second);
                    }
                }
                }else{
                    System.out.println("System is null..");
                    fileDetails.add(file.getAbsolutePath());
                    fileDetails.add("");
                    fileDetails.add(file.length()+"");
                }
            } catch (JSONException ex) {
                Logger.getLogger(FileInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(IOException ex){
            System.out.println("Exception FileInfo.java : getFileInfo() : "+ex.getMessage());
        }
        return fileDetails;
    }
}
