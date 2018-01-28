/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.LEFT;

/**
 *
 * @author kevin
 */
public class ItemPanel extends JPanel {
    Note note;

    public ItemPanel() {
    }

    public ItemPanel(Note note, int y) {
        this.note = note;
        
        this.setLayout(new BoxLayout(this, 1));
        
        this.setSize(158, 70);
        this.setLocation(0, y * 71);
        this.setBackground(new Color(197, 248, 225));
        
        JLabel lbl = new JLabel(String.valueOf(y));
        lbl.setVisible(false);
        
        this.add(lbl);
        
        lbl = new JLabel(note.getTitle());
        lbl.setFont(new Font("Serif", Font.BOLD, 18));
        
        this.add(lbl);
        
        lbl = new JLabel("Modificado el: " + note.getDate());
        
        this.add(lbl);
        
        lbl = new JLabel(note.getBody());
        
        this.add(lbl);
        
    }
    
    
}
