/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Asrock
 */
public class Bus {
    private String Nombre;
    private int Costo;
    private String Destino;
    private String Origen;
    private Date Fecha;

    public Bus(){
        
    }
    
    public Bus(String Nombre, int Costo, String Destino, String Origen, Date Fecha) {
        this.Nombre = Nombre;
        this.Costo = Costo;
        this.Destino = Destino;
        this.Origen = Origen;
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getCosto() {
        return Costo;
    }

    public String getDestino() {
        return Destino;
    }

    public String getOrigen() {
        return Origen;
    }

    public Date getFecha() {
        return Fecha;
    }
    
}
