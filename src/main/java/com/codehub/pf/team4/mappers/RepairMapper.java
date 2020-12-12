package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.models.RepairModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class RepairMapper {


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

    public List<RepairModel> mapToRepairModelList(List<Repair> repairs){
        return repairs.stream()
                .map(RepairMapper::mapToRepairModel)
                .collect(Collectors.toList());
    }

    public Optional<RepairModel> mapToRepairModelOptional(Repair repair) {
        return Optional.of(mapToRepairModel(repair));
    }
}