package persistence;

import java.util.Set;

import model.Comptes;
import model.Customer;

public interface Methods {
	
	public Customer getClientById(Integer idClient);
	
	public boolean createClient (Customer client);
	
	public boolean updateClient(Customer client);
	
	public Set<Customer> getMyClients(Integer idConseiller);
	
	public boolean deleteClientById(Integer idClient);
	
	public boolean createAndAssociateCompteToClient(Customer client);
	
	public Set<Comptes> getClientAssociatedComptes(Customer client);
	
}
