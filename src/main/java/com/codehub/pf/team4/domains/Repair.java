package com.codehub.pf.team4.domains;

import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "address", columnDefinition = "NVARCHAR(255)")
    private String address;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")//, referencedColumnName = "user_id")
    private User user;

    @Column(name = "description")
    private String description;
}
