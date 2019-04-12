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

import com.skilldistillery.bandbuilder.entities.Image;

@DisplayName("Image Entity Test")
class ImageTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Image image;
	
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
		image = em.find(Image.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		image = null;
	}

	@Test
	void test_image_mapping() {
		assertEquals("http://electricguitarhub.com/wp-content/uploads/2014/07/Best-guitarists-to-learn-from-tommy-.png", image.getUrl());
		assertEquals("justin the guitarest image", image.getAlt());
		assertEquals("This is an image of Justin the Guitarest", image.getDescription());
	}

}
