import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(new Alumno("Ana", 8.5));
        listaAlumnos.add(new Alumno("Luis", 7.2));
        listaAlumnos.add(new Alumno("Ana", 8.5)); // duplicado permitido
        listaAlumnos.add(new Alumno("María", 9.0));
        
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }
}

