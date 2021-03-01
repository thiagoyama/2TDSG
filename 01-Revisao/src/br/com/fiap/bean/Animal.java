package br.com.fiap.bean;

public class Animal {

	//Modificadores de acesso: 
	//private -> somente a classe, 
	//protected -> a classe e todos na herança e no mesmo pacote, 
	//public -> todos,
	//default (package) -> a classe e todas do mesmo pacote.
	
	//Atributos:
	
	//Tipos primitivos: boolean, byte, short, int, long, float, double, char
	//Valores padrões: primitivo numérico = 0; boolean = false;
	// Referência (Classe) = null;
	
	private int membros;
	
	private String especie;
	
	private Sexo genero;
	
	//Construtores:
	
	public Animal(int membros, String especie) {
		this.membros = membros;
		this.especie = especie;
	}
	
	public Animal() {

	}
	
	//Métodos:
	
	public String fazerSom() {
		return "Som do animal";
	}
	
	public void comer() {
		System.out.println("Comendo..");
	}
	
	//Sobrecarga de métodos -> métodos com mesmo nome e parâmetros diferentes
	public void comer(String comida) {
		System.out.println("Comendo " + comida);
	}
	
	public void setMembros(int membros) {
		this.membros = membros;
	}
	
	public int getMembros() {
		return this.membros;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Sexo getGenero() {
		return genero;
	}

	public void setGenero(Sexo genero) {
		this.genero = genero;
	}
	
}
