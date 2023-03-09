package com.proyecto.creditosinvested.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.creditosinvested.models.Loan;

@Service
public class LoanService {
	
	private final LoanRepository loanRep;
	
	@Autowired
	public LoanService (LoanRepository loanRep) {
		this.loanRep=loanRep;
	}
	
	public Loan createLoan (Loan newLoan) {
		try {
			loanRep.save(newLoan);
			return newLoan;
		}catch(Exception addError) {
			return null;
		}	
	}
	
	public boolean existingLoan(Long loanID) {
		return loanRep.existsById(loanID);
	}
	
	public ArrayList <Loan> listLoans (Long clientID){
		
		return (ArrayList<Loan>)loanRep.findByClientID(clientID);
		
	}
	
	public Loan getLoan (Long clientID, Long loanID) {
		Loan loan=loanRep.findSpecificLoan(clientID, loanID);
		return loan;
	}
	
	public boolean deleteLoan (Long clientID, Long loanID) {
		Loan loan=getLoan(clientID, loanID);
		if (loan!=null) {
			loanRep.deleteById(loanID);
			return true;
		} else {
			return false;
		}
	}
	
	public Loan updateLoan(Long clientID, Long loanID, Loan updatedLoan) {
		Loan existingLoan=getLoan(clientID, loanID);
		if (existingLoan!=null) {
			existingLoan.updateLoaninfo(updatedLoan);
			
			return createLoan(existingLoan);
		} else {
			return null;
		}
		
	}
	
	
	

}
