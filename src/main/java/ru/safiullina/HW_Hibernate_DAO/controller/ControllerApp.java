package ru.safiullina.HW_Hibernate_DAO.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullina.HW_Hibernate_DAO.dto.CityDto;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.service.ServiceApp;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerApp {

    private final ServiceApp service;

    public ControllerApp(ServiceApp service) {
        this.service = service;
    }

    /**
     * http://localhost:8080/persons/by-city?city=LA
     * @param cityDto - город проживания
     * @return Entity
     */
    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(CityDto cityDto) {
        return service.getPersonsByCity(cityDto);
    }

    /**
     * http://localhost:8080/persons/by-age?age=61
     * @param age - возраст
     * @return Entity
     */
    @GetMapping("/persons/by-age")
    public List<Person> getPersonByCity(@RequestParam Integer age) {
        return service.getPersonByAge(age);
    }

    /**
     * http://localhost:8080/persons/by-names?name=Jared&surname=Leto
     * @param name - имя
     * @param surname - фамилия
     * @return Entity
     */
    @GetMapping("/persons/by-names")
    public Optional<Person> getPersonByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameSurname(name, surname);
    }


}
