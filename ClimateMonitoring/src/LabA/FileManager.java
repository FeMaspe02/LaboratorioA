package LabA;
import java.io.*;

public class FileManager {
	
	public FileManager() {
		
	}
	
	
	//apre un file in scrittura 
	
	//NB - il metodo funziona, ma non so come dargli l'indirizzo del file
	
	public PrintWriter openToWrite(String file, boolean append) {
		PrintWriter pw = null;
		 
		try {
			FileWriter fw = new FileWriter(file, append);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return pw;
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