package ru.safiullina.HW_Hibernate_DAO.dto;


public class CityDto {
    private String city;

    public CityDto() {
    }

    public CityDto(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
