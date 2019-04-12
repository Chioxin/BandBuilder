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

import com.skilldistillery.bandbuilder.entities.SocialMedia;

@DisplayName("Social Media Entity Test")
class SocialMediaTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private SocialMedia socialMedia;

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
		socialMedia = em.find(SocialMedia.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		socialMedia = null;
		em.close();
	}

	@Test
	void test_social_media_test() {
		assertEquals("http://cofarming.info/wp-content/uploads/2017/01/facebook-icon-preview-1-400x400.png", socialMedia.getImageURL() );
		assertEquals("facebook ", socialMedia.getName());
	}

}
