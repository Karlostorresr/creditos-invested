package com.proyecto.creditosinvested.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.creditosinvested.models.Client;

@Service
public class ClientService {
	
	private final ClientRepository clientRep;
	
	@Autowired
	public ClientService (ClientRepository clientRep) {
		this.clientRep=clientRep;
		
	}
	
	public boolean existingClient (Long clientID) {
		return clientRep.existsById(clientID);
	}
	
	public Client createClient (Client client) {
		try {
			clientRep.save(client);
			return client;
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			return null;
		}
	}

	public ArrayList <Client> getClientsList(){
		 ArrayList <Client> clientList=new ArrayList<Client> () ;
				 clientList=(ArrayList<Client>) clientRep.findAll();
				 
				 for(Client client: clientList) {
					 client.setNumberOfLoans(clientRep.countClientLoans(client.getClientID()));
				 }
		 return clientList;
		
		}	

	
	public Client getClient (Long clientID) {
		
		try {
			Client myClient= clientRep.findById(clientID).orElseThrow(()-> new IllegalStateException());
			myClient.setNumberOfLoans(clientRep.countClientLoans(myClient.getClientID()));
			return myClient;
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean deleteClient(Long clientID) {
		
		if (clientRep.existsById(clientID)) {
			clientRep.deleteById(clientID);
			return true;
		}else {
			return false;
		}
		
	}
	
	public Client updateClient(Long clientID, Client clientNewInfo) {
		
		if(clientRep.existsById(clientID)){
			Client existingClient = getClient(clientID);
			existingClient.updateClientAttributes(clientNewInfo);
			
			return createClient(existingClient);
			
		}else {
			return null;
		}
		
	}

	
}
