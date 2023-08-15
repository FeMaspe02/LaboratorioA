package LabA;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ClimateMonitoring {

	public static void main(String[] args) throws IOException {
	
		AccessManager a = new AccessManager();
		Utente u = new Utente();
		Scanner sc = new Scanner(System.in);
		String Scelta;
		
		do {
			System.out.println("Digitare l'azione che si vuole compiere");
			Scelta = sc.nextLine();
			Scelta = Scelta.toLowerCase();
			
		switch(Scelta) {
		 	case("registrazione"):{
		 		u.registrazione();
		 		break;
		 		}
		 	case("ricerca per nome"):{
		 		System.out.println("Ricerca per nome");
				System.out.print("Inserire nome: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
				String nome = br.readLine();
				a.cercaAreaGeografica(nome);
		 	}
		 		break;
		 	case("ricerca per coordinate"):{
		 		System.out.println("Ricerca per coordinate geografiche");
				System.out.print("Inserire latitudine: ");
				String Latitudine = sc.next();
				double lat = Double.parseDouble(Latitudine);
				
				System.out.print("Inserire longitudine: ");
				String Longitudine = sc.next();
				double lon = Double.parseDouble(Longitudine);
				
				a.cercaAreaGeografica(lat,lon);
				
		 	}
		 	break;
		 	case("terminato"): Scelta = "terminato";
		 					break;
		 	default: if (Scelta != "terminato") System.out.println("Digitare un'operazione valida");
		 }
		}while(Scelta != "terminato");
		sc.close();					
		}
	}