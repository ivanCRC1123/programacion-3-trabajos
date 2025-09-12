import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Curso> cursos = new HashMap<>();


        cursos.put("MAT101", new Curso("Matemática I", "Prof. García"));
        cursos.put("FIS201", new Curso("Física II", "Prof. López"));
        cursos.put("PROG301", new Curso("Programación III", "Prof. Martínez"));


        Curso cursoRecuperado = cursos.get("FIS201");
        System.out.println("Curso recuperado: " + cursoRecuperado);
        System.out.println();


        System.out.println("Todos los cursos:");
        for (Map.Entry<String, Curso> entrada : cursos.entrySet()) {
            String codigo = entrada.getKey();
            Curso curso = entrada.getValue();
            System.out.println("Código: " + codigo + " -> " + curso);
        }
    }
}