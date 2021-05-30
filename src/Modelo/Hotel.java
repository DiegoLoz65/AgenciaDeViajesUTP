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
public class Hotel {
    private String Nombre;
    private int Estrellas;
    private int CostSimple;
    private int CostDoble;
    private int CostTriple;
    private String lugar;

    public Hotel(String Nombre, int Estrellas, int CostSimple, int CostDoble, int CostTriple, String lugar) {
        this.Nombre = Nombre;
        this.Estrellas = Estrellas;
        this.CostSimple = CostSimple;
        this.CostDoble = CostDoble;
        this.CostTriple = CostTriple;
        this.lugar = lugar;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEstrellas() {
        return Estrellas;
    }

    public int getCostSimple() {
        return CostSimple;
    }

    public int getCostDoble() {
        return CostDoble;
    }

    public int getCostTriple() {
        return CostTriple;
    }

    public String getLugar() {
        return lugar;
    }
    
    
}
