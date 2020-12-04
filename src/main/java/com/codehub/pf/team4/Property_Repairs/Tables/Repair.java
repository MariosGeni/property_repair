package com.codehub.pf.team4.Property_Repairs.Tables;

import com.codehub.pf.team4.Property_Repairs.enums.HouseType;
import com.codehub.pf.team4.Property_Repairs.enums.RepairType;
import com.codehub.pf.team4.Property_Repairs.enums.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Table(name = "Repair")
@Data
@Entity
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

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User users;

    @Column(name = "description")
    private String description;
}
