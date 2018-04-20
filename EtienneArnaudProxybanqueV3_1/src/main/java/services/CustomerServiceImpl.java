package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Adresse;
import model.Comptes;
import model.Conseiller;
import model.Customer;
import persistence.Methods;
import persistence.MethodsImpl;
import presentation.WebServiceRest;

public class CustomerServiceImpl implements CustomerService {
	private int currentId = 123;
	Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	Methods dao = new MethodsImpl();
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	public CustomerServiceImpl() {
		init();
	}
	
	final void init() {
		Adresse adresse = new Adresse();
		adresse.getNumero();
		adresse.getTypeVoie();
		adresse.getNomVoie();
		adresse.getCodePostal();
		adresse.getVille();
		adresse.setNumero(12);
		adresse.setTypeVoie("rue");
		adresse.setNomVoie("Léon");
		adresse.setCodePostal("75005");
		adresse.setVille("Paris");
		Customer customer = new Customer();
		Conseiller conseiller = customer.getConseiller();
		Set<Comptes> customerAssociatedComptes = new HashSet<>();
		customer.setIdClient(currentId);
		customer.setNom("Renard");
		customer.setPrenom("Arnaud");
		customer.setTelephone("0146137378");
		customer.setAdresse(adresse);
		customer.setConseiller(conseiller);
		customer.setCustomerAssociatedComptes(customerAssociatedComptes);
		customers.put(customer.getIdClient(), customer);
	
	}
	@Override
	public Customer getCustomer(String idClient) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(idClient);
		Customer client = dao.getClientById(id);
		LOGGER.info("Le client" + client.getPrenom() + " " + client.getNom() + "a été ajouté");
		return client;
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
		Response response = null;
		customer.setNom("tutu");
		dao.createClient(customer);
		response = Response.ok(customer).build();
		
		return response;
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
	public Set<Customer> getAllCustomersByConseiller() {
		// TODO Auto-generated method stub
		Set<Customer> listCustomers = new HashSet<>();
		return listCustomers;
	}

}
