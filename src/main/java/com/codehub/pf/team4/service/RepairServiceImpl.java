package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.mappers.RepairFormMapper;
import com.codehub.pf.team4.mappers.RepairMapper;
import com.codehub.pf.team4.mappers.UserFormMapper;
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

    public Optional<RepairForm> findRepairByIdAsRepairForm(Long id){
        try {
            RepairForm repairForm = RepairFormMapper.mapToRepairForm(repairRepository.findById(id).orElse(null));
            return Optional.ofNullable(repairForm);
        } catch (Exception e) {
            return Optional.empty();
        }
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
    public Optional<RepairForm> getRepairByIdAsForm(Long id) {
        Repair theRepair = repairRepository.findById(id).orElse(null);

        if(theRepair == null) return Optional.empty();
        return Optional.of(RepairFormMapper.mapToRepairForm(theRepair));
    }

    @Override
    public Optional<RepairModel> addRepair(RepairForm newRepair) {
        Repair repair = RepairFormMapper.mapToRepair(newRepair);
        repair.setUser(userRepository.findById(repair.getUser().getId()).get());
        return RepairMapper.mapToRepairModelOptional(repairRepository.save(repair));
    }

    @Override
    public Optional<RepairModel> updateRepair(RepairForm toBeUpdatedRepair) {
        Repair toBeUpdateRepair = RepairFormMapper.mapToRepair(toBeUpdatedRepair);
        Repair originalRepair = repairRepository.findById(toBeUpdateRepair.getId()).get();
        if(toBeUpdateRepair.equals(originalRepair)) {
            // if no changes made dont update
            return RepairMapper.mapToRepairModelOptional(toBeUpdateRepair);
        }

        toBeUpdateRepair.setUser(originalRepair.getUser());
        return RepairMapper.mapToRepairModelOptional(repairRepository.save(toBeUpdateRepair));
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
