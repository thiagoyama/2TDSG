package br.com.fiap.main;

import br.com.fiap.bean.Cachorro;
import br.com.fiap.bean.Sexo;

public class TesteEnum {

	public static void main(String[] args) {
		//Instanciar um cachorro
		Cachorro dog = new Cachorro(4, "Vira-Lata");
		
		//Atribuir um sexo para o dog
		dog.setGenero(Sexo.MACHO);
		
		//Testar se o dog é femea
		if (dog.getGenero() == Sexo.FEMEA)
			System.out.println("O dog é fêmea");
		else
			System.out.println("O dog é macho");
		
		
	}
	
}