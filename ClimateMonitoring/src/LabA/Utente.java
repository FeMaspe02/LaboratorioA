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
	
	 
//<<<<<<< HEAD
	private String fileSessione = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\Sessione.txt";
	private String fileUtenti = "C:\\Users\\david\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\Utenti.txt";
//=======
	//private String fileSessione = "ClimateMonitoring/src/LabA.File/Sessione.txt";
	//private String fileUtenti = "ClimateMonitoring/src/LabA.File/Utenti.txt";
	
	//eh ma cos� questi hanno il path del mio computer.. non so se funziona su un altro
//>>>>>>> branch 'master' of https://github.com/FeMaspe02/LaboratorioA.git
	
	// svuota il file sessione. Viene chiamato all'inizio del programma, per fare si che il file sessione sia vuoto
	//Viene riempito poi con i dati dell'utente che ha fatto login
	
	public Utente() throws IOException {
		PrintWriter pw = fm.openToWrite(fileSessione,false);
		pw.write("");
	}
	
	// costruttore classe Utente
	
	/*public Utente(String nome, String cognome, String codiceFiscale, String postaElettronica, String userid, String password) {
		 
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.postaElettronica = postaElettronica;
		this.userid = userid;
		this.password = password;
		
	}*/
	
	// check se e-mail � corretta
	
	public boolean checkMail(String mail) {
		
		boolean check = false;
		
		if(mail.contains("@") && mail.contains(".")) {
			check = true;
		}
		
		return check;
	}
	
	
	public void registrazione() throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("REGISTRAZIONE NUOVO UTENTE");
			System.out.println("\nInserire nome: ");
			this.nome = sc.next();
			
			System.out.println("Inserire cognome: ");
			this.cognome = sc.next();
		}
		
		PrintWriter bw = fm.openToWrite(fileUtenti,true);
		bw.write(nome + "," + cognome);
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	
	
	
}
