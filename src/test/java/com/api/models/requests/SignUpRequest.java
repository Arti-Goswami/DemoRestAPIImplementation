package com.api.models.requests;

public class SignUpRequest {


	private  String username; 
	private  String password; 
	private  String  email;
	private  String  firstName; 
	private  String  lastName; 
	private int  mobileNumber;

	@Override
	public String toString() {
		return "SignUpRequest [username=" + username + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

	public SignUpRequest(String username, String password, String email, String firstName, String lastName,
			int mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	} 


	// Builder design pattern - class created in a way that you can pass variables in any order
	// Page Object, Factory design pattern
	// Service design pattern
	// Builder Design Pattern - inner class - class inside another class - Rule for inner class - static class can be inner class
	// we can make a class static
	//In builder design pattern implementation we can make class static and that is inner class
	// Builder class will not be having constructure only methods it will have
	
	public static class Builder{
		private  String username; 
		private  String password; 
		private  String  email;
		private  String  firstName; 
		private  String  lastName; 
		private int  mobileNumber;
		
		public Builder userName(String userName) {
			this.username=userName;
			// Builder b= new Builder();
			// return b; // this is returning new object and we need to return current object hence mentioned this
			// returning current object
			// so Builder b = this;
			return this;
		}
		
		public Builder password(String password) {
			this.password=password;
			return this;
		}
		
		public Builder email(String email) {
			this.email=email;
			return this;
		}
		public Builder firstName(String firstName) {
			this.firstName=firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName=lastName;
			return this;
		}
		
		public Builder mobileNumber(int mobileNumber) {
			this.mobileNumber=mobileNumber;
			return this;
		}
		
		public SignUpRequest build()
		{
			SignUpRequest signUpRequest = new SignUpRequest(username, password, email, firstName, lastName, mobileNumber);
			return signUpRequest;
		}
	}
	
	
}


