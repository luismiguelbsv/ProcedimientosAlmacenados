/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientosalmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author manana
 */
public class ProcedimientosAlmacenados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           //1. cargar el DRV
        Connection con=null;
        Statement st=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Cargado");
        }catch(ClassNotFoundException cne)
        {
            System.out.println("Driver no cargado " 
                    +cne.getMessage());
            
        }
        
        // 2. Establecer conexión
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
            System.out.println("Conectados a Academia");
        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        
        try{
        CallableStatement cstmt = con.prepareCall("{call procd_asignaturas(?)}");
        cstmt.setString(1, "1");
        ResultSet rs=cstmt.executeQuery();
        if(rs.next())
        {
            
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  ");
            
        }
         } catch (SQLException sqe) {
            System.out.println(""+ sqe.getMessage());
        }
    }
    
}
