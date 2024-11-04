package Controlador;

import Modelo.Mecanico;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vista.frmLogin;
import Vista.frmRegistro;


public class ctrlLogin implements MouseListener {
    
    Mecanico Modelo;
    frmLogin Vista;
    
    public ctrlLogin(Mecanico Modelo, frmLogin Vista) {
        this.Modelo = Modelo;
        this.Vista = Vista;
    }
    
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == Vista.btnRegistrase){
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
//verificamos el log in para que nos permita entrar o no entrar
    @Override
    public void mouseClicked(MouseEvent e) {
    }

}

