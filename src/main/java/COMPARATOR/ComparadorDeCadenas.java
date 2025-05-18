package COMPARATOR;
import java.util.Comparator;


public class ComparadorDeCadenas implements Comparator<String> {
    // Si el 1ro va antes que el 2do, retorno un NEGATIVO
    // Si el 1ro va después que el 2do, retorno un POSITIVO
    // Si son iguales, retorno un cero

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

}