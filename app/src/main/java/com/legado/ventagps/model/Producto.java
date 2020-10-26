package com.legado.ventagps.model;

public class Producto {
    String nombre;
    String descripcion;
    String moneda;
    Double  precio;
    int imagen;

    public Producto(String nombre, String descripcion, String moneda, Double precio, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.moneda = moneda;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
