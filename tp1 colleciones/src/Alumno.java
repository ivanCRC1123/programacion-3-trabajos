class Alumno {
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // Sobrescritura de toString() para salida legible
    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', nota=" + nota + "}";
    }
}

