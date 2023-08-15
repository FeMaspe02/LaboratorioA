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
	
	private String fileSessione = "ClimateMonitoring/bin/LabA/File/Sessione.txt";
	private String fileUtenti = "ClimateMonitoring/bi/LabA/File/utenti.txt";

	//svuota il file sessione. Viene chiamato all'inizio del programma, per fare si che il file sessione sia vuoto
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
		
		String s = new String("");
		Boolean c = false;
		/*String check = new String("");
		Boolean controllo = false;*/
		
			Scanner sc = new Scanner(System.in);
			System.out.println("REGISTRAZIONE NUOVO UTENTE");
			System.out.println("\nInserire nome: ");
			nome = sc.nextLine();
			
			System.out.println("Inserire cognome: ");
			cognome = sc.nextLine();
			
			System.out.println("Inserire Codice Fiscale");
			codiceFiscale = sc.nextLine();
			
			while(c == false ) {
				System.out.println("Inserire indirizzo di posta elettronica valido");
				s = sc.nextLine();
				c = checkMail(s);
			}
			postaElettronica = s;
		//sc.close();
			
		PrintWriter bw = fm.openToWrite(fileUtenti,true);
		bw.write(nome + "," + cognome + "," + codiceFiscale + "," + postaElettronica);
		bw.write("\n");
		bw.flush();
		bw.close();
		
		
	}
	
	
	
}
