package LabA;
import java.io.*;

public class AccessManager {
	
	private String FileAree = "ClimateMonitoring/bin/LabA/File/CoordinateMonitoraggio.dati.CSV";
	private FileManager fm = new FileManager();

	public AccessManager() {
		
	}
	
	//Metodo che riceve in input una string che puo' essere un nome di un'area di interesse 
	//o una parte di esso e restituisce TUTTE le aree di interesse che contengono data stringa nel loro nome
	public void cercaAreaGeografica(String NomeParz) throws IOException {
			
		int Size = NomeParz.length();
		String nomeparz = NomeParz.toLowerCase();
		BufferedReader br = fm.openToRead(FileAree);
		String Riga = br.readLine();
		int c = 0;
		
		do{		
			
			int i = 0;
			boolean Trovato = false;
			
			while(Riga.charAt(i)!= ';') {i++;}		
			
				String nome = Riga.substring(0,i).toLowerCase();
				int n = ++i;

			while(Riga.charAt(i) != ';') {i++;}	
			
				String stato = Riga.substring(n,i).toLowerCase();
				
				if(stato.equals(nomeparz)) {
					c++;
					System.out.println(c + " " + nome + ", " + stato);
					Trovato = true;
					}
               
				if(!Trovato) {
					for (i = 0; i <= n - Size; i++) {
						int j;
						for (j = 0; j < Size; j++) {
							if (nome.charAt(i + j) != nomeparz.charAt(j)) {
								break;
							}
						}
						if (j == Size) {  // Sottostringa trovata
							c++;
							System.out.println(c + " " + nome + ", " + stato);
		               
						}
					}
				}	
				
				Riga = br.readLine();
				
				}while(Riga!=null);
			if (c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");
			br.close(); 
	}	
	
	//Metodo che riceve in ingresso latitudine e longitudine e restituisce l'area di interesse con date coordinate
	
	public void cercaAreaGeografica(double Latitudine, double Longitudine) throws IOException {
		
		BufferedReader br = fm.openToRead(FileAree);
		String Riga = br.readLine();
		int c = 0;
		
		do{		
			boolean TrovataLat = false;
			int i = 0;
			
			while(Riga.charAt(i)!= ';') {i++;}		
			
				String nome = Riga.substring(0,i).toLowerCase();
				int n = ++i;

			while(Riga.charAt(i) != ';') {i++;}	
		
				String stato = Riga.substring(n,i).toLowerCase();
				n = ++i;
			
			while(Riga.charAt(i) != ',') {i++;}
				String latitudine = Riga.substring(n,i);
			
			n = i+2;
			String longitudine = Riga.substring(n,Riga.length());
				
				double fileLat = Double.parseDouble(latitudine);
					if(Latitudine - 5 <= fileLat && fileLat <= Latitudine +5 ) {{
						TrovataLat = true;
					}
					
				while(Riga.charAt(i) != ',') i++;
					
				double fileLon = Double.parseDouble(longitudine);
						if(Longitudine - 5 <= fileLon && fileLon <= Longitudine +5 && TrovataLat) {	
						System.out.println(c + " " + nome + ", " + stato + ", " + latitudine + ", " + longitudine);
						c++;
						}	
					}

			Riga = br.readLine();	
			}while(Riga!=null);
		if(c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");		
		br.close();
	}
	
	public void visualizzaAreaGeografica() {
		
	}

	
}
