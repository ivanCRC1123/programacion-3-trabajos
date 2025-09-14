package org.example;

public class Main {
    public static void main(String[] args) {
        // Instanciar con constructor lleno
        Persona p1 = new Persona("Ana", 30);

        // Instanciar con constructor vacío y luego setear valores
        Persona p2 = new Persona();
        p2.setNombre("Luis");
        p2.setEdad(25);

        // Mostrar atributos
        System.out.println("Persona 1: " + p1.getNombre() + ", " + p1.getEdad());
        System.out.println("Persona 2: " + p2.getNombre() + ", " + p2.getEdad());
    }
}
