package rs.ac.bg.fon.nprog.mvnbiblioteka2019.biblioteka;


import java.util.LinkedList;
import java.util.List;
import rs.ac.bg.fon.nprog.mvnbiblioteka2019.biblioteka.Knjiga;
import rs.ac.bg.fon.nprog.mvnbiblioteka2019.biblioteka.interfejs.BibliotekaInterface;


public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige = new LinkedList<Knjiga>();


	public void dodajKnjigu(Knjiga k) {
		if (k == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(k))
			throw new RuntimeException("Knjiga ne sme vec postojati u biblioteci");
		
		knjige.add(k);
	}


	public void obrisiKnjigu(Knjiga k) {
		if (k == null)
			throw new RuntimeException("Knjiga ne sme biti null");

		knjige.remove(k);
	}


	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}


	public List<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && isbn == null && naslov == null && izdavac == null)
			throw new RuntimeException("Morate uneti bar jedan kriterijum za pretragu");
		
		LinkedList<Knjiga> rezultati = new LinkedList<Knjiga>();
		
		for (Knjiga knjiga: knjige)
			if (knjiga.getNaslov().contains(naslov))
				rezultati.add(knjiga);
		
		return rezultati;
	}
	
}
