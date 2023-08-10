package LabA;
import java.io.*;
import java.util.*;

public class AccessManager {
	
	private String FileCentro = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\CentroMonitoraggio.dati.CSV";
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
			String Riga = br.readLine();
			 
			do{		
				 
				boolean Trovato = false;
				int i = 0;;
					
				while(!Riga.substring(i,i+Size).contains(";")) {
						
						if(Riga.substring(i,i+Size).equals(NomeParz) && !Trovato) {
							
							System.out.println(Riga);
							Trovato = true;
			
						}
						
						else {
							i++;
						}
					}
				
				Riga = br.readLine();
				
				}while(Riga!=null);
			
			br.close();
			pw.flush();
			pw.close();
			 
	}	
	
	public void cercaAreaGeografica(String Latitudine, String Longitudine) throws IOException {
		
		int SizeLat = Latitudine.length();
		int SizeLon = Longitudine.length();
		BufferedReader br = fm.openToRead(FileCentro);
		PrintWriter pw = fm.openToWrite(FileSessione, true);
		String Riga = br.readLine();
		 
		do{		
			 
			int cont = 0;
			boolean TrovataLat = false;
			int i = 0;
				
				while(cont < 2) {
					
					if(Riga.charAt(i) == ';') {cont++; i++;}
					
					else i++;
					
					}
				
					if(Riga.substring(i,i+SizeLat).equals(Latitudine) && !TrovataLat ) {{
						
						TrovataLat = true;
						i = i+SizeLat+1;
		
					}
					
						if(TrovataLat && Riga.substring(i,i+SizeLon).equals(Longitudine)) {
						
						System.out.println(Riga);
						
						}	
					}

			Riga = br.readLine();
			
			}while(Riga!=null);
				
		br.close();
		pw.flush();
		pw.close();
		 
}
	
}
