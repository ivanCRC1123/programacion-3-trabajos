import java.util.ArrayList;
import java.util.List;

public class TestGenericos {
    public static void main(String[] args) {


        Caja<String> cajaString = new Caja<>("Hola Genéricos");
        System.out.println(cajaString);

        Caja<Integer> cajaInteger = new Caja<>(123);
        System.out.println(cajaInteger);

        List lista = new ArrayList();
        lista.add("Texto");
        lista.add(456);

        for (Object obj : lista) {
            System.out.println(obj);
        }

        List<String> listaGenerica = new ArrayList<>();
        listaGenerica.add("Solo texto");
        // listaGenerica.add(123); // Esto dara error

        for (String s : listaGenerica) {
            System.out.println(s);
        }
    }
}

