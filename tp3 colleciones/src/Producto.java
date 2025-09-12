
import java.util.Objects;


class Producto {
    private String codigo;
    private String descripcion;

    public Producto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }


    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Producto{codigo='" + codigo + "', descripcion='" + descripcion + "'}";
    }
}


