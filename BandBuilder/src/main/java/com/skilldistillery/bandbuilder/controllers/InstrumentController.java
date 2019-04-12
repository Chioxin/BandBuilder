package com.skilldistillery.bandbuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bandbuilder.datatransferobjects.NewInstrumentDTO;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.services.InstrumentService;

@RestController
@RequestMapping("api")
//@CrossOrigin({ "*", "http://localhost:4200" })
public class InstrumentController {

	@Autowired
	private InstrumentService instrumentSvc;
	
	@GetMapping("instruments")
	public List<Instrument> getInstruments() {
		return instrumentSvc.getAllInstruments();
	}
	
	@GetMapping("instruments/{iid}")
	public Instrument getInstrumentById(@PathVariable("iid") Integer id,
			HttpServletResponse resp) {
		
		Instrument instrument = instrumentSvc.getInstrumentById(id);
		
		if (instrument == null) {
			resp.setStatus(404);
		}
		return instrument;
	}
	
	@PostMapping("instruments")
	public Instrument createNewInstrument(@RequestBody NewInstrumentDTO instrumentInfo,
			HttpServletResponse resp,
			HttpServletRequest req) {
		Instrument instrument = instrumentSvc.createInstrument(instrumentInfo);
		
		if (instrument != null) {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/");
			url.append(instrument.getId());
			resp.setHeader("Location", url.toString());
		} else {
			resp.setStatus(400);
		}
		return instrument; 
	}
	
	@PutMapping("instruments/{iid}")
	public Instrument updateInstrument(@PathVariable("iid") Integer id, @RequestBody Instrument instrument) {
		
		
		return instrument;
	}
	
}
