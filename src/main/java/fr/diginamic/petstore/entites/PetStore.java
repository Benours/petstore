package fr.diginamic.petstore.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PetStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String managerName;
	
	@Embedded
	private Adress adress;
	
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
	private Set<Animal> animals = new HashSet<Animal>();
	
	@ManyToMany
	@JoinTable(name = "PROD_PET",
			joinColumns = @JoinColumn(name = "id_pet", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "id_prod", referencedColumnName = "ID"))
	private Set<Product> products = new HashSet<Product>();
	
	/**
	 * 
	 */
	public PetStore() {
	}

	/**
	 * @param name
	 * @param managerName
	 * @param adress
	 */
	public PetStore(String name, String managerName, Adress adress) {
		this.name = name;
		this.managerName = managerName;
		this.adress = adress;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * @return the animals
	 */
	public Set<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @param animals the animals to set
	 */
	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addAnimal(Animal animal) {
		animal.setPetStore(this);
	}
	
	public void removeAnimal(Animal animal) {
		animal.setPetStore(null);
	}	
	
	public void addProduct(Product product) {
		product.getPetStores().add(this);
	}
	
	public void removeProduct(Product product) {
		product.getPetStores().remove(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PetStore [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", adress=");
		builder.append(adress.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
}
