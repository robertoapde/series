
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import vista.Interfaz;

public class controladorInterfaz implements ActionListener,MouseListener
{
    
    Interfaz vista3;
    
    public enum AccionMVC
    {
        btnAñadirP,
        btnAñadirS,
        
        btnImprimirP,
        btnImprimirS,
        
        btnModificarP,
        btnModificarS,
        
        btnEliminarP,
        btnEliminarS,
        
        btnSalirP,
        btnSalirS,
    }
    public controladorInterfaz(Interfaz vista3)
    {
        this.vista3=vista3;
    }
    
    public void iniciar()
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista3);
        }catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
        
        //pelicula
        
        this.vista3.btnAñadirP.setActionCommand(" AñadirP ");
        this.vista3.btnAñadirP. addActionListener(this);
        
        this.vista3.btnEliminarP.setActionCommand(" EliminarP ");
        this.vista3.btnEliminarP. addActionListener(this);
        
        this.vista3.btnImprimirP.setActionCommand(" ImprimirP ");
        this.vista3.btnImprimirP. addActionListener(this);
        
        this.vista3.btnModificarP.setActionCommand(" ModificarP ");
        this.vista3.btnModificarP. addActionListener(this);
        
        this.vista3.btnSalirP.setActionCommand(" SalirP ");
        this.vista3.btnSalirP. addActionListener(this);
        
        this.vista3.tablePeliculas.addMouseListener(this);
        this.vista3.tablePeliculas.setModel(new DefaultTableModel());
        
        //series
        
        this.vista3.btnAñadirS.setActionCommand(" AñadirS ");
        this.vista3.btnAñadirS. addActionListener(this);
        
        this.vista3.btnEliminarS.setActionCommand(" EliminarS ");
        this.vista3.btnEliminarS. addActionListener(this);
        
        this.vista3.btnImprimirS.setActionCommand(" ImprimirS ");
        this.vista3.btnImprimirS. addActionListener(this);
        
        this.vista3.btnModificarS.setActionCommand(" ModificarS ");
        this.vista3.btnModificarS. addActionListener(this);
        
        this.vista3.btnSalirS.setActionCommand(" SalirS ");
        this.vista3.btnSalirS. addActionListener(this);
        
        this.vista3.tableSeries.addMouseListener(this);
        this.vista3.tableSeries.setModel(new DefaultTableModel());
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       switch (AccionMVC.valueOf(e.getActionCommand()))
       {
           //peliculas
           case btnAñadirP:   
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1)
        {
            int fila = this.vista3.tablePeliculas.rowAtPoint(e.getPoint());
            if (fila > -1)
            {
                this.vista3.textNombreP.setText(String.valueOf(this.vista3.tablePeliculas.getValueAt(fila,0) ));
                this.vista3.textGenero.setText(String.valueOf(this.vista3.tablePeliculas.getValueAt(fila,1) ));
                this.vista3.textDuracion.setText(String.valueOf(this.vista3.tablePeliculas.getValueAt(fila,2) ));
               
            }
            int fila1 = this.vista3.tableSeries.rowAtPoint(e.getPoint());
            if (fila1 > -1)
            {
                this.vista3.textNombreS.setText(String.valueOf(this.vista3.tableSeries.getValueAt(fila,0) ));
                this.vista3.textTemporada.setText(String.valueOf(this.vista3.tableSeries.getValueAt(fila,1) ));
                this.vista3.textCapitulo.setText(String.valueOf(this.vista3.tableSeries.getValueAt(fila,2) ));
               
            }
                    
            
        }
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
