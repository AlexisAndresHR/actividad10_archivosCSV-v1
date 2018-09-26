
package models;


public class ModelArchCSV {
    
    private String path = "C:\\archivos\\base.csv"; // Variable que almacena la ruta del archivo.

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    private String message = ""; // Variable que almacena los datos de los campos de texto de "ViewArchCSV".

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
