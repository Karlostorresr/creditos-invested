package com.proyecto.creditosinvested.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column (name="loanID")
	private Long loanID;
	@Column (name="clientId")
	private Long clientID;
	@Column (name="amount", nullable=false)
	private double amount;
	@Column (name="paymentPlan", nullable=false)
	private int paymentPlan;
	@Column (name="interestRate")
	private float interestRate =0.20f;
	@Column (name="creationDate", nullable=false)
	private LocalDate creationDate;
	
	//Constructores
	
	public Loan() {	
	}

	public Loan(Long loanID, Long clientID, double amount, int paymentPlan, float interestRate,LocalDate creationDate) {
		
		super();
		this.loanID = loanID;
		this.clientID = clientID;
		this.amount = amount;
		this.paymentPlan = paymentPlan;
		this.interestRate = interestRate;
		this.creationDate = creationDate;
	}
	
	//Getter & Setters
	
	public Long getLoanID() {
		return loanID;
	}

	public void setLoanID(Long loanID) {
		this.loanID = loanID;
	}

	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(int paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getCreationDate() {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return this.creationDate.format(formatter);
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	//updateLoaninfo
	
	public void updateLoaninfo(Loan updatedLoan) {
		this.amount=updatedLoan.getAmount();
		this.paymentPlan=updatedLoan.getPaymentPlan();
		this.interestRate=updatedLoan.getInterestRate();
	}

	//toString

	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", clientID=" + clientID + ", amount=" + amount + ", paymentPlan=" + paymentPlan
				+ ", interestRate=" + interestRate + ", creationDate=" + creationDate + "]";
	}
	
	
	
	
	
	
	


}
