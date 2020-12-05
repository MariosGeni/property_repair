package com.codehub.pf.team4.Property_Repairs.service;

import com.codehub.pf.team4.Property_Repairs.Tables.Repair;
import com.codehub.pf.team4.Property_Repairs.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    @Override
    public Optional<Repair> getRepairById(java.lang.Long id) {
        return repairRepository.findById(id);
    }

    @Override
    public Optional<Repair> postRepair(Repair newRepair) {
        return Optional.of(repairRepository.save(newRepair));
    }

    @Override
    public Optional<Repair> updateRepair(Repair toBeUpdatedRepair) {
        Long repairId = toBeUpdatedRepair.getId();
        if( repairId == null || getRepairById(repairId).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(repairRepository.save(toBeUpdatedRepair));
    }

    @Override
    public void deleteRepairById(Long repairId) {
        if(repairId == null || getRepairById(repairId).isEmpty()){
            System.out.println("User not found");
            return;
        }
        repairRepository.deleteById(repairId);
    }

    @Override
    public List<Repair> getRepairByUserAfm(Integer afm) {
        return repairRepository.findAllByAfm(afm);
    }
}
