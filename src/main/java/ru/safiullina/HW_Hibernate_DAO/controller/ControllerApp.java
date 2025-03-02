package ru.safiullina.HW_Hibernate_DAO.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * один из методов возвращает значения только для пользователей с ролью "READ" (используйте @Secured)
     * @param cityDto - город проживания
     * @return Entity
     */
    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersonByCity(CityDto cityDto) {
        return service.getPersonsByCity(cityDto);
    }

    /**
     * http://localhost:8080/persons/by-age?age=61
     * один из методов возвращает значения только для пользователей с ролью "WRITE" (используйте @RolesAllowed)
     * @param age - возраст
     * @return Entity
     */
    @GetMapping("/persons/by-age")
    @RolesAllowed("WRITE")
    public List<Person> getPersonByAge(@RequestParam Integer age) {
        return service.getPersonByAge(age);
    }

    /**
     * http://localhost:8080/persons/by-names?name=Jared&surname=Leto
     * один из методов, который принимает в качестве query-параметра имя пользователя (username),
     * должен возвращает значения, только если у пользователя username совпадает с именем пользователя
     * в вашем объекте Authentication, который Spring security сохраняет в SecurityContextHolder
     * после успешной аутентификации.
     * @param name    - имя
     * @param surname - фамилия
     * @return Entity
     */
    @GetMapping("/persons/by-names")
    @PostAuthorize("#surname == authentication.principal.username")
    public Optional<Person> getPersonByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameSurname(name, surname);
    }

    /**
     * http://localhost:8080/persons/all
     * один из методов возвращает значения, если у пользователя есть хотя бы одна из ролей из
     * "WRITE", "DELETE" (используйте pre/post аннотации)
     * @return список всех записей в БД
     */
    @GetMapping("/persons/all")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> getAll() {
        return service.getAllPersons();
    }


}
