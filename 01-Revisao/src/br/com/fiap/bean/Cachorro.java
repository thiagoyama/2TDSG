package br.com.fiap.bean;

public class Cachorro extends Animal {

	//Construtor não é herdado (herdado somente atributos e métodos)
	public Cachorro(int membros, String especie) {
		super(membros, especie);
	}
	
	public Cachorro() {}
	
	//Sobrescrita de método
	@Override
	public String fazerSom() {
		return "Au au";
	}
	
	//Sobrescrever o método toString() (Utilizado no print do objeto)
	@Override
	public String toString() {
		return getEspecie() + " - " + getMembros();
	}
	
	// Animal a = new Animal();
	// a.fazerSom(); -> "Som do animal";
	
	// Cachorro c = new Cachorro();
	// c.fazerSom(); -> "Au au";
	
	// Animal a1 = new Cachorro();
	// a1.fazerSom(); -> "Au au";
	
	// Cachorro c1 = new Animal(); 
	// Não compila!
	
}
