package be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.entities.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

	AddressEntity findOneByValue(String value);
}
