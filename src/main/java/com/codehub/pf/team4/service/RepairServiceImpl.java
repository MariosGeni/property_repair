package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.mappers.RepairMapper;
import com.codehub.pf.team4.model.RepairModel;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.utils.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public List<RepairModel> getAllRepairs() {
        return repairRepository.findAll()
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RepairModel> getRepairById(Long id) {
        return Optional.of(RepairMapper.mapToRepairModel(repairRepository.findById(id).orElse(null)));
    }

    @Override
    public List<RepairModel> getOngoingRepairsOfTheDay() throws Exception {
        return repairRepository.findByDateIsBetweenAndStateEquals(DateProvider.getStartOfDay(), DateProvider.getEndOfDay(), State.ONGOING)
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
        /* return repairRepository.findAll().stream()
                .filter(repair -> isToday(repair.getDate(), now))
                .filter(repair -> repair.getState() == State.ONGOING)
                .collect(Collectors.toList()); */
    }

    @Override
    public List<RepairModel> getRepairsByDate(String wholeDate) {
        // if the date value is null
        if (wholeDate.equals("")) { return null; }
        String[] arrayOfDates = wholeDate.split("/", 2);
        // timestamp for first-begin date
        Timestamp tsBeginDate = Timestamp.valueOf(arrayOfDates[0].substring(0, 10));

        if (arrayOfDates.length > 1) {
            // timestamp for second-end date
            Timestamp tsEndDate = Timestamp.valueOf(arrayOfDates[1].substring(0, 10));
            List<Repair> repairs = repairRepository.findByDateIsBetween(tsBeginDate, tsEndDate);

            return repairs
                    .stream()
                    .map(repair -> RepairMapper.mapToRepairModel(repair))
                    .collect(Collectors.toList());
        }

        List<RepairModel> repairs = repairRepository.findByDateIsBetween(tsBeginDate, tsBeginDate)
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
        return repairs;
    }

    @Override
    public Optional<RepairModel> postRepair(RepairForm newRepair) {
        return Optional.of(RepairMapper.mapToRepairModel(repairRepository.save(new Repair())));
    }

    @Override
    public Optional<RepairModel> updateRepair(RepairForm toBeUpdatedRepair) {
        /*Long repairId = toBeUpdatedRepair.getId();
        if (repairId == null || getRepairById(repairId).isEmpty()) {
            return Optional.empty();
        }*/
        return Optional.of(RepairMapper.mapToRepairModel(repairRepository.save(new Repair())));
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
