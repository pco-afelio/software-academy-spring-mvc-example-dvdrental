package be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	
	CustomerEntity findOneByFirstnameAndName(String firstname, String name);
	CustomerEntity findOneByEmail(String email);
}
