/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeviajes;

import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 *
 * @author Asrock
 */
public class AgenciaDeViajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista view = new Vista();
        PaqVerano PQ = new PaqVerano();
        PaqInvierno PI = new PaqInvierno();
        PaqOtoño PO = new PaqOtoño();
        PaqPrimavera PP = new PaqPrimavera();
        SeleccionarPrecios SP = new SeleccionarPrecios();
        SolicitarPaq SPAQ = new SolicitarPaq();
        PasarelaPago PPAGO = new PasarelaPago();
        Mensaje MS = new Mensaje();
        Login LG = new Login();
        RegistroCliente RC = new RegistroCliente();
        PlataformaAdmin PA = new PlataformaAdmin();
        EditarPaquete EP = new EditarPaquete();
        VerificarCredenciales VC = new VerificarCredenciales();
        Bus bus;
        ConstruirPaquete cp;
        FabricarPaquete fp;
        Hotel hotel;
        Operador operador;
        Paquete paquete;
        Plan1 plan1;
        Vuelo vuelo;
        
        Controlador controlador = new Controlador(view, PQ, PI, PO, PP, SP, SPAQ, PPAGO, MS, LG, RC, PA, EP, VC);
        controlador.inicio();
        LG.setVisible(true);
        
    }
    
}
