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
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "CustomerDto [firstname=" + firstname + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", store=" + store + "]";
	}
	
}
