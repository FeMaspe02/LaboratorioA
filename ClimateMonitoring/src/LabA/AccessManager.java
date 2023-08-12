package LabA;
import java.io.*;

public class AccessManager {
	
	private String FileCentro = "ClimateMonitoring/src/LabA/File/CentroMonitoraggio.dati.CSV";
	private FileManager fm = new FileManager();

	public AccessManager() {
		
	}
	
	//Metodo che riceve in input una string che puo' essere un nome di un'area di interesse 
	//o una parte di esso e restituisce TUTTE le aree di interesse che contengono data stringa nel loro nome
	public void cercaAreaGeografica(String NomeParz) throws IOException {
			
			int Size = NomeParz.length();
			BufferedReader br = fm.openToRead(FileCentro);
			String Riga = br.readLine();
			int c = 0;
			
			do{		
				 
				boolean Trovato = false;
				int i = 0;;
				
				if(i+Size-1>= Riga.length()){
					System.err.println("Stringa tropppo lunga, riprovare nuovamente");
					break;
				}
				
				while(!Riga.substring(i,i+Size).contains(";")) {
						if(Riga.substring(i,i+Size).toLowerCase().equals(NomeParz.toLowerCase()) && !Trovato) {
							System.out.println(Riga);
							Trovato = true;
							c++;
						}
						else {i++;}
					}				
						i = 0;
						while(!(Riga.charAt(i)==';')) {i++;}
							
						if(i++ +Size-1 >= Riga.length()) {
								System.err.println("Stringa tropppo lunga, riprovare nuovamente");
								break;
						}
						
						if(Riga.substring(i,i+Size).toLowerCase().equals(NomeParz.toLowerCase()) && !Trovato){
							
							System.out.println(Riga);
							Trovato = true;
							c++;
						}
					
				
				Riga = br.readLine();
				
				}while(Riga!=null);
			if (c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");
			br.close(); 
	}	
	
	//Metodo che riceve in ingresso latitudine e longitudine e restituisce l'area di interesse con date coordinate
	
	public void cercaAreaGeografica(String Latitudine, String Longitudine) throws IOException {
		int SizeLat = Latitudine.length();
		int SizeLon = Longitudine.length();
		double lat = Double.parseDouble(Latitudine);
		double lon = Double.parseDouble(Longitudine);
		BufferedReader br = fm.openToRead(FileCentro);
		String Riga = br.readLine();
		int c = 0;
		
		do{		
			int cont = 0;
			boolean TrovataLat = false;
			int i = 0;
			
				while(cont < 2) {
					if(Riga.charAt(i) == ';') {cont++; i++;}
					else i++;
					
				}
				
				if(i+SizeLat -1 >= Riga.length()) {
					System.err.println("Stringa tropppo lunga, riprovare nuovamente");
					break;
					}
				
				double fileLat = Double.parseDouble(Riga.substring(i,i+SizeLat));
					if(lat - 5 <= fileLat && fileLat <= lat +5 ) {{
						TrovataLat = true;
					}
					
				while(Riga.charAt(i) != ',') i++;
				
					if(i+SizeLon -1 >= Riga.length()) {
								System.err.println("Stringa tropppo lunga, riprovare nuovamente");
								break;
								}
					
				double fileLon = Double.parseDouble(Riga.substring(i+1,i+SizeLon+1));
						if(lon - 5 <= fileLon && fileLon <= lon +5 && TrovataLat) {	
						System.out.println(Riga);
						c++;
						}	
					}

			Riga = br.readLine();	
			}while(Riga!=null);
		if(c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");		
		br.close();
	}
	
}
