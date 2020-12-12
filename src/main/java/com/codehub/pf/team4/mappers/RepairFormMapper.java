package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.utils.DateProvider;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class RepairFormMapper {

    public static Repair mapToRepair(RepairForm repairForm) throws Exception{
        if(repairForm == null) return null;

        Repair repair = new Repair();
        repair.setDate(new Timestamp(DateProvider.SDF.parse(repairForm.getDate()).getTime()));
        repair.setAddress(repairForm.getAddress());
        repair.setAddress(repairForm.getAddress());
        repair.setRepairType(RepairType.valueOf(repairForm.getRepairType()));
        repair.setState(State.valueOf(repairForm.getState()));
        repair.setCost(Long.parseLong(repairForm.getCost()));
        repair.setDescription(repairForm.getDescription());
        repair.setUser((new User()));
        repair.getUser().setId(Long.parseLong(repairForm.getId()));

        if(!repairForm.getId().isEmpty()) {
            repair.setId(Long.parseLong(repairForm.getId()));
        }


        return repair;
    }
}
