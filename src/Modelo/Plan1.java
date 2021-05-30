/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.connector;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Asrock
 * 
 * INSERT INTO hoteles (ID, Nombre, Estrellas, CostSimple, CostDoble, CostTriple, Lugar) values (1, "Hotel El Rodeo", 5, 60000, 100000, 150000, "Cartagena")
 * INSERT INTO buses (ID, Nombre, Costo, Destino, Origen, Fecha) values (1, "Express", 80000, "Cartagena", "Bogotá", 2021-07-15)
 * INSERT INTO vuelos (ID, NumeroVuelo, Destino, Origen, CantAsientos, CostEjecutivo, CostEconomico, Fecha) values (1, 9721, "Cartagena", "Bogotá", 25, 600000, 400000, 2021-07-15)
 */
public class Plan1 extends ConstruirPaquete{
                        
    @Override
    public void construirHotel() {
           String Nombre = null;
           int Estrellas = 0;
           int CostoSimple = 0;
           int CostoDoble = 0;
           int CostoTriple = 0;
           String Lugar = null;
         try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM hoteles WHERE ID = 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            myRs = ps.executeQuery();
            while(myRs.next()){
                Nombre = myRs.getString("Nombre");
                Estrellas = myRs.getInt("Estrellas");
                CostoSimple = myRs.getInt("CostSimple");
                CostoDoble = myRs.getInt("CostDoble");
                CostoTriple = myRs.getInt("CostTriple");
                Lugar = myRs.getString("Lugar");
                System.out.println(myRs.getString("Nombre"));
            }
              
        }catch(Exception e){
            
        }
    
        Hotel hotel = new Hotel(Nombre, Estrellas, CostoSimple, CostoDoble, CostoTriple, Lugar);
        paquete.setHotel(hotel);
    }
    
    @Override
    public void construirBus() {
        String Nombre = null;
        int Costo = 0;
        String Destino = null;
        String Origen = null;
        //LocalDate localDate = LocalDate.of(2000, 01, 01);
        Date date = new Date();
        try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM buses WHERE ID = 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            myRs = ps.executeQuery();
            while(myRs.next()){
                Nombre = myRs.getString("Nombre");
                Costo = myRs.getInt("Costo");
                Destino = myRs.getString("Destino");
                Origen = myRs.getString("Origen");
                date = myRs.getDate("Fecha");
                //localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
              
        }catch(Exception e){
            
        }
        Bus bus = new Bus(Nombre, Costo, Destino, Origen, date);
        paquete.setBus(bus);
    }

    @Override
    public void construirVuelo() {
        int NumeroVuelo = 0;
        String Destino = null;
        String Origen = null;
        int CantAsientos = 0;
        int CostEjecutivo = 0;
        int CostEconomico = 0;
        Date date = new Date();
        try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM vuelos WHERE ID = 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            myRs = ps.executeQuery();
            while(myRs.next()){
                NumeroVuelo = myRs.getInt("NumeroVuelo");
                Destino = myRs.getString("Destino");
                Origen = myRs.getString("Origen");
                CantAsientos = myRs.getInt("CantAsientos");
                CostEjecutivo = myRs.getInt("CostEjecutivo");
                CostEconomico = myRs.getInt("CostEconomico");
                date = myRs.getDate("Fecha");
                //localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
              
        }catch(Exception e){
            
        }
        
        Vuelo vuelo = new Vuelo(NumeroVuelo, Destino, Origen, CantAsientos, CostEjecutivo, CostEconomico, date);
        paquete.setVuelo(vuelo);
    }

    @Override
    public void construirOperador() {
        String Nombre = null;
        String Lugar = null;
        int Precio = 0;
        String Correo = null;
        try{
            Connection cn;
            ResultSet myRs = null;
            cn = connector.getConnection();
            String sql;
            
            sql = "SELECT * FROM operadores WHERE ID = 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            myRs = ps.executeQuery();
            while(myRs.next()){
                Nombre = myRs.getString("Nombre");
                Lugar = myRs.getString("Lugar");
                Precio = myRs.getInt("Precio");
                Correo = myRs.getString("Correo");
            }
              
        }catch(Exception e){
            
        }
        
        Operador operador = new Operador(Nombre, Lugar, Precio, Correo);
        paquete.setOperador(operador);
    }

    @Override
    public void construirNombrePlan() {
        paquete.setNombrePlan("Plan Verano");
    }
    
    
    
}
