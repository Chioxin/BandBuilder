package com.skilldistillery.bandbuilder.services;

import java.util.List;

import com.skilldistillery.bandbuilder.datatransferobjects.BandDTO;
import com.skilldistillery.bandbuilder.entities.Band;

public interface BandService {
	
	public List<Band> getAllBands();
	public Band getBandById(int id);
	public List<Band> getAllBandsByUserUsername(String user);
	public Band createBand(BandDTO dto);
	public Band updateBandById(int id, Band band);
	public Boolean deleteBandById(int id);

}
