package com.dmdev.streams;

import java.io.Serializable;

public class Address implements Serializable {

    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "{city='" + city + "'}";
    }
}
