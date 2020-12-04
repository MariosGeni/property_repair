package com.codehub.pf.team4.Property_Repairs.enums;

public enum HouseType {

    DETACHED("Μονοκατοικία"),
    MAISONETTE("Μεζονέτα"),
    APARTMENT_BUILDING("Πολυκατοικία");

    private String houseType;

    HouseType(String houseType){
        this.houseType = houseType;
    }

    public java.lang.String getHouseType() {
        return houseType;
    }
}
