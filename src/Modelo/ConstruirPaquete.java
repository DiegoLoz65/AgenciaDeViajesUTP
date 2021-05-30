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
public abstract class ConstruirPaquete {
    
    protected Paquete paquete;

    public ConstruirPaquete() {
        paquete = new Paquete();
    }
    
    public Paquete getPaquete(){
        return this.paquete;
    }
    
    public abstract void construirHotel();
    public abstract void construirBus();
    public abstract void construirVuelo();
    public abstract void construirOperador();
    public abstract void construirNombrePlan();
    
}
