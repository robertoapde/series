
package modelo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class modeloRegistro extends Database{
    public modeloRegistro(){}
    
    public boolean nuevoUsuario(String u, String c){
        boolean resu = false;
        String q1 ="INSERT INTO usuario VALUES ('"+u+"','"+c+"')";
        try{
            PreparedStatement pstm1  = this.getConexion().prepareStatement(q1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Nombre en uso o demasiado largo.");
            e.getStackTrace();
        }
        return resu;
    }
}
