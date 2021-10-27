package com.cursos.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaTest {

	@Test
	public void testComprarCorrecto() {

		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 100, true);

		if (!maquina.comprar(15))
			fail("Vaya no se ha podido efectuar la compra.");
	}

	@Test
	public void testComprarNoHayStock() {

		Refresco refresco = new Refresco("Fanta", 1.8f, false, 0, 0, false);
		Maquina maquina = new Maquina(refresco, 100, true);

		if (!maquina.comprar(15))
			fail("Lo sentimos, no hay stock disponible.");
	}

	@Test
	public void testComprarNoHayCambio() {

		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 0, false);

		if (!maquina.comprar(15))
			fail("Lo sentimos, no hay cambio disponible.");
	}

	@Test
	public void testComprarSinEfectivoNecesario() {

		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 100, true);

		if (!maquina.comprar(0.1f))
			fail("Vaya no se ha podido efectuar la compra.");
	}
	
	@Test
	public void testRetirarCambioDeLaMaquinaCorrecto() {
		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 250, true);
		
		if(!maquina.retirarCambio(50)) {
			fail("Vaya. no se ha podido retirar cambio.");
		}
	}
	
	@Test
	public void testRetirarCambioDeLaMaquinaError() {
		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 250, true);
		
		if(!maquina.retirarCambio(160)) {
			fail("Vaya. no se ha podido retirar cambio.");
		}
	}
	
	@Test
	public void testMostrarEstadoActualCorrecto() {

		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		Maquina maquina = new Maquina(refresco, 100, true);

		if (!maquina.getEstadoActual().contains("Numero del producto disponibles"))
			fail("No se ha podido mostrar su estado actual");
		else
			System.out.println(maquina.getEstadoActual());
	}
	
}
