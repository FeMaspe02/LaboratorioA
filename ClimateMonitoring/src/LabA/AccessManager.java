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
			String Riga = br.readLine();
			 
			do{		
				 
				boolean Trovato = false;
				int i = 0;;
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(Riga.substring(0,Size));
					
				while(!matcher.find()) {
						
						if(Riga.substring(i,i+Size).equals(NomeParz) && !Trovato) {
							
							System.out.println(Riga);
							Trovato = true;
			
						}
						
						else {
							i++;
							matcher = pattern.matcher(Riga.substring(i,i+Size));
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
			 
			boolean TrovataLat = false;
			int i = 0;
			String sub = Riga.substring(i,i+SizeLat+1);
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(Riga.substring(0,1));
				
				while(!matcher.find()) {i++; matcher = pattern.matcher(Riga.substring(0,i));}

					if(Riga.substring(i+1,i+SizeLat).equals(Latitudine) && !TrovataLat ) {{
						
						TrovataLat = true;
						i = i+SizeLat;
						System.out.println(Riga);
		
					}
					
						if(TrovataLat && Riga.substring(i,i+SizeLon).equals(Longitudine+" ")) {
						
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
