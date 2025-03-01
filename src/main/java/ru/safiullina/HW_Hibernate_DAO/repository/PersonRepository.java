package ru.safiullina.HW_Hibernate_DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.safiullina.HW_Hibernate_DAO.entity.Person;
import ru.safiullina.HW_Hibernate_DAO.entity.PersonPrimaryKey;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonPrimaryKey> {

    @Query(value = "SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> selectByCity(@Param("city") String cityOfLiving);

    @Query(value = "SELECT p FROM Person p WHERE p.personPrimaryKey.age < :age ORDER BY p.personPrimaryKey.age")
    List<Person> selectByAge(@Param("age") Integer age);

    @Query(value = "SELECT p FROM Person p WHERE " +
            "p.personPrimaryKey.name = :name and " +
            "p.personPrimaryKey.surname = :surname")
    Optional<Person> selectByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
