/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej3;

/**
 *
 * @author kevin
 */
public class Pin {
    private String firstChar;
    private String secondChar;
    private String thirdChar;
    private String fourthChar;

    public Pin() {
    }

    //...O enviando los 4 de una sola vez
    public Pin(String firstChar, String secondChar, String thirdChar, String fourthChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
        this.thirdChar = thirdChar;
        this.fourthChar = fourthChar;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public String getSecondChar() {
        return secondChar;
    }

    public void setSecondChar(String secondChar) {
        this.secondChar = secondChar;
    }

    public String getThirdChar() {
        return thirdChar;
    }

    public void setThirdChar(String thirdChar) {
        this.thirdChar = thirdChar;
    }

    public String getFourthChar() {
        return fourthChar;
    }

    public void setFourthChar(String fourthChar) {
        this.fourthChar = fourthChar;
    }
    
    
    
    
}
