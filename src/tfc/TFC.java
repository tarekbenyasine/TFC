/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tfc;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author terak
 */
public class TFC {

    /**
     * @param args the command line arguments
     */
     private FileHandler fileHandler;
 private ConsoleHandler cons;
 private static Logger log = Logger.getLogger("controlador");
    private void logs(){
    try {
            cons = new ConsoleHandler();
            log.addHandler(cons);
            fileHandler = new FileHandler("Logs/errorres.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("Ocurrió un error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
                
                    javax.swing.UIManager.setLookAndFeel(new NoireLookAndFeel());
                    
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
    }
    
}
