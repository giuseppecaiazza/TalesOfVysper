package it.begear.corso.model;

public class Eroe {

	private int id;
	private String nome;
	private int livello;
	private int forza;
	private int destrezza;
	private int saggezza;
	private int hp;
	private String utente;
	private String classe;
	private int difesa;
	private int id_arma;
	private int id_armatura;

	public Eroe (String utente) {
		this.utente=utente;
	}

	public Eroe() {};


	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getId_arma() {
		return id_arma;
	}

	public void setId_arma(int id_arma) {
		this.id_arma = id_arma;
	}

	public int getId_armatura() {
		return id_armatura;
	}

	public void setId_armatura(int id_armatura) {
		this.id_armatura = id_armatura;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getLivello() {
		return livello;
	}


	public void setLivello(int livello) {
		this.livello = livello;
	}


	public int getForza() {
		return forza;
	}


	public void setForza(int forza) {
		this.forza = forza;
	}


	public int getDestrezza() {
		return destrezza;
	}


	public void setDestrezza(int destrezza) {
		this.destrezza = destrezza;
	}


	public int getSaggezza() {
		return saggezza;
	}


	public void setSaggezza(int saggezza) {
		this.saggezza = saggezza;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public String getUtente() {
		return utente;
	}


	public void setUtente(String utente) {
		this.utente = utente;
	}


	public String AbilitaSpeciale(String classe) {
		if (classe.equalsIgnoreCase("arciere")){
			String skillarciere = "L'arciere invoca la forza del drago e lancia una freccia potentissima!";
			return skillarciere;
		} else if (classe.equalsIgnoreCase("guerriero")) {
			String skillguerriero = "Il guerriero spacca il suolo con la sua spada e provoca un'eruzione!";
			return skillguerriero;
		} else {
			String skillmago = "Il mago evoca un fascio di luce e spazza via l'oscurità!";
			return skillmago;
		}
	};
}
