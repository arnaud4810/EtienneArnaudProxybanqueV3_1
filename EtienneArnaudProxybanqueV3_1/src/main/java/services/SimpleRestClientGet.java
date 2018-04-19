package services;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Customer;
public class SimpleRestClientGet {
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

	Customer customer2 = new Customer();
	customer2.setIdClient(123);
	customer2.setNom("RenardeauBest");
	WebTarget webTarget2 = client.target(SERVICE_CUSTOMERS).path(CUSTOMERS);
	Response response2 = webTarget2.request().put(Entity.entity(customer2, MediaType.APPLICATION_XML));
	System.out.println(response2.getStatus());

//	Client client2 = ClientBuilder.newClient();
//	WebTarget webTarget3 = client2.target(SERVICE_CUSTOMERS).path(CUSTOMERS).path(ID_PLACEHOLDER).resolveTemplate(ID, "123");
//	Response response3 = webTarget3.request().get();
//	Customer c2 = response3.readEntity(Customer.class);
//	System.out.println(c2.getNom() + " status " + response3.getStatus());
//	
//	response3 = webTarget3.request().delete();
//	System.out.println(c2.getNom() + " status " + response3.getStatus());
	}
}
