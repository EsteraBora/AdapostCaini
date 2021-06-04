package ro.emanuel.adapost.pojo;

public class Voluntari {

	private int id;
	private String nume;
	private String functie;
	private int vechime;
	
	public Voluntari(int id, String nume, String functie, int vechime) {
		super();
		this.id = id;
		this.nume = nume;
		this.functie = functie;
		this.vechime = vechime;
	}

	public Voluntari() {
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

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}
	
	
}
