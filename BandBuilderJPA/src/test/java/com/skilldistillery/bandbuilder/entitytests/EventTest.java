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

import com.skilldistillery.bandbuilder.entities.Event;

class EventTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Event event;
	
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
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		event = null;
	}

	@Test
	void test_event_mapping() {
		assertEquals(7, event.getAddress().getId());
		assertEquals(1, event.getBand().getId());
		assertEquals("What starts out as yearning soon becomes manipulated into a carnival of distress, leaving only a sense of unreality and the chance of a new synthesis.", event.getDescription());
		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);

		assertEquals("2019-04-11 09:38:48",
				sdf.format(event.getCreatedAt()) + " " + sdf2.format(event.getCreatedAt()));
		assertEquals("2019-04-11 09:38:48",
				sdf.format(event.getUpdatedAt()) + " " + sdf2.format(event.getUpdatedAt()));
		
		assertEquals("2019-04-26 20:00:00",
				sdf.format(event.getStartDate()) + " " + sdf2.format(event.getStartDate()));
		assertEquals("2019-04-26 22:00:00",
				sdf.format(event.getEndDate()) + " " + sdf2.format(event.getEndDate()));

	}

}
