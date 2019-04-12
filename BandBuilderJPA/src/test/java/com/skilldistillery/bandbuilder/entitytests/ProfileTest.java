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

import com.skilldistillery.bandbuilder.entities.Profile;

@DisplayName("Profile Entity Test")
class ProfileTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Profile profile;
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
		profile = em.find(Profile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		profile = null;
		em.close();
	}

	@Test
	void test_profile_mapping() {
		assertEquals(1, profile.getId());
		assertEquals("justin ", profile.getFirstName());
		assertEquals("blake", profile.getLastName());
		assertEquals("biebs@gmail.com", profile.getEmail());
		assertEquals("I have played the guitar since I was a small boy. My first guitar was gifted to me by my grandfather who was also a guitarest. ", profile.getAboutMe());
		assertEquals(1, profile.getAddress().getId());
		assertEquals(1, profile.getImage().getId());
//		assertEquals(1, profile.getImage().getId());
		
		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);

		assertEquals("2019-04-01 22:08:48",
				sdf.format(profile.getCreatedAt()) + " " + sdf2.format(profile.getCreatedAt()));
		assertEquals(1, profile.getUser().getId());
	}

}
