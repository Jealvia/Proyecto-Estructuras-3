/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuras3;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Julio Alvia
 */
public class VentanaComprimirController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
   
    @FXML
    private JFXTextField txtIngreso;

    @FXML
    private JFXButton btnComprimir;

    @FXML
    private JFXTextArea txtContenido;

    @FXML
    private JFXButton btnAtras;

    @FXML
    void comprimirAction(ActionEvent event) {
           
    }
    
    @FXML
    void regresar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("VistaPrincipal.fxml"));
        Stage stage=new Stage(); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BIENVENIDO");
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
