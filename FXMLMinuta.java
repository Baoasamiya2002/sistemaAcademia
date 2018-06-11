package vista;
import bd.BaseDeDatos;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import minuta.Academia;
import minuta.Academico;
import minuta.Asunto;
import minuta.Carrera;
import minuta.Coordinador_de_academia;
import minuta.Minuta_de_academia;
import minuta.Periodo;
import minuta.Reunion_de_academia;

/**
 *Esta clase consiste definir los metodos para las acciones de la ventana de 
 * Crear minuta.
 *@version 1.0, 07/06/2018
 *@author Puxka Acosta Domínguez
 */

public class FXMLMinuta implements Initializable {

    @FXML
    private TextField txAcademia;
    @FXML
    private TextField txCoordinadorAcademia;
    @FXML
    private TextField txHora;
    @FXML
    private TextField txFecha;
    @FXML
    private TextField txPeriodo;
    @FXML
    private TextField txCarrera;
    @FXML
    private TextField txObjetivo;
    @FXML
    private TextField txConclusion;
    @FXML
    private TextField txTemaTratar;
    @FXML
    private MenuButton mbParticipante;
    @FXML
    private MenuButton mbAsunto1;
    @FXML
    private TextField txAsunto1;
    @FXML
    private MenuButton mbAsunto2;
    @FXML
    private TextField txAsunto2;
    @FXML
    private Label lAsuntoNombre2;
    @FXML
    private Label lAsuntoAsunto2;
    @FXML
    private MenuButton mbAsunto3;
    @FXML
    private TextField txAsunto3;
    @FXML
    private Label lAsuntoNombre3;
    @FXML
    private Label lAsuntoAsunto3;
    @FXML
    private Button bGuardar;
    
    private final Minuta_de_academia minutaAcademia = new Minuta_de_academia();
    
    @FXML
    private void handleButtonAsuntoAdicional(ActionEvent event) {
        if(mbAsunto2.isVisible()){
            mbAsunto3.setVisible(true);
            txAsunto3.setVisible(true);
            lAsuntoNombre3.setVisible(true);
            lAsuntoAsunto3.setVisible(true);
        }else{
            mbAsunto2.setVisible(true);
            txAsunto2.setVisible(true);
            lAsuntoNombre2.setVisible(true);
            lAsuntoAsunto2.setVisible(true);
        }
    }
    
    @FXML
    private void handleButtonCrear(ActionEvent event) {
        minutaAcademia.setObjetivo(txObjetivo.getText());
        minutaAcademia.setConclusion(txConclusion.getText());
        minutaAcademia.setTemaTratar(txTemaTratar.getText());
        Asunto asunto1 = new Asunto(txAsunto1.getText());
        Asunto asunto2 = new Asunto(txAsunto2.getText());
        Asunto asunto3 = new Asunto(txAsunto3.getText());
        minutaAcademia.guardarListaAsunto(asunto1.getAsuntoAdicional());
        minutaAcademia.guardarListaAsunto(asunto2.getAsuntoAdicional());
        minutaAcademia.guardarListaAsunto(asunto3.getAsuntoAdicional());
        minutaAcademia.guardar();
        final Stage ventanaException = new Stage();
        ventanaException.setTitle("EXITO");
        ventanaException.initModality(Modality.APPLICATION_MODAL);
        VBox ventanaVbox = new VBox(20);
        ventanaVbox.setPadding(new Insets(40, 40, 40, 40));
        Text mensaje = new Text(25, 25, "Creación"+"\n"+
            "   exitosa");
        mensaje.setFill(Color.GREEN);
        mensaje.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        ventanaVbox.getChildren().add(mensaje);
        Scene dialogScene = new Scene(ventanaVbox, 345, 150);
        ventanaException.setScene(dialogScene);
        ventanaException.show();
        Stage stage = (Stage) bGuardar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BaseDeDatos baseDatos = new BaseDeDatos();
        Academia academia = baseDatos.recuperarAcademia();
        txAcademia.setText(academia.getNombre());
        Coordinador_de_academia coordinadorAcademia = 
                baseDatos.recuperarCoordinador_de_academia(academia);
        txCoordinadorAcademia.setText(coordinadorAcademia.getNombre());
        DateTimeFormatter formatoFecha = 
                DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate fechaLocal = LocalDate.now();
        String fecha_actual = formatoFecha.format(fechaLocal);
        Reunion_de_academia reunionAcademia = 
                baseDatos.recuperarReunion_de_academia(fecha_actual);
        txHora.setText(reunionAcademia.getHora());
        txFecha.setText(reunionAcademia.getFecha());
        Periodo periodo = 
                baseDatos.recuperarPeriodo(reunionAcademia);
        txPeriodo.setText(periodo.getPeriodo());
        Carrera carrera =
                baseDatos.recuperarCarrera(coordinadorAcademia);
        txCarrera.setText(carrera.getProgramaEduc());
        ArrayList<Academico> nombreAcademico = baseDatos.recuperarAcademico(academia);
        EventHandler<ActionEvent> manejadorEventoParticipante = this::click_listaParticipante;
        EventHandler<ActionEvent> manejadorEventoAsunto = this::click_listaAsunto;
        for(int i = 0; i < nombreAcademico.size(); i++){
            mbParticipante.getItems().add(llenarListaParticipante(nombreAcademico.get(i).getNombre(), manejadorEventoParticipante));
            mbAsunto1.getItems().add(llenarListaAsunto(nombreAcademico.get(i).getNombre(), manejadorEventoAsunto, "miAsunto1"));
            mbAsunto2.getItems().add(llenarListaAsunto(nombreAcademico.get(i).getNombre(), manejadorEventoAsunto, "miAsunto2"));
            mbAsunto3.getItems().add(llenarListaAsunto(nombreAcademico.get(i).getNombre(), manejadorEventoAsunto, "miAsunto3"));
        }
    }
    
    private void click_listaParticipante(ActionEvent event) {
        CustomMenuItem cmFuente = (CustomMenuItem) event.getSource();
        CheckBox academico = (CheckBox) cmFuente.getContent();
        minutaAcademia.guardarListaDeParticipante(academico.getText());
    }
    
    private void click_listaAsunto(ActionEvent event) {
        MenuItem mFuente = (MenuItem) event.getSource();
        minutaAcademia.guardarListaDeAsuntoParticipante(mFuente.getText(), mFuente.getId());
        if(mFuente.getId().equals("miAsunto1")){
            mbAsunto1.setText(mFuente.getText());
        } else if(mFuente.getId().equals("miAsunto2")){
            mbAsunto2.setText(mFuente.getText());
        } else{
            mbAsunto3.setText(mFuente.getText());
        }
    }
    
    private CustomMenuItem llenarListaParticipante(String nombreAcademico, EventHandler<ActionEvent> manejadorEvento) {
        CustomMenuItem nuevoMenuItem = new CustomMenuItem(new CheckBox(nombreAcademico), false);
        nuevoMenuItem.setOnAction(manejadorEvento);
        return nuevoMenuItem;
    }
    
    private MenuItem llenarListaAsunto(String nombreAcademico, EventHandler<ActionEvent> manejadorEvento, String id) {
        MenuItem nuevoMenuItem = new MenuItem(nombreAcademico);
        nuevoMenuItem.setId(id);
        nuevoMenuItem.setOnAction(manejadorEvento);
        return nuevoMenuItem;
    }
    
}
