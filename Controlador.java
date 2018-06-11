/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import bd.BaseDeDatos;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import plancurso.CriterioEvalTabla;
import plancurso.LibroTabla;
import plancurso.PlanDeCurso;
import plancurso.UnidadTabla;

/**
 * @version 1.1
 * @author Foncho
 * @since 08/06/2018
 */
public class Controlador implements Initializable {
    
    //Elementos de la pestanna Principal
    @FXML private TextField txtNRC;
    @FXML private TextField txtEE;
    @FXML private TextField txtPE;
    @FXML private TextField txtBloque;
    @FXML private TextField txtSeccion;
    @FXML private TextField txtAcademico;
    @FXML private TextField txtPeriodo;
    @FXML private TextArea txtObjetivo;

    
    //Elementos de la pestana Unidades
    @FXML private TableView<UnidadTabla> tablaUnidad;
    @FXML private TableColumn columnaUnidadU;
    @FXML private TableColumn columnaTemasU;
    @FXML private TableColumn columnaFechasU;
    @FXML private TableColumn columnaTareasU;
    @FXML private TableColumn columnaTecnicaU;
    ObservableList<UnidadTabla> unidades;
    @FXML private TextField txtUnidadU;
    @FXML private TextField txtTemaU;
    @FXML private TextField txtFechasU;
    @FXML private TextField txtTareaU;
    @FXML private TextField txtTecnicaU;
    private int posicionUnidadTabla;
    @FXML private Button btnEliminarUnidad;
    @FXML private Button btnNuevaUnidad;
    @FXML private Button btnAnadirUnidad;
    @FXML private Button btnModificarUnidad;
    
    //Elementos de la pestana Bibliografia
    @FXML private TableView<LibroTabla> tablaLibros;
    @FXML private TableColumn columnaAutor;
    @FXML private TableColumn columnaTitulo;
    @FXML private TableColumn columnaEditorial;
    @FXML private TableColumn columnaAnno;
    ObservableList<LibroTabla> bibliografia;
    @FXML private TextField txtAutor;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtEditorial;
    @FXML private TextField txtAnno;
    private int posicionLibroTabla;
    @FXML private Button btnEliminarLibro;
    @FXML private Button btnNuevoLibro;
    @FXML private Button btnAnadirLibro;
    @FXML private Button btnModificarLibro;
    @FXML private Label labelLibroIncompleto;
    
    //Elementos de la pestana Unidades
    @FXML private TableView<CriterioEvalTabla> tablaCriterio;
    @FXML private TableColumn columnaUnidad;
    @FXML private TableColumn columnaFechas;
    @FXML private TableColumn columnaCriterio;
    @FXML private TableColumn columnaInstrumento;
    @FXML private TableColumn columnaPorcentaje;
    ObservableList<CriterioEvalTabla> criterios;
    @FXML private TextField txtUnidad;
    @FXML private TextField txtFechas;
    @FXML private TextField txtCriterio;
    @FXML private TextField txtInstrumento;
    @FXML private TextField txtPorcentaje;
    private int posicionCriterioTabla;
    @FXML private Button btnEliminarCriterio;
    @FXML private Button btnNuevoCriterio;
    @FXML private Button btnAnadirCriterio;
    @FXML private Button btnModificarCriterio;
    @FXML private Label lbPasa100;
    @FXML private Label lbPorcentaje;
    
    /**
     * Este metodo es para guardar todo el plan de curso (lo que se ha 
     * registrado en las tablas) en la base de datos
     * @param event del click del mouse
     */
    @FXML
    private void guardar(ActionEvent event) {
        PlanDeCurso plan = new PlanDeCurso(txtObjetivo.getText(),txtPeriodo.getText(),"1","Ingenieria de software");
        BaseDeDatos co = new BaseDeDatos();
        try{
            co.guardarPlanCurso(plan);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        }
        plan.guardarTodo(unidades,bibliografia,criterios);
        
    }
    
    @FXML
    private void cancelar(ActionEvent event) throws Throwable{
        
    }
    /**
     * Este metodo agrega los campos que esta llenos a la tabla de Unidad como un nuevo objeto al presionar el boton Anadir
     * @param event del click del mouse
     */
    @FXML
    private void anadirUnidad(ActionEvent event){
        UnidadTabla unidad = new UnidadTabla();
        unidad.unidad.set(txtUnidadU.getText());
        unidad.tema.set(txtTemaU.getText());
        unidad.fecha.set(txtFechasU.getText());
        unidad.tarea.set(txtTareaU.getText());
        unidad.tecnica.set(txtTecnicaU.getText());
        unidades.add(unidad);
    }
    
    /**
     * Este metodo sirve para eliminar una unidad de la tabla al presionar el boton Eliminar
     * @param event del click del mouse
     */
    @FXML
    private void eliminarUnidad(ActionEvent event){
        unidades.remove(posicionUnidadTabla);
        btnModificarUnidad.setDisable(true);
        btnEliminarUnidad.setDisable(true);
    }
    
    /**
     * Metodo que limpia todos los textfields para la posterior esctritura
     * de nuevos atributos para una nueva unidad
     * @param event del click del mouse
     */
    @FXML
    private void nuevaUnidad(ActionEvent event){
        txtUnidadU.setText("");
        txtTemaU.setText("");
        txtFechasU.setText("");
        txtTareaU.setText("");
        txtTecnicaU.setText("");
        btnEliminarUnidad.setDisable(true);
        btnModificarUnidad.setDisable(true);
        btnAnadirUnidad.setDisable(false);
        
    }
    
    /**
     * Metodo que obtiene la unidad seleccionada en la tabla y los imprime en
     * los texts fleids, el usuario puede modificar la informacion de los texf
     * fields al presionar una segunda vez la informacion cambia
     * @param event del click del mouse
     */
    @FXML void modificarUnidad(ActionEvent event){
        UnidadTabla unidad = new UnidadTabla();
        unidad.unidad.set(txtUnidadU.getText());
        unidad.tema.set(txtTemaU.getText());
        unidad.fecha.set(txtFechasU.getText());
        unidad.tarea.set(txtTareaU.getText());
        unidad.tecnica.set(txtTecnicaU.getText());
        unidades.set(posicionUnidadTabla, unidad);
        btnModificarUnidad.setDisable(true);
        btnEliminarUnidad.setDisable(true);
    }
    
    /**
     * En este metodo se usa toda la informacion de los texts fields para generar
     * una nueva unidad y escribirla en la base de datos
     * @param event del click del mouse
     */
    @FXML
    private void anadirLibro(ActionEvent event){
        if(txtAutor.getText().length()==0 || txtTitulo.getText().length()==0 || txtEditorial.getText().length()==0 || txtAnno.getText().length()==0){
            labelLibroIncompleto.setVisible(true);
        }else{
            labelLibroIncompleto.setVisible(false);
            LibroTabla libro = new LibroTabla();
            libro.autor.set(txtAutor.getText());
            libro.titulo.set(txtTitulo.getText());
            libro.editorial.set(txtEditorial.getText());
            libro.anno.set(txtAnno.getText());
            bibliografia.add(libro);
        }
    }
    /**
     * Metodo para eliminar un libro de la tabla de libros al presionar guardar
     * @param event del click del mouse;
     */
    @FXML
    private void eliminarLibro(ActionEvent event){
        bibliografia.remove(posicionLibroTabla);
        labelLibroIncompleto.setVisible(false);
        btnModificarLibro.setDisable(true);
        btnEliminarLibro.setDisable(true);
    }
    /**
     * Metodo que prepara los campos de texto limpiandolos para un nuevo libro
     * @param event del click del mouse 
     */
    @FXML
    private void nuevoLibro(ActionEvent event){
        txtAutor.setText("");
        txtTitulo.setText("");
        txtEditorial.setText("");
        txtAnno.setText("");
        btnModificarLibro.setDisable(true);
        btnEliminarLibro.setDisable(true);
        btnAnadirLibro.setDisable(false);
        labelLibroIncompleto.setVisible(false);
    }
    /**
     * metodo que sirve para cambiar los datos de 
     * @param event del click del mouse
     */
    @FXML void modificarLibro(ActionEvent event){
        if(txtAutor.getText().length()==0 || txtTitulo.getText().length()==0 || txtEditorial.getText().length()==0 || txtAnno.getText().length()==0){
            labelLibroIncompleto.setVisible(true);
        }else{
            LibroTabla libro = new LibroTabla();
            libro.autor.set(txtAutor.getText());
            libro.titulo.set(txtTitulo.getText());
            libro.editorial.set(txtEditorial.getText());
            libro.anno.set(txtAnno.getText());
            bibliografia.set(posicionLibroTabla, libro);
            btnModificarLibro.setDisable(true);
            btnEliminarLibro.setDisable(true);
        }
    }
    /**
     * Este metodo sirve para crear un nuevo criterio de evaluacion, pero
     * si pasa del 100% de porcentaje entre todos, ya no es posible agregarlo,
     * tambien revisa que el numero agregado sea un numero y no otra cosa
     * @param event del click del mouse
     */
    @FXML
    private void anadirCriterio(ActionEvent event){
        if(isNumeric(txtPorcentaje.getText())){
            int total = criterios.size();
            int porcentajeTotal = 0;
            //Este For permite contar el porcentaje antes de sumarle el nuevo
            for(int i=0;i<total;i++){
                porcentajeTotal = porcentajeTotal + Integer.parseInt(criterios.get(i).getPorcentaje());
            }
            porcentajeTotal = porcentajeTotal + Integer.parseInt(txtPorcentaje.getText());
            if(porcentajeTotal>100){
                lbPasa100.setVisible(true);
            }else{
                CriterioEvalTabla criterio = new CriterioEvalTabla();
                criterio.unidad.set(txtUnidad.getText());
                criterio.fecha.setValue(txtFechas.getText());
                criterio.criterio.setValue(txtCriterio.getText());
                criterio.instrumento.setValue(txtInstrumento.getText());
                criterio.porcentaje.setValue(txtPorcentaje.getText());
                criterios.add(criterio);
                lbPasa100.setVisible(false);
                lbPorcentaje.setVisible(false);
            }
            }else{
                lbPorcentaje.setVisible(true);
            }
    }
    /**
     * metodo que elimina el criterio que esta seleccionado en la tabla
     * @param event 
     */
    @FXML
    private void eliminarCriterio(ActionEvent event){
        criterios.remove(posicionCriterioTabla);
        btnEliminarCriterio.setDisable(true);
        btnModificarCriterio.setDisable(true);
        lbPasa100.setVisible(false);
        lbPorcentaje.setVisible(false);
    }
    /**
     * Metodo para limpiar los text fields de la pantalla de Calendario evaluacion
     * @param event 
     */
    @FXML
    private void nuevoCriterio(ActionEvent event){
        txtUnidad.setText("");
        txtFechas.setText("");
        txtCriterio.setText("");
        txtInstrumento.setText("");
        txtPorcentaje.setText("");
        btnModificarCriterio.setDisable(true);
        btnEliminarCriterio.setDisable(true);
        btnAnadirCriterio.setDisable(false);
        lbPasa100.setVisible(false);
        lbPorcentaje.setVisible(false);
    }
    /**
     * Metodo para modificar el criterio que esta seleccionado en la tabla, si
     * se sobrepasa el 100% no permite modificar, ademas verifica que la entrada
     * sea un numero
     * @param event 
     */
    @FXML void modificarCriterio(ActionEvent event){
        int total = criterios.size();
        int porcentajeTotal = 0;
        //determina si el campo porcentaje fue llenado con un numero
        if(isNumeric(txtPorcentaje.getText())){
            //Este For permite contar el porcentaje antes de sumarle el nuevo
            for(int i=0;i<total;i++){
                porcentajeTotal = porcentajeTotal + Integer.parseInt(criterios.get(i).getPorcentaje());
            }
            //En este if verifica si hay almenos un criterio agregado para modificar
            //y que el porcentaje no sea mayor a 100
            if(total > 0){
                porcentajeTotal = porcentajeTotal - Integer.parseInt(criterios.get(posicionCriterioTabla).getPorcentaje());
            }
            porcentajeTotal = porcentajeTotal + Integer.parseInt(txtPorcentaje.getText());
            if(porcentajeTotal>100){
                lbPasa100.setVisible(true);
            }else{
                CriterioEvalTabla criterio = new CriterioEvalTabla();
                criterio.unidad.set(txtUnidad.getText());
                criterio.fecha.setValue(txtFechas.getText());
                criterio.criterio.setValue(txtCriterio.getText());
                criterio.instrumento.setValue(txtInstrumento.getText());
                criterio.porcentaje.setValue(txtPorcentaje.getText());
                criterios.set(posicionCriterioTabla, criterio);
                lbPasa100.setVisible(false);
                btnModificarCriterio.setDisable(true);
                btnEliminarCriterio.setDisable(true);
                lbPorcentaje.setVisible(false);
        }
        }else{
            lbPorcentaje.setVisible(true);
        }
    }
    
    
    //A partir de aqui se maneja la tabla de Unidad
    
    /**
     * variable que indica donde se hizo click el usuario en la tabla de unidad
     */
    private final ListChangeListener<UnidadTabla> selectorUnidadTabla =
            new ListChangeListener<UnidadTabla>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends UnidadTabla> c) {
                   ponerUnidadSeleccionada();
                }
            };
    
    /**
     * metodo para obtener la unidad seleccionada de la tabla cpn el click
     * @return el criterio seleccionado por un click
     */
    public UnidadTabla getUnidadTablaSeleccionada(){
        if(tablaUnidad != null){
            List<UnidadTabla> tabla = tablaUnidad.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1){
                final UnidadTabla competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    
    /**
     * Metodo para escribir en los text fields los datos de la unidad seleccionada
     */
    private void ponerUnidadSeleccionada(){
        final UnidadTabla unidad = getUnidadTablaSeleccionada();
        posicionUnidadTabla = unidades.indexOf(unidad);
        
        if(unidad != null){
            //poner los textField con sus datos correspondientes
            txtUnidadU.setText(unidad.getUnidad());
            txtTemaU.setText(unidad.getTema());
            txtFechasU.setText(unidad.getFecha());
            txtTareaU.setText(unidad.getTarea());
            txtTecnicaU.setText(unidad.getTecnica());
            
            //deshabilitar botones
            btnModificarUnidad.setDisable(false);
            btnEliminarUnidad.setDisable(false);
            btnAnadirUnidad.setDisable(true);
        }
    }
    
    /**
     * Metodo para inicializar la tabla de Unidades
     */
    private void inicializarTablaUnidad(){
        columnaUnidadU.setCellValueFactory(new PropertyValueFactory<UnidadTabla,String>("unidad"));
        columnaTemasU.setCellValueFactory(new PropertyValueFactory<UnidadTabla,String>("tema"));
        columnaFechasU.setCellValueFactory(new PropertyValueFactory<UnidadTabla, String>("fecha"));
        columnaTareasU.setCellValueFactory(new PropertyValueFactory<UnidadTabla,String>("tarea"));
        columnaTecnicaU.setCellValueFactory(new PropertyValueFactory<UnidadTabla,String>("tecnica"));
        
        unidades = FXCollections.observableArrayList();
        tablaUnidad.setItems(unidades);
    }
    
    //hasta aqui se maneja la tabla de unidad
    //A partir de aqui se maneja la tabla de bibliografia
    
    /**
     * variable que indica donde se hizo click el usuario en la tabla de Libro
     */
    private final ListChangeListener<LibroTabla> selectorLibroTabla =
            new ListChangeListener<LibroTabla>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends LibroTabla> c) {
                   ponerLibroSeleccionado();
                }
            };
    
    /**
     * Metodo para obtener el libro que esta seleccionado con el click
     * @return el libro seleccionado de la tabla cpn mouse
     */
    public LibroTabla getLibroTablaSeleccionada(){
        if(tablaLibros != null){
            List<LibroTabla> tabla = tablaLibros.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1){
                final LibroTabla competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    
    /**
     * Metodo para escribir en los text fields los datos del libro seleccionado
     */
    private void ponerLibroSeleccionado(){
        final LibroTabla libro = getLibroTablaSeleccionada();
        posicionLibroTabla = bibliografia.indexOf(libro);
        
        if(libro != null){
            //poner los textField con sus datos correspondientes
            txtAutor.setText(libro.getAutor());
            txtTitulo.setText(libro.getTitulo());
            txtEditorial.setText(libro.getEditorial());
            txtAnno.setText(libro.getAnno());
            
            //deshabilitar botones
            btnModificarLibro.setDisable(false);
            btnEliminarLibro.setDisable(false);
            btnAnadirLibro.setDisable(true);
        }
    }
    
    /**
     * Metodo para inicializar la tabla de libros
     */
    private void inicializarTablaLibros(){
        columnaAutor.setCellValueFactory(new PropertyValueFactory<LibroTabla,String>("autor"));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<LibroTabla,String>("titulo"));
        columnaEditorial.setCellValueFactory(new PropertyValueFactory<LibroTabla, String>("editorial"));
        columnaAnno.setCellValueFactory(new PropertyValueFactory<LibroTabla,String>("anno"));
        
        bibliografia = FXCollections.observableArrayList();
        tablaLibros.setItems(bibliografia);
    }
    
    //hasta aqui se maneja la tabla de libros
    //desde aqui se maneja la tabla de Calendario evaluacion
    
    /**
     * variable que indica donde se hizo click el usuario en la tabla de Criterio
     * evaluacion
     */
    private final ListChangeListener<CriterioEvalTabla> selectorCriterioTabla =
            new ListChangeListener<CriterioEvalTabla>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends CriterioEvalTabla> c) {
                   ponerCriterioSeleccionado();
                }
            };
    
    /**
     * Metodo para obtener cual es el criterio seleccionado
     * @return el criterio que se selecciono con un click
     */
    public CriterioEvalTabla getCriterioTablaSeleccionada(){
        if(tablaCriterio != null){
            List<CriterioEvalTabla> tabla = tablaCriterio.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1){
                final CriterioEvalTabla competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    
    /**
     * Metodo para escribir en los text fields los datos del criterio seleccionado
     */
    private void ponerCriterioSeleccionado(){
        final CriterioEvalTabla criterio = getCriterioTablaSeleccionada();
        posicionCriterioTabla = criterios.indexOf(criterio);
        
        if(criterio != null){
            //poner los textField con sus datos correspondientes
            txtUnidad.setText(criterio.getUnidad());
            txtFechas.setText(criterio.getFecha());
            txtCriterio.setText(criterio.getCriterio());
            txtInstrumento.setText(criterio.getInstrumento());
            txtPorcentaje.setText(criterio.getPorcentaje());
            
            //deshabilitar botones
            btnModificarCriterio.setDisable(false);
            btnEliminarCriterio.setDisable(false);
            btnAnadirCriterio.setDisable(true);
        }
    }
    
    /**
     * Metodo para iniciar la tabla de criterios
     */
    private void inicializarTablaCriterios(){
        columnaUnidad.setCellValueFactory(new PropertyValueFactory<CriterioEvalTabla,String>("unidad"));
        columnaFechas.setCellValueFactory(new PropertyValueFactory<CriterioEvalTabla,String>("fecha"));
        columnaCriterio.setCellValueFactory(new PropertyValueFactory<CriterioEvalTabla,String>("criterio"));
        columnaInstrumento.setCellValueFactory(new PropertyValueFactory<CriterioEvalTabla,String>("instrumento"));
        columnaPorcentaje.setCellValueFactory(new PropertyValueFactory<CriterioEvalTabla,String>("porcentaje"));
        
        criterios = FXCollections.observableArrayList();
        tablaCriterio.setItems(criterios);
    }
    
    /**
     * Sirve para determinar si un campo ingresado es numero o no
     * @param cadena la cadena ingresada en el campo de texto
     * @return true si es numero, false si no lo es
     */
    private boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
        }
    }
    
    /**
     * Metodo principal
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar la tabla de Unidades
        this.inicializarTablaUnidad();
        btnModificarUnidad.setDisable(true);
        btnEliminarUnidad.setDisable(true);
        final ObservableList<UnidadTabla> tablaUnidadSel = tablaUnidad.getSelectionModel().getSelectedItems();
        tablaUnidadSel.addListener(selectorUnidadTabla);
        //Inicializar la tabla de bibliografia
        this.inicializarTablaLibros();
        btnModificarLibro.setDisable(true);
        btnEliminarLibro.setDisable(true);
        final ObservableList<LibroTabla> tablaLibroSel = tablaLibros.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorLibroTabla);
        //Inicializar la tabla criterio
        this.inicializarTablaCriterios();
        btnModificarCriterio.setDisable(true);
        btnEliminarCriterio.setDisable(true);
        final ObservableList<CriterioEvalTabla> tablaCriterioSel = tablaCriterio.getSelectionModel().getSelectedItems();
        tablaCriterioSel.addListener(selectorCriterioTabla);
        BaseDeDatos co = new BaseDeDatos();
        try{
            txtAcademico.setText(co.recuperarNombreAcademico(1));
            txtPeriodo.setText(co.recuperarPeriodo("1"));
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        }
        txtBloque.setText("3");
        txtSeccion.setText("5");
        txtPE.setText("Ingenieria de software");
        txtNRC.setText("98731");
        txtEE.setText("Procesos");
    }    
    
}
