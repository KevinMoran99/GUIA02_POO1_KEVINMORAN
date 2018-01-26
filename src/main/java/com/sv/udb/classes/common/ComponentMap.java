/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.common;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
//Mapa que contiene todos los componentes y sus nombres del contenedor dado
public class ComponentMap {

    private HashMap componentMap;
    
    public ComponentMap(JFrame context) {
        componentMap = new HashMap<String,Component>();
        Component[] components = context.getContentPane().getComponents();
        for (int i=0; i < components.length; i++) {
                componentMap.put(components[i].getName(), components[i]);
        }
    }
    
    //Obtener componente por nombre (no confundir con el nombre de la variable)
    public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
    }
    
}
