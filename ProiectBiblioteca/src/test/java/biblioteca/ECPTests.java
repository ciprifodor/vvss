package biblioteca;

import biblioteca.model.Carte;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ECPTests {

    @Test
    public void testBook(){
        Carte carte = new Carte();

        carte.setAnAparitie("1997");
        carte.setCuvinteCheie(Arrays.asList("primul","doilea","treilea"));
        carte.setEditura("Edituraa");
        carte.setReferenti(Arrays.asList("primul","doilea","treilea"));
        carte.setTitlu("titlul");
        assert(runTests(carte));
        carte.setAnAparitie(getStringWithSize(256));
        carte.setCuvinteCheie(Arrays.asList("primul","doilea",getStringWithSize(256)));
        carte.setEditura(getStringWithSize(256));
        carte.setReferenti(Arrays.asList(getStringWithSize(256),"doilea","treilea"));
        carte.setTitlu(getStringWithSize(256));
        assert(runTests(carte));
    }

    private boolean runTests(Carte carte){
        boolean passed = true;
        try {
            assert (carte.getTitlu().length() < 255);
            assert (carte.getCuvinteCheie().size() < 12);
            for (String cuvantCheie : carte.getCuvinteCheie()) {
                assert (cuvantCheie.length() < 255);
            }
            assert (carte.getEditura().length() < 255);
            assert (carte.getReferenti().size() < 12);
            for (String cuvantCheie : carte.getReferenti()) {
                assert (cuvantCheie.length() < 255);
            }
            assert (carte.getAnAparitie().length() < 5);
            assert (carte.getAnAparitie().length() >= 3);
        }catch(AssertionError ex){
            passed=false;
        }
        return passed;
    }

    private String getStringWithSize(int size){
        String stringy= "";
        Random r = new Random();
        while(stringy.length()<size){
            char c = (char)(r.nextInt(26) + 'a');
            stringy += c;
        }
        return stringy;
    }
}
