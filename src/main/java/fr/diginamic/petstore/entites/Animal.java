package fr.diginamic.petstore.entites;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date birth;
	private String couleur;

	@ManyToOne
	@JoinColumn(name = "id_petstore")
	private PetStore petStore;

	/**
	 * 
	 */
	public Animal() {
	}

	/**
	 * @param birth
	 * @param couleur
	 */
	public Animal(Date birth, String couleur) {
		this.birth = birth;
		this.couleur = couleur;
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
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the petStore
	 */
	public PetStore getPetStore() {
		return petStore;
	}

	/**
	 * @param petStore the petStore to set
	 */
	public void setPetStore(PetStore petStore) {
		if (this.petStore != null) 
			this.petStore.getAnimals().remove(this);
		this.petStore = petStore;
		if (this.petStore != null) 
			this.petStore.getAnimals().add(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [id=");
		builder.append(id);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append("]");
		return builder.toString();
	}


}
