package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import model.Conseiller;
import model.Customer;
public class SimpleRestClientEx {
	private static final String ID = "newIdClient";
	private static final String ID_PLACEHOLDER = "/{newIdClient}";
	private static final String CUSTOMERS = "/Customer";
	private static final String SERVICE_CUSTOMERS = "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService";
	
	
	public static void main(String[] args) {
		
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target(SERVICE_CUSTOMERS).path(CUSTOMERS).path(ID_PLACEHOLDER).resolveTemplate(ID, "123");
	Response response = webTarget.request().get();
	Customer c = response.readEntity(Customer.class);
	System.out.println(c.getNom() + " status " + response.getStatus());

	}
}
