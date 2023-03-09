package com.proyecto.creditosinvested.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.creditosinvested.models.Loan;


public interface LoanRepository extends JpaRepository <Loan, Long>{
	
	@Query(value="SELECT * FROM Loan WHERE client_id=?1", nativeQuery=true)
	List<Loan> findByClientID(Long clientID);
	
	
	@Query(value="SELECT * FROM Loan WHERE client_id=?1 AND loanID=?2", nativeQuery=true)
	Loan findSpecificLoan(Long clientID, Long loanID);

}
