package com.cursos.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class RefrescoTest {

	@Test
	public void testReponerRefrescoCorrecto() {
		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		
		if(!refresco.reponer(10)) {
			fail("No se ha podido reponer");
		}
	}
	
	@Test
	public void testReponerRefrescoError() {
		Refresco refresco = new Refresco("Fanta", 1.8f, true, 0, 50, false);
		
		if(!refresco.reponer(-10)) {
			fail("No se ha podido reponer");
		}
	}
}
