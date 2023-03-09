package com.proyecto.creditosinvested.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.creditosinvested.models.Client;



public interface ClientRepository extends JpaRepository <Client, Long> {
	
	@Query(value="SELECT COUNT(*) FROM Loan WHERE client_id=?1", nativeQuery=true)
	int countClientLoans(Long clientID);
}
