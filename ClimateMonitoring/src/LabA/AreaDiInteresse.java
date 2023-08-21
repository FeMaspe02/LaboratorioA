package LabA;

import java.io.IOException;
import java.util.LinkedList;

public class AreaDiInteresse {
	
	 private String nome;
	 private String stato;
	 private Double latitudine; 
	 private Double longitudine;
	 private int Vento;
	 private int Umidità;
	 private int Pressione;
	 private int Temperatura;
	 private int Precipitazioni;
	 private int AltitudineDeiGhiacciai;
	 private int MassaDeiGhiacciai;

	 
	 public AreaDiInteresse (String nome,String stato,Double latitudine,Double longitudine) {
		 this.nome = nome;
		 this.stato = stato;
		 this.latitudine = latitudine;
		 this.longitudine = longitudine; 
	 }
	 
	 
	// public void visualizzaAreaGeografica(String nome, int n) throws IOException {
		// AccessManager a = new AccessManager();
			//LinkedList<AreaDiInteresse> lista = a.cercaAreaGeografica(nome);
			//AreaDiInteresse area = lista.get(n);
			//System.out.print(area.Vento);
	 //}

}
