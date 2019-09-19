package be.afelio.software_academy.spring_mvc.example.dvdrental.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.CustomerDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.entities.CustomerEntity;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories.*;

@Component
public class ApplicationRepository {

	@Autowired CustomerRepository customerRepository;
	@Autowired CityRepository cityRepository;
	@Autowired StoreRepository storeRepository;
	@Autowired AddressRepository addressRepository;
	
	public CustomerDto findOneCustomerDtoWithMapping(String firstname, String lastname) {
		CustomerEntity customer = customerRepository.findOneByFirstnameAndName(firstname, lastname);
		return createCustomerDto(customer);
	}
	
	public CustomerDto findOneCustomerDtoWithQuery(String firstname, String lastname) {
		return customerRepository.findOneByFirstnameAndNameAsDto(firstname, lastname);
	}
	
	private CustomerDto createCustomerDto(CustomerEntity entity) {
		return new CustomerDto(
			entity.getFirstname(), 
			entity.getName(), 
			entity.getEmail(), 
			entity.getAddress().getValue(), 
			entity.getAddress().getCity().getName(), 
			entity.getAddress().getCity().getCountry().getName(), 
			entity.getStore().getId());
	}
}
