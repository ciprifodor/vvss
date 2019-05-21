package biblioteca;


import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntT_TD {
    private BibliotecaCtrl bibliotecaCtrl;
    private CartiRepoMock cartiRepoMock;

    @Before
    public void init() {
        this.cartiRepoMock = new CartiRepoMock();
        this.bibliotecaCtrl = new BibliotecaCtrl(cartiRepoMock);
    }

    @Test
    public void testareUnitaraF01() {
        Carte carte = new Carte();
        carte.setTitlu("Ion");
        carte.setAnAparitie("1601");
        carte.setReferenti(Arrays.asList("Liviu Rebreanu"));
        carte.setEditura("sds");
        try {
            cartiRepoMock.adaugaCarte(carte);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            assertEquals(7, cartiRepoMock.getCarti().size());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testareUnitaraF02() {
        try {
            cartiRepoMock.adaugaCarte(Carte.getCarteFromString("Morometii;Marin Preda;1973;Corint;povesti,povestiri"));
            cartiRepoMock.adaugaCarte(Carte.getCarteFromString("Scrisoarea I;Eminescu;1973;Corint;povesti,povestiri"));
            cartiRepoMock.adaugaCarte(Carte.getCarteFromString("Ion;Liviu Rebreanu;1973;Corint;povesti,povestiri"));
            List<Carte> carti = cartiRepoMock.cautaCarte("Eminescu");
            assertEquals(carti.size(), 1);
            assertEquals(carti.get(0).getTitlu(), "Scrisoarea I");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testareUnitaraF03() {
        try {
            List<Carte> cartiOrdonate = cartiRepoMock.getCartiOrdonateDinAnul("1948");
            assertEquals(cartiOrdonate.size(), 3);
            assertEquals(cartiOrdonate.get(0).getTitlu(), "Dale carnavalului");
            assertEquals(cartiOrdonate.get(1).getTitlu(), "Enigma Otiliei");
            assertEquals(cartiOrdonate.get(2).getTitlu(), "Intampinarea crailor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIntegrareA() {
        Carte carte = new Carte();
        carte.setTitlu("Ion");
        carte.setAnAparitie("1948");
        carte.setReferenti(Arrays.asList("Liviu Rebreanu"));
        carte.setEditura("sds");

        try {
            bibliotecaCtrl.adaugaCarte(carte);
            assertEquals(bibliotecaCtrl.getCarti().size(), 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testIntegrareAB() {
        Carte carte = new Carte();
        carte.setTitlu("Ion");
        carte.setAnAparitie("1948");
        carte.setReferenti(Arrays.asList("Liviu Rebreanu"));
        carte.setEditura("sds");

        try {
            bibliotecaCtrl.adaugaCarte(carte);
            List<Carte> carti = bibliotecaCtrl.cautaCarte("Liviu Rebreanu");
            assertEquals(carti.size(), 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testIntegrareABC() {
        Carte carte = new Carte();
        carte.setTitlu("Ion");
        carte.setAnAparitie("1948");
        carte.setReferenti(Arrays.asList("Liviu Rebreanu"));
        carte.setEditura("sds");
        try {
            bibliotecaCtrl.adaugaCarte(carte);
            assertEquals(bibliotecaCtrl.getCarti().size(), 7);
            List<Carte> carti = bibliotecaCtrl.cautaCarte("Liviu");
            assertEquals(carti.size(), 1);
            List<Carte> cartiOrdonate = bibliotecaCtrl.getCartiOrdonateDinAnul("1948");
            assertEquals(cartiOrdonate.size(), 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
