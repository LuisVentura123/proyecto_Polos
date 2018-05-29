package com.example.luis.proyecto_polos;

public class Persona {
    private int Id;
    private String Nombre;
    private String Domicilio;

    public Persona(int id, String nombre, String domicilio) {
        Id = id;
        Nombre = nombre;
        Domicilio = domicilio;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }
}

