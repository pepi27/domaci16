package com.webshop.obj;

public class Proizvod {

	private long id, kategorijaID; 
	private String naziv, nazivK; 
	private double cena;
	
	
	public Proizvod(long id, String naziv, double cena, long kategorijaID, String nazivK) {
		this.id = id;
		this.kategorijaID = kategorijaID; 
		this.naziv = naziv;
		this.nazivK = nazivK; 
		this.cena = cena;
	}
	
	public Proizvod(long id, String naziv, double cena) {
		this.id = id; 
		this.naziv = naziv; 
		this.cena = cena; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public long getKategorijaID() {
		return kategorijaID;
	}

	public void setKategorijaID(long kategorijaID) {
		this.kategorijaID = kategorijaID;
	}

	public String getNazivK() {
		return nazivK;
	}

	public void setNazivK(String nazivK) {
		this.nazivK = nazivK;
	} 
	
	
}