package com.cobellisantiago.examen;

public class Store {

    private Double latitude;
    private Double longitude;
    private String name;
    private String type;


    public Store(Double latitude, Double longitude, String name, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Store{" +
                "latitude= " + latitude +
                ", longitude= " + longitude +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getlongitude() {
        return longitude;
    }

    public void setlongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
