package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.models.RepairModel;

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

}