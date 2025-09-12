public class Main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante(20, "Ana Pérez", "Ingeniería");
        Estudiante e2 = new Estudiante(22, "Juan Gómez", "Medicina");
        Estudiante e3 = new Estudiante(19, "Lucía Fernández", "Arquitectura");

        Curso curso1 = new Curso("Estructuras de Datos", "Prof. Carlos Ruiz");
        Curso curso2 = new Curso("Programación Orientada a Objetos", "Prof. Marta López");

        curso1.agregarEstudiante(e1);
        curso1.agregarEstudiante(e2);

        curso2.agregarEstudiante(e3);

        System.out.println(curso1);
        System.out.println("----------------------");
        System.out.println(curso2);
    }
}
