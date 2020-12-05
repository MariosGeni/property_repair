package com.codehub.pf.team4.Property_Repairs.service;

import com.codehub.pf.team4.Property_Repairs.Tables.Repair;

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
