package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Producto p1 = new Producto("P100", "Monitor", "Dell", 250.00);
        Producto p2 = new Producto("P101", "Laptop", "HP", 899.99);
        Producto p3 = new Producto("P102", "Teclado", "Logitech", 45.50);


        List<ProductoRecord> productosRecord = new ArrayList<>();


        productosRecord.add(new ProductoRecord(p1.getCodigo(), p1.getNombre(), p1.getPrecio()));
        productosRecord.add(new ProductoRecord(p2.getCodigo(), p2.getNombre(), p2.getPrecio()));
        productosRecord.add(new ProductoRecord(p3.getCodigo(), p3.getNombre(), p3.getPrecio()));


        System.out.println("=== Productos DTO (Record) ===");
        for (ProductoRecord pr : productosRecord) {
            System.out.println("Código: " + pr.codigo() +
                    ", Nombre: " + pr.nombre() +
                    ", Precio: $" + pr.precio());
        }
    }
}
