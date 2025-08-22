
public class Estudiante extends Persona {
    String carrera;

    public Estudiante(int edad, String nombre, String carrera) {
        super(edad, nombre);
        this.carrera = carrera;
    }

    @Override

    public String toString(){
        return super.toString()+ "  carrera: "+ carrera;
    }
}
