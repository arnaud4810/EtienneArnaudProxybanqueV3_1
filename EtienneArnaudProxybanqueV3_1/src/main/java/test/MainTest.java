package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
			Customer customer1 = new Customer();

			em.persist(conseiller1);
			em.persist(customer1);

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
