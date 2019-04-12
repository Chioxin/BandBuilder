package com.skilldistillery.bandbuilder.entitytests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.bandbuilder.entities.UserInstrument;

class UserInstrumentTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserInstrument userInstrument;
	
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
		userInstrument = em.find(UserInstrument.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		userInstrument = null;
		em.close();
	}

	@Test
	void test_user_instrument_mapping() {
		assertEquals(1, userInstrument.getProfile().getId());
		assertEquals("Expert", userInstrument.getExperience());
		assertEquals("This is the description for the guitarest", userInstrument.getDescription());
		assertThat(userInstrument.getInstrument().isEmpty(), is(false));
	}

}
