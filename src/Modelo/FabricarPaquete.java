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
public class FabricarPaquete {
    private ConstruirPaquete construirPaquete;
     public void CrearPaquete(){
         construirPaquete.construirHotel();
         construirPaquete.construirBus();
         construirPaquete.construirVuelo();
         construirPaquete.construirOperador();
         construirPaquete.construirNombrePlan();
         
     }

    public void setConstruirPaquete(ConstruirPaquete cp) {
        this.construirPaquete = cp;
    }
    
    public Paquete getPaquete(){
        return construirPaquete.getPaquete();
    }
}
