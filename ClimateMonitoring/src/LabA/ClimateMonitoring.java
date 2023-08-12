package LabA;
import java.io.*;
import java.util.*;

public class ClimateMonitoring {

	public static void main(String[] args) throws IOException {
	
		AccessManager a = new AccessManager();
		Utente u = new Utente();
		Scanner sc = new Scanner(System.in);
		String Scelta = null;
		
		while(Scelta!="terminato") {
			System.out.println("Digitare l'azione che si vuole compiere");
			Scelta = sc.nextLine();
			Scelta = Scelta.toLowerCase();
		switch(Scelta) {
		 	case("registrazione"):
		 		u.registrazione();
		 	break;
		 	case("ricerca per nome"):{
		 		System.out.println("Ricerca per nome");
				System.out.print("Inserire nome: ");
				String nome = sc.nextLine();
				a.cercaAreaGeografica(nome);
		 	}
		 	break;
		 	case("ricerca per coordinate"):{
		 						System.out.println("Ricerca per coordinate geografiche");
				System.out.print("Inserire latitudine: ");
				String Latitudine = sc.nextLine();
				
				System.out.print("Inserire longitudine: ");
				String Longitudine = sc.nextLine();
				
				
				a.cercaAreaGeografica(Latitudine,Longitudine);
		 	}
		 	break;
		 	default: System.out.println("Digitare un'operazione valida");
		 }
		}		
		sc.close();					
		}
	}