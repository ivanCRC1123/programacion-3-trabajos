import java.util.List;
import java.util.ArrayList;

public class GenericosDemo {

    public static <T> void imprimirLista(List<T> lista) {
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {

        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(10);
        listaEnteros.add(20);
        listaEnteros.add(30);

        List<String> listaCadenas = new ArrayList<>();
        listaCadenas.add("Hola");
        listaCadenas.add("Mundo");
        listaCadenas.add("Genericos");

        System.out.println("Imprimiendo lista de enteros:");
        imprimirLista(listaEnteros);

        System.out.println("\nImprimiendo lista de cadenas:");
        imprimirLista(listaCadenas);
    }
}
