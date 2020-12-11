package com.codehub.pf.team4.models;

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

    public UserModel(Long id, String email, Integer afm) {
        this.id = id;
        this.email = email;
        this.afm = afm;
    }

    public UserModel(Long id, Integer afm, String firstName, String lastName, String address, Long phoneNumber, String email) {
        this.id = id;
        this.afm = afm;
        this.email = email;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
