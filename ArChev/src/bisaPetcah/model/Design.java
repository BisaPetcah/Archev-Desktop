/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.model;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author bisaPetcah
 */
public class Design {
    public static void setM(JPanel p){
        p.setBackground(new Color(249, 201, 115, 255));
    }
    public static void resetM(JPanel p){
        p.setBackground(new Color(255, 153, 0));
    }

    
    public static void btnHover(JPanel p){
        p.setBackground(new Color(249, 201, 115, 255));
    }
    
    public static void btnActive(JPanel p){
        p.setBackground(new Color(255, 153, 0));
    }
    
    public static void btnInActive(JPanel p){
        p.setBackground(new Color(255, 255, 255, 255));
    }
}
