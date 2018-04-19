package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import model.Conseiller;
public class SimpleRestClientEx {
	
	public static void main(String[] args) {
		
	
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target("http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/123");
	Response response = webTarget.request().get();
	Customer c = response.readEntity(Customer.class);
	System.out.println(c.getNom() + " status " + response.getStatus());

	}
}
