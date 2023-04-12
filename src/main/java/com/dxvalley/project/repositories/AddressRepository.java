package com.dxvalley.project.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Address;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByAddressId (Long addressId);
    Address findAddressByPhoneNumber(String phoneNumber);
    // List<Address> findAddressByUnion(Unions union);
    // List<Address> findAddressByPrCooperative(PrCooperative prCooperative);
    
}
