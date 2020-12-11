package com.codehub.pf.team4.domains;
import com.codehub.pf.team4.enums.HouseType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users", uniqueConstraints = {@UniqueConstraint(columnNames = {"afm","email"})})
@Data
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "afm", length = 9, nullable = false)
    private Integer afm;

    @Column(name = "first_name", nullable = false)
    private  String firstName;

    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @Column(name = "address", nullable = false)
    private  String address;

    @Column(name = "phone_number", length=10, nullable = false)
    private  Long phoneNumber;

    @Column(name = "password", nullable = false)
    private  String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_type", nullable = false)
    private HouseType houseType;

    @Column( name= "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", targetEntity = Repair.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Repair> repairs;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", afm=" + afm +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", houseType=" + houseType +
                ", email='" + email + '\'' +
                '}';
    }
}
