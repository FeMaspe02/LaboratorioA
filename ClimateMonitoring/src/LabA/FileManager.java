package LabA;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	
	public FileManager() {
		
	}
	
	
	//apre un file in scrittura 
	
	//NB - il metodo funziona, ma non so come dargli l'indirizzo del file
	
	public PrintWriter openToWrite(String file, boolean append) {
		 
    		String basePath = System.getProperty("user.dir");
    		String relativePath = file;
    		String fullPath = basePath + "/" + relativePath;
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(fullPath, true));
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