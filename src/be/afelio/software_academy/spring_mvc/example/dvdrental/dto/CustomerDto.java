package be.afelio.software_academy.spring_mvc.example.dvdrental.dto;

public class CustomerDto {
	
	private String firstname;
	private String name;
	private String email;
	private String address;
	private String city;
	private String country;
	private int store;
	
	public CustomerDto() {}

	public CustomerDto(String firstname, String name, String email, 
			String address, String city, String country, int store) {
		super();
		this.firstname = firstname;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
		this.store = store;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public int getStore() {
		return store;
	}

	@Override
	public String toString() {
		return "CustomerDto [firstname=" + firstname + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", store=" + store + "]";
	}
	
}
