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

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(CityDto cityDto){
        return service.getPersonsByCity(cityDto);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonByCity(@RequestParam Integer age){
        return service.getPersonByAge(age);
    }

    @GetMapping("/persons/by-names")
    public Optional<Person> getPersonByNameSurname(@RequestParam String name, @RequestParam String surname){
        return service.getPersonByNameSurname(name, surname);
    }


}
