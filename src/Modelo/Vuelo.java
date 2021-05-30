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
public class Vuelo {
    private int NumeroVuelo;
    private String Destino;
    private String Origen;
    private int CantAsientos;
    private int CostEjecutivo;
    private int CostEconomico;
    private Date Fecha;

    public Vuelo(int NumeroVuelo, String Destino, String Origen, int CantAsientos, int CostEjecutivo, int CostEconomico, Date Fecha) {
        this.NumeroVuelo = NumeroVuelo;
        this.Destino = Destino;
        this.Origen = Origen;
        this.CantAsientos = CantAsientos;
        this.CostEjecutivo = CostEjecutivo;
        this.CostEconomico = CostEconomico;
        this.Fecha = Fecha;
    }

    public int getNumeroVuelo() {
        return NumeroVuelo;
    }

    public String getDestino() {
        return Destino;
    }

    public String getOrigen() {
        return Origen;
    }

    public int getCantAsientos() {
        return CantAsientos;
    }

    public int getCostEjecutivo() {
        return CostEjecutivo;
    }

    public int getCostEconomico() {
        return CostEconomico;
    }

    public Date getFecha() {
        return Fecha;
    }
    
    
}
