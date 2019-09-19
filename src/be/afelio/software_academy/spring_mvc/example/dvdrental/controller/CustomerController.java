package be.afelio.software_academy.spring_mvc.example.dvdrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.CustomerDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.ResponseDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.ResponseDtoStatus;
import be.afelio.software_academy.spring_mvc.example.dvdrental.dto.UpdateCustomerEmailDto;
import be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.ApplicationRepository;

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
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> updateCustomerEmail(@RequestBody UpdateCustomerEmailDto updateCustomerEmailDto) {
		ResponseDto dto = new ResponseDto(ResponseDtoStatus.SUCCESS, "ok");
		System.out.println("CustomerController.updateCustomerEmail() => " + updateCustomerEmailDto);
		return ResponseEntity.ok(dto);
	}
	
}










