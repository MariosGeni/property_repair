package com.codehub.pf.team4.Property_Repairs.Tables;

import com.codehub.pf.team4.Property_Repairs.enums.HouseType;
import com.codehub.pf.team4.Property_Repairs.enums.RepairType;
import com.codehub.pf.team4.Property_Repairs.enums.State;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Users")
@Data
public class Repair {
    private static final int MAX_NAME_LENGTH = 50;

    @Id
    @Column(name = "repair_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Timestamp date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair_type")
    private RepairType repairType;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "address")
    private String address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "description")
    private String description;

}
