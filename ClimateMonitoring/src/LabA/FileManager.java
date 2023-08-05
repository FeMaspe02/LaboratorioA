package LabA;
import java.io.*;

public class FileManager {
	
	public FileManager() {
		
	}
	
	
	//apre un file in scrittura 
	
	public FileWriter openToWrite(String file, boolean append) {
		
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file, append);
			BufferedWriter bw = new BufferedWriter(fw);
			//pw = new PrintWriter(bw);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return fw;
	}
	
	//apre un file in lettura
	public BufferedReader openToRead(String file) {
		BufferedReader br = null;
		
		try {
			FileReader fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
		return br;
	}
	
	

}