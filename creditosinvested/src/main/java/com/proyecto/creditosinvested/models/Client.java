package com.proyecto.creditosinvested.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import java.sql.Date;



import jakarta.persistence.Column;

@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)

	@Column (name="clientID")
	private Long clientID;
	@Column (name="name", nullable=false)
	private String name;
		
	@Column (name="lastName", nullable=false)
	private String lastName;
	
	@Column (name="phoneNumber", nullable=false)
	private String phoneNumber;
	
	@Column (name="email", nullable=false)
	private String email;
	
	@Column (name="address", nullable=false)
	private String address;
	
	@Column (name="birthdate", nullable=false)
	private LocalDate birthdate;
	
	@Column (name="numberOfLoans")
	private int numberOfLoans;
	
	
	//constructor por defecto
	public Client () {
		
	}
	
	public Client(Long clientId, String name, String lastName, LocalDate birthdate, String email, String phoneNumber,
			String address, int numberOfLoans) {
		super();
		this.clientID = clientId;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.numberOfLoans=numberOfLoans;
	}
	
	//Getters y Setters

	public Long getClientID() {
		return clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getBirthdate() {
		DateTimeFormatter formatter=
				DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return this.birthdate.format(formatter);
	}

	public void setBirthdate(LocalDate birthDate) {
		this.birthdate = birthDate;
	}

	public int getNumberOfLoans() {
		return numberOfLoans;
	}

	public void setNumberOfLoans(int loan) {
		this.numberOfLoans = loan;
	}
	
	
	//upDateClientInfo
	
	public void updateClientAttributes(Client updatedClient) {
		this.name = updatedClient.getName();
		this.lastName = updatedClient.getLastName();
		this.phoneNumber= updatedClient.getPhoneNumber();
		this.email=updatedClient.getEmail();
		this.address=updatedClient.getAddress();
		//this.birthdate=updatedClient.getBirthdate();
	}

	//toString
	
	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", name=" + name + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", address=" + address + ", birthDate=" + birthdate + ", loan="
				+ numberOfLoans + "]";
	}

	
	
	
	
}
