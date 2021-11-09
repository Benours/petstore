package fr.diginamic.petstore.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String label;
	private double price;
	
	@Enumerated(EnumType.STRING)
	private ProdType type;
	
	@ManyToMany(mappedBy = "products")
	private Set<PetStore> petStores = new HashSet<PetStore>();

	/**
	 * 
	 */
	public Product() {
	}

	/**
	 * @param code
	 * @param label
	 * @param price
	 * @param type
	 */
	public Product(String code, String label, double price, ProdType type) {
		this.code = code;
		this.label = label;
		this.price = price;
		this.type = type;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public ProdType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProdType type) {
		this.type = type;
	}

	/**
	 * @return the petStores
	 */
	public Set<PetStore> getPetStores() {
		return petStores;
	}

	/**
	 * @param petStores the petStores to set
	 */
	public void setPetStores(Set<PetStore> petStores) {
		this.petStores = petStores;
	}
	
	public void addPetStore(PetStore petStore) {
		petStore.getProducts().add(this);
	}
	
	public void removePetStore(PetStore petStore) {
		petStore.getProducts().remove(this);
	}	
	
	
}
