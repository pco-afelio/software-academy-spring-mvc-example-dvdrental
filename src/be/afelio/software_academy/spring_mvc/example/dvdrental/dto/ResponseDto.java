package be.afelio.software_academy.spring_mvc.example.dvdrental.dto;

public class ResponseDto {

	private String status;
	private String message;
	
	public ResponseDto() {}
	
	public ResponseDto(ResponseDtoStatus status, String message) {
		super();
		this.status = status.name();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
