package ru.safiullina.HW_Hibernate_DAO.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RepositoryApp {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city){
        List<Person> personList = new ArrayList<>();
        Query query = entityManager.createNativeQuery("select name, surname, age, phone_number, city_of_living from persons");
        List<Object[]> resultList = query.getResultList();
        for (Object[] cortege : resultList){
            System.out.println(city + " == " + cortege[4]);
            if (cortege[4].equals(city)) {
                personList.add(new Person(
                        (String) cortege[0],
                        (String) cortege[1],
                        (Integer) cortege[2],
                        (String) cortege[3],
                        (String) cortege[4]));
            }
        }
        return personList;
    }
}
