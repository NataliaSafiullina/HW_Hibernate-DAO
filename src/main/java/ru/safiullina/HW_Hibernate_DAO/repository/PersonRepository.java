package ru.safiullina.HW_Hibernate_DAO.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.entity.PersonPrimaryKey;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository <Person, PersonPrimaryKey> {

    List<Person> findAllByCityOfLiving (String cityOfLiving);

    List<Person> findAllByPersonPrimaryKey_AgeLessThanOrderByPersonPrimaryKey_Age(Integer age);

    Optional<Person> findFirstByPersonPrimaryKey_NameAndPersonPrimaryKey_Surname(String name, String surname);
}
