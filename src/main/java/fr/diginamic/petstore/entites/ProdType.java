package fr.diginamic.petstore.entites;

public enum ProdType {
	FOOD("food"),
	ACCESSORY("accessory"),
	CLEANING("cleaning");
	
	private String libelle;
	
	private ProdType(String nom) {
		this.libelle = nom;
	}
	
	public String getNom() {
		return libelle;
	}
	
	public void setNom(String nom) {
		this.libelle = nom;
	}
	
	public static ProdType getInstance(String libelle) {
		for (ProdType prodType : ProdType.values()) {
			if (prodType.getNom().equals(libelle)) {
				return prodType;
			}
		}
		return null;
	}

}
