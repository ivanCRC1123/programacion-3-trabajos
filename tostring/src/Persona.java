public class Persona {
    String nombre;
    int edad;

    public Persona(int edad, String nombre) {

        this.nombre = nombre;
        this.edad = edad;

    }

    @Override

    public String toString(){

        return "Nombre: " +nombre+"  Edad: "+ edad;

    }
}
