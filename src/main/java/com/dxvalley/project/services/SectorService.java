package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Sector;

public interface SectorService {
    Sector addSector (Sector sector);
    Sector editsector (Sector sector);
    List<Sector> getSectors ();
    Sector getSectorById(Long sectorId);
    void deleteSector( Long sectorId);
}
