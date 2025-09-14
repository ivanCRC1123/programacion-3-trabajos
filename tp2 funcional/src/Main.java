import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Ana", 8.5, "Matemáticas"),
                new Alumno("Luis", 6.0, "Física"),
                new Alumno("Marta", 7.5, "Matemáticas"),
                new Alumno("Carlos", 9.0, "Física"),
                new Alumno("Laura", 5.5, "Química"),
                new Alumno("Sofía", 7.0, "Química"),
                new Alumno("Pedro", 8.0, "Matemáticas"),
                new Alumno("Julia", 6.5, "Física")
        );

        List<String> nombresAprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Nombres de alumnos aprobados (en mayúsculas y ordenados):");
        nombresAprobados.forEach(System.out::println);

        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0);

        System.out.println("\nPromedio general de notas: " + promedioGeneral);

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("\nAlumnos agrupados por curso:");
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println(curso + ":");
            lista.forEach(a -> System.out.println("  " + a));
        });

        List<Alumno> mejoresTres = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nLos 3 mejores alumnos:");
        mejoresTres.forEach(System.out::println);
    }
}
