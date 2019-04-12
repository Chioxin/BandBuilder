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

import com.skilldistillery.bandbuilder.entities.BandMember;

class BandMemberTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private BandMember bandMember;

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
		bandMember = em.find(BandMember.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		bandMember = null;
		em.close();
	}

	@Test
	void test_band_member_mapping() {
		assertEquals(1, bandMember.getBand().getId());
		assertEquals(1, bandMember.getInstrument().getId());
		assertEquals(1, bandMember.getProfile().getId());
		assertEquals("This is the lead Guitar Player", bandMember.getDescription());
		assertEquals("Expert", bandMember.getExperience());
		
		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);

		assertEquals("2019-04-01 22:38:48",
				sdf.format(bandMember.getCreatedAt()) + " " + sdf2.format(bandMember.getCreatedAt()));
		assertEquals("2019-04-01 22:38:48",
				sdf.format(bandMember.getJoinedAt()) + " " + sdf2.format(bandMember.getJoinedAt()));
	}

}
