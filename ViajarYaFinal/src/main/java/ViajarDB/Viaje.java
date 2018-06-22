/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class Viaje {
    private int idViaje;
    private String origen;
    private String destino;
    double gastosaproximados;
    // arreglo de String ciudadesintermedias;
    //el primer lugar del arreglo seria el origen y en la ultima posicion ponemos el destino
    Date fechaPartida;
    Date horaPartida;
    //capacidaddelbaul;
    //boolean aceptamascota;
    Usuario conductor;
    private String lugar_salida;
    private boolean mascota;
    private boolean fumador;
    private Date fecha_creacion;
    private ArrayList<Usuario> pasajeros= new ArrayList<>();
    
    
    Viaje(int id,String origen, String destino, double gastosaproximados, Date fecha,Date hora, Usuario conductor,String lugar_salida,boolean mascota,boolean fumador,Date fecha_creacion){
        this.idViaje=id;
        this.origen=origen;
        this.destino=destino;
        this.gastosaproximados=gastosaproximados;
        this.fechaPartida=fecha;
        this.horaPartida=hora;
        this.conductor=conductor;
        this.lugar_salida=lugar_salida;
        this.mascota=mascota;
        this.fumador=fumador;
        this.fecha_creacion=fecha_creacion;
    }
    
    
      // ---------constructor sin conductor solo para probar tabla en pantalla
    Viaje(int id,String origen, String destino, double gastosaproximados,Date fecha,Date hora,String lugar_salida,boolean mascota,boolean fumador,Date fecha_creacion){
        this.idViaje=id;
        this.origen=origen;
        this.destino=destino;
        this.gastosaproximados=gastosaproximados;
        this.fechaPartida=fecha;
        this.horaPartida=hora;
        this.lugar_salida=lugar_salida;
        this.mascota=mascota;
        this.fumador=fumador;
        this.fecha_creacion=fecha_creacion;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
    
    
    
    void setOrigen(String origen){
        this.origen=origen;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    void setDestino(String destino){
        this.destino=destino;
    }
    
    public String getDestino(){
        return this.destino;
    }

    public double getGastosaproximados() {
        return gastosaproximados;
    }

    public void setGastosaproximados(double gastosaproximados) {
        this.gastosaproximados = gastosaproximados;
    }
    
    
    
    void setFechaPartida(Date fechora){
        this.fechaPartida=fechora;
    }
    
    public Date getFechaPartida(){
        return this.fechaPartida;
    }

    public Date getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Date horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    
    
    void setConductor(Usuario conductor){
        this.conductor=conductor;
    }
    
    public Usuario getConductor(){
        return this.conductor;
    }

    public String getLugar_salida() {
        return lugar_salida;
    }

    public void setLugar_salida(String lugar_salida) {
        this.lugar_salida = lugar_salida;
    }

    public boolean isMascota() {
        return mascota;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
    
    
    void setPasajero(Usuario pasajero){
        this.pasajeros.add(pasajero);
    }
    
    
    //se da de baja un pasajero
    void deletePasajero(Usuario pasajero){
        boolean existe=false;
        int i=0;
        while ( i< pasajeros.size()&&!existe){
            if (pasajero.getMail()==pasajeros.get(i).getMail())
                existe=true;                
            else
                i++;
        }
        //notificar al conductor que se dio de baja ese pasajero
        this.pasajeros.remove(i);
    }
}
