package Interfaces_GENÉRICAS_en_Java;

public class Principal {
    public static void main (String[] args){
        Persona p = new Persona("Gomez", 1234, "Luis");
        Auto a = new Auto("Rojo", "ABC123");
        identificar(p);
        identificar(a);
        a.setId("ABD454");
        p.setId(15155);
        identificar(p);
        identificar(a);
    }
    public static void identificar(Identificable objIdentif) {
        System.out.println("Yo soy " + objIdentif.getId());
    }
}
