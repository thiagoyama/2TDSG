package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Teste.java (source) -> compila -> Teste.class (class) -> interpretar na JVM (execução)

//Define até que parte a anotação estará presente 
//SOURCE -> código
//CLASS -> compilação
//RUNTIME -> Execução
@Retention(RetentionPolicy.RUNTIME)

//Define a anotação para atributos e métodos
@Target({ElementType.FIELD,ElementType.METHOD}) 
public @interface Coluna {

	String nome();
	boolean obrigatorio() default false;
	
	
}