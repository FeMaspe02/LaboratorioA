package LabA;
import java.io.*;
import java.util.*;

public class ClimateMonitoring {

	public static void main(String[] args) throws IOException {
		
		//String fileUtenti = new String("C:\Users\Huawei\git\LaboratorioA\ClimateMonitoring\src\LabA\File\Utenti");
		//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH
		
		
		//Sto provando se le mie funzioni funzionano (hehe lol)
		
		Utente u = new Utente();
		u.registrazione();
		
		//OK PIU O MENO FUNZIONA
		
		AccessManager a = new AccessManager();
			Scanner sc = new Scanner(System.in);
			System.out.println("Ricerca per nome");
			System.out.print("Inserire nome: ");
			String nome = sc.nextLine();
			
			System.out.println("Ricerca per coordinate geografiche");
			System.out.print("Inserire latitudine: ");
			String latitudine = sc.next();
			
			System.out.print("Inserire longitudine: ");
			String longitudine = sc.next();
			
			a.cercaAreaGeografica(nome);
			a.cercaAreaGeografica(latitudine,longitudine);
			sc.close();
	}

}
