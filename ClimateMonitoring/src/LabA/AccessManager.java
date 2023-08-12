package LabA;
import java.io.*;

public class AccessManager {
	
	private String FileCentro = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\CentroMonitoraggio.dati.CSV";
	private FileManager fm = new FileManager();

	//Metodo che riceve in input una string che puo' essere un nome di un'area di interesse 
	//o una parte di esso e restituisce TUTTE le aree di interesse che contengono data stringa nel loro nome
	 
	public AccessManager() {
		
	}
	
	public void cercaAreaGeografica(String NomeParz) throws IOException {
			
			int Size = NomeParz.length();
			BufferedReader br = fm.openToRead(FileCentro);
			String Riga = br.readLine();
			
			do{		
				 
				boolean Trovato = false;
				int i = 0;;
				String sub = Riga.substring(i,i+Size);
					
				while(sub.contains(";")) {
						
						if(sub.toLowerCase().equals(NomeParz.toLowerCase()) && !Trovato) {
							
							System.out.println(Riga);
							Trovato = true;
			
						}
						
						else {
							i++;
						}
						
						if(Riga.substring(i+Size+1,i+Size+Size+1).toLowerCase().equals(NomeParz.toLowerCase()) && !Trovato){
							
							System.out.println(Riga);
							Trovato = true;
							
						}
					}
				
				Riga = br.readLine();
				
				}while(Riga!=null);
			
			br.close();
			 
	}	
	
	//Metodo che riceve in ingresso latitudine e longitudine e restituisce l'area di interesse con date coordinate
	
	public void cercaAreaGeografica(String Latitudine, String Longitudine) throws IOException {
		
		int SizeLat = Latitudine.length();
		int SizeLon = Longitudine.length();
		BufferedReader br = fm.openToRead(FileCentro);
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
	}
	
}
