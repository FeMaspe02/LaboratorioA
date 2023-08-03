package LabA;
import java.io.*;
import java.util.*;

public class Utente {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String postaElettronica;
	private String userid;
	private String password;
	//centro di monitoraggio di afferenza
	private FileManager fm = new FileManager();
	
	
	private String fileSessione = "/ClimateMonitoring/src/LabA/File/Sessione";
	private String fileUtenti = "/ClimateMonitoring/src/LabA/File/Utenti";
	
	// svuota il file sessione. Viene chiamato all'inizio del programma, per fare si che il file sessione sia vuoto
	//Viene riempito poi con i dati dell'utente che ha fatto login
	
	public Utente() {
		PrintWriter pw = fm.openToWrite(fileSessione, false);
		pw.print("");
	}
	
}
