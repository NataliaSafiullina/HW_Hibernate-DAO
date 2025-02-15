package ru.safiullina.HW_Hibernate_DAO.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private PersonPrimaryKey personPrimaryKey;
    private String phone_number;
    private String city_of_living;

    public Person() {
    }

    public Person(String name, String surname, int age, String phone_number, String city_of_living) {
        this.personPrimaryKey = new PersonPrimaryKey(name,surname,age);
        this.phone_number = phone_number;
        this.city_of_living = city_of_living;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personPrimaryKey=" + personPrimaryKey +
                ", phone_number='" + phone_number + '\'' +
                ", city_of_living='" + city_of_living + '\'' +
                '}';
    }

    public PersonPrimaryKey getPersonPrimaryKey() {
        return personPrimaryKey;
    }

    public void setPersonPrimaryKey(PersonPrimaryKey personPrimaryKey) {
        this.personPrimaryKey = personPrimaryKey;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity_of_living() {
        return city_of_living;
    }

    public void setCity_of_living(String city_of_living) {
        this.city_of_living = city_of_living;
    }
}
