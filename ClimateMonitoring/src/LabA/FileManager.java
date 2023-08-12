package LabA;
import java.io.*;

public class FileManager {
	
	public FileManager() {
		
	}
	
	
	//apre un file in scrittura 
	
	//NB - il metodo funziona, ma non so come dargli l'indirizzo del file
	
	public PrintWriter openToWrite(String file, boolean append) {
		 
			//String filePath = ClimateMonitoring.class.getResource(file).getPath();
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return pw;
	}
	
	
	
	//apre un file in lettura
	
	public BufferedReader openToRead(String file) {
		
		InputStream inputStream = ClimateMonitoring.class.getClassLoader().getResourceAsStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		
		return br;
	}
	
	

}