/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import forms.ServerForm;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import threads.ServerThread;

/**
 *
 * @author Nikola
 */
public class Main {
    
    public static void main(String[] args) {
        JFrame serverForm=new ServerForm();
        serverForm.setVisible(true);       
    }
}
