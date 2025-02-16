package ru.safiullina.HW_Hibernate_DAO.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryApp {

    /**
     * An EntityManager instance is associated with a persistence context.
     * The EntityManager API is used to create and remove persistent entity instances,
     * to find entities by their primary key, and to query over entities.
     */
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city){
        List<Person> personList = new ArrayList<>();

        // Создайте экземпляр Query для выполнения именованного запроса (на языке запросов Java Persistence или на собственном SQL).
        Query query = entityManager.createNativeQuery("select name, surname, age, phone_number, city_of_living from persons");

        //Выполнить запрос SELECT и вернуть результаты запроса в виде списка.
        List<Object[]> resultList = query.getResultList();

        // Разбираем полученный ответ за записи, если город соответствует заданному, то помещаем персону в список
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
