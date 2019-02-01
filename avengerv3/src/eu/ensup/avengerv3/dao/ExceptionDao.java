package eu.ensup.avengerv3.dao;

public class ExceptionDao extends Exception {

	private String message;

	public ExceptionDao(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error Dao=" + message + "";
	}

}
