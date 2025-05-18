package COMPARATOR;
import java.util.Comparator;


public class ComparadorDeAutosPorPatente implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getPatente().compareTo(o2.getPatente());
    }

}