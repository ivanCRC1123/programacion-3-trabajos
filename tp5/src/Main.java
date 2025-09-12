import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Producto> productos = new HashSet<>();

        Producto p1 = new Producto("0001", "Laptop", 1500.0);
        Producto p2 = new Producto("0002", "Mouse", 25.0);
        Producto p3 = new Producto("0001", "Laptop Gamer", 1800.0);
        Producto p4 = new Producto("0003", "Teclado", 45.0);
        Producto p5 = new Producto("0002", "Mouse inalámbrico", 30.0);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        System.out.println("Contenido del HashSet (sin duplicados):");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
