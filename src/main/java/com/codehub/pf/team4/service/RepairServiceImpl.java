package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.utils.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Repair> getOngoingRepairsOfTheDay() throws Exception{
        return repairRepository.findByDateIsBetweenAndStateEquals(DateProvider.getEndOfDay(), DateProvider.getEndOfDay(), State.ONGOING);
        /* return repairRepository.findAll().stream()
                .filter(repair -> isToday(repair.getDate(), now))
                .filter(repair -> repair.getState() == State.ONGOING)
                .collect(Collectors.toList()); */
    }

    @Override
    public Optional<Repair> postRepair(Repair newRepair) {
        return Optional.of(repairRepository.save(newRepair));
    }

    @Override
    public Optional<Repair> updateRepair(Repair toBeUpdatedRepair) {
        Long repairId = toBeUpdatedRepair.getId();
        if (repairId == null || getRepairById(repairId).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(repairRepository.save(toBeUpdatedRepair));
    }

    @Override
    public void deleteRepairById(Long repairId) {
        if (repairId == null || getRepairById(repairId).isEmpty()) {
            System.out.println("User not found");
            return;
        }
        repairRepository.deleteById(repairId);
    }
}
