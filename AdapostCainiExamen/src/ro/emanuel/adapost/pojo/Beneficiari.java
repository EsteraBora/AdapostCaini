package ro.emanuel.adapost.pojo;

public class Beneficiari {
	
	private int id;
	private String nume;
	private int varsta;
	private String adresa;
	private int caineID;
	
	public Beneficiari(int id, String nume, int varsta, String adresa, int caineID) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
		this.adresa = adresa;
		this.caineID = caineID;
	}

	public Beneficiari() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getCaineID() {
		return caineID;
	}

	public void setCaineID(int caineID) {
		this.caineID = caineID;
	}
	

}
