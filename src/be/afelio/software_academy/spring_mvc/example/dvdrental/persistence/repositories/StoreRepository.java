package be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.entities.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

	StoreEntity findOneById(int id);
}
