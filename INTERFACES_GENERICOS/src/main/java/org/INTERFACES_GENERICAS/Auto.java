package INTERFACES_GENERICAS;

public class Auto implements Identificable<String > {
    private String patente;
    private String color;

    public Auto(String color, String patente) {
        this.color = color;
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "color='" + color + '\'' +
                ", patente='" + patente + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return patente;
    }

    @Override
    public void setId(String s) {
        this.patente = s;
    }
}
