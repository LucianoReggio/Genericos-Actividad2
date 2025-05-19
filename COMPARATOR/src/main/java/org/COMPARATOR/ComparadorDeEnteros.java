package COMPARATOR;
import java.util.Comparator;


public class ComparadorDeEnteros implements Comparator<Integer> {
    // Si el 1ro va antes que el 2do, retorno un NEGATIVO
    // Si el 1ro va después que el 2do, retorno un POSITIVO
    // Si son iguales, retorno un cero

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }

}