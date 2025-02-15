package ru.safiullina.HW_Hibernate_DAO.service;

import org.springframework.stereotype.Service;
import ru.safiullina.HW_Hibernate_DAO.dto.CityDto;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.repository.RepositoryApp;

import java.util.List;

@Service
public class ServiceApp {

    private final RepositoryApp repository;

    public ServiceApp(RepositoryApp repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(CityDto cityDto){
        return repository.getPersonsByCity(cityDto.getCity());
    }
}
