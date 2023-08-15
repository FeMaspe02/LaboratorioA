package LabA;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
	
	public FileManager() {
		
	}
	
	
	//apre un file in scrittura 
	
	public PrintWriter openToWrite(String file, boolean append) {
		 
    		String basePath = System.getProperty("user.dir");
    		String relativePath = file;
    		String fullPath = basePath + "/" + relativePath;
			PrintWriter pw = null;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fullPath, append));
				pw = new PrintWriter(bw);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return pw;
	}
	
	
	
	//apre un file in lettura
	
	public BufferedReader openToRead(String file){

		    	String basePath = System.getProperty("user.dir");
		    	String relativePath = file;
		    	String fullPath = basePath + "/" + relativePath;
		
		    	BufferedReader br = null;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath),StandardCharsets.UTF_8));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		
		return br;
	}
	
	

}