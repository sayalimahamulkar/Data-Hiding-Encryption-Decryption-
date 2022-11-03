package com.algorithm;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class RC6 {

	private static int w = 32, r = 20;
	private static final double e = Math.E;
	private static final double goldenRatio = 1.6180339887496482;

	private static int Pw = 0xb7e15163, Qw = 0x9e3779b9;
	
	private static int[] S;

	private static int[] convBytesWords(byte[] key, int u, int c) {
		int[] tmp = new int[c];
		for (int i = 0; i < tmp.length; i++)
			tmp[i] = 0;

		for (int i = 0, off = 0; i < c; i++) 
			tmp[i] = ((key[off++] & 0xFF)) | ((key[off++] & 0xFF) << 8)
					| ((key[off++] & 0xFF) << 16) | ((key[off++] & 0xFF) << 24);

		return tmp;
	}

	private static int[] generateSubkeys(byte[] key) {

		int u = w / 8;
		int c = key.length / u;
		int t = 2 * r + 4;

		int[] L = convBytesWords(key, u, c);


		int[] S = new int[t];
		S[0] = Pw;
		for (int i = 1; i < t; i++)
			S[i] = S[i - 1] + Qw;

		int A = 0;
		int B = 0;
		int k = 0, j = 0;

		int v = 3 * Math.max(c, t);

		for (int i = 0; i < v; i++) {
			A = S[k] = rotl((S[k] + A + B), 3);
			B = L[j] = rotl(L[j] + A + B, A + B);
			k = (k + 1) % t;
			j = (j + 1) % c;

		}

		return S;
	}

	private static int rotl(int val, int pas) {
		return (val << pas) | (val >>> (32 - pas));
	}
	private static int rotr(int val, int pas) {
		return (val >>> pas) | (val << (32-pas));
	}
	
	private static byte[] decryptBloc(byte[] input){
		byte[] tmp = new byte[input.length];
		int t,u;
		int aux;
		int[] data = new int[input.length/4];
		for(int i =0;i<data.length;i++)
			data[i] = 0;
		int off = 0;
		for(int i=0;i<data.length;i++){
			data[i] = 	((input[off++]&0xff))|
						((input[off++]&0xff) << 8) |
						((input[off++]&0xff) << 16) |
						((input[off++]&0xff) << 24);
		}
		
		
		int A = data[0],B = data[1],C = data[2],D = data[3];
		
		C = C - S[2*r+3];
		A = A - S[2*r+2];
		for(int i = r;i>=1;i--){
			aux = D;
			D = C;
			C = B;
			B = A;
			A = aux;
			
			u = rotl(D*(2*D+1),5);
			t = rotl(B*(2*B + 1),5);
			C = rotr(C-S[2*i + 1],t) ^ u;
			A = rotr(A-S[2*i],u) ^ t;
		}
		D = D - S[1];
		B = B - S[0];
		
		data[0] = A;data[1] = B;data[2] = C;data[3] = D;
		
		
		for(int i = 0;i<tmp.length;i++){
			tmp[i] = (byte)((data[i/4] >>> (i%4)*8) & 0xff);
		}
		
		return tmp;
	}
	
	private static byte[] encryptBloc(byte[] input){
		
		byte[] tmp = new byte[input.length];
		int t,u;
		int aux;
		int[] data = new int[input.length/4];
		for(int i =0;i<data.length;i++)
			data[i] = 0;
		int off = 0;
		for(int i=0;i<data.length;i++){
			data[i] = 	((input[off++]&0xff))|
						((input[off++]&0xff) << 8) |
						((input[off++]&0xff) << 16) |
						((input[off++]&0xff) << 24);
		}
	
		int A = data[0],B = data[1],C = data[2],D = data[3];
		
		B = B + S[0];
		D = D + S[1];
		for(int i = 1;i<=r;i++){
			t = rotl(B*(2*B+1),5);
			u = rotl(D*(2*D+1),5);
			A = rotl(A^t,u)+S[2*i];
			C = rotl(C^u,t)+S[2*i+1];
			
			aux = A;
			A = B;
			B = C;
			C = D;
			D = aux;
		}
		A = A + S[2*r+2];
		C = C + S[2*r+3];
		
		data[0] = A;data[1] = B;data[2] = C;data[3] = D;
		
		for(int i = 0;i<tmp.length;i++){
			tmp[i] = (byte)((data[i/4] >>> (i%4)*8) & 0xff);
		}
		
		return tmp;
	}
	
	private static byte[] paddingKey(byte[] key){
		int l = key.length%4;
		for(int i=0;i<l;i++)
			key[key.length+i] = 0;
		return key;
	}

	public static byte[] encrypt(byte[] data, byte[] key) {
		
		byte[] bloc = new byte[16];
		key = paddingKey(key);
		S = generateSubkeys(key);
		

		
		int lenght = 16 - data.length % 16;
		byte[] padding = new byte[lenght];
		padding[0] = (byte) 0x80;
		
		for (int i = 1; i < lenght; i++)
			padding[i] = 0;
		int count = 0;
		byte[] tmp = new byte[data.length+lenght];
		//afiseazaMatrice(S);
		int i;
		for(i=0;i<data.length+lenght;i++){
			if(i>0 && i%16 == 0){
				bloc = encryptBloc(bloc);
				System.arraycopy(bloc, 0, tmp, i-16, bloc.length);
			}
			
			if (i < data.length)
				bloc[i % 16] = data[i];
			else{														
				bloc[i % 16] = padding[count];
				count++;
				if(count>lenght-1) count = 1;
			}
		}
		bloc = encryptBloc(bloc);
		System.arraycopy(bloc, 0, tmp, i - 16, bloc.length);
		return tmp;
	}

	public static byte[] decrypt(byte[] data, byte[] key) {
		byte[] tmp = new byte[data.length];
		byte[] bloc = new byte[16];
		key = paddingKey(key);
		S = generateSubkeys(key);

		int i;
		for(i=0;i<data.length;i++){
			if(i>0 && i%16 == 0){
				bloc = decryptBloc(bloc);
				System.arraycopy(bloc, 0, tmp, i-16, bloc.length);
			}
			
			if (i < data.length)
				bloc[i % 16] = data[i];
		}

		bloc = decryptBloc(bloc);
		System.arraycopy(bloc, 0, tmp, i - 16, bloc.length);
		
		tmp = deletePadding(tmp);
		return tmp;
	}
	
	private static byte[] deletePadding(byte[] input){
		int count = 0;

		int i = input.length - 1;
		while (input[i] == 0) {	
			count++;
			i--;
		}

		byte[] tmp = new byte[input.length - count - 1];
		System.arraycopy(input, 0, tmp, 0, tmp.length);
		return tmp;
	}
        
        public static byte[] getImageEncryptByteData(File file,byte[] key){
            byte[] encrypt = null;
            try{
                System.out.println("getImageEncryptByteData() : "+file.toPath());
                byte[] filecontent = Files.readAllBytes(file.toPath());
                encrypt = RC6.encrypt(filecontent, key);
            }catch(Exception ex){
                System.out.println("Exception : "+ex.getMessage());
            }
            return encrypt;
        }
        
        public static byte[] getImageDecryptByteData(byte[] encryptByte,byte[] key){
            byte[] decrypt = RC6.decrypt(encryptByte, key);
            return decrypt;
        }
        public static void main(String[] args){
            try{
                String key = "Ganesh_PAtil";
                String plaintext = "JAVA Developer";
                byte[] keyByte = key.getBytes();
                byte[] plainTextByte = plaintext.getBytes();
                byte[] encrypt = encrypt(plainTextByte, keyByte);
                for(int count = 0 ; count < encrypt.length; count++)
                    System.out.print(encrypt[count]+" ");
                System.out.println();
            }catch(Exception ex){
                ex.printStackTrace();
            }
//            try {
//                File file = new File("D:/TSS/DataHidingRC6/video_frames/123.mp4_31.jpg");
//                byte[] filecontent = Files.readAllBytes(file.toPath());
//                String keyValue = "Hi am ganesh";
//                byte[] key = keyValue.getBytes();
//                
//                byte[] encrypt = RC6.encrypt(filecontent, key);
//                System.out.println(encrypt.length);
//                for(int count = 0;count < encrypt.length;count++){
////                    System.out.println(encrypt[count]+" ");
//                }
//                
//                byte[] decrypt = RC6.decrypt(encrypt, key);
//                System.out.println(decrypt.length);
////                FileOutputStream fout = new FileOutputStream("a_test.jpg");
////                fout.write(encrypt, 0, encrypt.length);
////                fout.close();
//                ByteArrayInputStream in = new ByteArrayInputStream(encrypt);
//                BufferedImage bufferedImage = ImageIO.read(in);
//                if(bufferedImage!= null){
//                    ImageIO.write(bufferedImage, "jpg", new File("D:/TSS/DataHidingRC6/video_frames/0_1123.mp4_31.jpg"));
//                    System.out.println("\nFile write successully...");
//                }else{
//                    System.out.println("Image is null..");
//                }
//                File[] files = new File("D:/TSS/DataHidingRC6/video_frames/").listFiles();
//                String keyValue = "Hi am ganesh";
//                byte[] key = keyValue.getBytes();
//                System.out.println("Files Size : "+files.length);
//                String[] list = new String[files.length];
//                for(int fileCount = 0 ; fileCount < files.length; fileCount++){
//                    for(int count = 0;count < files.length;count++){
//                        String[] file_name = files[count].getPath().split("_");
//                        int last_item = (file_name.length-1);
//                        String fileLastName  = file_name[last_item];
//                        String[] numberStr = fileLastName.split("\\.");
//                        int fileNumber = Integer.parseInt(numberStr[0]);
//                        if(fileCount == fileNumber){
//                            list[fileCount] = files[count].getPath();
//                        }
//                    }
//                }
//                ArrayList<ArrayList<Byte>> frameByteList = new ArrayList<ArrayList<Byte>>();
//                for(int i = 1 ; i < list.length;i++){
//                    File file = new File(list[i]);
//                    byte[] encrypt = RC6.getImageEncryptByteData(file,key);
//                    ArrayList<Byte> l = new ArrayList<Byte>();
//                    for(int count = 0; count < encrypt.length;count++){
//                        l.add(encrypt[count]);
//                    }
//                    frameByteList.add(l);
//                }
//                // create object file
//                File file = new File("FramesByte.enc");
//                FileOutputStream fileOutputStream = new FileOutputStream(file);
//                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
//                out.writeObject(frameByteList);
//                // get object file data
//                ObjectInputStream objectInputStream = new ObjectInputStream(
//                                                             new FileInputStream("FramesByte.enc"));
//                ArrayList<ArrayList<Byte>> objectFileList = (ArrayList<ArrayList<Byte>>) objectInputStream.readObject();
//                for(int c = 0 ; c < objectFileList.size();c++){
//                   byte[] getData = new byte[objectFileList.get(c).size()];
//                    for(int s = 0 ; s < objectFileList.get(c).size();s++){
//                       getData[s] = objectFileList.get(c).get(s);
//                   }
//                  byte[] dec =  RC6.decrypt(getData, key);
//                  ByteArrayInputStream in = new ByteArrayInputStream(dec);
//                  BufferedImage bufferedImage = ImageIO.read(in);
//                  if(bufferedImage!= null){
//                    ImageIO.write(bufferedImage, "jpg", new File("D:/TSS/DataHidingRC6/output/"+c+".jpg"));
//                    System.out.println("\nFile write successully...");
//                  }else{
//                        System.out.println("Image is null..");
//                  }
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(RC6.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
}
