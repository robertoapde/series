
package controlador;

import javax.swing.JOptionPane;
import vista.*;

public class Main {

    static controladorCarga controlC;
    static Carga vista1 = new Carga();
    
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Pulse 'Aceptar' y espere alrededor de 30 segundos."+"\nDisculpe las molestias.");
        
        controlC = new controladorCarga(vista1);
        controlC.iniciar();
    }
    
}
