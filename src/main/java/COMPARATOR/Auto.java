package COMPARATOR;

public class Auto {
    private String patente;
    private int kilometraje;

    public Auto(String patente, int kilometraje) {
        this.patente = patente;
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", kilometraje=" + kilometraje + '}';
    }

    public String getPatente() {
        return patente;
    }

    public int getKilometraje() {
        return kilometraje;
    }


}
