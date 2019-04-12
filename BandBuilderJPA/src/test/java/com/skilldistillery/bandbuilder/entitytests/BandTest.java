package com.skilldistillery.bandbuilder.entitytests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.bandbuilder.entities.Band;

@DisplayName("Band Entity Test")
class BandTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Band band;
	
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
		band = em.find(Band.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		band = null;
		em.close();
	}

	@Test
	void test_band_mapping() {
		assertEquals(1, band.getId());
		assertEquals("Piss-ant Graphite", band.getName());
		assertEquals("What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.", band.getAboutUs());
		assertEquals("Rock", band.getGenre());
		assertEquals(6, band.getAddress().getId());
		assertEquals("thegarageband@gmail.com", band.getEmail());
		assertEquals("Test", band.getTimeCommitment());
		assertEquals("Test", band.getTimeCommitment());
		
		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);

		assertEquals("2019-04-01 22:38:48",
				sdf.format(band.getCreatedAt()) + " " + sdf2.format(band.getCreatedAt()));
		assertEquals("2019-04-01 22:38:48",
				sdf.format(band.getUpdatedAt()) + " " + sdf2.format(band.getUpdatedAt()));
		assertTrue(band.getImages().get(0).getId() > 0);
	}

}
