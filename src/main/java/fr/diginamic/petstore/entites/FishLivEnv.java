package fr.diginamic.petstore.entites;

public enum FishLivEnv {
	FRESH_WATER("fresh_water"),
	SEA_WATER("sea_water");
	
	private String libelle;
	
	private FishLivEnv(String nom) {
		this.libelle = nom;
	}

	public String getNom() {
		return libelle;
	}
	
	public void setNom(String nom) {
		this.libelle = nom;
	}
	
	public static FishLivEnv getInstance(String libelle) {
		for (FishLivEnv livEnv : FishLivEnv.values()) {
			if (livEnv.getNom().equals(libelle)) {
				return livEnv;
			}
		}
		return null;
	}

}
