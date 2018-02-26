package fr.eni.clinique.bo;

public class Client {
	private Integer codeClient;
	private String nomClient;
	private String prenomClient;
	private String adresse1;
	private String adresse2;
	private String ville;
	private String numTel;
	private String assurance;
	private String email;
	private String remarque;
	private Boolean archive;	
	
	/**
	 * @param nomClient
	 * @param prenomClient
	 * @param adresse1
	 * @param adresse2
	 * @param ville
	 * @param numTel
	 * @param assurance
	 * @param email
	 * @param remarque
	 * @param archive
	 */
	public Client(String nomClient, String prenomClient, String adresse1, String adresse2, String ville, String numTel,
			String assurance, String email, String remarque, Boolean archive) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.ville = ville;
		this.numTel = numTel;
		this.assurance = assurance;
		this.email = email;
		this.remarque = remarque;
		this.archive = archive;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/**
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	/**
	 * @return the adresse1
	 */
	public String getAdresse1() {
		return adresse1;
	}

	/**
	 * @param adresse1 the adresse1 to set
	 */
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	/**
	 * @return the adresse2
	 */
	public String getAdresse2() {
		return adresse2;
	}

	/**
	 * @param adresse2 the adresse2 to set
	 */
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}

	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/**
	 * @return the assurance
	 */
	public String getAssurance() {
		return assurance;
	}

	/**
	 * @param assurance the assurance to set
	 */
	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the remarque
	 */
	public String getRemarque() {
		return remarque;
	}

	/**
	 * @param remarque the remarque to set
	 */
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	/**
	 * @return the archive
	 */
	public Boolean getArchive() {
		return archive;
	}

	/**
	 * @param archive the archive to set
	 */
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
		.append("Client [codeClient=")
		.append(codeClient)
		.append(", nomClient=")
		.append(nomClient)
		.append(", prenomClient=")
		.append(prenomClient)
		.append(", adresse1=")
		.append(adresse1)
		.append(", adresse2=")
		.append(adresse2)
		.append(", ville=")
		.append(ville)
		.append(", numTel=")
		.append(numTel)
		.append(", assurance=")
		.append(assurance)
		.append(", email=")
		.append(email)
		.append(", remarque=")
		.append(remarque)
		.append(", archive=")
		.append(archive)
		.toString();
	}
	
	

}
