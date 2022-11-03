/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm;

public class AVCAlgo {
    /**
     * 
     * @param embedded_message
     * @return 
     */
    public static String applyAVCAlgorithm(byte[] embedded_message){
        StringBuilder sb = new StringBuilder(embedded_message.length * Byte.SIZE);
        for(int count = 0 ; count < Byte.SIZE * embedded_message.length;count++){
           sb.append((embedded_message[count / Byte.SIZE] << count % Byte.SIZE & 0x80) == 0 ? '0' : '1'); 
        }
       return sb.toString();
    }
    /**
     * 
     * @param embedded_message
     * @return 
     */
    public static byte[] decodingAvcAlgorithm(String embedded_message){
        int sLen = embedded_message.length();
        byte[] toReturn = new byte[(sLen + Byte.SIZE - 1) / Byte.SIZE];
        char c;
            for( int i = 0; i < sLen; i++ )
                if( (c = embedded_message.charAt(i)) == '1' )
                    toReturn[i / Byte.SIZE] = (byte) (toReturn[i / Byte.SIZE] | (0x80 >>> (i % Byte.SIZE)));
                else if ( c != '0' )
                    throw new IllegalArgumentException();
        return toReturn;
    }
    
    public static void toPrintResult(byte[] array){
        for(int i = 0 ; i < array.length;i++)
            System.out.println(i+" "+array[i]+" ");
    }
}
