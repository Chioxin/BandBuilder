package com.skilldistillery.bandbuilder.entitytests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.bandbuilder.entities.Band;
import com.skilldistillery.bandbuilder.entities.Instrument;

class InstrumentTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Instrument instrument;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("bandJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		instrument = em.find(Instrument.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		instrument = null;
		em.close();
	}

	@Test
	void test_instrument_mapping() {
		assertEquals("guitar", instrument.getName());
		assertTrue(instrument.isApproved());
		assertEquals(6, instrument.getImage().getId());
		assertEquals("This is a guitar", instrument.getDescription());
	}

}
