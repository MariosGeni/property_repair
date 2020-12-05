package com.codehub.pf.team4.Property_Repairs.Tables;
import com.codehub.pf.team4.Property_Repairs.enums.HouseType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users", uniqueConstraints = {@UniqueConstraint(columnNames = {"afm"})})
@Data
public class User {

    private static final int MAX_NAME_LENGTH = 50;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "afm", length = 9)
    private Integer afm;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "address")
    private  String address;

    @Column(name = "phone_number", length=10)
    private  Integer phoneNumber;

    @Column(name = "password")
    private  String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private HouseType houseType;

    @Column( name= "email")
    private String email;

    @OneToMany(mappedBy = "user", targetEntity = Repair.class)
    @JsonIgnore
    private List<Repair> repairs;

}
