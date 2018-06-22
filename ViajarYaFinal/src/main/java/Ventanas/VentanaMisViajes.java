/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Usuario;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale2
 */
public class VentanaMisViajes extends FrameManager {
    
    private int idViaje;
    private Date fechaPar;
    public VentanaMisViajes (Usuario u){
    
        super();
        final ViajeDB viajes = new ViajeDB();    
        final String[] nombreColumnas = {"Id","Salida","Origen","Destino","Lugar Salida","Marca","Modelo","Conductor"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        
        
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JLabel labelq = new JLabel(" Viajes de  "+u.getNombre());  
        labelq.setFont(new Font("Arial",3,20));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        //----- Listado de viajes       
        JPanel panelListadoViajes = new JPanel();
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints gRes3 = new GridBagConstraints ();
        panelListadoViajes.setLayout(gBag3);
        panelListadoViajes.setBackground(Color.white);
        TitledBorder borde1 = new TitledBorder("  Listado actualizado  ");
        borde1.setTitleFont(new Font("Arial",3,16));
        panelListadoViajes.setBorder(borde1);
        
        String [][]misViajes;
        int idUsuario = u.getId_usuario();
        misViajes = viajes.getMisViajes(idUsuario);
        modTabla.setDataVector(misViajes,nombreColumnas);
         
        
        JTable tablaViajes = new JTable(modTabla);
        tablaViajes.setPreferredScrollableViewportSize(new Dimension(300, 300));
         //------------oculto la primer columna del id-------------------------ale
            tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
            //------------------------------------------------------------------------
            
        
        gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(0,0,10,0);
        
        panelListadoViajes.add(new JScrollPane(tablaViajes),gRes3);
        tablaViajes.addMouseListener(new MouseAdapter(){
          
        @Override
            public void mouseClicked(MouseEvent e) {
           
                //tablaViajes.getSelectedRows()
                String id=String.valueOf(tablaViajes.getValueAt(tablaViajes.getSelectedRow(), 0));
                idViaje=Integer.parseInt(id);
            
             }
                           
               
        });
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        Boton botonCalificar=new Boton("CALIFICAR VIAJE");
        panelBotones.add(botonCalificar);
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    VentanaViajes viajes = new VentanaViajes(u);
                     viajes.setVisible(true);
                     self.setVisible(false);
                
            }
        });
        
        
        botonCalificar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                ViajeDB v = new ViajeDB();
                Viaje viaje = v.getViajeUsuario(idViaje);
                Calendar fecha = new GregorianCalendar();
                fechaPar=viaje.getFechaPartida();
                Date f = fecha.getTime();
                System.out.println(f);
                System.out.println(fechaPar);
                //Date fechaPar= viaje.getFechaPartida();
                if (fechaPar.after(f)){
                  JOptionPane.showMessageDialog(null, "Aún no se ha realizado este viaje","No se puede calificar" , JOptionPane.WARNING_MESSAGE);
                }
                else{
                
                    VentanaCalificarViaje cv = new VentanaCalificarViaje(u,idViaje);
                     cv.setVisible(true);
                     self.setVisible(false);
                }
            }
        });
        
        
        
        
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,40,0,0);
        this.add(panelTitulo,res);
        
   
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,40,30,40);
        this.add(panelListadoViajes,res);
        
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(20,40,0,40);
        this.add(panelBotones,res);
        
    }
        
       
       
    
    
    
}
