/*
 * Copyright (C) 2017 Kevin Vásconez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package espol.edu.ec.GUI;

import espol.edu.ec.TDAs.ArbolHuffman;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static espol.edu.ec.TDAs.Prueba.arbol;
import static espol.edu.ec.TDAs.Prueba.calcularArbol;
import static espol.edu.ec.TDAs.Prueba.calcularFrecuencias;
import static espol.edu.ec.TDAs.Util.binarioHexadecimal;
import static espol.edu.ec.TDAs.Util.guardarTexto;
import static espol.edu.ec.TDAs.Util.leerTexto;
import static espol.edu.ec.TDAs.Util.obtenerPath;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * FXML Controller class
 *
 * @author Kevin Vásconez
 */
public class FXMLVentanaComprimirController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label status;
    
    @FXML
    private Label lbl;
    
    @FXML
    private Button abrir;
    
    @FXML
    private Button btnComprimir;

    @FXML
    private Button btnAtras;
    
    private FileChooser chooser = new FileChooser();
    
    private File file;

    @FXML
    void comprimirAction(ActionEvent event) throws FileNotFoundException {
        boolean stat = false;
        if (this.file != null) {
            String s = leerTexto(this.file);
            HashMap<String, Integer> mapa = calcularFrecuencias(s);
            System.out.println(mapa);
            ArbolHuffman arbol=new ArbolHuffman();
            //arbol.calcularArbol(mapa);
            //calcularArbol(mapa);
            arbol.calcularArbol(mapa);
            System.out.println();
            String b = arbol.codificar(s, arbol.calcularCodigos());
            String hexa = binarioHexadecimal(b);
            File newFile = saveFile();
            if (newFile != null) {
                stat = guardarTexto(newFile, hexa, arbol.calcularCodigos());
            }
        }
        if (stat) {
            status.setText("¡Compresión exitosa!");
        } else {
            status.setText("Ha ocurrido un error durante la compresión.");
        }
    }
    
    @FXML
    File openFile(ActionEvent event) {
        Node node = (Node) event.getSource();
        this.file = chooser.showOpenDialog(node.getScene().getWindow());
        if (file != null && file.getName().endsWith(".txt")) {
            this.lbl.setText(file.getAbsolutePath());
            return file;
        }
        return null;
    }
    
    File saveFile() {
        Node node = (Node) btnComprimir;
        File fileSave = chooser.showSaveDialog(node.getScene().getWindow());
        if (fileSave != null && fileSave.getName().endsWith(".txt")) {
            return fileSave;
        }
        return null;
    }
    
    
    
    @FXML
    void regresar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVistaPrincipal.fxml"));
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