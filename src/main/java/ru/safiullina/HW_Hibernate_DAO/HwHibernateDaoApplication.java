package ru.safiullina.HW_Hibernate_DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HwHibernateDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwHibernateDaoApplication.class, args);
	}

}
