package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.datatransferobjects.NewInstrumentDTO;
import com.skilldistillery.bandbuilder.entities.Instrument;

public interface InstrumentService {
	
	List<Instrument> getAllInstruments();
	Instrument getInstrumentById(int id);
	Instrument createInstrument(NewInstrumentDTO instrumentDTO);
	Instrument updateInstrument(int id, Instrument instrument);
	Boolean deleteInstrument(int id);

}
