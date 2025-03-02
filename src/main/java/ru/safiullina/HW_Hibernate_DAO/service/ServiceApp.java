package ru.safiullina.HW_Hibernate_DAO.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.safiullina.HW_Hibernate_DAO.dto.CityDto;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceApp {

    private final PersonRepository repository;

    public ServiceApp(PersonRepository repository) {
        this.repository = repository;
    }


    public List<Person> getPersonsByCity(CityDto cityDto) {
        return repository.selectByCity(cityDto.getCity());
    }

    public List<Person> getPersonByAge(Integer age) {
        return repository.selectByAge(age);
    }

    public Optional<Person> getPersonByNameSurname(String name, String surname) {
        return repository.selectByNameAndSurname(name, surname);
    }

    public List<Person> getAllPersons() {
        return repository.selectAll();
    }


}
