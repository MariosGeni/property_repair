package com.codehub.pf.team4.service;

import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.models.RepairModel;

import java.util.List;
import java.util.Optional;

public interface RepairService {

    List<RepairModel> getAllRepairs();

    Optional<RepairModel> getRepairById(Long id);

    Optional<RepairForm> findRepairByIdAsRepairForm(Long id);

    Optional<RepairModel> addRepair(RepairForm repair) throws Exception;

    Optional<RepairModel> updateRepair(RepairForm toBeUpdatedRepair);

    boolean deleteRepairById(Long repairId);

    List<RepairModel> getOngoingRepairsOfTheDay() throws Exception;

    List<RepairModel> getRepairsByDate(String wholeDate);

}
