package br.com.fiap.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {
		
		//Criar um objeto de Data com a data atual (Calendar)
		Calendar hoje = Calendar.getInstance(); //Retorna o objeto com a data atual
		
		//Criar um objeto de Data com uma data específica (ano, mês, dia)
		Calendar challenge = new GregorianCalendar(2021, Calendar.MAY, 25);
		
		//Formatador de data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Exibir a data atual formatado
		System.out.println(formatador.format(hoje.getTime()));
		
		//Exibir a data da challenge 
		System.out.println(formatador.format(challenge.getTime()));
		
	}
	
}