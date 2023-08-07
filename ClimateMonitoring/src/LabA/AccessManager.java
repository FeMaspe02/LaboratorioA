package LabA;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessManager {
	
	private String FileCentro = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\CentroMonitoraggio.dati.txt";
	private String FileSessione = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\Sessione";
	private FileManager fm = new FileManager();

	//Metodo che riceve in input una string che può essere un nome di un centro di monitoraggio 
	//o una parte di esso e restituisce TUTTI i centri di monitoraggio che contengono data stringa
	 
	public AccessManager() {
		
	}
	
	public void cercaAreaGeografica(String NomeParz) throws IOException {
			
			int Size = NomeParz.length();
			BufferedReader br = fm.openToRead(FileCentro);
			PrintWriter pw = fm.openToWrite(FileSessione, true);
			String Riga=br.readLine();
			
			do{		
				 
				boolean Trovato = false;
				int i = 0;
				String sub = Riga.substring(i,i+Size+1);
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(sub);
					
					if(!matcher.find() && !Trovato) {
						
						if(Riga.substring(i,i+Size).equals(NomeParz) ) {
							
							pw.print(Riga);
							pw.print("\n");
							Trovato = true;
			
						}
						
						else
							i++;
					}
				
				Riga = br.readLine();
				
				}
			
			while(Riga!=null);
			
			br.close();
			pw.flush();
			pw.close();
			 
	}
	
}
