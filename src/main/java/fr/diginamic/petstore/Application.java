package fr.diginamic.petstore;

import java.sql.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.petstore.entites.Adress;
import fr.diginamic.petstore.entites.Animal;
import fr.diginamic.petstore.entites.Cat;
import fr.diginamic.petstore.entites.Fish;
import fr.diginamic.petstore.entites.FishLivEnv;
import fr.diginamic.petstore.entites.PetStore;
import fr.diginamic.petstore.entites.ProdType;
import fr.diginamic.petstore.entites.Product;

public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger( Application.class );
	private static final String DATABASE_NAME;
	private static final String REQUEST_ANIMAL;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("petstore");
		DATABASE_NAME = rb.getString("jpa.db.name");
		REQUEST_ANIMAL = rb.getString("jpa.request.animaux");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


        EntityManagerFactory emf = Persistence.createEntityManagerFactory( DATABASE_NAME );
        EntityManager em = emf.createEntityManager();
        //Produits
        Product product1 = new Product("aa", "la", 10, ProdType.FOOD);
        Product product2 = new Product("bb", "lb", 20, ProdType.ACCESSORY);
        Product product3 = new Product("cc", "lc", 30, ProdType.CLEANING);
        
        //PetStore
        PetStore petstore1 = new PetStore("le a", "A a", new Adress("1", "rue a", "10000", "Aaaa"));
        PetStore petstore2 = new PetStore("le b", "B b", new Adress("2", "rue b", "20000", "Bbbb"));
        PetStore petstore3 = new PetStore("le c", "C c", new Adress("3", "rue c", "30000", "Cccc"));
        
        //Animaux
        Animal chat = new Cat(new Date(121, 10, 20), "kalinko", "a1AA");
        Animal poisson1 = new Fish(new Date(121, 11, 21), "rouge", FishLivEnv.FRESH_WATER);
        Animal poisson2 = new Fish(new Date(121, 12, 22), "jaune", FishLivEnv.SEA_WATER);
        
        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        
        em.persist(petstore1);
        em.persist(petstore2);
        em.persist(petstore3);

        petstore1.addAnimal(chat);
        petstore1.addAnimal(poisson1);
        petstore1.addAnimal(poisson2);

        product1.addPetStore(petstore2);

        em.getTransaction().commit();
        
        TypedQuery<PetStore> query = em.createQuery(REQUEST_ANIMAL, PetStore.class);        
        PetStore petstoreSeek = query.getResultList().get(0);
        
        for (Animal animal : petstoreSeek.getAnimals()) {
        	System.out.println(animal.toString());
		}
        
        em.close();
        emf.close();
	}

}
