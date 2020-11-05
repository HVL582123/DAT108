package no.hvl.dat108;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless					
public class PersonDAO {

	@PersistenceContext(name = "personPU")
	private EntityManager em;
	
	public PersonDAO() {}
	
	public List<Person> paameldingsliste(){
		List<Person> listen = em.createQuery("SELECT p FROM Person p").getResultList();
		
		Comparator<Person> sorterFnavn = (p,q) -> p.getFnavn().compareToIgnoreCase(q.getFnavn());
		Comparator<Person> sorterEnavn = (p,q) -> p.getEnavn().compareToIgnoreCase(q.getEnavn());
		
		return listen.stream()
		.sorted(sorterFnavn.thenComparing(sorterEnavn))
		.collect(Collectors.toList());
		
		
	}
	
	public void leggTil(Person person) {
		em.persist(person);
	}
	
	public Person finnPerson(String mobilnr) {
		return (Person) em.find(Person.class, mobilnr);
	}
}
