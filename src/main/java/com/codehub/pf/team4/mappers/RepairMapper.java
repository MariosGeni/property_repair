package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.repository.RepairRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class RepairMapper {

    private RepairRepository repairRepository;

    public static RepairModel mapToRepairModel(Repair repair) {
        if (repair == null) { return null; }

        RepairModel repairModel = new RepairModel();
        repairModel.setId(repair.getId());
        repairModel.setDate(repair.getDate());
        repairModel.setState(repair.getState());
        repairModel.setRepairType(repair.getRepairType());
        repairModel.setCost(repair.getCost());
        repairModel.setAddress(repair.getAddress());
        repairModel.setDescription(repair.getDescription());
        repairModel.setUser(repair.getUser().getFirstName() + ", " + repair.getUser().getLastName());
        return repairModel;
    }

    public List<RepairModel> mapToFindAll(){

        repairRepository.findAll()
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
        return null;
    }

    public Optional<RepairModel> mapToRepairModelOptional(long id) {

        return Optional.of(RepairMapper.mapToRepairModel(repairRepository.findById(id).orElse(null)));
    }
}