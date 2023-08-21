package LabA;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ClimateMonitoring {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Per REGISTRAZIONE premere 1");
		System.out.println("Per LOGIN premere 2");
		System.out.println("Per ACCESSO COME OSPITE premere 3");
		String input = sc.nextLine();
			switch(input) {
			case ("1"): {Utente u = new Utente(); 
						u.registrazione();
						} break;
			case ("2"): {Utente u = new Utente(); 
						//u.login();
						} break;
			case ("3"): {System.out.println("Per eseguire una RICERCA PER NOME premere 1");
						 System.out.println("Per eseguire una RICERCA PER COORDINATE premere 2");
						 input = sc.nextLine();
						 switch(input) {
						 case("1"): {AccessManager a = new AccessManager();
						 			 System.out.print("Inserire il nome da cercare : ");
						 			 String nome = sc.nextLine();
						 			 a.cercaAreaGeografica(nome);
						 			}break;
						 case("2"): {AccessManager a = new AccessManager();
			 			 			System.out.print("Inserire Latitudine : ");
			 			 			double latitudine = Double.parseDouble(sc.nextLine());
			 			 			System.out.print("Inserire Longitudine : ");
			 			 			double longitudine = Double.parseDouble(sc.nextLine());
			 			 			a.cercaAreaGeografica(latitudine, longitudine);
			 			        	}break;
						 }
			}
			}
		}
	}