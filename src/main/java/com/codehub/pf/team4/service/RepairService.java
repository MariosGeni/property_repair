package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;

import java.util.List;
import java.util.Optional;

public interface RepairService {

    List<Repair> getAllRepairs();

    Optional<Repair> getRepairById(Long id);

    Optional<Repair> postRepair(Repair newRepair);

    Optional<Repair> updateRepair(Repair toBeUpdatedRepair);

    void deleteRepairById(Long repairId);

    List<Repair> getRepairByUserAfm(Integer afm);


}
