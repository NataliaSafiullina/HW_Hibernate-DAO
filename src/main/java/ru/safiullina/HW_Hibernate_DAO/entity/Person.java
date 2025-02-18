package ru.safiullina.HW_Hibernate_DAO.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private PersonPrimaryKey personPrimaryKey;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {
    }

    public Person(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        this.personPrimaryKey = new PersonPrimaryKey(name,surname,age);
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personPrimaryKey=" + personPrimaryKey +
                ", phone_number='" + phoneNumber + '\'' +
                ", city_of_living='" + cityOfLiving+ '\'' +
                '}';
    }

    public PersonPrimaryKey getPersonPrimaryKey() {
        return personPrimaryKey;
    }

    public void setPersonPrimaryKey(PersonPrimaryKey personPrimaryKey) {
        this.personPrimaryKey = personPrimaryKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String city) {
        this.cityOfLiving = city;
    }
}
