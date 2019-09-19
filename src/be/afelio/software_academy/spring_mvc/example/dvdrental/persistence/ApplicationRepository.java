package be.afelio.software_academy.spring_mvc.example.dvdrental.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories.AddressRepository;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories.CityRepository;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories.CustomerRepository;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories.StoreRepository;

@Component
public class ApplicationRepository {

	@Autowired CustomerRepository customerRepository;
	@Autowired CityRepository cityRepository;
	@Autowired StoreRepository storeRepository;
	@Autowired AddressRepository addressRepository;
}
