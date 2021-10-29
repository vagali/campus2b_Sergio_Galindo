package com.cursos.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaRefrescosTest {

	@Test
	public void testComprar() {
		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 10, false), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 100f, true);
		
		if (!maquina.comprar(10, refrescos[0])) {
			fail("no se ha podido comprar");
		}
	}

	@Test
	public void testComprarNoHayStock() {

		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, false, 0, 0, true),
				new Refresco("Cola", 1.80f, false, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 100f, true);
		if (maquina.comprar(15, refrescos[1]))
			fail("No Deberia de haber stock");
		
	
	}

	@Test
	public void testComprarNoHayCambio() {

		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 0, false);

		if (maquina.comprar(15, refrescos[0]))
			fail("No se deberia de poder comprar si no hay cambio");
	}

	@Test
	public void testComprarSinEfectivoNecesario() {

		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 250, false);

		if (maquina.comprar(0.1f, refrescos[2]))
			fail("No se puede comprar sin efectivo suficiente");
	}

	@Test
	public void testRetirarCambioDeLaMaquinaCorrecto() {
		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 250, false);

		if (!maquina.retirarCambio(50)) {
			fail("Vaya. no se ha podido retirar cambio.");
		}
	}

	@Test
	public void testRetirarCambioDeLaMaquinaError() {
		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 100, false);

		if (maquina.retirarCambio(550)) {
			fail("No se deberia poder retirar cambio");
		}
	}

	@Test
	public void testMostrarEstadoActualCorrecto() {
		Refresco[] refrescos = { new Refresco("Fanta", 1.56f, true, 0, 10, false),
				new Refresco("Cola", 1.80f, true, 0, 0, true), new Refresco("Pepsi", 1.96f, true, 0, 10, false) };
		MaquinaRefrescos maquina = new MaquinaRefrescos(refrescos, 250, false);

		if (maquina.getEstadoActual() == null)
			fail("No se ha podido mostrar su estado actual");
		else {
			for (String estado : maquina.getEstadoActual()) {
				System.out.println(estado);
			}
		}

	}
}
