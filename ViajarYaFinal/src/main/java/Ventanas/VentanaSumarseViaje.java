/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 *
 * @author alejandro
 */
public class VentanaSumarseViaje extends JFrame{
   
  
    
    public VentanaSumarseViaje(int id, int idUsuarioActual){
        ViajeDB v = new ViajeDB();
        Viaje viaje = v.getViajeUsuario(id);
       
        JFrame ventana = new JFrame("Detalle del viaje");
        
        JLabel labelConductor=new JLabel("Conductor: ");
        JTextField textConductor=new JTextField(viaje.getConductor().getNombre()+" "+viaje.getConductor().getApellido());
        labelConductor.setBounds(10,10,200,30);
        textConductor.setBounds(150,10,200,30);
        
        JLabel labelOrigen=new JLabel("Origen: ");
        JTextField textOrigen=new JTextField(viaje.getOrigen());
        labelOrigen.setBounds(10,50,200,30);
        textOrigen.setBounds(150,50,200,30);
        
        JLabel labelDestino=new JLabel("Destino: ");
        JTextField textDestino=new JTextField(viaje.getDestino());
        labelDestino.setBounds(10,90,200,30);
        textDestino.setBounds(150,90,200,30);
        
        JLabel labelFecha=new JLabel("Fecha: ");
       
        JTextField textFecha=new JTextField(viaje.getFechaPartida().toString());
        labelFecha.setBounds(10,130,200,30);
        textFecha.setBounds(150,130,70,30);
        
        JLabel labelHora=new JLabel("Hora: ");
        
        JTextField textHora=new JTextField(viaje.getHoraPartida().toString());
        labelHora.setBounds(230,130,200,30);
        textHora.setBounds(285,130,60,30);
        
        
        JLabel labelLugar=new JLabel("Lugar de Salida: ");
        JTextField textLugar=new JTextField(viaje.getLugar_salida());
        labelLugar.setBounds(10,170,200,30);
        textLugar.setBounds(150,170,200,30);
        
        JLabel labelGastos=new JLabel("Gastos Aproximados: ");
        JTextField textGastos=new JTextField(String.valueOf(viaje.getGastosaproximados()));
        labelGastos.setBounds(10,210,200,30);
        textGastos.setBounds(150,210,200,30);
        
        JLabel labelMascota=new JLabel("Acepta Mascota?: ");
        String mascota=String.valueOf(viaje.isMascota());
        if (mascota.equals("true")){
            mascota="Si";
        }
        else{
            mascota="No";
        }
        JTextField textMascota=new JTextField(mascota);
        labelMascota.setBounds(10,250,200,30);
        textMascota.setBounds(150,250,50,30);
        
        JLabel labelFumador=new JLabel("Se puede fumar?: ");
        String fumador=String.valueOf(viaje.isFumador());
        if (fumador.equals("true")){
            fumador="Si";
        }
        else{
            fumador="No";
        }
        JTextField textFumador=new JTextField(fumador);
        labelFumador.setBounds(10,290,200,30);
        textFumador.setBounds(150,290,50,30);
        
        AutoDB v2 = new AutoDB();
        Auto auto = v2.getViajeAuto(id);
       
        //-----------------datos del auto---------------------------------------
        JLabel labelMarca=new JLabel("Marca: ");
        JTextField textMarca=new JTextField(auto.getMarca());
        labelMarca.setBounds(400,10,200,30);
        textMarca.setBounds(530,10,200,30);
        
        JLabel labelModelo=new JLabel("Modelo: ");
        JTextField textModelo=new JTextField(auto.getModelo());
        labelModelo.setBounds(400,50,200,30);
        textModelo.setBounds(530,50,200,30);
        
        JLabel labelColor=new JLabel("Color: ");
        JTextField textColor=new JTextField(auto.getColor());
        labelColor.setBounds(400,90,200,30);
        textColor.setBounds(530,90,200,30);
        
        JLabel labelCombustible=new JLabel("Combustible: ");
        JTextField textCombustible=new JTextField(auto.getCombustible());
        labelCombustible.setBounds(400,130,200,30);
        textCombustible.setBounds(530,130,200,30);
        
        JLabel labelAire=new JLabel("Aire acondicionado: ");
        String aire=String.valueOf(auto.isAire_acondicionado());
        if (aire.equals("true")){
            aire="Si";
        }
        else{
            aire="No";
        }
        JTextField textAire=new JTextField(aire);
        labelAire.setBounds(400,170,200,30);
        textAire.setBounds(530,170,50,30);
        
        JLabel labelCalefaccion=new JLabel("Calefaccion: ");
        String calefa=String.valueOf(auto.isCalefaccion());
        if (calefa.equals("true")){
            calefa="Si";
        }
        else{
            calefa="No";
        }
        JTextField textCalefaccion=new JTextField(calefa);
        labelCalefaccion.setBounds(400,210,200,30);
        textCalefaccion.setBounds(530,210,50,30);
        
        JLabel labelCantidad=new JLabel("Cantidad de Asientos: ");
        JTextField textCantidad=new JTextField(String.valueOf(auto.getCantidad_de_asientos()));
        labelCantidad.setBounds(400,250,200,30);
        textCantidad.setBounds(530,250,50,30);
        
        JLabel labelBaul=new JLabel("Capacidad Baul: ");
        JTextField textBaul=new JTextField(auto.getCapacidad_baul());
        labelBaul.setBounds(400,290,200,30);
        textBaul.setBounds(530,290,200,30);
        
        JLabel labelCalificacion=new JLabel("Calificacion: ");
        JTextField textCalificacion=new JTextField(String.valueOf(auto.getCalificacion()));
        labelCalificacion.setBounds(400,330,200,30);
        textCalificacion.setBounds(530,330,50,30);
        
        //-------------------botones--------------------------------------------
        
        Integer cantAsientoOcupado= v.getCantidadAsientos(id);
        Integer cantAsientoDisponible =  auto.getCantidad_de_asientos() - cantAsientoOcupado;
        
        JLabel labelDisponible = new JLabel ("Cantidad de asientos disponibles: ");
        JTextField textDisponible=new JTextField(String.valueOf(cantAsientoDisponible));
        labelDisponible.setBounds(200,400,200,30);
        textDisponible.setBounds(400,400,50,30);
        
        Boton botonSumarse=new Boton("SUMARSE");
        botonSumarse.setBounds(500,500,100,30);
        
        if (cantAsientoDisponible == 0)
            botonSumarse.setEnabled(false);
        
        botonSumarse.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                if((v.existeUsuarioEnViaje(id, idUsuarioActual)) && true)
                    JOptionPane.showMessageDialog(null, "Ya estas sumado en el viaje!", "Error al sumarse en el viaje", JOptionPane.WARNING_MESSAGE);
                else{
                    v.insertarUsuarioEnViaje(id,idUsuarioActual,auto.getId_auto());
                    JOptionPane.showMessageDialog(null, "Operación realizada correctamente. Ya estas sumado al viaje!!!");
                    ventana.setVisible(false);
                }
            }
        });
        
        Boton botonVolver=new Boton("VOLVER");
        botonVolver.setBounds(320,500,100,30);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.setVisible(false);
                
            }
        });
        
        
        
        
        ventana.add(labelConductor);
        ventana.add(textConductor);
        ventana.add(labelOrigen);
        ventana.add(textOrigen);
        ventana.add(labelDestino);
        ventana.add(textDestino);
        ventana.add(labelFecha);
        ventana.add(textFecha);
        ventana.add(labelGastos);
        ventana.add(textGastos);
        ventana.add(labelHora);
        ventana.add(textHora);
        ventana.add(labelLugar);
        ventana.add(textLugar);
        ventana.add(labelMascota);
        ventana.add(textMascota);
        ventana.add(labelFumador);
        ventana.add(textFumador);
        
        ventana.add(labelMarca);
        ventana.add(textMarca);
        ventana.add(labelModelo);
        ventana.add(textModelo);
        ventana.add(labelColor);
        ventana.add(textColor);
        ventana.add(labelAire);
        ventana.add(textAire);
        ventana.add(labelCalefaccion);
        ventana.add(textCalefaccion);
        ventana.add(labelCantidad);
        ventana.add(textCantidad);
        ventana.add(labelBaul);
        ventana.add(textBaul);
        ventana.add(labelCalificacion);
        ventana.add(textCalificacion);
        ventana.add(labelCombustible);
        ventana.add(textCombustible);
        
        ventana.add(labelDisponible);
        ventana.add(textDisponible);
        ventana.add(botonSumarse);
        ventana.add(botonVolver);
        
        ventana.setSize(850,600);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }    
}


