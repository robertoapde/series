/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.Carga;
import vista.Registro;

/**
 *
 * @author Rob
 */
public class modeloRegistro extends Database{
    
    public boolean nuevoUsuario(String u, String c){
            boolean resu =false;
           
           
                String q2 = "INSERT INTO usuario VALUES ('"+u+"','"+c+"')";
                try{
                    PreparedStatement pstm2 = this.getConexion().prepareStatement(q2);
                    pstm2.execute();
                    pstm2.close();
                 resu = true;
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Nombre en uso o demasiado largo.");
                    ex.getStackTrace();
                }
           
            
        return resu;
     
    }
}
