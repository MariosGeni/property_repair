package com.codehub.pf.team4.form;

import com.codehub.pf.team4.enums.HouseType;

public class UserForm {

    private Integer afm;
    private  String firstName;
    private  String lastName;
    private  String address;
    private  Long phoneNumber;
    private  String password;
    private HouseType houseType;
    private String email;

    public Integer getAfm() {
        return afm;
    }

    public void setAfm(Integer afm) {
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
