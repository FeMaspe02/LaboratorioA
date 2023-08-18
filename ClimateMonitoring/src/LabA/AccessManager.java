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
	public LinkedList<AreaDiInteresse> cercaAreaGeografica(String NomeParz) throws IOException {
		
		AccessManager accesso = new AccessManager();
		int Size = NomeParz.length();
		String nomeparz = NomeParz.toLowerCase();
		BufferedReader br = fm.openToRead(FileAree);
		String Riga = br.readLine();
		int c = 0;
		LinkedList<AreaDiInteresse> lista = new LinkedList<AreaDiInteresse>();
		AreaDiInteresse a;
		int count = 1;
		int[] valori = new int[6];
		do{		
			
			int i = 0;
			boolean Trovato = false;
			
			while(Riga.charAt(i)!= ';') {i++;}		
			
				String nome = Riga.substring(0,i).toLowerCase();
				int n = ++i;
				int k = n;
				
			while(Riga.charAt(i) != ';') {i++;}	
			
				String stato = Riga.substring(n,i).toLowerCase();
				n = ++i;
				
			while(Riga.charAt(i) != ',') {i++;}
			
				double latitudine = Double.parseDouble(Riga.substring(n,i));
				n = ++i;
				
				double longitudine = Double.parseDouble(Riga.substring(n,Riga.length()));
				
				if(stato.equals(nomeparz)) {
					c++;
					valori =  accesso.ottienivaloriparametri(count);
					a = new AreaDiInteresse(nome,stato,latitudine,longitudine,valori[0],valori[1],valori[2],valori[3],valori[4],valori[5],valori[6]);
					lista.add(a);
					System.out.println(c + " " + nome + ", " + stato);
					Trovato = true;
					}
               
				if(!Trovato) {
					for (i = 0; i < k -1-Size; i++) {						
							if (nome.substring(i + Size).equals(nomeparz)) {
								valori =  accesso.ottienivaloriparametri(count);
								a = new AreaDiInteresse(nome,stato,latitudine,longitudine,valori[0],valori[1],valori[2],valori[3],valori[4],valori[5],valori[6]);
								System.out.println(c + " " + nome + ", " + stato);
								lista.add(a);
								c++;
							}
					}
				}	
				
				Riga = br.readLine();
				count ++;
				
				}while(Riga!=null);
			if (c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");
			br.close();
			return lista; 
	}	
	
	public AreaDiInteresse scegliAreaDiInteresseNome(String nome, int n) throws IOException {
		LinkedList<AreaDiInteresse> lista = cercaAreaGeografica(nome);
		return lista.get(n);
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
	
	public int[] ottienivaloriparametri(int n) throws IOException{
		int[] valori = new int[6];
		BufferedReader br = fm.openToRead(FileParametri);
		String s = null;
		for(int i = 0; i < n; i++) {
			s = br.readLine();
		}
		int c = 0;
		while(s.charAt(c) != ';') {c++;}
		valori[0] = Integer.parseInt(s.substring(0,c));
		while (s.charAt(c) != ';') {c++;}
		int k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[1] = Integer.parseInt(s.substring(n,c));
		while (s.charAt(c) != ';') {c++;}
		k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[2] = Integer.parseInt(s.substring(n,c));
		while (s.charAt(c) != ';') {c++;}
		k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[3] = Integer.parseInt(s.substring(n,c));
		while (s.charAt(c) != ';') {c++;}
		k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[4] = Integer.parseInt(s.substring(n,c));
		while (s.charAt(c) != ';') {c++;}
		k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[5] = Integer.parseInt(s.substring(n,c));
		while (s.charAt(c) != ';') {c++;}
		k = ++c;
		while (s.charAt(c) != ';') {c++;}
		valori[6] = Integer.parseInt(s.substring(n,c));
		return valori;
	}
	
}
