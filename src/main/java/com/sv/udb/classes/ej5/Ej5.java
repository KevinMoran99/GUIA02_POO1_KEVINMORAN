/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Ej5 {

    private final static String CSV_PATH = "src/main/resources/db.csv";
    
    public Ej5() {
    }
    
    private static ArrayList<String> prepareToModify () throws FileNotFoundException, IOException {
        //https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        ArrayList<String> lines = new ArrayList<>();

        //Obteniendo archivo
        BufferedReader reader = new BufferedReader (new FileReader(CSV_PATH));

        //Leyendo cada linea
        String line;
        while ((line = reader.readLine()) != null) 
            lines.add(line); //Guardando cada linea para luego recrear el archivo

        reader.close();
        
        return lines;
    }
    
    private static String parseToString (Note note) {
        
        if (note.getTitle().contains("\",\""))
            note.setTitle(note.getTitle().replace("\",\"", " "));
        if (note.getBody().contains("\",\""))
            note.setBody(note.getBody().replace("\",\"", " "));
        return "\"" + note.getTitle() + "\"," +
                "\"" + note.getBody() + "\"," +
                "\"" + note.getDate() + "\"\n";
    }
    
    public static void create (String title, String body, String date) throws FileNotFoundException, IOException  {
        
        Note note = new Note(title, body, date);

        ArrayList<String> lines = prepareToModify();

        //Create
        //Obteniendo archivo, listo para ser reescrito
        PrintWriter writer = new PrintWriter(CSV_PATH);
        StringBuilder builder = new StringBuilder();
        //Añadiendo las lineas que ya estaban al archivo (pues se reescribira desde 0)
        for(String line1: lines) {
            builder.append(line1);
            builder.append("\n");
        }

        //Añadiendo nuevos valores
        builder.append(parseToString(note));
        //Haciendo cambios
        writer.write(builder.toString());
        writer.close();
    }
    
    public static ArrayList<ItemPanel> read () throws FileNotFoundException, IOException {
        ArrayList<ItemPanel> notes = new ArrayList<>();
        //Read
        //Obteniendo archivo
        BufferedReader reader = new BufferedReader (new FileReader(CSV_PATH));

        //Leyendo cada linea
        String line;
        int itemPosition = 0;
        while ((line = reader.readLine()) != null) {
            try {
                //Eliminando delimitadores
                String[] data = line.split("\",\"");
                data[0] = data[0].replaceFirst("\"", ""); 
                data[2] = data[2].substring(0, data[2].length() - 2);

                Note note = new Note(data[0], data[1], data[2]);

                notes.add(new ItemPanel(note, itemPosition));

                itemPosition++;
            }
            catch (Exception e) {}
        }
        
        reader.close();
        
        return notes;
    }
    
    public static void update (String title, String body, String date, String index) throws FileNotFoundException, IOException {
        
        Note note = new Note(title, body, date);

        ArrayList<String> lines = prepareToModify();

        //Update
        //Obteniendo archivo, listo para ser reescrito
        PrintWriter writer = new PrintWriter(CSV_PATH);
        //Construye cadenas de texto
        StringBuilder builder = new StringBuilder();
        //Añadiendo las lineas que ya estaban al archivo (pues se reescribira desde 0)
        int forIndex = -1;
        for(String line1: lines) {
            if (forIndex++ == Integer.parseInt(index)) {
                //Añadiendo nuevos valores
                builder.append(parseToString(note));
            }
            else{
                builder.append(line1);
                builder.append("\n");
            }

        }

        //Haciendo cambios
        writer.write(builder.toString());
        writer.close();
    }
    
    public static void delete (String index) throws FileNotFoundException, IOException {

        ArrayList<String> lines = prepareToModify();

        //Delete
        //Obteniendo archivo, listo para ser reescrito
        PrintWriter writer = new PrintWriter(CSV_PATH);
        //Construye cadenas de texto
        StringBuilder builder = new StringBuilder();
        //Añadiendo las lineas que ya estaban al archivo (pues se reescribira desde 0)
        int forIndex = -1;
        for(String line1: lines) {
            if (forIndex++ == Integer.parseInt(index)) {
                //No se añade el valor eliminado
            }
            else{
                builder.append(line1);
                builder.append("\n");
            }

        }

        //Haciendo cambios
        writer.write(builder.toString());
        writer.close();
    }
}
