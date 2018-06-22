/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vale2
 */
public class ViajeDB extends DbManager {
    private ArrayList<Viaje> resul= new ArrayList<Viaje>();
    private String consulta;
    private String[][] misViajes;
    
    public ArrayList<Viaje> getViajes() {
        //ArrayList<Viaje> resul= new ArrayList<Viaje>();
        try {
            
            //String consulta = "SELECT * FROM viaje where fechayhora_partida > now()";
            ResultSet st = GET_RESULT_SET(consulta);
            
            while (st.next()) {
                int idViaje= st.getInt("id_viaje");
                String origen = st.getString("origen");
                String destino = st.getString("destino");
                Double gastosAprox = st.getDouble("gastos_aproximados");
                Date fechaPartida = st.getDate("fechayhora_partida");
                Date horaPartida = st.getTime("fechayhora_partida");
                String lugarSalida = st.getString("lugar_salida");
                boolean mascota = st.getBoolean("mascota");
                boolean fumador = st.getBoolean("fumador");
                Date fechaCreacion = st.getDate("fecha_creacion");                
                Viaje v = new Viaje (idViaje,origen,destino,gastosAprox,fechaPartida,horaPartida,lugarSalida,mascota,fumador,fechaCreacion);
                resul.add(v);
            }
            closeConections();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return resul;
    }
   
    
    public ArrayList<Viaje> getViajesActuales(){
            
            this.consulta = "SELECT * FROM viaje where fechayhora_partida > now()";
            return getViajes();
    }
    
    public ArrayList<Viaje> getViajesxCiudades(String ciudadOrigen,String ciudadDestino){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida > now() and origen= '"+ciudadOrigen+"' and destino= '"+ciudadDestino+"' ";
            return getViajes();
        
        
    }
    
     public ArrayList<Viaje> getViajesxFecha(String fecha){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida like '"+fecha+"%'";
            System.out.println(this.consulta);
            return getViajes();
        
        
    }
     
     public ArrayList<Viaje> getViajesxCiudadesxFecha(String ciudadOrigen,String ciudadDestino,String fecha){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida like '"+fecha+"%' and origen= '"+ciudadOrigen+"' and destino= '"+ciudadDestino+"' ";
            return getViajes();
        
        
    } 
     
     public String[][]getMisViajes(int idUsuario){
            
        String[][] viajes= new String[100][8];   
          
           this.consulta = "select v.id_viaje,v.fechayhora_partida,v.origen,v.destino,v.lugar_salida,a.marca,a.modelo,u.nombre,u.apellido "+
                            "from viaje v "+
                            "inner join viaje_has_usuario as vhu on vhu.Viaje_id_viaje=v.id_viaje "+
                            "inner join auto as a on a.id_auto=vhu.Auto_id_auto "+
                            "inner join usuario as u on u.id_usuario=a.id_propietario "+
                            "where vhu.Usuario_id_usuario ='"+idUsuario+"'";
            
            try {
                
               
            ResultSet st = GET_RESULT_SET(consulta);
            int f=0;
            
           
            while (st.next()) {
               
                String idViaje = st.getString("id_viaje");
                viajes[f][0]= idViaje;
                Date fechaPartida = st.getDate("fechayhora_partida");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = sdf.format(fechaPartida);
                viajes[f][1]= fecha;
                String origen = st.getString("origen");
                viajes[f][2]= origen;
                String destino = st.getString("destino");
                viajes[f][3]= destino;
                String lugarSalida = st.getString("lugar_salida");
                viajes[f][4]= lugarSalida;
                String marca = st.getString("marca");
                viajes[f][5]= marca;
                String modelo = st.getString("modelo");
                viajes[f][6]= modelo; 
                String nombre = st.getString("nombre");
                String apellido = st.getString("apellido");
                viajes[f][7]= nombre+" "+apellido;
                
                f++;
                
            }
            closeConections();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return viajes;
    }
   
       //----------------------alejandro--------------------------------------------------------
     //------------------------retorno el detalle de un viaje en especifico------------------
    
     public Viaje getViajeUsuario(int idViaje){
        Viaje viaje = null;
        
        try {   
             
            String consulta = "select v.*,u.nombre,u.apellido,a.*,vhu.Usuario_id_usuario "+
                              "from viaje v "+
                              "inner join viaje_has_usuario as vhu on vhu.Viaje_id_viaje=v.id_viaje "+
                              "inner join auto as a on a.id_auto=vhu.Auto_id_auto "+
                              "inner join usuario as u on u.id_usuario=a.id_propietario "+
                              "where v.id_viaje ='"+idViaje+"'";
            
            
           /* 
            String consulta = "SELECT v.*, u.nombre,u.apellido,a.* FROM viaje v join viaje_has_usuario vu " +
             "on v.id_viaje = vu.Viaje_id_viaje " +
             "join usuario u on u.id_usuario = vu.Usuario_id_usuario " +
             "join auto a on a.id_auto = vu.Auto_id_auto " +
             "where v.id_viaje="+idViaje;*/


             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int id_usuario = st.getInt("Usuario_id_usuario");
            int id_Viaje = st.getInt("id_viaje");
            String nombre = st.getString("nombre");
            String apellido = st.getString("apellido");
            Usuario conductor =new Usuario(nombre, apellido,id_usuario);
            String nombreCiudadOrigen = st.getString("origen");
            String nombreCiudadDestino = st.getString("destino");
            double gastosAprox = st.getDouble("gastos_aproximados");
            String lugarDeSalida = st.getString("lugar_salida");
            boolean mascota = st.getBoolean("mascota");
            System.out.println("acepta mascota"+ mascota);
            boolean fumador = st.getBoolean("fumador");
            Date fechaCreacion = st.getDate("fecha_creacion");
            Date fecha = st.getDate("fechayhora_partida");
            Date hora = st.getTime("fechayhora_partida");
            viaje = new Viaje(id_Viaje,nombreCiudadOrigen,nombreCiudadDestino,gastosAprox,fecha,hora,conductor,lugarDeSalida,mascota,fumador,fechaCreacion);
         //crear un objeto viaje
         //setear valores del viaje st.
         //crear y setear usuario
         //crear y setear auto
         //setear en viaje el usuario
         //setear en el usuario el auto
         resul.add(viaje);
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return resul.get(0);  
    
    }
    
    public int getCantidadAsientos(int idViaje){
        Viaje viaje = null;
        int cantAsiento=0;
        try {   
             String consulta = "SELECT * FROM viaje_has_usuario where Viaje_id_viaje = '"+idViaje+"'";
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            cantAsiento++;
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return cantAsiento;  
    
    }
     
    public boolean existeUsuarioEnViaje (int idViaje, int idUsuario){
        boolean VoF = false;
        try{
            String consulta="SELECT * FROM viaje_has_usuario where Viaje_id_viaje = '"+idViaje+"' and Usuario_id_usuario= '"+idUsuario+"'";
            ResultSet st = GET_RESULT_SET(consulta);
            if(st.absolute(1))
                VoF=true;
            //else
            //    VoF=true;
            closeConections();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return VoF;
    }
    
    public void insertarUsuarioEnViaje(int idViaje, int idUsuario, int idAuto){
        String SSQL="Insert into viaje_has_usuario(Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values ("+idViaje+","+idUsuario+","+idAuto+")";
        super.InsertSql(SSQL);
    }   
    
     public void insertarCalificacion(int idViaje, int idUsuario, int idAuto,int puntaje,String descripcion){
         
        String SSQL="Insert into calificacion (Viaje_has_Usuario_Viaje_id_viaje,Viaje_has_Usuario_Usuario_id_usuario,Viaje_has_Usuario_Auto_id_auto,puntuacion,descripcion)\n" +
                    "values ("+idViaje+","+idUsuario+","+idAuto+","+puntaje+",'"+descripcion+"');";
        super.InsertSql(SSQL);
    }   
   
           
        
    }
      
      
   
 
    
