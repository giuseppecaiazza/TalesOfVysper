package it.begear.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="guerrieri")
public class Guerriero extends Eroe{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id_guerrieri")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "forza")
	private int forza;
	
	@Column(name = "destrezza")
	private int destrezza;
	
	@Column(name = "saggezza")
	private int saggezza;
	
	@Column(name = "livello")
	private int livello;
	
	@Column(name = "hp")
	private int hp;

	@Column(name="utente")
	private String utente;
	
	@Column(name= "difesa")
	private int difesa;
	
	@Column(name="id_arma")
	private int id_arma;
	
	@Column(name="id_armatura")
	private int id_armatura; 
	
	public Guerriero() {};
	public Guerriero (String utente, String nome) {
		this.utente= utente;
		this.nome=nome;
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
	public int getDifesa() {
		return difesa;
	}
	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}
	public int getId() {
		return id;
	}

	public void setId(int id_guerriero) {
		this.id = id_guerriero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
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

	
}
