import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = List.of(
                new Producto("Laptop", "Electrónica", 1200.0, 10),
                new Producto("Mouse", "Electrónica", 25.0, 50),
                new Producto("Café", "Alimentos", 150.0, 30),
                new Producto("Libro", "Libros", 80.0, 20),
                new Producto("Teléfono", "Electrónica", 800.0, 15),
                new Producto("Galletas", "Alimentos", 110.0, 40),
                new Producto("Cuaderno", "Libros", 50.0, 100)
        );

        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        System.out.println("Productos con precio mayor a 100, ordenados por precio descendente:");
        caros.forEach(System.out::println);

        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println("\nStock total por categoría:");
        stockPorCategoria.forEach((cat, stock) -> System.out.println(cat + ": " + stock));

        String listado = productos.stream()
                .map(p -> p.getNombre() + " " + p.getPrecio())
                .collect(Collectors.joining("; "));

        System.out.println("\nListado de productos (nombre y precio separados por ';'):");
        System.out.println(listado);

        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);

        System.out.println("\nPrecio promedio general: " + promedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("\nPrecio promedio por categoría:");
        promedioPorCategoria.forEach((cat, prom) -> System.out.println(cat + ": " + prom));
    }
}
