package rh.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Projet implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String intitule;
	private  Date dateDebut;
	private Date dateFin;
	
	
	@ManyToMany(mappedBy="projets")
	//@JsonBackReference
	private Set<Collaborateur> collaborateurs;

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projet(Long id, String intitule, Date dateDebut, Date dateFin) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Set<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(Set<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public Projet(Long id, String intitule, Date dateDebut, Date dateFin,
			Set<Collaborateur> collaborateurs) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateurs = collaborateurs;
	}
	
	
	
	
	

}