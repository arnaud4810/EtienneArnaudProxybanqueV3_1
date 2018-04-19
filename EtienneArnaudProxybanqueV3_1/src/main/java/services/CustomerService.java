package services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Customer;

@Produces({"application/xml","application/json"})
public interface CustomerService {

	@GET
	@Path("/Customer/{newIdClient}")
	
	Customer getCustomer(@PathParam("newIdClient") String idClient);

	@PUT
	@Path("/Customer/")
	Response updateCustomer(Customer newCustomer);

	@POST
	@Path("/Customer/")
	Response addCustomer(Customer customer);

	@DELETE
	@Path("/Customer/{newIdClient}")
	Response deleteCustomers(@PathParam("newIdClient") String idClient);
	
	@GET
	@Path("/Customer/")
	List<Customer> getAllCustomers();	
}
