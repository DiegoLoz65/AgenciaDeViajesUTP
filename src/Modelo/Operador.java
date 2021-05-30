/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Asrock
 */
public class Operador {
    private String nombre;
    private String lugar;
    private int Precio;
    private String Correo;

    public Operador(String nombre, String lugar, int Precio, String Correo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.Precio = Precio;
        this.Correo = Correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public int getPrecio() {
        return Precio;
    }

    public String getCorreo() {
        return Correo;
    }
    
    
}
