package Interfaces_GENÉRICAS_en_Java;

public class Persona implements Identificable<Integer>{
    private int DNI;
    private String nombre;
    private String apellido;

    public Persona(String apellido, int DNI, String nombre) {
        this.apellido = apellido;
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", DNI=" + DNI +
                ", nombre='" + nombre + '\'' +
                '}';
    }


    @Override
    public Integer getId() {
        return DNI;
    }

    @Override
    public void setId(Integer integer) {
        this.DNI = integer;
    }
}
