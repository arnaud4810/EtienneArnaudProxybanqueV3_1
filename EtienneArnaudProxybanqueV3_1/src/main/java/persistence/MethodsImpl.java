package persistence;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.fabric.xmlrpc.Client;

import model.Adresse;
import model.Comptes;
import model.Conseiller;
import model.Customer;

public class MethodsImpl implements Methods {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction txn = em.getTransaction();

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param Prend
	 *            un client pour le persister dans la base de donénes.
	 * @param Devrait vérifier
	 *            d'abord que le client n'existe pas déjà. (code en commentaire)
	 * @result renvoie true si la persistance dans la BDD est ok
	 * false si non.
	 * 
	 */
	@Override
	public boolean createClient(Customer client) {

		try {

			// if ((Integer) client.getIdClient() == null) {
			txn.begin();
			em.persist(client);
			txn.commit();
			// } else
			// {
			// return false;
			// }

			return true;

		}

		catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

		return false;
	}

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param Prend
	 *            un client pour le mettre à jour dans la base de données.
	 * @result renvoi true si la mise à jour est ok, et false si il n'y a pas eu de mise à jour
	 * 
	 */
	@Override
	public boolean updateClient(Customer client) {

		try {

			txn.begin();
			em.merge(client);
			txn.commit();
			return true;

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null)
				em.close();
		}

	}

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param Récupère un Conseiller par son id.
	 *        récupère la liste des clients de ce conseiller
	 * @result renvoi la liste des clients de ce conseiller si ok,
	 * @renvoi null en exception.
	 * 
	 */
	@Override
	public Set<Customer> getMyClients(Integer idConseiller) {

		try {
			txn.begin();
			Conseiller conseiller = em.find(Conseiller.class, idConseiller);
			conseiller.getConseillerAssociatedCustomer().size(); // pour eviter la lazy Exception.

			return conseiller.getConseillerAssociatedCustomer();

		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return null;

		} finally {
			if (em != null) {
				em.close();
			}

		}
	}

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param Prend
	 *            un client pour le supprimer de la base de donénes.
	 * @param Devrait vérifier
	 *            d'abord que le client existe. (code à générer)
	 * 
	 */
	@Override
	public boolean deleteClientById(Integer idClient) {

		try {

			txn.begin();
			Customer client = em.find(Customer.class, idClient);
			em.remove(client);
			txn.commit();
			return true;

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param Prend
	 *            un client pour le persister dans la base de donénes.
	 * @param Devrait vérifier
	 *            d'abord que le client n'existe pas déjà. (code en commentaire)
	 * 
	 */
	
	@Override
	public boolean createAndAssociateCompteToClient(Customer client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Comptes> getClientAssociatedComptes(Customer client) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Author Arnaud et Etienne
	 * 
	 * @param récupère un client par son Id
	 *            
	 * @result renvoi le client récupéré si ok,
	 * renvoi null en exeption.
	 * 
	 */
	
	@Override
	public Customer getClientById(Integer idClient) {
		try {

			txn.begin();
			Customer client = em.find(Customer.class, idClient);
			
			return client;

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if (em != null)
				em.close();
		}

	}

}
