package com.example.springboothibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManagerFactory;

@Configuration
public class JpaConfig {
/*la integración de JPA y Hibernate en una aplicación de Spring Boot
 permite acceder y manipular datos de una base de datos relacional de
 manera más fácil y eficiente, lo que puede mejorar el rendimiento y
 la escalabilidad de la aplicación.*/
    @Autowired            //se inyecta automaticamente
    private EntityManagerFactory entityManagerFactory; // JPA

    @Bean
    public Session getSession(){
        System.out.println("Creando bean Session");
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory.openSession(); // Session de Hibernate
    }
}
