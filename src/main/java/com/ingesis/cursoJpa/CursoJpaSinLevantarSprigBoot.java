package com.ingesis.cursoJpa;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingesis.cursoJpa.logic.ClienteLogic;
import com.ingesis.cursoJpa.testContext.TestPersistenceContext;

public class CursoJpaSinLevantarSprigBoot {

	public static void main(String[] args) {
		CursoJpaSinLevantarSprigBoot cursoJpaApplication = new CursoJpaSinLevantarSprigBoot();
		cursoJpaApplication.testPersistenceContext();
	}
	
	private void testPersistenceContext() {
		TestPersistenceContext testPersistenceContext = new TestPersistenceContext("jpa-pu");

		testPersistenceContext.probarLazyAndEagerLoading();
//		testPersistenceContext.probandoEstadoManagedConTranaccion();
//		testPersistenceContext.probandoEstadoManagedSinTranaccion();
//		testPersistenceContext.probandoEstadoManagedTranaccionPosterior();
//		testPersistenceContext.probandoFlushExplicitoSinTransaccion();

		
	}
}
