package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.datatransferobjects.InstrumentDTO;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.repositories.InstrumentRepository;

public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepo;
	
	@Override
	public List<Instrument> getAllInstruments() {
		return instrumentRepo.findAll();
	}

	@Override
	public Instrument getInstrumentById(int id) {
		Instrument instrument = null;
		
		Optional<Instrument> opt = instrumentRepo.findById(id);
		if (opt.isPresent()) {
			instrument = opt.get();
		}
		
		return instrument;
	}

	@Override
	public Instrument createInstrument(InstrumentDTO instrumentInfo) {
		// Can't do this until image is built.
		return null;
	}

	@Override
	public Instrument updateInstrument(int id, Instrument instrument) {
		Instrument managed = null;
		
		Optional<Instrument> opt = instrumentRepo.findById(id);
		if (opt.isPresent()) {
			managed = opt.get();
			managed.setApproved(instrument.isApproved());
			managed.setDescription(instrument.getDescription());
			managed.setImage(instrument.getImage());
			managed.setName(instrument.getName());
		}
		
		return managed;
	}

	@Override
	public Boolean deleteInstrument(int id) {
		Boolean deleted = false;
		
		Optional<Instrument> opt = instrumentRepo.findById(id);
		if (opt.isPresent()) {
			Instrument managed = opt.get();
			managed.setApproved(false);
			deleted = true;
		}
		
		return deleted;
	}

}
