import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <Estudiante> lista = new ArrayList<>();

       lista.add(new Estudiante( 22,"ivan", "programacion"));
       lista.add(new Estudiante (21,"jorge","medicina"));
       lista.add(new Estudiante(32,"martina","periodismo"));


        System.out.println(lista);
    }
}