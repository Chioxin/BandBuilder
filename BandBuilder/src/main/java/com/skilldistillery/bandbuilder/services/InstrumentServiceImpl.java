package com.skilldistillery.bandbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bandbuilder.datatransferobjects.InstrumentDTO;
import com.skilldistillery.bandbuilder.entities.Image;
import com.skilldistillery.bandbuilder.entities.Instrument;
import com.skilldistillery.bandbuilder.repositories.ImageRepository;
import com.skilldistillery.bandbuilder.repositories.InstrumentRepository;

public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepo;
	
	@Autowired
	private ImageRepository imageRepo;
	
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
		
		// Building Image
		Image image = new Image();
		image.setUrl(instrumentInfo.getImageURL());
		image.setAlt(instrumentInfo.getImageAlt());
		image.setDescription(instrumentInfo.getImageDescription());
		image = imageRepo.saveAndFlush(image);
		
		// Build Instrument
		Instrument instrument = new Instrument();
		instrument.setName(instrumentInfo.getInstrumentName());
		instrument.setDescription(instrumentInfo.getInstrumentDescription());
		instrument.setApproved(instrumentInfo.isInstrumentApproved());
		instrument.setActive(true);
		instrument.setImage(image);
		
		return instrumentRepo.saveAndFlush(instrument);
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
