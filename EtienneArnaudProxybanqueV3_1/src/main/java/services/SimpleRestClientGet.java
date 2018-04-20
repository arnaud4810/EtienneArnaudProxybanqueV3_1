package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Customer;

public class SimpleRestClientGet {
	private static final String ID = "newIdClient";
	private static final String ID_PLACEHOLDER = "/{newIdClient}";
	private static final String CUSTOMERS = "/Customer";
	private static final String SERVICE_CUSTOMERS = "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService";
	private static String typeLogger;
	private static String typeLogger2;
	private static String typeLogger3;
	private static Logger LOGGER = LoggerFactory.getLogger(SimpleRestClientGet.class);

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(SERVICE_CUSTOMERS).path(CUSTOMERS).path(ID_PLACEHOLDER).resolveTemplate(ID,
				"123");
		Response response = webTarget.request().get();
		Customer c = response.readEntity(Customer.class);
		typeLogger = c.getNom() + " status " + response.getStatus();
		LOGGER.debug(typeLogger);

		Customer customer2 = new Customer();
		customer2.setIdClient(123);
		customer2.setNom("RenardeauBest");
		WebTarget webTarget2 = client.target(SERVICE_CUSTOMERS).path(CUSTOMERS);
		Response response2 = webTarget2.request().put(Entity.entity(customer2, MediaType.APPLICATION_XML));
		typeLogger2 = c.getNom() + "Status : " + response2.getStatus();
		LOGGER.debug(typeLogger2);

		Client client2 = ClientBuilder.newClient();
		WebTarget webTarget3 = client2.target(SERVICE_CUSTOMERS).path(CUSTOMERS).path(ID_PLACEHOLDER)
				.resolveTemplate(ID, "123");
		Response response3 = webTarget3.request().get();
		Customer c2 = response3.readEntity(Customer.class);
		typeLogger3 = c2.getNom() + " status " + response3.getStatus();
		LOGGER.trace(typeLogger3);
		
		
//		response3 = webTarget3.request().delete();
//		typeLogger4 = c2.getNom() + " status " + response3.getStatus();
	}
}
