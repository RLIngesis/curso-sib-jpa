package com.ingesis.cursoJpa;

import com.ingesis.cursoJpa.testContext.TestPersistenceContext;

public class CursoJpaSinLevantarSprigBoot {

	public static void main(String[] args) {
		CursoJpaSinLevantarSprigBoot cursoJpaApplication = new CursoJpaSinLevantarSprigBoot();
		cursoJpaApplication.testPersistenceContext();
	}
	
	private void testPersistenceContext() {
		TestPersistenceContext testPersistenceContext = new TestPersistenceContext("jpa-pu");
		testPersistenceContext.erroresDeIntegridad();
	}

	
}
