
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import models.ModelArchCSV;
import views.ViewArchCSV;

public class ControllerArchCSV {
    
    ModelArchCSV modelcsv; // Crea un objeto para acceder al contenido del Model.
    ViewArchCSV viewcsv; // Crea un objeto para acceder al contenido de la View.
    
        ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewcsv.jb_guardar) { // Comprueba si se selecciona el botón "Guardar".
                jb_guardar_action_performed();
            }
            else if (e.getSource() == viewcsv.jb_nuevo) { // Comprueba si se selecciona el botón "Nuevo".
                jb_nuevo_action_performed();
            }
        }
    };
    
    /**
     * Método para integrar los componentes del módelo MVC.
     * @param modelArchCSV
     * @param viewArchCSV 
     */
    public ControllerArchCSV(ModelArchCSV modelArchCSV, ViewArchCSV viewArchCSV) {
        this.modelcsv = modelArchCSV;
        this.viewcsv = viewArchCSV;
        
        this.viewcsv.jb_guardar.addActionListener(actionlistener);
        this.viewcsv.jb_nuevo.addActionListener(actionlistener);
        initComponents();
    }
    
    /**
     * Método para el botón "Guardar" de la interfaz (ViewArchCSV).
     */
    public void jb_guardar_action_performed() {
        String nombre = viewcsv.jtf_nombre.getText();
        String email = viewcsv.jtf_email.getText();
        String registro = nombre + "," + email;
        modelcsv.setMessage(registro);
        this.writeFile(modelcsv.getPath(), modelcsv.getMessage());
    }
    
    /**
     * Método para el botón "Nuevo" de la interfaz (ViewArchCSV).
     */
    public void jb_nuevo_action_performed() {
        viewcsv.jtf_nombre.setText("");
        viewcsv.jtf_email.setText("");
    }
    
    
// Métodos para la lectura y escritura del archivo CSV...
    
//    /**
//     * 
//     * @param path: Indica la ruta de almacenamiento del archivo a manipular.
//     * @return 
//     */
//    public String readFile (String path) {
//        try {
//            String row; // Variable que indica una "fila".
//            try (FileReader archivo = new FileReader(path)) { // Permite leer el contenido del archivo.
//                BufferedReader bufferedreader = new BufferedReader(archivo); // Permite almacenar el contenido del archivo de texto de forma temporal.
//                while ((row = bufferedreader.readLine()) != null ) {
//                    viewblocnotas.jta_bloc_notas.setText(row);
//                }
//            }
//        }
//        catch (FileNotFoundException err) { // Detecta un error en caso de no encontrar el archivo en el path indicado.
//            System.err.println("Archivo no encontrado: " + err.getMessage());
//        }
//        catch (IOException err) { // Marca error en caso de no contar con los permisos para acceder al archivo indicado.
//            System.err.println("Error en operación I/O: " + err.getMessage());
//        }
//        return null;
//    };
    
    /**
     * Método para guardar un nuevo registro en el archivo .csv.
     * @param path: Indica la ruta de almacenamiento del archivo a manipular.
     * @param message: Variable que almacena el contenido del área de texto.
     */
    public void writeFile (String path, String message) {
        try {
            File archivo = new File(path); // Abre el archivo de la ruta especificada, si no existe, lo crea (según el path o ruta).
            FileWriter filewriter = new FileWriter(archivo, true); // Permite subreescribir (parámetro 'true') en el archivo especificado.
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) { // Permite guardar el nuevo contenido en del archivo especificado.
                printwriter.println(message);
                printwriter.close();
            }
        }
        catch (FileNotFoundException err) { // Detecta un error en caso de no encontrar el archivo en el path indicado.
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { // Marca error en caso de no contar con los permisos para acceder al archivo indicado.
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    
    /**
     * Método para acceder a los componentes de la interfaz "ViewArchCSV".
     */
    public void initComponents() {
        viewcsv.setVisible(true);
    }
    
}
