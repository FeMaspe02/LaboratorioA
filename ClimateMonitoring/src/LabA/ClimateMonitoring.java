package LabA;
import java.io.*;
import java.util.*;

public class ClimateMonitoring {

	public static void main(String[] args) throws IOException {
		
		String fileUtenti = "/ClimateMonitoring/src/LabA/File/Utenti";
		
		
		//Sto provando se le mie funzioni funzionano (hehe lol)
		FileManager fm = new FileManager();
		//Utente u = new Utente();
		
		FileWriter fw = fm.openToWrite(fileUtenti, true);
		fw.write("prova");
		
		//u.registrazione();
		
		//hehe lol non funziona 
		
	}

}
