
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class modeloCarga extends Database {
    
    public int login(String u, String p){
        int resu = 0;
            try{
                String q1 = "SELECT nombre, contraseña FROM usuario WHERE nombre = '"+u+"'";
                String usu = "";
                String pass = "";
                try{
                    PreparedStatement pstm1 = this.getConexion().prepareStatement(q1);
                    ResultSet res = pstm1.executeQuery();
                    res.next();
                    usu = res.getString("nombre");
                    pass = res.getString("contraseña");
                    res.close();
                    pstm1.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error de SQL");
                }
                if(pass.equals(p) && usu.equals(u)){
                    resu = 1;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inicio de sesión");
            }
        return resu;
    }

  
}
