package LabA;
import java.io.*;

public class AccessManager {
	
	private String FileCentro = "ClimateMonitoring/bin/LabA/File/CentroMonitoraggio.dati.CSV";
	private FileManager fm = new FileManager();

	public AccessManager() {
		
	}
	
	//Metodo che riceve in input una string che puo' essere un nome di un'area di interesse 
	//o una parte di esso e restituisce TUTTE le aree di interesse che contengono data stringa nel loro nome
	public void cercaAreaGeografica(String NomeParz) throws IOException {
			
			int Size = NomeParz.length();
			String nomeparz = NomeParz.toLowerCase();
			BufferedReader br = fm.openToRead(FileCentro);
			String Riga = br.readLine();
			int c = 0;
			
			do{		
				 
				boolean Trovato = false;
				int i = 0;;
				
				if(Size>= Riga.length()){
					System.err.println("Stringa tropppo lunga, riprovare nuovamente");
					break;
				}
				
				while(!(Riga.charAt(i++)== ';')) {}
					int n = i;
					String nome = Riga.substring(0,i).toLowerCase();
				while(!(Riga.charAt(i++)== ';')) {}	
					String stato = Riga.substring(n,i).toLowerCase();
					System.out.println(nome);
					System.out.println(stato);
					
						/*if(nome.equals(n) && !Trovato) {
							System.out.println(nome);
							Trovato = true;
							c++;
						}
						else {i++;}
						
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
					
				
				Riga = br.readLine();*/
				
				}while(Riga!=null);
			//if (c == 0) System.out.println("Non ci sono riscontri positivi per l'input immesso");
			//br.close(); */
	}	
	
	//Metodo che riceve in ingresso latitudine e longitudine e restituisce l'area di interesse con date coordinate
	
	public void cercaAreaGeografica(double Latitudine, double Longitudine) throws IOException {
		
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
				
				double fileLat = Double.parseDouble(Riga.substring(i,i+3));
					if(Latitudine - 5 <= fileLat && fileLat <= Latitudine +5 ) {{
						TrovataLat = true;
					}
					
				while(Riga.charAt(i) != ',') i++;
					
				double fileLon = Double.parseDouble(Riga.substring(i+2,i+5));
						if(Longitudine - 5 <= fileLon && fileLon <= Longitudine +5 && TrovataLat) {	
						System.out.println(Riga);
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
