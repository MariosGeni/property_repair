package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.mappers.RepairFormMapper;
import com.codehub.pf.team4.mappers.RepairMapper;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.repository.UserRepository;
import com.codehub.pf.team4.utils.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<RepairModel> getAllRepairs() {
        return repairRepository.findAll()
                .stream()
                .map(RepairMapper::mapToRepairModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RepairModel> getRepairById(Long id) {
        return RepairMapper.mapToRepairModelOptional(repairRepository.findById(id).orElse(null));
    }

    @Override
    public List<RepairModel> getOngoingRepairsOfTheDay() throws Exception {
        return repairRepository.findByDateAndState(DateProvider.getToday(), State.ONGOING)
                .stream()
                .map(RepairMapper::mapToRepairModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> getRepairsByDate(String date) {
        LocalDate localDate = DateProvider.getLocalDate(date);
        return repairRepository.findByDate(localDate)
                .stream()
                .map(RepairMapper::mapToRepairModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RepairModel> addRepair(RepairForm newRepair) throws Exception {
        Repair repair = RepairFormMapper.mapToRepair(newRepair);
        repair.setUser(userRepository.findById(repair.getUser().getId()).get());
        return RepairMapper.mapToRepairModelOptional(repairRepository.save(repair));
    }

    @Override
    public Optional<RepairModel> updateRepair(RepairForm toBeUpdatedRepair) {
        try {
            Repair theRepair = RepairFormMapper.mapToRepair(toBeUpdatedRepair);
            return RepairMapper.mapToRepairModelOptional(repairRepository.save(theRepair));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteRepairById(Long repairId) {
        if (repairId == null || getRepairById(repairId).isEmpty()) {
            System.out.println("User not found");
            return false;
        }

        repairRepository.deleteById(repairId);
        return true;
    }

}
