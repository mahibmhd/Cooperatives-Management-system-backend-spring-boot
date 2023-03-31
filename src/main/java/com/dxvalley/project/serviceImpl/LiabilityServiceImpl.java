package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.repositories.LiabilityRepository;
import com.dxvalley.project.services.LiabilityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LiabilityServiceImpl implements LiabilityService{
    @Autowired
    private final LiabilityRepository liabilityRepository;
    @Override
    public Liabilty addLiabilty(Liabilty liabilty) {
       return liabilityRepository.save(liabilty);
    }

    @Override
    public Liabilty editLiabilty(Liabilty liabilty) {
        return liabilityRepository.save(liabilty);
    }

    @Override
    public List<Liabilty> getLiabilties() {
        return liabilityRepository.findAll();
    }

    @Override
    public Liabilty getLiabiltyById(Long liabiltyId) {
        return liabilityRepository.findLiabiltyByLiabilityId(liabiltyId);
    }

    @Override
    public void deleteLiabilty(Long liabiltyId) {
        liabilityRepository.deleteById(liabiltyId);
    }
    
}
