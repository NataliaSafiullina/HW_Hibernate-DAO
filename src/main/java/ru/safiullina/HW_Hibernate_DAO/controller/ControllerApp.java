package ru.safiullina.HW_Hibernate_DAO.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullina.HW_Hibernate_DAO.dto.CityDto;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.service.ServiceApp;

import java.util.List;

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
}
