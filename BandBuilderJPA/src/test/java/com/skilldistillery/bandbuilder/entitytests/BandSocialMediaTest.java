package com.skilldistillery.bandbuilder.entitytests;

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

import com.skilldistillery.bandbuilder.entities.BandSocialMedia;

@DisplayName("Band Social Media Entity Test")
class BandSocialMediaTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private BandSocialMedia bandSocialMedia;

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
		bandSocialMedia = em.find(BandSocialMedia.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		bandSocialMedia = null;
		em.close();
	}

	@Test
	void test_band_social_media_mapping() {
		assertEquals("facebook ", bandSocialMedia.getSocialMedia().getName());
		assertEquals(1, bandSocialMedia.getBand().getId());
		assertEquals("https://www.facebook.com/bandpage/", bandSocialMedia.getUrl());
	}

}
