package br.com.fiap.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.bean.Animal;
import br.com.fiap.bean.Cachorro;

public class TesteColecoes {

	public static void main(String args[]) {
		
		//Criar uma lista de cachorro e adicionar 2 dogs
		List<Cachorro> lista = new ArrayList<Cachorro>();
		
		lista.add(new Cachorro(4, "Golden"));
		
		Cachorro c = new Cachorro(3, "Buldog");
		lista.add(c);
		
		//Exibir os elementos da lista
		for (int i = 0; i < lista.size(); i++ ) {
			System.out.println(lista.get(i).getEspecie() + " " + 
					lista.get(i).getMembros());
		}
		
		for (Cachorro dog : lista) {
			System.out.println(dog);
			//System.out.println(dog.getEspecie() + " " + dog.getMembros());
		}
		
		//Mapa (chave do tipo String e valor do tipo Cachorro)
		Map<String, Cachorro> mapa = new HashMap<String,Cachorro>();
		
		//Adicionar 2 cachorros no mapa
		mapa.put("dog1", new Cachorro(4, "Pitbull"));
		mapa.put("dog2", new Cachorro(4, "Pastor Alemao"));
		
		//Recuperar o cachorro da chave "dog1"
		
		c = mapa.get("dog1");
		System.out.println(c.getEspecie() + " " + c.getMembros());
	}
	
}




