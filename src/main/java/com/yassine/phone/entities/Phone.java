package com.yassine.phone.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Phone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String couleur;
    private String marque;
    private Date dateCreation;
    private double prix;
    private int ram;
    private int stockage;
    @ManyToOne
    private Type type;
    /*@OneToOne
    private Image image;*/
    
    @OneToMany (mappedBy = "phone")
	private List<Image> images;
	 

    // Constructeur par défaut
    public Phone() {
        super();
    }

    // Constructeur avec paramètres
    public Phone(String couleur,  Date dateCreation,String marque, double prix, int ram, int stockage) {
        super();
        this.couleur = couleur;
        this.marque = marque;
        this.dateCreation = dateCreation;
        this.prix = prix;
        this.ram = ram;
        this.stockage = stockage;
    }

    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	// Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStockage() {
        return stockage;
    }

    public void setStockage(int stockage) {
        this.stockage = stockage;
    }

    // Méthode toString pour afficher l'objet Phone
    @Override
    public String toString() {
        return "Phone [id=" + id + ", couleur=" + couleur + ", marque=" + marque +
                ", dateCreation=" + dateCreation + ", prix=" + prix +
                ", ram=" + ram + " Go, stockage=" + stockage + " Go]";
    }
    public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	

}
