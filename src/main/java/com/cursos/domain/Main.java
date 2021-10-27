package com.cursos.domain;

public class Main {

	public static void main(String[] args) {
		
		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 100, true);
	}

}
