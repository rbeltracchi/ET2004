/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Usuario;
import ViajarDB.UsuarioDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author vale2
 */
public class VentanaCuenta extends FrameManager{
    
     
    private JTextField textNom;
    private JTextField textApe;
    private JTextField textCalle;
    private JTextField textCiudad;
    private JTextField textNumTel;
    private JDateChooser dateNac;
    private JTextField textMail;
    private JTextField textPass;
    
   
    public VentanaCuenta(Usuario u){
            
        
        UsuarioDB db=new UsuarioDB();
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaCuenta self = this;

        //----Mostrar informacion del usuario
        //-------- PANEL 1-----------------
        
        JPanel panel1 = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints gRes1 = new GridBagConstraints ();
        panel1.setLayout(gBag1);
        panel1.setBackground(Color.WHITE);
        
        JLabel laReg = new JLabel("Mis datos");  
        laReg.setFont(new Font("Calibri",3,22));
        laReg.setForeground(Color.BLACK);
        gRes1.gridx = 0;
        gRes1.gridy = 0;
        gRes1.gridwidth =GridBagConstraints.REMAINDER; 
        gRes1.anchor = GridBagConstraints.CENTER;
        gRes1.insets = new Insets(50,0,50,10);
        panel1.add(laReg,gRes1);
        
            
        //NOMBRE--------------------
        JLabel laNombre = new JLabel("Nombre:");  
        laNombre.setFont(new Font("arial",3,12));
        laNombre.setForeground(Color.BLACK);
        laNombre.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laNombre,gRes1);
        textNom = new JTextField(u.getNombre());
        textNom.setColumns(25);
        gRes1.gridx = 1;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textNom,gRes1);
        
       
        
      textNom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                textNom.setText((""));
                
            }
        });
        
        //APELLIDO--------------------
        JLabel laApellido = new JLabel("Apellido:");  
        laApellido.setFont(new Font("arial",3,12));
        laApellido.setForeground(Color.BLACK);
        laApellido.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laApellido,gRes1);
        textApe = new JTextField(u.getApellido());
        textApe.setColumns(25);
        gRes1.gridx = 3;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textApe,gRes1);
        
        textApe.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textApe.setText((""));
                
            }
        });
        
        
        //---------Direccion
        JLabel laDireccion = new JLabel("Direccion:");  
        laDireccion.setFont(new Font("arial",3,12));
        laDireccion.setForeground(Color.BLACK);
        laDireccion.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laDireccion,gRes1);
        textCalle = new JTextField(u.getDireccion());
        textCalle.setColumns(25); 
        gRes1.gridx =1;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textCalle,gRes1);
        
        textCalle.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textCalle.setText((""));
                
            }
        });
        
        //-----Ciudad
        
        JLabel laCiudad = new JLabel("Ciudad:");  
        laCiudad.setFont(new Font("arial",3,12));
        laCiudad.setForeground(Color.BLACK);
        laCiudad.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laCiudad,gRes1);
        //extCiudad = new JTextField();
        textCiudad = new JTextField(u.getCiudad());
        textCiudad.setColumns(25); 
        gRes1.gridx =3;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textCiudad,gRes1);
        
        textCiudad.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textCiudad.setText((""));
                
            }
        });
        
        
        //Telefono
        
        JLabel laTel = new JLabel("Telefono : ");  
        laTel.setFont(new Font("arial",3,12));
        laTel.setForeground(Color.BLACK);
        laTel.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laTel,gRes1);
     
        textNumTel = new JTextField(u.getTelefono());
        textNumTel.setColumns(15);
        gRes1.gridx =1;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.fill = GridBagConstraints.NONE;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textNumTel,gRes1);
                  
        textNumTel.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textNumTel.setText((""));
            }
        });
        
        
        //--Fecha Nacimiento
        JLabel laFechaNac = new JLabel("Fecha de nacimiento:");  
        laFechaNac.setFont(new Font("arial",3,12));
        laFechaNac.setForeground(Color.BLACK);
        gRes1.gridx = 0;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laFechaNac,gRes1);
        
        //Bajar libreria jCalendar para agregar JdateChooser
        dateNac = new JDateChooser(u.getFecha_nacimiento());
        gRes1.gridx =1;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        gRes1.ipadx = 20;
        //gRes2.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(dateNac,gRes1);
        
        //Mail
        JLabel laMail = new JLabel(" Mail : ");  
        laMail.setFont(new Font("arial",3,12));
        laMail.setForeground(Color.BLACK);
        laMail.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laMail,gRes1);
        textMail = new JTextField(u.getMail());
        textMail.setColumns(20);
        gRes1.gridx = 1;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textMail,gRes1);
        
        //Contraseña
        JLabel labelPassReg = new JLabel("Contraseña : ");
        labelPassReg.setForeground(Color.BLACK);
        labelPassReg.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx =2;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(labelPassReg,gRes1);
        textPass = new JTextField(u.getPass());
        textPass.setColumns(10);
        gRes1.gridx =3;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textPass,gRes1);
    
//-----PANEL 3-------------------------
       
        JPanel panel3 = new JPanel(); 
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        //panel3.setBackground(Color.LIGHT_GRAY);
        Boton botonActualizar=new Boton("ACTUALIZAR");
        panel3.add(botonActualizar);
        Boton botonEliminar=new Boton("ELIMINAR CUENTA");
        panel3.add(botonEliminar);       
        Boton botonVolver=new Boton("VOLVER");
        panel3.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    VentanaViajes viajes = new VentanaViajes(u);
                     viajes.setVisible(true);
                     self.setVisible(false);
                
            }
        });
        
        
         
        botonActualizar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                Date fec=dateNac.getDate();
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
                String fecha_nacimiento=sdf.format(fec);
                String id=Integer.toString(u.getId_usuario());
                
                db.updateUser(id,textNom.getText(),textApe.getText(),textCalle.getText(),textCiudad.getText(),textNumTel.getText(),fecha_nacimiento,textMail.getText(),textPass.getText());
                JOptionPane.showMessageDialog(self,"Sus datos han sido actualizados");
            }
        });
        
        
        
         
        botonEliminar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                    UIManager.put("OptionPane.yesButtonText", "Si");
                    int n = JOptionPane.showConfirmDialog(self, "¿Estas seguro que deseas eliminar tu cuenta?","Mensaje",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (n== JOptionPane.YES_OPTION)
                    {
                        String id=Integer.toString(u.getId_usuario());
                        db.deleteCuenta(id);
                    }
                    
            }
        });
        
        

               
        
        
        this.setTitle("Mi cuenta");
    /*    this.setSize(850,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        GridBagLayout gridBag = new GridBagLayout ();
        GridBagConstraints res = new GridBagConstraints ();
        this.setLayout(gridBag);
        //----presentacion
        res.gridx=0;
        res.gridy=0;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.weightx=0.5;
        res.weighty=0.5;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelPresent,res);*/
        //-----panel1
        res.gridx=0;
        res.gridy=1;
        res.gridheight=GridBagConstraints.RELATIVE;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.weightx=0.0;
        res.weighty=1.0;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0 ,0,0);
        this.add(panel1,res);
        
        //-----panel3
        res.gridx=0;
        res.gridy=2;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.RELATIVE;
       // res.weightx=0.1;
       // res.weighty=0.3;
        res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;
        
        res.insets = new Insets(20,0 ,0,0);
        this.add(panel3,res);
             
        
    }
       
}

    
    

