
package main;

import controllers.ControllerArchCSV;
import models.ModelArchCSV;
import views.ViewArchCSV;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelArchCSV modelcsv = new ModelArchCSV();
        ViewArchCSV viewcsv = new ViewArchCSV();
        ControllerArchCSV controllercsv = new ControllerArchCSV(modelcsv, viewcsv); // Integra los componentes del modelo MVC.
        
    }
    
}
