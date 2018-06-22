/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author alejandro
 */
public class AutoDB extends DbManager {
    public Auto getViajeAuto(int idViaje){
        Auto auto = null;
        try {   
             String consulta = "SELECT a.* FROM viaje v join viaje_has_usuario vu " +
             "on v.id_viaje = vu.Viaje_id_viaje " +
             "join auto a on a.id_auto = vu.Auto_id_Auto " +
             "where v.id_viaje="+idViaje;
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int id_auto = st.getInt("id_auto");
            String marca = st.getString("marca");
            String modelo = st.getString("modelo");
            String color = st.getString("color");
            String combustible = st.getString("combustible");
            boolean aire = st.getBoolean("aireacondicionado");
            boolean calefaccion = st.getBoolean("calefaccion");
            short cantAsientos = st.getShort("cantidad_de_asientos");
            String baul = st.getString("capacidad_de_baul");
            short calificacion = st.getShort("calificacion");
            String patente = st.getString("patente");
            
            auto = new Auto(id_auto,marca,modelo,color,combustible,patente,aire,calefaccion,cantAsientos,calificacion,baul," ");
         //crear un objeto viaje
         //setear valores del viaje st.
         //crear y setear usuario
         //crear y setear auto
         //setear en viaje el usuario
         //setear en el usuario el auto
         //resul.add(u);*/
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return auto;  
    
    }
    
     public void addCar(String marca, String modelo, String color,String combustible, String patente, String aire, String calefaccion, String cantAsientos, String calificacion, String baul, String id_usuario){
        String SQL="'insert into auto(modelo,marca,color,combustible,patente,id_Auto,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,idUsusario) values ('"+marca+"','"+modelo+"','"+color+"','"+combustible+"','"+patente+"','"+aire+"','"+calefaccion+"','"+cantAsientos+"','"+calificacion+"','"+baul+"','" + id_usuario + "')'";
        super.InsertSql(SQL);
    }
    
    public void updateCar(String marca, String modelo, String color,String combustible, String patente, String aire, String calefaccion, String cantAsientos, String calificacion, String baul, String idAuto){
        String SQL="'UPDATE auto set modelo = '" + modelo +"',marca= '" + marca + "',baul= '" + baul + "',color= '" + color + "',combustible= '" + combustible + "',patente= '" + patente + "',aire= '" + aire + "',calefaccion= '" + calefaccion + "',cantidad_asientos= '" + cantAsientos + "',calificacion= '" + calificacion + "'WHERE idAuto = '" + idAuto + "';'";
        super.InsertSql(SQL);
        
        
    }
    
    public void deleteCar(String id_auto){ 
        String SQL="'delete from auto WHERE id_Auto='" + id_auto + "';'";
        super.InsertSql(SQL);
    }
    
    
    
    
    
}
