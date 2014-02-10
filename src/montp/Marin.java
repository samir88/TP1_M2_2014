package montp;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity(name="Marin") 
@Table(
		    name="marin",
		    uniqueConstraints={
		        @UniqueConstraint(name="nom_prenom",columnNames={"nom", "prenom"})})
public  class Marin  implements Serializable {

		    	private String nom,prenom;
		    	@Column(name="datedenaissance")
		        @Temporal(TemporalType.DATE)
		        private Date datedenaissance ;

		    	@Id
		        @GeneratedValue(strategy = GenerationType.AUTO)
		    	private Long id;
		    	@ManyToOne(cascade=CascadeType.PERSIST)
		        private Bateau bateau ;
	public String getNom() {
					return nom;
				}

				public void setNom(String nom) {
					this.nom = nom;
				}

				public String getPrenom() {
					return prenom;
				}

				public void setPrenom(String prenom) {
					this.prenom = prenom;
				}

				public Date getDatedenaissance() {
					return datedenaissance;
				}

				public void setDatedenaissance(Date datedenaissance) {
					this.datedenaissance = datedenaissance;
				}

				public Long getId() {
					return id;
				}

				@Override
				public String toString() {
					return "Marin [nom=" + nom + ", prenom=" + prenom
							+ ", datedenaissance=" + datedenaissance + ", id="
							+ id + "]";
				}

				public void setId(Long id) {
					this.id = id;
				}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-JPA") ;

	        EntityManager em = emf.createEntityManager() ;

	        Marin marin =  new Marin() ;
	        Calendar cal = Calendar.getInstance();
	        cal.set(1989, 5,15);
	        marin.datedenaissance=cal.getTime();
	        marin.nom="hammoum";
	        marin.prenom="karim";
	        
	        em.getTransaction().begin() ;
	        em.persist(marin) ;
	        em.getTransaction().commit() ;
	        
	        Marin marin1 =  new Marin() ;
	        Calendar cal1 = Calendar.getInstance();
	        cal1.set(1986, 10,16);
	        marin1.datedenaissance=cal1.getTime();
	        marin1.nom="toumert";
	        marin1.prenom="mouloud";
	        
	        em.getTransaction().begin() ;
	        em.persist(marin1) ;
	        em.getTransaction().commit() ;
	        
	        System.out.println("Marin recherché est : "+em.find(Marin.class, 1L)) ;
	        System.out.println("Marin recherché est : "+em.find(Marin.class, 2L)) ;
	        
	        //em.find(Marin.class, 1L);

	        //System.out.println("Id = " + marin.getId()) ;
	
	        

	 
	 }

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	

	}

