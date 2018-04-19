package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Conseiller;
import model.Customer;

public class MainTest {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static EntityTransaction txn = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		emf = Persistence.createEntityManagerFactory("my-pu");
		em = emf.createEntityManager();
		txn = em.getTransaction();

		try {

			txn.begin();

			Conseiller conseiller1 = new Conseiller();
			Conseiller conseiller2 = new Conseiller();
			
			Customer customer1 = new Customer();
			Customer customer2 = new Customer();
			Customer customer3 = new Customer();
			Customer customer4 = new Customer();
			Customer customer5 = new Customer();
			Customer customer6 = new Customer();
			
			Adresse adresse1 = new Adresse();
			Adresse adresse2 = new Adresse();
			Adresse adresse3 = new Adresse();
			Adresse adresse4 = new Adresse();
			Adresse adresse5 = new Adresse();
			Adresse adresse6 = new Adresse();
			
			customer1.setConseiller(conseiller1);
			customer3.setConseiller(conseiller1);
			customer5.setConseiller(conseiller1);
			
			customer2.setConseiller(conseiller2);
			customer4.setConseiller(conseiller2);
			customer6.setConseiller(conseiller2);
			
			customer1.setAdresse(adresse1);
			customer2.setAdresse(adresse2);
			customer3.setAdresse(adresse3);
			customer4.setAdresse(adresse4);
			customer5.setAdresse(adresse5);
			customer6.setAdresse(adresse6);
			
			

			em.persist(conseiller1);
			em.persist(conseiller2);
			em.persist(customer1);
			em.persist(customer2);
			em.persist(customer3);
			em.persist(customer4);
			em.persist(customer5);
			em.persist(customer6);
			

			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

		}
		emf.close();

	}

}
