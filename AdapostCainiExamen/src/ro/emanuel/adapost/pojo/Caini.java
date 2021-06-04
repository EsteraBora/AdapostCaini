package ro.emanuel.adapost.pojo;

public class Caini {
	
	private int id;
	private String nume;
	private String rasa;
	private int varsta;
	
	public Caini(int id, String nume, String rasa, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.rasa = rasa;
		this.varsta = varsta;
	}

	public Caini() {
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

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	

}
