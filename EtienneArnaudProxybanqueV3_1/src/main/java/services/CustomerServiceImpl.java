package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import model.Customer;

public class CustomerServiceImpl implements CustomerService {
	private int currentId = 123;
	Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	
	public CustomerServiceImpl() {
		init();
	}
	
	final void init() {
		Customer customer = new Customer();
		customer.setNom("Renard");
		customer.setIdClient(currentId);
		customers.put(customer.getIdClient(), customer);
	}
	@Override
	public Customer getCustomer(String idClient) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(idClient);
		System.out.println("get customer " + id);
		Customer customer = customers.get(id);
		return customer;
	}

	@Override
	public Response updateCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		Customer customer = customers.get(newCustomer.getIdClient());
		Response response = null;
		if (customer != null) {
			customers.put(newCustomer.getIdClient(), newCustomer);
			response = Response.ok().build();

		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer.setIdClient(++currentId);
		customers.put(customer.getIdClient(), customer);
		return Response.ok(customer).build();
	}

	@Override
	public Response deleteCustomers(String idClient) {
		// TODO Auto-generated method stub
		System.out.println("Supprimer client :  "+ idClient);
		int id = Integer.parseInt(idClient);
		Customer customer = customers.get(id);
		Response response = null;
		if (customer != null) {
			customers.remove(id);
			response = Response.ok(true).build();

		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		ArrayList<Customer> listCustomers = new ArrayList(customers.values());
		return listCustomers;
	}

}
