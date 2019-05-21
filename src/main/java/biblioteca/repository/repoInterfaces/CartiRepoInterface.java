package biblioteca.repository.repoInterfaces;


import biblioteca.model.Carte;
import biblioteca.util.exceptions.InvalidValueException;

import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c) throws Exception;
	void modificaCarte(Carte nou, Carte vechi);
	void stergeCarte(Carte c);
	List<Carte> cautaCarte(String ref) throws Exception;
	List<Carte> getCarti();
	List<Carte> getCartiOrdonateDinAnul(String an) throws Exception;
}
