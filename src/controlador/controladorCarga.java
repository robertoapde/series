
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.modeloCarga;
import vista.*;


public class controladorCarga implements ActionListener, MouseListener{
    Carga vista1 = Main.vista1; ;
    Registro vista2;
    Interfaz vista3;
    
    modeloCarga modelo ;
    String usuario;
    controladorRegistro controlR;
    controladorInterfaz controlI;
    
     public enum AccionMVC
    {
        
        btnEntrarC,
        btnSalirC,
        btnRegistroC,
        
    }
    public controladorCarga(Carga vista1)
    {
        this.vista1 = vista1;      
    }
   
    public void iniciar()
    {
       try{
            vista2 = new Registro();
        vista3 = new Interfaz();
        
        modelo = new modeloCarga();
                 
        controlR=new controladorRegistro(vista2);
        controlR.iniciar();
        
        controlI = new controladorInterfaz(vista3);
        
        this.vista1.setVisible(true);
        this.vista1.setLocation(150,100);
        
        this.vista1.btnEntrarC.setActionCommand("btnEntrarC");
        this.vista1.btnEntrarC.addActionListener(this);
        
        this.vista1.btnRegistroC.setActionCommand("btnRegistroC");
        this.vista1.btnRegistroC.addActionListener(this);
        
        this.vista1.btnSalirC.setActionCommand("btnSalirC");
        this.vista1.btnSalirC.addActionListener(this);
        
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, "Error al cargar ControladorCarga");
           JOptionPane.showMessageDialog(null, ex.getStackTrace());
       }
       
        
    }
 
   
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand()))
        {
            case btnEntrarC:
                try
                {
                    String u = String.valueOf(this.vista1.textUsuarioC.getText());
                    String c = String.valueOf(this.vista1.passConC.getText());
                    
                    if(u.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Introduzca un usuario");
                    }else if(c.equals("")){
                        JOptionPane.showMessageDialog(null, "Introduzca una contraseña");        
                    }else if(u.equals("") && c.equals("")){
                        JOptionPane.showMessageDialog(null, "Introduzca su usuario y contraseña");
                    }else{
                        int login;
                        login = modelo.login(u, c);
                        if(login == 1)
                        {
                           vista1.setVisible(false);
                           controlI.iniciar();
                           vista3.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
                        }
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al conectar");
                }
                break;
            case btnRegistroC:
                vista2.setVisible(true);
                vista1.setVisible(false);
                break;
            case btnSalirC:
                vista1.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
