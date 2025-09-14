package org.example;

public class Producto {
    private String codigo;
    private String nombre;
    private String proveedor;
    private double precio;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String proveedor, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
    }


    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}

