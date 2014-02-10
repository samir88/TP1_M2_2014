package montp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

@Entity(name="Bateau")
public  class Bateau  implements Serializable {
	@SuppressWarnings("unused")
	private String nom;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy="bateau")
	private Collection<Marin> equipage ;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Marin> getEquipage() {
		return equipage;
	}

	public void setEquipage(Collection<Marin> equipage) {
		this.equipage = equipage;
	}
}
