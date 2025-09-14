package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Producto prod1 = new Producto("P001", "Teclado", 29.99, "Juan Pérez");
        Producto prod2 = new Producto("P002", "Ratón", 15.50, "Ana Gómez");


        ProductoDTO dto1 = new ProductoDTO();
        dto1.setCodigo(prod1.getCodigo());
        dto1.setNombre(prod1.getNombre());
        dto1.setPrecio(prod1.getPrecio());

        ProductoDTO dto2 = new ProductoDTO();
        dto2.setCodigo(prod2.getCodigo());
        dto2.setNombre(prod2.getNombre());
        dto2.setPrecio(prod2.getPrecio());


        List<ProductoDTO> listaDTOs = new ArrayList<>();
        listaDTOs.add(dto1);
        listaDTOs.add(dto2);


        System.out.println("Lista de ProductoDTO:");
        for (ProductoDTO dto : listaDTOs) {
            System.out.println("Codigo: " + dto.getCodigo() +
                    ", Nombre: " + dto.getNombre() +
                    ", Precio: $" + dto.getPrecio());
        }
    }
}
