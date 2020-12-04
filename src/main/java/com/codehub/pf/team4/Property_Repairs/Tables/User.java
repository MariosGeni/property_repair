package com.codehub.pf.team4.Property_Repairs.Tables;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname", "lastname"})})
public class User {

    private static final int MAX_NAME_LENGHT = 50;

    @Id
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
