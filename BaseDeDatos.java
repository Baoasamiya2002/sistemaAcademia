package bd;
import vista.Sistema_academia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import minuta.Academia;
import minuta.Academico;
import minuta.Asunto;
import minuta.Carrera;
import minuta.Coordinador_de_academia;
import minuta.Minuta_de_academia;
import minuta.Periodo;
import minuta.Reunion_de_academia;
import plancurso.CriterioEvalTabla;
import plancurso.LibroTabla;
import plancurso.UnidadTabla;
import plancurso.PlanDeCurso;

/**
 *Esta clase consiste usar los metodos de la interfaz SistemaAcademiaDAO.java.
 *@version 1.0, 07/06/2018
 *@author Puxka Acosta Domínguez
 */

public class BaseDeDatos {
    
    /**
     * Abre connection que conecta al sistema con la base de datos y no necesita
     * parametros
     */
    
    public Connection conectarABaseDeDatos(){
        String url = "jdbc:mysql://localhost:3306/sistema?verifyServerCertificate=false&useSSL=true";
        String username = "root";
        String password = "puxkas";
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    /**
     * Desconecta al sistema de la base de datos de la conecction que recibe
     * @param conn connection que recibe
     */
    
    public void desconectarDeBaseDeDatos(Connection conn){
        try {
                conn.close();
        } catch(SQLException se) {
        }
        try {
            if(conn != null){
                conn.close();
            } 
        } catch(SQLException se) {
            
        }
    }
    
    /**
     * Metodo para recuperar el nombre de un academico
     * @param numPersonal es el identificador del academico
     * @return el nombre del academico en un string
     */
    
    public String recuperarNombreAcademico(int numPersonal) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String nombreAcademico= null;
        try{
            int i = 0;
            ResultSet rs = stm.executeQuery("Select * from academico");
            while(rs.next()){
                if(rs.getInt("numPersonal") == numPersonal){
                    nombreAcademico = rs.getString("nombre");
                }
            }
            rs.close();
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return nombreAcademico;
    }
    
    /**
     * Metodo para recuperar el nombre de una Experiencia educativa
     * @param nombre de la experiencia educativa
     * @return el nombre de la experiencia educativa
     */
    
    public String recuperarNombreEE(String nombre) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String nombreEE=null;
        try{
            int i = 0;
            ResultSet rs = stm.executeQuery("Select * from experienciaeducativa");
            while(rs.next()){
                if(rs.getString("nombreEE").equals(nombre)){
                    nombreEE = rs.getString("nombreEE");
                }
            } 
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return nombreEE;
    }
    
    /**
     * Metodo para recuperar el nombre de un programa educativo
     * @param nombre del programa educativa
     * @return el nombre del programa educativo
     */
    
    public String recuperarProgramaEducativo(String nombre) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String nombreP=null;
        try{
            int i = 0;
            ResultSet rs = stm.executeQuery("Select * from programaEduc");
            while(rs.next()){
                if(rs.getString("programaEduc").equals(nombre)){
                    nombreP = rs.getString("programaEduc");
                }
            } 
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return nombreP;
    }
    
    /**
     * Metodo para guardar un plan de curso
     * @param plan el plan para guardar
     */
    
    public void guardarPlanCurso(PlanDeCurso plan) throws SQLException {
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String sentencia = "INSERT INTO plancurso (idPlanCurso, objGeneral, idPeriodo, numPersonal, programaEduc) VALUES "
                + "(NULL, '" + plan.getObjGeneral() + "',  1, '" + plan.getNumPersonal() + "', '" + plan.getProgramaEducativo() + "');";
        try{
            stm.executeUpdate(sentencia);
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
    /**
     * Metodo para guardar una unidad en la base de datos
     * @param unidad la unidad que se va a guardar
     * @param idPlanCurso al que pertenece esta unidad
     */
    
    public void guardarUnidad(UnidadTabla unidad, String idPlanCurso) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String sentencia = "INSERT INTO planeacion (idPlaneacion, fecha, tarea, tecnicaDidactica, tema, unidad, idPlanCurso) VALUES "
                + "(NULL, '" + unidad.getFecha() + "', '" + unidad.getTarea() + "', '" + unidad.getTecnica() + "', '" + unidad.getTema() + "', '" + unidad.getUnidad()+ "', "+ idPlanCurso +");";
        System.out.println(sentencia);
        try{
            stm.executeUpdate(sentencia);
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
    /**
     * metodo para guardar un libro en la base de datos
     * @param libro el libro a guardar
     * @param idPlanCurso al que pertenece el libro
     */
    
    public void guardarLibro(LibroTabla libro, String idPlanCurso) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String sentencia = "INSERT INTO libro (idLibro, anio, editorial, titulo, autor, idPlanCurso) VALUES "
                + "(NULL, '" + libro.getAnno() + "', '" + libro.getEditorial() + "', '" + libro.getTitulo() + "', '" + libro.getAutor() + "', " + idPlanCurso +");";
        System.out.println(sentencia);
        try{
            stm.executeUpdate(sentencia);
        }catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
    /**
     * Metodo para guardar un criterio de evaluacion en la base de datos
     * @param criterio el criterio a guardar
     * @param idPlanCurso al que pertecene el criterio de evaluacion
     */
    
    public void guardarCriterio(CriterioEvalTabla criterio, String idPlanCurso) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String sentencia = "INSERT INTO calendarioEval (idCalendarioEval, criterio, fecha, instrumento, porcentaje, unidad, idPlanCurso) VALUES "
                + "(NULL, '" + criterio.getCriterio() + "', '" + criterio.getFecha() + "', '" + criterio.getInstrumento() + "', '" + criterio.getPorcentaje() + "', '" + criterio.getUnidad()+ "', "+ idPlanCurso +");";
        System.out.println(sentencia);
        try{
            stm.executeUpdate(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
    /**
     * metodo para recuperar un periodo
     * @param idPeriodo el periodo que se desea recuperar
     * @return el periodo en un string
     */
    
    public String recuperarPeriodo(String idPeriodo) throws SQLException{
        Connection conn = conectarABaseDeDatos();
        Statement stm = conn.createStatement();
        String periodo=null;
        try{
            int i = 0;
            ResultSet rs = stm.executeQuery("Select * from periodo");
            while(rs.next()){
                if(rs.getString("idPeriodo").equals(idPeriodo)){
                    periodo = rs.getString("periodo");
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger (BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return periodo;
    }
    
    /**
     * Regresa la academia del usuario
     * @return La academia del usuario
     */
    
    public Academia recuperarAcademia(){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        Academia academia = null;
        String nombre = null;
        String sql = "SELECT nombre FROM ACADEMIA WHERE numPersonal = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                nombre = rs.getString("nombre");
            }
            academia= new Academia(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return academia;
    }
    
    /**
     * Regresa el coordinador de la academia que recibe
     * @param academia academia que recibe
     * @return La coordinador de la academia
     */
    
    public Coordinador_de_academia recuperarCoordinador_de_academia(Academia 
            academia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        Coordinador_de_academia coordinadorAcademia = null;
        String nombre = null;
        int idAcademia = 0;
        String sql = "SELECT idAcademia FROM ACADEMIA WHERE numPersonal = ?";
        String sql2 = "SELECT nombre FROM ACADEMICO WHERE numPersonal = ? AND "
                + "idAcademia = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                idAcademia = rs.getInt("idAcademia");
            }
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, idAcademia);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                nombre = rs.getString("nombre");
            }
            coordinadorAcademia= new Coordinador_de_academia(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return coordinadorAcademia;
    }
    
    /**
     * Regresa la reunion de la fecha actual
     * @param fecha_actual fecha del dia actual
     * @return La reunion de academia
     */
    
    public Reunion_de_academia recuperarReunion_de_academia(String 
            fecha_actual){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        Reunion_de_academia reunionAcademia = null;
        String hora = null;
        String lugar = null;
        String sql = "SELECT hora, lugar FROM REUNIONACADEMIA WHERE fecha = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, fecha_actual);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                hora = rs.getString("hora");
                lugar = rs.getString("lugar");
            }
            reunionAcademia= new Reunion_de_academia(" ", fecha_actual, hora, 
                    lugar);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return reunionAcademia;
    }
    
    /**
     * Regresa el periodo de la reunion de academia que recibe
     * @param reunionAcademia reunion de academia que recibe
     * @return El periodo de la reunion de academia
     */
    
    public Periodo recuperarPeriodo(Reunion_de_academia reunionAcademia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        Periodo periodo = null;
        int idPeriodo = 0;
        String periodoValor = null;
        String nombre = null;
        String sql = "SELECT idPeriodo FROM REUNIONACADEMIA WHERE fecha = ?";
        String sql2 = "SELECT periodo FROM PERIODO WHERE idPeriodo = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, reunionAcademia.getFecha());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                idPeriodo = rs.getInt("idPeriodo");
            }
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setInt(1, idPeriodo);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                periodoValor = rs.getString("periodo");
            }
            periodo= new Periodo(periodoValor);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return periodo;
    }
    
    /**
     * Regresa la carrera del coordinador de academia que recibe
     * @param coordinadorAcademia coordinador de academia que recibe
     * @return La carrera del coordinador de academia
     */
    
    public Carrera recuperarCarrera(Coordinador_de_academia 
            coordinadorAcademia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        Carrera carrera = null;
        int idAcademia = 0;
        String programaEduc = null;
        String sql = "SELECT idAcademia FROM ACADEMICO WHERE nombre = ?";
        String sql2 = "SELECT programaEduc FROM ACADEMIA WHERE idAcademia = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, coordinadorAcademia.getNombre());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                idAcademia = rs.getInt("idAcademia");
            }
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setInt(1, idAcademia);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                programaEduc = rs.getString("programaEduc");
            }
            carrera = new Carrera(programaEduc);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return carrera;        
    }
    
    /**
     * Regresa un ArrayList con los nombres de los academicos de la academia que
     * recibe
     * @param academia academia que recibe
     * @return El ArrayList con los nombres de los academicos
     */
    
    public ArrayList<Academico> recuperarAcademico(Academia academia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        ArrayList<Academico> nombreAcademico = new ArrayList<Academico>();
        int idAcademia = 0;
        int cont = 0;
        String sql = "SELECT idAcademia FROM ACADEMIA WHERE nombre = ?";
        String sql2 = "SELECT nombre FROM ACADEMICO WHERE idAcademia = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Redes");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                idAcademia = rs.getInt("idAcademia");
            }
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setInt(1, idAcademia);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                nombreAcademico.add(new Academico(rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
        return nombreAcademico;
    }
    
    /**
     * Guarda la minuta de academia completa que recibe en la base de datos
     * @param minutaAcademia minuta de academia que recibe
     */
    
    public void guardarMinuta_de_academia(Minuta_de_academia minutaAcademia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        ArrayList listaDeParticipante = minutaAcademia.getListaDeParticipante();
        int numPersonal = 0;
        int idAcademia = 0;
        String sql = "INSERT INTO MINUTAACADEMIA (objetivo, conclusion, "
                + "temaTratar, idReunionAcademia, numPersonal, programaEduc)" 
                + "VALUES (?, ?, ?, ?, ?, ?)";
        String sql2 = "SELECT numPersonal, idAcademia FROM ACADEMICO WHERE "
                + "nombre = ?";
        String sql3 = "INSERT INTO MINUTAACADEMIA_ACADEMICO (numPersonal, "
                + "idMinutaAcademica)" + "VALUES (?, ?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, minutaAcademia.getObjetivo());
            preparedStatement.setString(2, minutaAcademia.getConclusion());
            preparedStatement.setString(3, minutaAcademia.getTemaTratar());
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, 15234);
            preparedStatement.setString(6, "Licenciatura en Redes y Servicios de Computo");
            preparedStatement.executeUpdate();
            preparedStatement = conn.prepareStatement(sql2);
            for(int i = 0; i < listaDeParticipante.size(); i++){
                preparedStatement = conn.prepareStatement(sql2);
                preparedStatement.setString(1, 
                        (String) listaDeParticipante.get(i));
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    numPersonal = rs.getInt("numPersonal");
                    idAcademia = rs.getInt("idAcademia");
                }
                preparedStatement = conn.prepareStatement(sql3);
                preparedStatement.setInt(1, numPersonal);
                preparedStatement.setInt(2, idAcademia);
                preparedStatement.executeUpdate();
                i++;
            }
            guardarAsunto(minutaAcademia);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
    /**
     * Guarda los asuntos adicionales de la minuta de academia completa que 
     * recibe en la base de datos
     * @param minutaAcademia minuta de academia que recibe
     */
    
    public void guardarAsunto(Minuta_de_academia minutaAcademia){
        Connection conn = conectarABaseDeDatos();
        PreparedStatement preparedStatement = null;
        ArrayList listaDeAsuntoParticipante = 
                minutaAcademia.getListaDeAsuntoParticipante();
        ArrayList asuntoAdicional = minutaAcademia.getAsuntoAdicional();
        int numPersonal = 0;
        int idAcademia = 0;
        String sql = "SELECT numPersonal, idAcademia FROM ACADEMICO WHERE "
                + "nombre = ?";
        String sql2 = "INSERT INTO ASUNTO (asuntoAdicional, "
                + "idMinutaAcademia, numPersonal)" + "VALUES (?, ?, ?)";
        try {
            for(int i = 0; i < listaDeAsuntoParticipante.size(); i++){
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, 
                        (String) listaDeAsuntoParticipante.get(i));
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    numPersonal = rs.getInt("numPersonal");
                    idAcademia = rs.getInt("idAcademia");
                }
                Asunto asunto = new Asunto((String) asuntoAdicional.get(i));
                preparedStatement = conn.prepareStatement(sql2);
                preparedStatement.setString(1, asunto.getAsuntoAdicional());
                preparedStatement.setInt(2, idAcademia);
                preparedStatement.setInt(3, numPersonal);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
        } finally {
            desconectarDeBaseDeDatos(conn);
        }
    }
    
}
