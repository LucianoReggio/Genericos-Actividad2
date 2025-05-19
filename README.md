# 🧠 Proyecto Java – Interfaces y Genéricos

Este proyecto está dividido en cuatro partes y tiene como objetivo demostrar el uso de conceptos fundamentales en Java como interfaces genéricas, `Comparable`, `Comparator` y búsquedas genéricas. Cada parte se enfoca en una característica específica y muestra su implementación con ejemplos prácticos.

---

## 📚 Tabla de Contenidos 

1. [Interfaces Genéricos](#-parte-1-interfaces-genéricos)
2. [Comparable](#-parte-2-comparable)
3. [Comparator](#-parte-3-comparator)
4. [Buscador Genérico](#-parte-4-buscador-genérico) 
5. [Conclusión y aprendizaje](#-parte-5-conclusión-y-aprendizaje) 

---

## 🧩 Parte 1: Interfaces Genéricos

Esta sección del proyecto demuestra el uso de interfaces genéricas en Java para aplicar un mismo comportamiento a diferentes clases mediante el uso de **tipos genéricos**.

### ✨ Objetivo

Implementar una interfaz genérica llamada `Identificable<T>`, que obliga a las clases que la implementen a definir métodos para obtener y establecer un identificador (`ID`) de tipo genérico `T`.

### 📦 Clases involucradas

#### `Identificable<T>`

Es una interfaz genérica con dos métodos:

```java
public interface Identificable<T> {
    T getId();
    void setId(T t);
}
```

Permite que cualquier clase que la implemente defina el tipo de identificador que usará (por ejemplo, `String` o `Integer`).

---

#### `Persona`

Clase que representa una persona con nombre, apellido y DNI. Implementa `Identificable<Integer>`, utilizando el DNI como identificador.

```java
public class Persona implements Identificable<Integer> {
    private int DNI;
    private String nombre;
    private String apellido;

    // constructor, toString y métodos de Identificable...
}
```

---

#### `Auto`

Clase que representa un auto con color y patente. Implementa `Identificable<String>`, usando la **patente** como identificador.

```java
public class Auto implements Identificable<String> {
    private String color;
    private String patente;

    // constructor, toString y métodos de Identificable...
}
```

---

#### `Principal`

Clase principal con método `main` donde se crean objetos de `Persona` y `Auto`, se accede a sus identificadores y se los modifica usando la interfaz `Identificable`.

```java
public class Principal {
    public static void main(String[] args) {
        Persona p = new Persona("Gomez", 1234, "Luis");
        Auto a = new Auto("Rojo", "ABC123");
        identificar(p);
        identificar(a);
        // cambio de ID
        a.setId("ABD454");
        p.setId(15155);
        identificar(p);
        identificar(a);
    }

    public static void identificar(Identificable objIdentif) {
        System.out.println("Yo soy " + objIdentif.getId());
    }
}
```

### ✅ Conclusión

Esta parte ilustra cómo las interfaces genéricas permiten reutilizar lógica sin importar el tipo concreto de los objetos. Tanto `Persona` como `Auto` comparten la capacidad de ser "identificables", pero cada uno define su tipo de identificador (entero o cadena) según su necesidad.

---

## 🧩 Parte 2: Comparable

En esta sección se ejemplifica el uso de la interfaz `Comparable` de Java, que permite definir un **criterio de ordenamiento natural** para objetos de una clase.

### ✨ Objetivo

Implementar la interfaz `Comparable` en una clase personalizada (`Persona`), permitiendo ordenarla automáticamente con `Collections.sort()` según diferentes criterios (DNI, apellido, estatura, estado civil).

---

### 📦 Clases involucradas

#### `Persona implements Comparable<Persona>`

Clase que representa una persona con atributos como DNI, nombre, apellido, estatura y estado civil. Define su criterio de comparación por **DNI** en orden ascendente por defecto:

```java
@Override
public int compareTo(Persona otra) {
    return this.DNI - otra.DNI; // Orden natural ascendente por DNI
}
```

La clase incluye otros criterios de orden (comentados) que pueden activarse según necesidad:

* Ordenamiento por apellido (ascendente o descendente)
* Ordenamiento por estatura (double)
* Ordenamiento por estado civil (alfabético o por orden de declaración en el enum)

---

#### `EstadoCivil (enum)`

Enumeración que define los posibles estados civiles de una persona:

```java
public enum EstadoCivil {
    CASADO, SOLTERO, DIVORCIADO, VIUDO;
}
```

---

#### `TestComparable`

Clase principal que prueba el uso de `Comparable` con listas de enteros, cadenas y personas. Utiliza `Collections.sort()` para ordenar cada lista:

```java
ArrayList<Persona> personas = new ArrayList<>();
personas.add(new Persona(...));
Collections.sort(personas); // Usa compareTo()
```

Además, muestra el contenido de las listas ordenadas mediante un método genérico `mostrarLista`.

---

### ✅ Conclusión

Gracias a la implementación de `Comparable`, la clase `Persona` puede ordenarse automáticamente según un criterio definido. Esto permite reutilizar `Collections.sort()` sin necesidad de lógica adicional. Cambiar el criterio de orden es tan simple como modificar el método `compareTo`.

---

## ⚖️ Parte 3: Comparator

En esta sección se implementan distintos comparadores utilizando la interfaz `Comparator`, con el fin de definir **ordenamientos personalizados externos** a las clases comparadas.

### ✨ Objetivo

Demostrar cómo aplicar distintos criterios de ordenamiento sin alterar la clase de los objetos, creando comparadores reutilizables.

---

### 📦 Clases involucradas

#### `Auto`

Clase simple con `patente` y `kilometraje`. No implementa `Comparable`, lo cual permite ordenarla usando distintos `Comparator`.

---

#### Comparadores

Se crean varias clases que implementan `Comparator<T>`:

* `ComparadorDeAutosPorKilometraje`: Ordena los autos por kilometraje. Admite orden ascendente o descendente según un parámetro booleano en el constructor.

  ```java
  new ComparadorDeAutosPorKilometraje(true);  // Ascendente
  new ComparadorDeAutosPorKilometraje(false); // Descendente
  ```

* `ComparadorDeAutosPorPatente`: Ordena los autos alfabéticamente por su patente.

* `ComparadorDeCadenas`: Ordena las cadenas de texto en orden descendente (Z-A).

* `ComparadorDeEnteros`: Ordena los números enteros en orden ascendente.

---

#### `TestComparator`

Clase principal que prueba los distintos comparadores sobre listas de enteros, strings y autos. Usa `Collections.sort(lista, comparator)` para aplicar el criterio correspondiente:

```java
Collections.sort(numeros, new ComparadorDeEnteros());
Collections.sort(colores, new ComparadorDeCadenas());
Collections.sort(autos, new ComparadorDeAutosPorKilometraje(false));
```

El resultado se muestra con un método genérico `mostrarLista`.

---

### ✅ Conclusión

El uso de `Comparator` permite separar la lógica de ordenamiento de la clase original, haciendo más flexible y reutilizable el código. Se pueden crear múltiples criterios para la misma clase, sin modificar su implementación.

---

## 🔍 Parte 4: Buscador Genérico

Esta sección presenta una implementación genérica de un buscador, capaz de buscar cualquier tipo de objeto que implemente una interfaz `Identificable`.

---

### 🎯 Objetivo

Generalizar la lógica de búsqueda para que funcione con cualquier tipo de objeto, siempre que implemente una interfaz que provea un método de identificación (`getId()` / `sameId()`).

---

### 🔧 Clases involucradas

#### `Identificable<T>`

Interfaz genérica que define tres métodos esenciales para identificación:

```java
public interface Identificable<T> {
    T getId();
    void setId(T x);
    boolean sameId(T anotherID);
}
```

---

#### Clases que implementan `Identificable`

* `Auto`: Usa una **`String`** como identificador (`patente`).
* `Persona`: Usa un **`Integer`** como identificador (`DNI`).

Cada clase implementa los métodos definidos por la interfaz `Identificable<T>`.

---

#### `Buscador<T extends Identificable, K>`

Clase genérica que permite buscar elementos dentro de una colección a partir de un ID, utilizando el método `sameId()`.

```java
public T buscar(Collection<? extends T> elementos, K id)
```

* Utiliza **bounded generics** para asegurar que `T` implemente `Identificable`.
* El método recorre la colección y devuelve el primer objeto cuya identificación coincide con el valor buscado.

---

#### `Principal`

Contiene dos ejemplos prácticos del uso del `Buscador`:

1. Buscar un `Auto` por patente.
2. Buscar una `Persona` por DNI.

```java
Auto a = buscadorDeAutosPorPatente.buscar(autos, "CDE345");
Persona p = buscadorDePersonasPorDNI.buscar(personas, 2345);
```

Ambos resultados se muestran por consola.

---

### ✅ Conclusión

Este diseño genérico demuestra cómo aplicar la **programación genérica con restricciones** (`bounded types`) para crear componentes reutilizables y seguros en tiempo de compilación. El buscador funciona con cualquier tipo de objeto identificable, lo que favorece la escalabilidad y reutilización del código.

---

## ✅ Parte 5: Conclusión y aprendizaje

Este proyecto aborda conceptos fundamentales de Java genérico y diseño orientado a objetos:

* Uso de interfaces genéricas para flexibilidad.
* Implementación de `Comparable` para ordenamiento natural.
* Creación de `Comparator` para múltiples criterios de ordenamiento.
* Aplicación de tipos genéricos acotados (`T extends ...`) para validar comportamientos en tiempo de compilación.

Estas herramientas son clave para desarrollar software robusto, reutilizable y adaptable a distintos contextos sin duplicar código.

---






