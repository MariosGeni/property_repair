package com.codehub.pf.team4.models;

import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairModel {
    private Long id;
    private Timestamp date;
    private State state;
    private RepairType repairType;
    private Long cost;
    private String address;
    private String user;
    private String description;
}
