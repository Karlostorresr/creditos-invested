package com.proyecto.creditosinvested.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.creditosinvested.models.Loan;
import com.proyecto.creditosinvested.models.WebServiceResponse;
import com.proyecto.creditosinvested.servicios.ClientService;
import com.proyecto.creditosinvested.servicios.LoanService;

@CrossOrigin(origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

@RestController
@RequestMapping(path="api/v1/cliente/")


public class LoanController {
	
	public final LoanService loanServ;
	public final ClientService clientServ;
	public WebServiceResponse wsResponse;
	
	@Autowired
	public LoanController(LoanService loanServ, ClientService clientServ) {
		this.loanServ = loanServ;
		this.clientServ=clientServ;
	
	}
	
	@PostMapping(path="{clienteID}/credito")	
	public @ResponseBody WebServiceResponse createLoan(@PathVariable("clienteID")Long clientID, @RequestBody Loan newLoan) {
		System.out.println("I am here");
		boolean response=clientServ.existingClient(clientID);
		if(response) {
			newLoan.setClientID(clientID);
			Loan loanCreated =loanServ.createLoan(newLoan);
			if (loanCreated != null) {
				wsResponse=new WebServiceResponse(true, "");
				wsResponse.addResult(loanCreated);
			}
		}else {
			wsResponse=new WebServiceResponse(false, "Couldn't create new loan");
		}
		return wsResponse;
	}
	
	@PutMapping(path="{clienteID}/credito/{creditoID}")
	public @ResponseBody WebServiceResponse updateLoan(@PathVariable("clienteID")Long clientID, @PathVariable("creditoID")Long loanID, @RequestBody Loan updatedLoan){
		
		Loan actualLoad=loanServ.updateLoan(clientID, loanID, updatedLoan);
		
		if(actualLoad!=null) {
			wsResponse = new WebServiceResponse(true, "");
			wsResponse.addResult(actualLoad);
		} else {
			wsResponse = new WebServiceResponse(false, "Couldn't update information.");
		}
		return wsResponse;
		}
	
	@GetMapping(path="{clienteID}/credito")
	public @ResponseBody WebServiceResponse loansListedByClient(@PathVariable("clienteID")Long clientID) {
		
		boolean response=clientServ.existingClient(clientID);
		if(response) {
			ArrayList <Loan> loanList =loanServ.listLoans(clientID);
			if(loanList!=null) {
				wsResponse=new WebServiceResponse(true, "");
				
				for(Loan loans:loanList) {
					wsResponse.addResult(loans);
				}
			}
		}else {
			wsResponse=new WebServiceResponse(false, "Client doesnt exists");
		}
		return wsResponse;
	}
	
	
	@GetMapping(path="{clienteID}/credito/{creditoID}")
	public @ResponseBody WebServiceResponse getLoan(@PathVariable("clienteID")Long clientID, @PathVariable("creditoID")Long loanID) {
		Loan result=loanServ.getLoan(clientID, loanID);
		
		if(result!=null) {
			wsResponse = new WebServiceResponse(true, "");
			wsResponse.addResult(result);
		}else {
			wsResponse = new WebServiceResponse(false, "Couldn't find loan  ");
			
		}
		return wsResponse;
	}
	
	@DeleteMapping(path="{clienteID}/credito/{creditoID}")
	public @ResponseBody WebServiceResponse deleteLoan (@PathVariable("clienteID")Long clientID,@PathVariable("creditoID")Long loanID) {
		
		boolean result= loanServ.deleteLoan(clientID,loanID);
		
		if(result) {
			wsResponse = new WebServiceResponse(true, "");
		}else {
			wsResponse = new WebServiceResponse(false, "Couldn't delete loan.");
		}
		
		return wsResponse;
	}

}
