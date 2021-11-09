package fr.diginamic.petstore.entites;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Fish extends Animal {

	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;

	/**
	 * 
	 */
	public Fish() {
		super();
	}

	/**
	 * @param birth
	 * @param couleur
	 */
	public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
		super(birth, couleur);
		// TODO Auto-generated constructor stub
		this.livingEnv = livingEnv;
	}

	/**
	 * @return the livingEnv
	 */
	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	/**
	 * @param livingEnv the livingEnv to set
	 */
	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}
	
	
}
