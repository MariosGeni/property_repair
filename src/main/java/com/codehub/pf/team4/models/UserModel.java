package com.codehub.pf.team4.models;

import com.codehub.pf.team4.enums.HouseType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserModel {
    private Long id;
    private Integer afm;
    private String firstName;
    private String lastName;
    private String address;
    private Long phoneNumber;
    private String email;
    private String password;
    private HouseType houseType;

    public UserModel(Long id, String email, Integer afm) {
        this.id = id;
        this.email = email;
        this.afm = afm;
    }

    public UserModel(Long id, Integer afm, String firstName, String lastName, String address, Long phoneNumber, String email, String password, HouseType houseType) {
        this.id = id;
        this.afm = afm;
        this.email = email;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.houseType = houseType;
    }
}
