package com.codehub.pf.team4.domains;

import com.codehub.pf.team4.enums.HouseType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Property")
@Data
@Entity
public class Property {

    @Id
    @Column(name = "property_id", nullable = false)
    private Long id;

    @Column(name ="address", columnDefinition = "NVARCHAR()225")
    private String address;

    @Column(name ="year_of_construction")
    private String yearOfConstruction;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private HouseType houseType;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")//, referencedColumnName = "user_id")
    private User user;

    }

