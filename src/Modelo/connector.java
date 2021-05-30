/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
/**
 *
 * @author Asrock
 */
public class connector {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cn = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia_turismo", "root", "");
            return cn;
    }
}

