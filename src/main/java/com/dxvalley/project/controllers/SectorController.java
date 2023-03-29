package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.Sector;
import com.dxvalley.project.services.SectorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sector")
public class SectorController {
    @Autowired
    private final SectorService sectorService;
    
    @GetMapping("/getSectors")
    List<Sector> getSector() {
    return this.sectorService.getSectors();
  }

  @GetMapping("/{sectorId}")
  Sector getSector(@PathVariable Long sectorId) {
    return sectorService.getSectorById(sectorId);
  }

  @PostMapping("/add")
  Sector addSector(@RequestBody Sector sector) {
    return sectorService.addSector(sector);
  }

  @PutMapping("/edit/{sectorId}")
  Sector editSector(@RequestBody Sector tempSector, @PathVariable Long sectorId) {
    Sector sector = this.sectorService.getSectorById(sectorId);
    sector.setName(tempSector.getName());
    return sectorService.editsector(sector);
  }

//   @DeleteMapping("/delete/{sectorId}")
//   void deleteSector(@PathVariable Long sectorId) {
//     sectorService.deleteSector(sectorId);
//   }
}
