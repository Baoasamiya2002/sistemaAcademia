
package vista;

import bd.BaseDeDatos;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import plandetrabajo.Academico;
import plandetrabajo.Actividad;
import plandetrabajo.ExperienciaEducativa;
import plandetrabajo.FormaEvaluar;
import plandetrabajo.Herramienta;
import plandetrabajo.Meta;
import plandetrabajo.ObjetivoParticular;
import plandetrabajo.Participante;
import plandetrabajo.Periodo;
import plandetrabajo.ProgramaEducativo;
import plandetrabajo.TemaParcial;
import plandetrabajo.PlanTrabajo;

/*************************************************************
 * Controlador.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class FXMLDocumentController implements Initializable {
///Paneles///
    @FXML private TabPane tpPlanTrabajo;
    @FXML private Tab tabPDT;
    @FXML private Tab tabOP;
    @FXML private Tab tabTema;
    @FXML private Tab tabFE;
    @FXML private Tab tabCrear;
    
///Primera ventana///
    @FXML private TextField tfNomAcad;
    @FXML private TextField tfFechaAp;
    @FXML private ComboBox cbPE;
    @FXML private TextField tfPeriodo;
    @FXML private TextField tfNomAcad2;
    @FXML private TextField tfNomCA;
    @FXML private ComboBox<String> cbParticipantes;
    @FXML private TextField txtObjGeneral;
    
///Objetivo particular///
    @FXML private TextField tfMeta;
    @FXML private TextArea txtObjPart;
    @FXML private TableView<Meta> tbMetas;
    @FXML private TableColumn<Meta, Integer> tbcNumero;
    @FXML private TableColumn<Meta, String> tbcMeta;
    @FXML private TableView tbActividades;
    @FXML private TableColumn<Actividad, String> tcAcciones;
    @FXML private TableColumn<Actividad, String> tcFecha;
    @FXML private TableColumn<Actividad, String> tcFormaOperar;
    @FXML private Button bAgregarOP;
    @FXML private Button bAgregarMeta;
    @FXML private Button bAgregarActividad;
    @FXML private TextField tfAccionesOP;
    @FXML private TextField tfFechaSemanaOP;
    @FXML private TextField tfFormaOperarOP;
    @FXML private Button bAnterior;
    
///Tema Parcial
    @FXML private ComboBox cbEET;
    @FXML private TextField tfPrimer;
    @FXML private TextField tfSegundo;
    @FXML private TableView tbHerramientas;
    @FXML private TableColumn<Herramienta, Integer> tbcNumeroH;
    @FXML private TableColumn<Herramienta, String> tbcNombreH;
    @FXML private TextField tfHerramienta;
    @FXML private Button bAgregarHerramienta;
    @FXML private Button bAgregarTema;
    
///FormaEvaluar///
    @FXML private ComboBox<String> cbEE;
    @FXML private TableView<FormaEvaluar> tbFormasEvaluar;
    @FXML private TableColumn<FormaEvaluar, Integer> tbcPorcentaje;
    @FXML private TableColumn<FormaEvaluar, String> tbcElemento;
    @FXML private Button bAgregarForma;
    @FXML private TextField tfElemento;
    @FXML private TextField tfPorcentaje;
    @FXML private Button bAgregarNuevaForma;
    
////Crear//////
    @FXML private ComboBox<Academico> cbParticupantesAcad;
    @FXML private Button bCrear;
    @FXML private Button bCancelar;
    @FXML private Button bAgregarParticipantes;
    
    ObservableList<String> nombresAcademicos = FXCollections.observableArrayList();
    ObservableList<String> nombresEE = FXCollections.observableArrayList();
    ObservableList<String> nombresEEaux = FXCollections.observableArrayList();
    ObservableList<String> nombresPE = FXCollections.observableArrayList();
    ObservableList<Meta> metas = FXCollections.observableArrayList();
    ObservableList<Actividad> actividades = FXCollections.observableArrayList();
    ObservableList<ObjetivoParticular> objetivos = FXCollections.observableArrayList();
    ObservableList<Herramienta> herramientas = FXCollections.observableArrayList();
    ObservableList<Academico> acads = FXCollections.observableArrayList();
    ArrayList<TemaParcial> temas = new ArrayList<>();
    ObservableList<FormaEvaluar> formas = FXCollections.observableArrayList();
    PlanTrabajo planT = new PlanTrabajo();
    ArrayList<Participante> participantes = new ArrayList<>();
///////METODOS//////

    /**
     * Este metodo guarda en la base de datos el plan de trabajo e invoca a todos los metodos para
     * guardar sus correspondientes partes.
     * @param event Click en guardar en la pestaña Crear.
     */
    @FXML
    private void crearPlan(ActionEvent event) {
        if (!cbPE.getSelectionModel().isEmpty()){
            Periodo periodo = new Periodo();
        periodo = obtenerPeriodoActual();
        int idPla=0;
        BaseDeDatos baseDatos = new BaseDeDatos();
        PlanTrabajo planTrabajo = new PlanTrabajo(
                0, //Id temporal
                tfFechaAp.getText(), 
                txtObjGeneral.getText(), 
                1, 
                periodo.getIdPeriodo(), 
                (String) cbPE.getSelectionModel().getSelectedItem(), 
                1 );
        Connection conect = baseDatos.conectarABaseDeDatos();
        idPla = planTrabajo.agregar(conect);
        baseDatos.desconectarDeBaseDeDatos(conect);
        planT.setIdPlanTrabajo(idPla);
        guardarObjetivosParticulares();
        guardarTemaParcial();
        guardarFormasEvaluar();
        guardarParticipantes();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion del plan de trabajo.");
        alert.setContentText("Creacion exitosa.");
        alert.show();
        System.exit(0);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creacion del plan de trabajo.");
            alert.setContentText("Seleccione un programa educativo");
            alert.show();
        }
        
    }
    
    /**
     * Este metodo guarda los objetivos particulares en la base de datos junto con sus actividades y sus metas.
     */
    private void guardarObjetivosParticulares() {
        int claveOP = 0;
        BaseDeDatos baseDatos = new BaseDeDatos();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        for (int i = 0; i < objetivos.size(); i++) {
            objetivos.get(i).setIdPlan(planT.getIdPlanTrabajo());
            claveOP =objetivos.get(i).agregar(conect);
            for (int j = 0; j < objetivos.get(i).getTamanioMetas(); j++) {
                objetivos.get(i).getMeta(j).setIdObjetivoParticular(claveOP);
                objetivos.get(i).getMeta(j).agregar(conect);
            }
            for (int k = 0; k <objetivos.get(i).getIdObjetivoParticular(); k++) {
                objetivos.get(i).getActividad(k).setIdObjetivoParticular(claveOP);
                objetivos.get(i).getActividad(k).agregar(conect);
            }
        }
        baseDatos.desconectarDeBaseDeDatos(conect);
    }
    
    /**
     * Este metodo guarda los temas parciales junto con sus herramientas en la base de datos.
     */
    private void guardarTemaParcial() {
        int claveTP = 0;
        BaseDeDatos baseDatos = new BaseDeDatos();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        for (int i = 0; i < temas.size(); i++) {
            temas.get(i).setIdPlan(planT.getIdPlanTrabajo());
            claveTP = temas.get(i).guardarTema(conect);
            for (int j = 0; j < temas.get(i).getTamanioHerramientas(); j++) {
                temas.get(i).getHerramienta(j).setIdTemaParcial(claveTP);
                temas.get(i).getHerramienta(j).agregar(conect);
            }
        }
        baseDatos.desconectarDeBaseDeDatos(conect);
    }
    
    /**
     * Este metodo guarda todas las formas de evaluar en la base de datos y les asigna el id del plan de trabajo.
     */
    private void guardarFormasEvaluar() {
        BaseDeDatos baseDatos = new BaseDeDatos();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        for (int i = 0; i < formas.size(); i++) {
            formas.get(i).setIdPlan(planT.getIdPlanTrabajo());
            formas.get(i).agregar(conect);
        }
        baseDatos.desconectarDeBaseDeDatos(conect);
    }
    
    /**
     * Este metodo agrega los temas y las herramientas de las correspondientes tablas a un objetivo particular.
     */
    @FXML
    private void agregarTema() {
        if (agregarTemaParcial(temas.size() + 1) != null){
            temas.add(agregarTemaParcial(temas.size() + 1));
            herramientas.removeAll(herramientas);
            limpiarCamposTemaParcial();
        }
    }
    
    /**
     * Este metodo crea un TemaParcial a partir de los datos introducidos por el usuario.
     * @param contTemaParcial Indica el idTemporal del nuevo tema parcial.
     * @return El Tema Parcial creado.
     */
    private TemaParcial agregarTemaParcial(int contTemaParcial) {
        TemaParcial nuevosTemas = null;
        if (!cbEET.getSelectionModel().isEmpty()){
            nuevosTemas = new TemaParcial(contTemaParcial, tfPrimer.getText(), tfSegundo.getText(), 0, 
            (String) cbEET.getSelectionModel().getSelectedItem());
            for (int i = 0; i < herramientas.size(); i++) {
                nuevosTemas.setHerramienta(herramientas.get(i));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Temas parciales");
            alert.setContentText("Seleccione una Experiencia Educativa.");
            alert.show();
        }
        
        return nuevosTemas;
    }
    
    /**
     * Este metodo guarda todas las metas y actividades en un mismo objetivo particular;
     * @param event Click en el boton Agregar nuevo objetivo particular.
     */
    @FXML
    private void agregarObjetivoParticular(ActionEvent event) {
        objetivos.add(agregarObjPart(objetivos.size()+1));
        metas.removeAll(metas);
        actividades.removeAll(actividades);
        txtObjPart.setText("");
    }
    
    /**
     * Este metodo captura todos los datos dentro de un objetivo de particular nuevo.
     * @param idObjetivo Indica el id temporal para el objetivo.
     * @return El ObjetivoParticular que se creo a partir de los campos llenados por el usuario.
     */
    private ObjetivoParticular agregarObjPart(int idObjetivo) {
        ObjetivoParticular nuevoObjetivo = new ObjetivoParticular(
        txtObjPart.getText(),
        0,
        idObjetivo);
        for (int i = 0; i < metas.size(); i++) {
            metas.get(i).setIdObjetivoParticular(nuevoObjetivo.getIdObjetivoParticular());
            nuevoObjetivo.setMetas(metas.get(i));
        }
        for (int j = 0; j < actividades.size(); j++) {
            actividades.get(j);nuevoObjetivo.getIdObjetivoParticular();
            nuevoObjetivo.setActividad(actividades.get(j));
        }
        return nuevoObjetivo;
    }
    
    /**
     * Este metodo recupera de la base de datos todos los academicos dentro de la academia.
     */
    private void llenarListaAcademicos() {
        tfNomAcad.setText("Programacion");
        BaseDeDatos baseDatos = new BaseDeDatos();
        Academico academico = new Academico();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        academico.obtenerDatos(conect, nombresAcademicos, 1);
        baseDatos.desconectarDeBaseDeDatos(conect);
        cbParticipantes.setItems(nombresAcademicos); 
    }    
    
    /**
     * Este metodo recupera las Experiencias Educativas de la base de datos y llena la lista.
     */
    private void llenarListaEE() {
        BaseDeDatos baseDatos = new BaseDeDatos();
        ExperienciaEducativa expe = new ExperienciaEducativa();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        expe.obtenerDatos(conect, nombresEE);
        baseDatos.desconectarDeBaseDeDatos(conect);
        nombresEEaux = nombresEE;
        cbEE.setItems(nombresEEaux);
        cbEET.setItems(nombresEE);
    }
    
    /**
     * Este metodo obtiene el ultimo periodo de la base de datos.
     * @return ultimo Periodo de la base de datos.
     */
    private Periodo obtenerPeriodoActual() {
        ArrayList<Periodo> periodos = new ArrayList<>();
        BaseDeDatos baseDatos = new BaseDeDatos();
        Periodo periodo = new Periodo();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        periodo.obtenerNombre(conect, periodos);
        baseDatos.desconectarDeBaseDeDatos(conect);
        periodo = periodos.get(periodos.size() - 1);
        return periodo;
    }
    
    /**
     * Este metodo llena los campos iniciales.
     */
    private void llenarCamposIniciales() {
        Periodo periodo = new Periodo();
        periodo = obtenerPeriodoActual();
        BaseDeDatos baseDatos = new BaseDeDatos();
        tfNomAcad.setText("Programacion");
        tfNomAcad2.setText("Programacion");
        tfNomCA.setText("Maria Karen Cortes Verdin");
        tfPeriodo.setText(periodo.getPeriodo());
    }
    
    /**
     * Este metodo recupera de la base de datos todos los Programas Educativos y llena la lista.
     */
    private void llenarListaPE() {
        BaseDeDatos baseDatos = new BaseDeDatos();
        ProgramaEducativo pe = new ProgramaEducativo();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        pe.obtenerPrograma(conect, nombresPE);
        baseDatos.desconectarDeBaseDeDatos(conect);
        cbPE.setItems(nombresPE);
    }
    
    /**
     * Este metodo limpia los campos de texto en la pesta;a Tema parcial.
     */
    private void limpiarCamposTemaParcial() {
        tfPrimer.setText("");
        tfSegundo.setText("");
        cbEET.getSelectionModel().clearSelection();
    }
    
    /**
     * Este metodo agrega la meta generada a partir de los datos del usuario al Array de metas.
     * @param event Click en el boton agregar de la pestaña Objetivo Particular.
     */
    @FXML
    private void agregarMeta(ActionEvent event) {
        int contadorMetas = 0;
        if(!"".equals(tfMeta.getText())){
            metas.add(agregarMetaActividad(metas.size()+1));
        }
        tfMeta.setText("");
    }
    
    /**
     * Este metodo crea una Meta y captura los datos ingresados por el usuario como atributos para la Meta.
     * @param idMeta Indica el id temporal de la Meta.
     * @return La Meta creada.
     */
    private Meta agregarMetaActividad(int idMeta) {
        Meta nuevaMeta = new Meta(idMeta, tfMeta.getText(), 0);
        return nuevaMeta;
    }
    
    /**
     * Este metodo agrega una nueva actividad al Array de actividades.
     * @param event Click en el boton agregar en la seccion de forma de evaluar.
     */
    @FXML
    private void agregarActividad(ActionEvent event) {
        if (validarDatosActividad()) {
            actividades.add(agregarActividadAccion(actividades.size()+1));
            tfAccionesOP.setText("");
            tfFechaSemanaOP.setText("");
            tfFormaOperarOP.setText("");            
        }
    }
    
    /**
     * Este metodo crea una actividad capturando los atributos introducidos por el usuario.
     * @param contActividad Indica el idTemporal de la actividad.
     * @return Actividad creada.
     */
    private Actividad agregarActividadAccion(int contActividad) {
        Actividad nuevaActividad = new Actividad(
                tfAccionesOP.getText(),
                tfFechaSemanaOP.getText(),
                tfFormaOperarOP.getText(),
                contActividad, 
                0);
        return nuevaActividad;
    }
    
    /**
     * Este metodo agregar la Herrmienta creada al Array de herrmientas validando que el campo
     * destinado al nombre de la herrmienta no este vacio.
     * @param event Click en el boton Agregar en la pestaña de Tema Parcial
     */
    @FXML
    private void agregarHerramienta(ActionEvent event) {
       if (!tfHerramienta.getText().equals("") && crearHerramienta(herramientas.size()+1) != null) {
            herramientas.add(crearHerramienta(herramientas.size()+1));
            tfHerramienta.setText("");
        }
    }
    
    /**
     * Este metodo captura los datos que exitan en el campo de texto destinado a la 
     * herramienta y crea un nuevo objeto de tipo Herramienta.
     * @param contHerramienta Indica el id temporal de la herramienta.
     * @return La Herramienta generada a partir del dato introducido por el usuario.
     */
    private Herramienta crearHerramienta(int contHerramienta) {
        Herramienta nuevaHerramienta =  null;
        if (!cbEET.getSelectionModel().isEmpty()) {
            nuevaHerramienta = new Herramienta(
                contHerramienta, 
                tfHerramienta.getText(), 
                (String) cbEET.getSelectionModel().getSelectedItem(), 
                0);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Temas parciales.");
            alert.setContentText("Seleccione una Experiencia Educativa");
            alert.show();
        }
        return nuevaHerramienta;
    }
    
    /**
     * Este metodo verifica que no haya campos vacios al momento de agregar una actividad.
     * @return false si hay por lo menos un campo vacio, true si todos los campos estan llenados.
     */
    private boolean validarDatosActividad() {
        if (tfAccionesOP.getText().equals("")) {
            return false;
        }
        if (tfFechaSemanaOP.getText().equals("")){
            return false;
        }
        if (tfFormaOperarOP.getText().equals("")) {
            return false;
        }
        return true;
    }
    
    /**
     * Este metodo calcula el nuevo id del plan de trabajo por crear y lo regresa como entero.
     * @return el futuro nuevo id del Plan de trabajo.
     */
    private int identificarIdPlan() {
        int numPersonal = 1;
        BaseDeDatos baseDatos = new BaseDeDatos();
        PlanTrabajo nuevoPlan = new PlanTrabajo();
        ArrayList<PlanTrabajo> planes = new ArrayList<>();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        nuevoPlan.obtenerPlanes(conect, planes,numPersonal);
        baseDatos.desconectarDeBaseDeDatos(conect);
        if (planes != null && !planes.isEmpty()) {
            nuevoPlan = planes.get(planes.size()-1);
            planT.setIdPlanTrabajo(nuevoPlan.getIdPlanTrabajo());
            return nuevoPlan.getIdPlanTrabajo();
        }
        return 0;
    }
    
    /**
     * Este metodo agrega una nueva forma de evaluar al arreglo donde se alamacenan las 
     * FormaEvaluacion validando que el usuario haya introducido un entero en el campo para
     * el porcentaje.
     * @param event Click en el boton Agregar en la pestaña Forma de evaluacion;
     */
    @FXML
    private void agregarForma(ActionEvent event) {
        int porcentaje = 0;
        try{
            porcentaje = Integer.parseInt(tfPorcentaje.getText());
            
        }catch(Exception e) {
            porcentaje = -1;
        }
        if (porcentaje <= 0 || porcentaje >= 100) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Validacion de datos");
            alert.setContentText("Porcentaje no valido.");
            alert.show();
        }else {
            formas.add(agregarFormaEvaluar(formas.size()));
        }
        tfElemento.setText("");
        tfPorcentaje.setText("");
    }
    
    /**
     * Este metodo captura los datos de los campos de texto Elemento y Porcentaje y crea un 
     * nuevo objeto FormaEvaluar con esos atributos.
     * @param contForma Indica un id temporal.
     * @return 
     */
    private FormaEvaluar agregarFormaEvaluar(int contForma) {
        int porcentaje = Integer.parseInt(tfPorcentaje.getText());
        FormaEvaluar formaEvaluar = new FormaEvaluar(
                tfElemento.getText(), 
                porcentaje, 
                0,
                cbEE.getSelectionModel().getSelectedItem());
        return formaEvaluar;
    }
    
    /**
     * Este metodo finaliza la ejecucion del programa cancelando todo.
     * @param event Click en el boton Cancelar en la pestaña Crear.
     */
    @FXML
    private void cancelar(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Este metodo guarda a cada participante seleccionado.
     * @param event Seleccion de cada integrante de la lista de academicos.
     */
    @FXML
    private void crearParticipante(ActionEvent event) {
        String nombre = "";
        nombre = cbParticipantes.getSelectionModel().getSelectedItem();
        Participante participante = new Participante(nombre, 0);
        if(!participantes.contains(participante)){
            participantes.add(participante);
        }
        for (int i = 0; i< participantes.size(); i++){
            System.out.println(participantes.get(i).getNombre());
        }
    }
    
    /**
     * Este metodo guarda cada participante en la base de datos.
     */
    private void guardarParticipantes() {
        BaseDeDatos baseDatos = new BaseDeDatos();
        Connection  conect = baseDatos.conectarABaseDeDatos();
        for (int i = 0; i < participantes.size(); i++) {
            participantes.get(i).setIdPlanTrabajo(planT.getIdPlanTrabajo());
            participantes.get(i).agregar(conect);
            
        }
        baseDatos.desconectarDeBaseDeDatos(conect);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarListaAcademicos();
        llenarListaEE();
        llenarCamposIniciales();
        llenarListaPE();
        tbMetas.setItems(metas);
        tbcMeta.setCellValueFactory(new PropertyValueFactory<Meta, String>("meta"));
        tbcNumero.setCellValueFactory(new PropertyValueFactory<Meta, Integer>("idMeta"));
        tbActividades.setItems(actividades);
        tcAcciones.setCellValueFactory(new PropertyValueFactory<Actividad, String>("actividad_accion"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<Actividad, String>("fecha_semana"));
        tcFormaOperar.setCellValueFactory(new PropertyValueFactory<Actividad, String>("formaOperar"));
        tbHerramientas.setItems(herramientas);
        tbcNombreH.setCellValueFactory(new PropertyValueFactory<Herramienta, String>("nombre"));
        tbcNumeroH.setCellValueFactory(new PropertyValueFactory<Herramienta, Integer>("idHerramienta"));
        tbFormasEvaluar.setItems(formas);
        tbcElemento.setCellValueFactory(new PropertyValueFactory<FormaEvaluar, String>("elemento"));
        tbcPorcentaje.setCellValueFactory(new PropertyValueFactory<FormaEvaluar, Integer>("porcentaje"));
    }    
    
}
