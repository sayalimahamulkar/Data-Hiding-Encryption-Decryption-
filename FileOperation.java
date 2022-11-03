/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fileinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileOperation {
  /**
   * 
   * @param file_path
   * @return 
   */
  public static String readObjectFile(String file_path){
       String resultValue = null;
        try{
            FileInputStream fin = new FileInputStream(new File(file_path));
            ObjectInputStream ois = new ObjectInputStream(fin);
            byte[] resultValueByte = (byte[]) ois.readObject();
            resultValue = new String(resultValueByte);
            ois.close();
        }catch(Exception ex){
            System.out.println("Exception : "+ex.getMessage());
            ex.printStackTrace();
        }
       return resultValue;
   } 
  /**
   * 
   * @param file_path
   * @return 
   */
  public static ArrayList<ArrayList<Byte>> readObjectFramesFile(String file_path){
      ArrayList<ArrayList<Byte>> result = new ArrayList<ArrayList<Byte>>();
      try{
          FileInputStream fis = new FileInputStream(new File(file_path));
          ObjectInputStream oin = new ObjectInputStream(fis);
          result = (ArrayList<ArrayList<Byte>>) oin.readObject();
          System.out.println("Data is add successfully...");
          oin.close();
      }catch(Exception ex){
          System.out.println("FileOperation.java : readObjectFramesFile() :");
          ex.printStackTrace();
      }
      return result;
  }
  
  public static String getEmbeddedMessage(String file_path){
      String result = null;
      try{
          FileInputStream fin = new FileInputStream(new File(file_path));
          ObjectInputStream oin = new ObjectInputStream(fin);
          result = (String)oin.readObject();
          oin.close();
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return result;
  }
  
}
