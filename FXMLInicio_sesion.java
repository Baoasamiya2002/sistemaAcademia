package vista;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *Esta clase consiste definir los metodos para las acciones de la ventana de 
 * Inicio de sesion.
 *@version 1.0, 10/06/2018
 *@author Puxka Acosta Domínguez
 */

public class FXMLInicio_sesion implements Initializable {

    @FXML
    private Label ventana;
    @FXML
    private Button aceptar;
    @FXML
    private Button cancelar;
    @FXML
    private PasswordField contrasena;
    @FXML
    private TextField usuario;
    
    @FXML
    private void handleButtonIniciar(ActionEvent event) {
        if(usuario.getText().equals("15234")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "Menu_CoordinadorAcademia.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Menu de opciones de Coordinador de academia");
                stage.setScene(scene);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "Menu_Academico.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Menu de opciones de academico");
                stage.setScene(scene);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        Stage stage = (Stage) cancelar.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
