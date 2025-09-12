import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String profesor;
    private List<Estudiante> listaDeEstudiantes;

    public Curso(String nombre, String profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.listaDeEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        listaDeEstudiantes.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(nombre).append("\n");
        sb.append("Profesor: ").append(profesor).append("\n");
        sb.append("Cantidad de alumnos: ").append(listaDeEstudiantes.size()).append("\n");
        sb.append("Lista de estudiantes:\n");
        for (int i = 0; i < listaDeEstudiantes.size(); i++) {
            sb.append(i + 1).append(". ").append(listaDeEstudiantes.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}


