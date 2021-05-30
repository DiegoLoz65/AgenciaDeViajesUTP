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
public class Paquete {
    public Hotel hotel;
    public Bus bus;
    public Vuelo vuelo;
    public Operador operador;
    public String NombrePlan;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public String getNombrePlan() {
        return NombrePlan;
    }

    public void setNombrePlan(String NombrePlan) {
        this.NombrePlan = NombrePlan;
    }
    
    
    
}
