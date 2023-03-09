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

import com.proyecto.creditosinvested.models.Client;
import com.proyecto.creditosinvested.models.WebServiceResponse;
import com.proyecto.creditosinvested.servicios.ClientService;



@CrossOrigin(origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

@RestController
@RequestMapping(path="api/v1/cliente/")

public class ClientController {
	
	public final ClientService clientServ;
	
	public WebServiceResponse wsResponse;
	
	@Autowired
	public ClientController(ClientService clientServ) {
		this.clientServ=clientServ;
	}
	
	@PostMapping
	public @ResponseBody WebServiceResponse createClient(@RequestBody Client client) {
		Client newClient= clientServ.createClient(client);
		if(newClient!=null) {
			wsResponse =new WebServiceResponse(true, "");
			wsResponse.addResult(newClient);
		}else {
			wsResponse = new WebServiceResponse(false, "Couldn't add new client");
		}
		return wsResponse;
	}
	
	@PutMapping(path="{clienteID}")
	public @ResponseBody WebServiceResponse updateClient (@PathVariable("clienteID")Long clientID, @RequestBody Client newClientInfo) {
		
		Client updatedClient=clientServ.updateClient(clientID, newClientInfo);
		if (updatedClient!=null) {
			wsResponse = new WebServiceResponse(true, "");
			wsResponse.addResult(updatedClient);
		} else {
			wsResponse = new WebServiceResponse(false, "Couldn't update information.");
		}
		
		return wsResponse;
	}
	
	@GetMapping
	public @ResponseBody WebServiceResponse getClients() {
		
		ArrayList <Client> clientsList = clientServ.getClientsList();
		
		if(clientsList!=null) {
			wsResponse = new WebServiceResponse(true, "");
				for(Client cliente:clientsList) {
					wsResponse.addResult(cliente);
				}
		}else{
			wsResponse = new WebServiceResponse(false, "Couldn't get ClientsList");	
		}
		return wsResponse;
	}
	
	@GetMapping (path="{clienteID}")
	public @ResponseBody WebServiceResponse getClient (@PathVariable("clienteID")Long clientID) {
		
		Client client=clientServ.getClient(clientID);
		
		if(client!=null) {
			wsResponse = new WebServiceResponse(true, "");
			wsResponse.addResult(client);
		}else {
			wsResponse = new WebServiceResponse(false, "Couldn`t find client with ID: "+ clientID);
		}
		return wsResponse;
	}
	
	@DeleteMapping (path="{clienteID}")
	public @ResponseBody WebServiceResponse deleteClient(@PathVariable("clienteID")Long clientID) {
		boolean result=clientServ.deleteClient(clientID);
		
		if(result) {
			wsResponse = new WebServiceResponse(true, "Client with id: " +clientID+ " has been deleted successfully.");
		}else {
			wsResponse = new WebServiceResponse(true, "Error trying to delete the client with id: "+ clientID);
		}
		return wsResponse;
	}
}
