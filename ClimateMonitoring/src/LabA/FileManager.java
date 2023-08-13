package LabA;
import java.io.*;

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
	
	public BufferedReader openToRead(String file) throws UnsupportedEncodingException, FileNotFoundException {

		    	String basePath = System.getProperty("user.dir");
		    	String relativePath = file;
		    	String fullPath = basePath + "/" + relativePath;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath), "UTF-8"));
		
		return br;
	}
	
	

}