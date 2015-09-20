/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelo.modeloRegistro;
import vista.Carga;
import vista.Registro;

/**
 *
 * @author Rob
 */
public class controladorRegistro implements ActionListener{
    
    Carga vista1 = controlador.Main.controlC.vista1;
    Registro vista2 = controlador.Main.controlC.vista2;
    modeloRegistro modeloR = new modeloRegistro();

   
    public enum AccionMVC
    {
        btnRegistroR,
        btnSalirR,
    }
    public controladorRegistro(Registro vista2)
    {
        this.vista2 = vista2;
    }
    public void iniciar()
    {
        try
        {
            this.vista2.btnRegistroR.setActionCommand("btnRegistroR");
            this.vista2.btnRegistroR.addActionListener(this);
            
            this.vista2.btnSalirR.setActionCommand("btnSalirR");
            this.vista2.btnSalirR.addActionListener(this);
            
        }catch(Exception e){}
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        switch(AccionMVC.valueOf(e.getActionCommand())){
            case btnRegistroR:
                String nick = this.vista2.textNick.getText();
                String contra = this.vista2.passCR.getText();
                String confContra = this.vista2.passCRR.getText();
               try
               { 
                 if(nick.equals("") || contra.equals("") || confContra.equals("") )
                 {
                        JOptionPane.showMessageDialog(null,"Rellene todos los campos necesarios");
                 }else{
                     if(contra.equals(confContra))
                     {
                         boolean confi;
                         confi = modeloR.nuevoUsuario(nick, contra);
                         
                         if(confi == true)
                         {
                             JOptionPane.showMessageDialog(null, "Usuario "+nick+" creado");
                             vista1.setVisible(true);
                             vista2.dispose();
                         }
                     
                     } else {
                        JOptionPane.showMessageDialog(null, "Error al crear el usuario");
                     }
                 }
               }catch(Exception ex)
               {
                   JOptionPane.showMessageDialog(null, "Error al crear el ususario");
               }
                 break;
            case btnSalirR:
                vista1.setVisible(true);
                vista2.dispose();
                break;
        }
    }
}   
