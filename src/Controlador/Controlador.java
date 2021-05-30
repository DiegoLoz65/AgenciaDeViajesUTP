/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import java.sql.*;
import java.awt.event.ActionEvent;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author Asrock
 */
public class Controlador implements ActionListener{
    public String DNI;
    public int PrecioTotal;
    public int plan;
    public String Clase;
    public String Habitacion;
    public int codigo;
    
    
    Vista view;
    PaqVerano PV;
    PaqInvierno PI;
    PaqOtoño PO;
    PaqPrimavera PP;
    SeleccionarPrecios SP;
    SolicitarPaq SPAQ;
    PasarelaPago PPAGO;
    Mensaje MS;
    Login LG;
    RegistroCliente RC;
    PlataformaAdmin PA;
    EditarPaquete EP;
    VerificarCredenciales VC;
    Bus bus;
    ConstruirPaquete cp;
    FabricarPaquete fp;
    Hotel hotel;
    Operador operador;
    Paquete paquete;
    Plan1 plan1;
    Vuelo vuelo;
    
    
    public Controlador(Vista view, PaqVerano PV, PaqInvierno PI, PaqOtoño PO, PaqPrimavera PP, SeleccionarPrecios SP, SolicitarPaq SPAQ, PasarelaPago PPAGO, Mensaje MS, Login LG, RegistroCliente RC, PlataformaAdmin PA, EditarPaquete EP, VerificarCredenciales VC){
        this.PV = PV;
        this.PI = PI;
        this.PO = PO;
        this.PP = PP;
        this.SP = SP;
        this.SPAQ = SPAQ;
        this.PPAGO = PPAGO;
        this.MS = MS;
        this.LG = LG;
        this.RC = RC;
        this.PA = PA;
        this.EP = EP;
        this.VC = VC;
        this.view = view;
        
        this.view.BotonSolicitarPaq.addActionListener(this);
        this.view.BotonPaqueteVerano.addActionListener(this);
        this.view.BotonPaqueteInvierno.addActionListener(this);
        this.view.BotonPaqueteOtoño.addActionListener(this);
        this.view.BotonPaquetePrimavera.addActionListener(this);
        this.view.BotonLogout.addActionListener(this);
        this.SPAQ.BotonEnviarInfo.addActionListener(this);
        this.SP.BotonPasarelaPago.addActionListener(this);
        this.PPAGO.BotonPagar.addActionListener(this);
        this.LG.BotonLoginCliente.addActionListener(this);
        this.LG.BotonLoginAdministrador.addActionListener(this);
        this.LG.BotonRegistrarCliente.addActionListener(this);
        this.RC.BotonRegistrar.addActionListener(this);
        this.PA.BotonEditar.addActionListener(this);
        this.PA.BotonLogoutAdmin.addActionListener(this);
        this.EP.BotonActualizarPaquete.addActionListener(this);
        
    }

    public Controlador(Vista view, Bus bus, ConstruirPaquete cp, FabricarPaquete fp, Hotel hotel, Operador operador, Paquete paquete, Plan1 plan1, Vuelo vuelo) {
        this.view = view;
        this.bus = bus;
        this.cp = cp;
        this.fp = fp;
        this.hotel = hotel;
        this.operador = operador;
        this.paquete = paquete;
        this.plan1 = plan1;
        this.vuelo = vuelo;
        
        
    }

    
    public void inicio(){
        view.setLocationRelativeTo(view);
        view.setTitle("PLATAFORMA DE AGENCIA DE VIAJES");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        

        
        /*
        FabricarPaquete fp = new FabricarPaquete();
        fp.setConstruirPaquete(new Plan1());
        fp.CrearPaquete();
        Paquete pq = fp.getPaquete();
        */

        if(ae.getSource() == view.BotonPaqueteVerano){

            FabricarPaquete fp = new FabricarPaquete();
            fp.setConstruirPaquete(new Plan1());
            fp.CrearPaquete();
            Paquete pq = fp.getPaquete();
            //ASIGNANDO VALORES DE HOTEL 
            PV.LabelNombreHotel.setText(pq.hotel.getNombre());
            PV.LabelEstrellasHotel.setText(Integer.toString(pq.hotel.getEstrellas()));
            PV.LabelCostoSimpleHotel.setText(Integer.toString(pq.hotel.getCostSimple()));
            PV.LabelCostoDobleHotel.setText(Integer.toString(pq.hotel.getCostDoble()));
            PV.LabelCostoTripleHotel.setText(Integer.toString(pq.hotel.getCostTriple()));
            PV.LabelLugarHotel.setText(pq.hotel.getLugar());
            
            //ASIGNANDO VALORES DE BUS
            PV.LabelNombreBus.setText(pq.bus.getNombre());
            PV.LabelPrecioBus.setText(Integer.toString(pq.bus.getCosto()));
            PV.LabelDestinoBus.setText(pq.bus.getDestino());
            PV.LabelOrigenBus.setText(pq.bus.getOrigen());
            PV.LabelFechaBus.setText(pq.bus.getFecha().toString());
            
            //ASIGNANDO VALORES DE VUELO
            PV.LabelNumeroVuelo.setText(Integer.toString(pq.vuelo.getNumeroVuelo()));
            PV.LabelDestinoVuelo.setText(pq.vuelo.getDestino());
            PV.LabelOrigenVuelo.setText(pq.vuelo.getOrigen());
            PV.LabelCantidadVuelo.setText(Integer.toString(pq.vuelo.getCantAsientos()));
            PV.LabelCostoEjecVuelo.setText(Integer.toString(pq.vuelo.getCostEjecutivo()));
            PV.LabelCostoEconVuelo.setText(Integer.toString(pq.vuelo.getCostEconomico()));
            PV.LabelFechaVuelo.setText(pq.vuelo.getFecha().toString());
            
            //ASIGNANDO VALORES DE OPERADOR
            PV.LabelNombreOP.setText(pq.operador.getNombre());
            PV.LabelLugarOP.setText(pq.operador.getLugar());
            PV.LabelPrecioOP.setText(Integer.toString(pq.operador.getPrecio()));
            PV.LabelCorreoOp.setText(pq.operador.getCorreo());
            PV.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            PV.setVisible(true);
        }
        
        if(ae.getSource() == view.BotonPaqueteInvierno){
            
            FabricarPaquete fp = new FabricarPaquete();
            fp.setConstruirPaquete(new Plan2());
            fp.CrearPaquete();
            Paquete pq = fp.getPaquete();
            //ASIGNANDO VALORES DE HOTEL 
            PI.LabelNombreHotel.setText(pq.hotel.getNombre());
            PI.LabelEstrellasHotel.setText(Integer.toString(pq.hotel.getEstrellas()));
            PI.LabelCostoSimpleHotel.setText(Integer.toString(pq.hotel.getCostSimple()));
            PI.LabelCostoDobleHotel.setText(Integer.toString(pq.hotel.getCostDoble()));
            PI.LabelCostoTripleHotel.setText(Integer.toString(pq.hotel.getCostTriple()));
            PI.LabelLugarHotel.setText(pq.hotel.getLugar());
            
           
            //ASIGNANDO VALORES DE VUELO
            PI.LabelNumeroVuelo.setText(Integer.toString(pq.vuelo.getNumeroVuelo()));
            PI.LabelDestinoVuelo.setText(pq.vuelo.getDestino());
            PI.LabelOrigenVuelo.setText(pq.vuelo.getOrigen());
            PI.LabelCantidadVuelo.setText(Integer.toString(pq.vuelo.getCantAsientos()));
            PI.LabelCostoEjecVuelo.setText(Integer.toString(pq.vuelo.getCostEjecutivo()));
            PI.LabelCostoEconVuelo.setText(Integer.toString(pq.vuelo.getCostEconomico()));
            PI.LabelFechaVuelo.setText(pq.vuelo.getFecha().toString());
            
            //ASIGNANDO VALORES DE OPERADOR
            PI.LabelNombreOP.setText(pq.operador.getNombre());
            PI.LabelLugarOP.setText(pq.operador.getLugar());
            PI.LabelPrecioOP.setText(Integer.toString(pq.operador.getPrecio()));
            PI.LabelCorreoOp.setText(pq.operador.getCorreo());
            PI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            PI.setVisible(true);
        }
        
        if(ae.getSource() == view.BotonPaqueteOtoño){
            
            FabricarPaquete fp = new FabricarPaquete();
            fp.setConstruirPaquete(new Plan3());
            fp.CrearPaquete();
            Paquete pq = fp.getPaquete();
            //ASIGNANDO VALORES DE HOTEL 
            PO.LabelNombreHotel.setText(pq.hotel.getNombre());
            PO.LabelEstrellasHotel.setText(Integer.toString(pq.hotel.getEstrellas()));
            PO.LabelCostoSimpleHotel.setText(Integer.toString(pq.hotel.getCostSimple()));
            PO.LabelCostoDobleHotel.setText(Integer.toString(pq.hotel.getCostDoble()));
            PO.LabelCostoTripleHotel.setText(Integer.toString(pq.hotel.getCostTriple()));
            PO.LabelLugarHotel.setText(pq.hotel.getLugar());
            
           
            //ASIGNANDO VALORES DE VUELO
            PO.LabelNumeroVuelo.setText(Integer.toString(pq.vuelo.getNumeroVuelo()));
            PO.LabelDestinoVuelo.setText(pq.vuelo.getDestino());
            PO.LabelOrigenVuelo.setText(pq.vuelo.getOrigen());
            PO.LabelCantidadVuelo.setText(Integer.toString(pq.vuelo.getCantAsientos()));
            PO.LabelCostoEjecVuelo.setText(Integer.toString(pq.vuelo.getCostEjecutivo()));
            PO.LabelCostoEconVuelo.setText(Integer.toString(pq.vuelo.getCostEconomico()));
            PO.LabelFechaVuelo.setText(pq.vuelo.getFecha().toString());
            
            //ASIGNANDO VALORES DE OPERADOR
            PO.LabelNombreOP.setText(pq.operador.getNombre());
            PO.LabelLugarOP.setText(pq.operador.getLugar());
            PO.LabelPrecioOP.setText(Integer.toString(pq.operador.getPrecio()));
            PO.LabelCorreoOp.setText(pq.operador.getCorreo());
            PO.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            PO.setVisible(true);
        }
        
        if(ae.getSource() == view.BotonPaquetePrimavera){
            
            FabricarPaquete fp = new FabricarPaquete();
            fp.setConstruirPaquete(new Plan4());
            fp.CrearPaquete();
            Paquete pq = fp.getPaquete();
            //ASIGNANDO VALORES DE HOTEL 
            PP.LabelNombreHotel.setText(pq.hotel.getNombre());
            PP.LabelEstrellasHotel.setText(Integer.toString(pq.hotel.getEstrellas()));
            PP.LabelCostoSimpleHotel.setText(Integer.toString(pq.hotel.getCostSimple()));
            PP.LabelCostoDobleHotel.setText(Integer.toString(pq.hotel.getCostDoble()));
            PP.LabelCostoTripleHotel.setText(Integer.toString(pq.hotel.getCostTriple()));
            PP.LabelLugarHotel.setText(pq.hotel.getLugar());
            
            //ASIGNANDO VALORES DE VUELO
            PP.LabelNumeroVuelo.setText(Integer.toString(pq.vuelo.getNumeroVuelo()));
            PP.LabelDestinoVuelo.setText(pq.vuelo.getDestino());
            PP.LabelOrigenVuelo.setText(pq.vuelo.getOrigen());
            PP.LabelCantidadVuelo.setText(Integer.toString(pq.vuelo.getCantAsientos()));
            PP.LabelCostoEjecVuelo.setText(Integer.toString(pq.vuelo.getCostEjecutivo()));
            PP.LabelCostoEconVuelo.setText(Integer.toString(pq.vuelo.getCostEconomico()));
            PP.LabelFechaVuelo.setText(pq.vuelo.getFecha().toString());
            
            //ASIGNANDO VALORES DE OPERADOR
            PP.LabelNombreOP.setText(pq.operador.getNombre());
            PP.LabelLugarOP.setText(pq.operador.getLugar());
            PP.LabelPrecioOP.setText(Integer.toString(pq.operador.getPrecio()));
            PP.LabelCorreoOp.setText(pq.operador.getCorreo());
            PP.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            PP.setVisible(true);
        }
        
        if(ae.getSource() == view.BotonSolicitarPaq){
            SPAQ.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            SPAQ.setVisible(true);
        }
        
        if(ae.getSource() == view.BotonLogout){
            view.setVisible(false);
            LG.setVisible(true);
        }
        
        if(ae.getSource() == PA.BotonLogoutAdmin){
            PA.setVisible(false);
            LG.setVisible(true);
        }

        if(ae.getSource() == SPAQ.BotonEnviarInfo){
            SPAQ.setVisible(false);
            System.out.println("ENTRA A ENVIAR INFO");
            if("Plan Verano".equals(SPAQ.ListaPlanes.getSelectedValue())){
                plan = 1;
            }
            if("Plan Invierno".equals(SPAQ.ListaPlanes.getSelectedValue())){
                plan = 2;
            }
            if("Plan Otoño".equals(SPAQ.ListaPlanes.getSelectedValue())){
                plan = 3;
            }
            if("Plan Primavera".equals(SPAQ.ListaPlanes.getSelectedValue())){
                plan = 4;
            }
            
            try{
                
            Connection cn;
            cn = connector.getConnection();
            String sql;
            //sql = "INSERT INTO clientes (DNI, Nombre, Numero, Plan, NCuotas, NumeroCC, CVV, FechaVen) values (?,?,?,?,?,?,?,?)";
            sql = "UPDATE clientes SET Numero = ?, Plan = ?  WHERE DNI =  ";
            PreparedStatement ps = cn.prepareStatement(sql + DNI);
            ps.setString(1, SPAQ.CajaTelefono.getText());
            ps.setString(2, SPAQ.ListaPlanes.getSelectedValue());
            ps.execute();
            System.out.println("ENTRA A LA CONEXIÓN");
        }catch(Exception e){
                System.out.println("EXCEPCIÓN");
        }
            SP.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            SP.setVisible(true);
        }
        
        if(ae.getSource() == SP.BotonPasarelaPago){
            SP.setVisible(false);
            int PrecioClase=0;
            int PrecioHabitacion=0;
            int PrecioOperador=0;
            
            try{
            ResultSet myRs = null;
            Connection cn;
            cn = connector.getConnection();
            String sql;
            //sql = "INSERT INTO clientes (DNI, Nombre, Numero, Plan, NCuotas, NumeroCC, CVV, FechaVen) values (?,?,?,?,?,?,?,?)";
            sql = "UPDATE clientes SET ClasePref = ?, HabPref = ?  WHERE DNI = ";
            PreparedStatement ps = cn.prepareStatement(sql + DNI);
            ps.setString(1, SP.ListaClasePref.getSelectedValue());
            ps.setString(2, SP.ListaHabPref.getSelectedValue());
            ps.execute();
            System.out.println("ENTRA A LA CONEXIÓN");
        }catch(Exception e){
                System.out.println("EXCEPCIÓN");
        }
            
            
            if("Clase Económica".equals(SP.ListaClasePref.getSelectedValue())){
                Clase = "CostEconomico";
            }
            if("Clase Ejecutiva".equals(SP.ListaClasePref.getSelectedValue())){
                Clase = "CostEjecutivo";
            }
            
            if("Habitación Sencilla".equals(SP.ListaHabPref.getSelectedValue())){
                Habitacion = "CostSimple";
            }
            if("Habitación Doble".equals(SP.ListaHabPref.getSelectedValue())){
                Habitacion = "CostDoble";
            }
            if("Habitación Ejecutiva".equals(SP.ListaHabPref.getSelectedValue())){
                Habitacion = "CostTriple";
            }
            
            //TRY CATCH PARA OBTENER EL COSTO DE LA CLASE DE VUELO
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            String SELECT = "SELECT ";
            sql = " FROM vuelos WHERE ID = ";
            PreparedStatement ps = cn.prepareStatement(SELECT+Clase+sql+plan);
            myRs = ps.executeQuery();
            while(myRs.next()){
                PrecioClase = myRs.getInt(Clase);
                System.out.println("EL PRECIO DE LA CLASE ES: " + PrecioClase);
            }
              
            }catch(Exception e){

            }
            
            //TRY CATCH PARA OBTENER EL COSTO DE LA HABITACIÓN DEL HOTEL
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            String SELECT = "SELECT ";
            sql = " FROM hoteles WHERE ID = ";
            PreparedStatement ps = cn.prepareStatement(SELECT+Habitacion+sql+plan);
            myRs = ps.executeQuery();
            while(myRs.next()){
                PrecioHabitacion = myRs.getInt(Habitacion);
                System.out.println("EL PRECIO DE LA HABITACIÓN ES: " + PrecioHabitacion);
            }
              
            }catch(Exception e){

            }
            
            //TRY CATCH PARA OBTENER EL COSTO DEl OPERADOR
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            sql = "SELECT Precio FROM operadores WHERE ID = ";
            PreparedStatement ps = cn.prepareStatement(sql+plan);
            myRs = ps.executeQuery();
            while(myRs.next()){
                PrecioOperador = myRs.getInt("Precio");
                System.out.println("EL PRECIO DEL OPERADOR ES: " + PrecioOperador);
            }
              
            }catch(Exception e){

            }
            
            PrecioTotal = PrecioClase + PrecioHabitacion + PrecioOperador;
            PPAGO.LabelPrecioTotal.setText(Integer.toString(PrecioTotal));
            PPAGO.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            PPAGO.setVisible(true);
        }
        
        if(ae.getSource() == PPAGO.BotonPagar){
            PPAGO.setVisible(false);
            
            int cantidadAsientos = 0;
            try{

            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM vuelos WHERE ID = ";
            PreparedStatement ps = cn.prepareStatement(sql + plan);
            myRs = ps.executeQuery();
            while(myRs.next()){
                cantidadAsientos = myRs.getInt("CantAsientos");
            }
            
        }catch(Exception e){
            
        }
            if(cantidadAsientos == 0){
                System.exit(0);
            }
            if(cantidadAsientos != 0){
                try{
                    Connection cn;
                    cn = connector.getConnection();
                    String sql;
                    sql = "UPDATE `vuelos` SET CantAsientos = ? WHERE ID = ";
                    PreparedStatement ps = cn.prepareStatement(sql + plan);
                    ps.setInt(1, (cantidadAsientos-1));
                    ps.execute();
                }catch(Exception e){
                }
            }
            
            try{
                Connection cn;
                cn = connector.getConnection();
                String sql;
                //sql = "INSERT INTO clientes (DNI, Nombre, Numero, Plan, NCuotas, NumeroCC, CVV, FechaVen) values (?,?,?,?,?,?,?,?)";
                sql = "UPDATE clientes SET NCuotas = ?, NumeroCC = ?, CVV = ?, FechaVen = ?, TotalPagar = ?  WHERE DNI = ";
                PreparedStatement ps = cn.prepareStatement(sql + DNI);
                ps.setString(1, PPAGO.CajaCuotas.getSelectedValue());
                ps.setString(2, PPAGO.CajaNumeroTarjeta.getText());
                ps.setString(3, PPAGO.CajaCVV.getText());
                ps.setString(4, PPAGO.CajaFechaVen.getText());
                ps.setString(5, PPAGO.LabelPrecioTotal.getText());
                ps.execute();
                System.out.println("ENTRA A LA CONEXIÓN");
            }catch(Exception e){
                    System.out.println("EXCEPCIÓN");
            }
            String nombre1 = null;
            
            
            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");
            
            Session sesion = Session.getDefaultInstance(propiedad);
            
            
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM clientes WHERE DNI = ";
            PreparedStatement ps = cn.prepareStatement(sql + DNI);
            myRs = ps.executeQuery();
            while(myRs.next()){
                nombre1 = myRs.getString("Nombre");
                MS.LabelNombre.setText(myRs.getString("Nombre"));
                MS.LabelDNI.setText(DNI);
                MS.LabelPlan.setText(myRs.getString("Plan"));
                MS.LabelCuotas.setText(myRs.getString("NCuotas"));
                MS.LabelTotalPagar.setText(myRs.getString("TotalPagar"));
            }
              
        }catch(Exception e){
            
        }
            
            
            String correoEnvia = "juanjoEscop789@gmail.com";
            String contrasena = "jueves789";
            String destinatario = "tourvip91@gmail.com";
            String asunto = "SE HA RESERVADO UN PAQUETE";
            String mensaje = "Buen día, la presente es para informar la solicitud de un operador turístico para " + nombre1 + " con número de identificación: "+ DNI + ".";
            
            MimeMessage mail = new MimeMessage(sesion);
            try {
                mail.setFrom(new InternetAddress(correoEnvia));
                mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                mail.setSubject(asunto);
                mail.setText(mensaje);
                Transport transporte = sesion.getTransport("smtp");
                transporte.connect(correoEnvia, contrasena);
                transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                transporte.close();
            } catch (AddressException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            

        MS.setVisible(true);
            
        }
        
        if(ae.getSource() == LG.BotonLoginCliente){
            
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            sql = "SELECT COUNT(*) FROM clientes WHERE DNI = ";
            String and;
            and = " AND Contraseña = ";
            PreparedStatement ps = cn.prepareStatement(sql + LG.CajaDNI.getText() + and + LG.CajaContraseña.getText());
            myRs = ps.executeQuery();
            while(myRs.next()){
                if(myRs.getInt("COUNT(*)") == 1){
                    DNI = LG.CajaDNI.getText();
                    LG.setVisible(false);
                    view.setVisible(true);
                }
                else{
                    VC.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    VC.setVisible(true);
                }
            }
              
            }catch(Exception e){

            }
        }
        
        
        if(ae.getSource() == LG.BotonRegistrarCliente){
            LG.setVisible(false);
            RC.setVisible(true);
        }
            
        if(ae.getSource() == RC.BotonRegistrar){
        try{
                System.out.println("ENTRA");
                Connection cn;
                cn = connector.getConnection();
                String sql;
                
                sql = "INSERT INTO clientes (DNI, Contraseña, Nombre, Numero, Plan, NCuotas, NumeroCC, CVV, FechaVen, ClasePref, HabPref, TotalPagar) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(sql);
                DNI = RC.CajaDNIregister.getText();
                ps.setString(1, RC.CajaDNIregister.getText());
                ps.setString(2, RC.CajaContraseñaRegister.getText());
                ps.setString(3, RC.CajaNombreRegister.getText());
                ps.setString(4, "0");
                ps.setString(5, "0");
                ps.setString(6, "0");
                ps.setString(7, "0");
                ps.setString(8, "0");
                ps.setString(9, "2010-01-01");
                ps.setString(10, "0");
                ps.setString(11, "0");
                ps.setString(12, "0");

                
                ps.execute();
                }catch(Exception e){

                }
            RC.setVisible(false);
            LG.setVisible(true);
        }
         
        if(ae.getSource() == LG.BotonLoginAdministrador){
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            sql = "SELECT COUNT(*) FROM admins WHERE DNI = ";
            String and;
            and = " AND Contraseña = ";
            PreparedStatement ps = cn.prepareStatement(sql + LG.CajaDNI.getText() + and + LG.CajaContraseña.getText());
            myRs = ps.executeQuery();
            while(myRs.next()){
                if(myRs.getInt("COUNT(*)") == 1){
                    LG.setVisible(false);
                    PA.setVisible(true);
                }
                else{
                    VC.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    VC.setVisible(true);
                }
            }
              
            }catch(Exception e){

            }
        }
        
        if(ae.getSource() == PA.BotonEditar){
            PA.setVisible(false);

            if(PA.ListaPlanes.getSelectedValue() == "Plan Verano"){
                codigo = 1;
            }
            if(PA.ListaPlanes.getSelectedValue() == "Plan Invierno"){
                codigo = 2;
            }
            if(PA.ListaPlanes.getSelectedValue() == "Plan Otoño"){
                codigo = 3;
            }
            if(PA.ListaPlanes.getSelectedValue() == "Plan Primavera"){
                codigo = 4;
            }
            
            try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM hoteles WHERE ID = ";
            PreparedStatement ps = cn.prepareStatement(sql + codigo);
            myRs = ps.executeQuery();
            while(myRs.next()){
                EP.FieldNombreHotel.setText(myRs.getString("Nombre")); 
                EP.FieldEstrellasHotel.setText(Integer.toString(myRs.getInt("Estrellas")));
                EP.FieldCostoSimpleHotel.setText(Integer.toString(myRs.getInt("CostSimple")));
                EP.FieldCostoDobleHotel.setText(Integer.toString(myRs.getInt("CostDoble")));
                EP.FieldCostoTripleHotel.setText(Integer.toString(myRs.getInt("CostTriple")));
                EP.FieldLugarHotel.setText(myRs.getString("Lugar")); 
            }
              
            myRs = null;
            sql = "SELECT * FROM vuelos WHERE ID = ";
            ps = cn.prepareStatement(sql + codigo);
            myRs = ps.executeQuery();
            while(myRs.next()){
                EP.FieldNVuelo.setText(Integer.toString(myRs.getInt("NumeroVuelo")));
                EP.FieldDestinoVuelo.setText(myRs.getString("Destino"));
                EP.FieldOrigenVuelo.setText(myRs.getString("Origen"));
                EP.FieldCantAsientosVuelo.setText(Integer.toString(myRs.getInt("CantAsientos")));
                EP.FieldCostoEjecVuelo.setText(Integer.toString(myRs.getInt("CostEjecutivo")));
                EP.FieldCostoEconomico.setText(Integer.toString(myRs.getInt("CostEconomico")));
                EP.FieldFechaVuelo.setText(myRs.getDate("Fecha").toString());
            }
            
            myRs = null;
            sql = "SELECT * FROM buses WHERE ID = ";
            ps = cn.prepareStatement(sql + codigo);
            myRs = ps.executeQuery();
            while(myRs.next()){
                EP.FieldNombreBus.setText(myRs.getString("Nombre"));
                EP.FieldPrecioBus.setText(Integer.toString(myRs.getInt("Costo")));
                EP.FieldDestinoBus.setText(myRs.getString("Destino"));
                EP.FieldOrigenBus.setText(myRs.getString("Origen"));
                EP.FieldFechaBus.setText(myRs.getDate("Fecha").toString());
            }
            
            myRs = null;
            sql = "SELECT * FROM operadores WHERE ID = ";
            ps = cn.prepareStatement(sql + codigo);
            myRs = ps.executeQuery();
            while(myRs.next()){
                EP.FieldNombreOperador.setText(myRs.getString("Nombre"));
                EP.FieldLugarOperador.setText(myRs.getString("Lugar"));
                EP.FieldPrecioOperador.setText(Integer.toString(myRs.getInt("Precio")));
                EP.FieldCorreoOperador.setText(myRs.getString("Correo"));
            }
            
            }catch(Exception e){

            }
            EP.setVisible(true);
        }
        
        if(ae.getSource() == EP.BotonActualizarPaquete){
            try{
                
                Connection cn;
                cn = connector.getConnection();
                String sql;
                //sql = "INSERT INTO clientes (DNI, Nombre, Numero, Plan, NCuotas, NumeroCC, CVV, FechaVen) values (?,?,?,?,?,?,?,?)";
                sql = "UPDATE `hoteles` SET Nombre = ? ,Estrellas = ? ,CostSimple = ?,CostDoble = ?, CostTriple = ?, Lugar = ? WHERE ID = ";
                PreparedStatement ps = cn.prepareStatement(sql + codigo);
                ps.setString(1, EP.FieldNombreHotel.getText());
                ps.setString(2, EP.FieldEstrellasHotel.getText());
                ps.setString(3, EP.FieldCostoSimpleHotel.getText());
                ps.setString(4, EP.FieldCostoDobleHotel.getText());
                ps.setString(5, EP.FieldCostoTripleHotel.getText());
                ps.setString(6, EP.FieldLugarHotel.getText());
                ps.execute();

                
                sql = "UPDATE `vuelos` SET NumeroVuelo = ?, Destino =  ?, Origen = ?, CantAsientos = ?, CostEjecutivo = ?, CostEconomico = ?, Fecha = ? WHERE ID = ";
                ps = cn.prepareStatement(sql + codigo);
                ps.setString(1, EP.FieldNVuelo.getText());
                ps.setString(2, EP.FieldDestinoVuelo.getText());
                ps.setString(3, EP.FieldOrigenVuelo.getText());
                ps.setString(4, EP.FieldCantAsientosVuelo.getText());
                ps.setString(5, EP.FieldCostoEjecVuelo.getText());
                ps.setString(6, EP.FieldCostoEconomico.getText());
                SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );  // United States style of format.
                java.util.Date myDate = format.parse( EP.FieldFechaVuelo.getText() );  // Notice the ".util." of package name.
                java.sql.Date sqlDate = new java.sql.Date( myDate.getTime() ); // Notice the ".sql." (not "util") in package name.
                ps.setDate(7, sqlDate);
                ps.execute();

                
                sql = "UPDATE `buses` SET Nombre = ?, Costo = ?, Destino = ?, Origen = ?, Fecha = ? WHERE ID = ";
                ps = cn.prepareStatement(sql + codigo);
                ps.setString(1, EP.FieldNombreBus.getText());
                ps.setString(2, EP.FieldPrecioBus.getText());
                ps.setString(3, EP.FieldDestinoBus.getText());
                ps.setString(4, EP.FieldOrigenBus.getText());
                format = new SimpleDateFormat( "yyyy-MM-dd" );  // United States style of format.
                myDate = format.parse( EP.FieldFechaBus.getText() );  // Notice the ".util." of package name.
                sqlDate = new java.sql.Date( myDate.getTime() ); // Notice the ".sql." (not "util") in package name.
                ps.setDate(5, sqlDate);
                ps.execute();

                
                sql = "UPDATE `operadores` SET Nombre = ?, Lugar = ?, Precio = ?, Correo = ? WHERE ID = ";
                ps = cn.prepareStatement(sql + codigo);
                ps.setString(1, EP.FieldNombreOperador.getText());
                ps.setString(2, EP.FieldLugarOperador.getText());
                ps.setString(3, EP.FieldPrecioOperador.getText());
                ps.setString(4, EP.FieldCorreoOperador.getText());
                ps.execute();

                
            }catch(Exception e){

            }
            EP.setVisible(false);
            PA.setVisible(true);
        }
        
    }
}
