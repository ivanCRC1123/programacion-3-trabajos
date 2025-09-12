import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Producto> productos = new HashSet<>();

        productos.add(new Producto("P001", "Producto A"));
        productos.add(new Producto("P002", "Producto B"));
        productos.add(new Producto("P001", "Producto A duplicado"));
        productos.add(new Producto("P003", "Producto C"));

        
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}