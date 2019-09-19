package be.afelio.software_academy.spring_mvc.example.dvdrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.CustomerDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.ResponseDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.ResponseDtoStatus;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.UpdateCustomerEmailDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.ApplicationRepository;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.CityNotFoundException;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.CustomerNotFoundException;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.DuplicatedCustomerException;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.DuplicatedEmailException;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.InvalidCreateParametersException;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.exceptions.StoreNotFoundException;

@Controller
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired ApplicationRepository repository;
	
	@GetMapping(value="{firstname}/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> findOne(
			@PathVariable("firstname") String firstname, 
			@PathVariable("name") String lastname) {
		System.out.println(String.format("CustomerController.findOne(%s, %s)", firstname, lastname));
		
		ResponseDto dto = null;
		try {
			CustomerDto customer = repository.findOneCustomerDtoWithQuery(firstname, lastname);
			if (customer == null) {
				dto = new ResponseDto(ResponseDtoStatus.FAILURE, "customer not found");
			} else {
				dto = new ResponseDto(ResponseDtoStatus.SUCCESS, "ok");
				dto.setPayload(customer);
			}
		} catch(Exception e) {
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto>  createCustomer(@RequestBody CustomerDto customerDto) {
		ResponseDto dto = null;
		System.out.println("CustomerController.createCustomer() => " + customerDto);
		
		try {
			repository.createCustomer(customerDto);
			dto = new ResponseDto(ResponseDtoStatus.SUCCESS, "customer created");
		} catch(InvalidCreateParametersException e) {
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "invalid create parameters");
		} catch(DuplicatedCustomerException e) {		
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "duplicated customer");
		} catch(DuplicatedEmailException e) {		
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "duplicated email");
		} catch(CityNotFoundException e) {			
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "city not found");
		} catch(StoreNotFoundException e) {			
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "store not found");
		} catch(Exception e) {			
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "unexpected exception");
		}
		
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> updateCustomerEmail(@RequestBody UpdateCustomerEmailDto updateCustomerEmailDto) {
		ResponseDto dto = null;
		System.out.println("CustomerController.updateCustomerEmail() => " + updateCustomerEmailDto);
		
		try {
			repository.updateCustomerEmail(updateCustomerEmailDto.getFirstname(), 
					updateCustomerEmailDto.getName(), updateCustomerEmailDto.getEmail());
			dto = new ResponseDto(ResponseDtoStatus.SUCCESS, "email updated");
		} catch(CustomerNotFoundException e) {
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "user not found");
		} catch(DuplicatedEmailException e) {
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "duplicated email");
		} catch(Exception e) {
			dto = new ResponseDto(ResponseDtoStatus.FAILURE, "unexpected exception");
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value="{firstname}/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> deleteCustomer(
			@PathVariable("firstname") String firstname, 
			@PathVariable("name") String lastname) {
		return null;
	}
	
}










