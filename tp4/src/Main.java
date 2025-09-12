import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto p1 = new Producto("00001", "Laptop", 1500.0);
        Producto p2 = new Producto("00002", "Mouse", 25.0);
        Producto p3 = new Producto("00001", "Laptop Gamer", 1800.0);

        agregarProducto(productos, p1);
        agregarProducto(productos, p2);
        agregarProducto(productos, p3);

        System.out.println("Lista de productos:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public static void agregarProducto(List<Producto> lista, Producto nuevo) {
        if (lista.contains(nuevo)) {
            System.out.println("Producto duplicado no agregado: " + nuevo.getCodigo());
        } else {
            lista.add(nuevo);
            System.out.println("Producto agregado: " + nuevo.getCodigo());
        }
    }
}
