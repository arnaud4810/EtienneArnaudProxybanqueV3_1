package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.CompteCourant;
import model.CompteEpargne;
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
			
			CompteCourant cc1 = new CompteCourant();
			CompteCourant cc11 = new CompteCourant();
			CompteCourant cc2 = new CompteCourant();
			CompteCourant cc3 = new CompteCourant();
			CompteCourant cc4 = new CompteCourant();
			CompteCourant cc5 = new CompteCourant();
			CompteCourant cc6 = new CompteCourant();
			
			CompteEpargne ce1 = new CompteEpargne();
			CompteEpargne ce2 = new CompteEpargne();
			CompteEpargne ce3 = new CompteEpargne();
			CompteEpargne ce4 = new CompteEpargne();
			CompteEpargne ce5 = new CompteEpargne();
			CompteEpargne ce6 = new CompteEpargne();
			
			
			cc1.setClient(customer1);
			cc11.setClient(customer1);
			cc2.setClient(customer2);
			cc3.setClient(customer3);
			cc4.setClient(customer4);
			cc5.setClient(customer5);
			cc6.setClient(customer6);
			
			ce1.setClient(customer1);
			ce2.setClient(customer2);
			ce3.setClient(customer3);
			ce4.setClient(customer4);
			ce5.setClient(customer5);
			ce6.setClient(customer6);
			
						
//			em.persist(conseiller1);
//			em.persist(conseiller2);
//			em.persist(customer1);
//			em.persist(customer2);
//			em.persist(customer3);
//			em.persist(customer4);
//			em.persist(customer5);
//			em.persist(customer6);
			em.persist(cc1);
			em.persist(cc11);
			em.persist(ce1);
			em.persist(ce2);
			em.persist(ce3);
			em.persist(ce4);
			em.persist(ce5);
			em.persist(ce6);
			
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
