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
	
	
	private String fileSessione = "C:\\Users\\Huawei\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\Sessione";
	private String fileUtenti = "C:\\Users\\Huawei\\git\\LaboratorioA\\ClimateMonitoring\\src\\LabA\\File\\Utenti";
	
	//eh ma così questi hanno il path del mio computer.. non so se funziona su un altro
	
	// svuota il file sessione. Viene chiamato all'inizio del programma, per fare si che il file sessione sia vuoto
	//Viene riempito poi con i dati dell'utente che ha fatto login
	
	public Utente() {
		PrintWriter pw = fm.openToWrite(fileSessione, false);
		pw.print("");
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
	
	// check se e-mail è corretta
	
	public boolean checkMail(String mail) {
		
		boolean check = false;
		
		if(mail.contains("@") && mail.contains(".")) {
			check = true;
		}
		
		return check;
	}
	
	
	public void registrazione() {
		Scanner sc = new Scanner(System.in);
		System.out.println("REGISTRAZIONE NUOVO UTENTE /n /n");
		System.out.print("Inserire nome: ");
		this.nome = sc.next();
		
		System.out.print("Inserire cognome");
		this.cognome = sc.next();
		
		PrintWriter pw = fm.openToWrite(fileUtenti, true);
		pw.print(nome + "," + cognome);
		pw.flush();
		pw.close();
	}
	
	
	
}
