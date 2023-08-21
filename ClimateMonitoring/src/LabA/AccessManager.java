package LabA;
import java.io.*;
import java.util.LinkedList;

public class AccessManager {
	
	private String FileAree = "ClimateMonitoring/bin/LabA/File/CoordinateMonitoraggio.dati.CSV";
	private String FileParametri = "ClimateMonitoring/bin/LabA/File/ParametriClimatici.dati.txt";
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
					System.out.println(c + " " + nome + ", " + stato);
					Trovato = true;
					c++;
					}
               
				if(!Trovato) {
					for (i = 0; i < nome.length() - Size + 1; i++) {						
							if (nome.substring(i,i + Size).equals(nomeparz)) {
								System.out.println(c + " " + nome + ", " + stato);
								c++;
							}
					}
				}	
				
				Riga = br.readLine();
				
				}while(Riga!=null);
			if (c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");
			br.close();
	}	
	
	//public AreaDiInteresse scegliAreaDiInteresseNome(String nome, int n) throws IOException {
		//LinkedList<AreaDiInteresse> lista = cercaAreaGeografica(nome);
		//return lista.get(n);
	//}
	
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
	
}
