/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej3;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Ej3 {
    
    private final Pin VALID_PIN;
    private int triesLeft;

    public Ej3() {
        VALID_PIN = new Pin("1", "2", "3", "4");
        triesLeft = 3;
    }
    
    public String checkPin (ArrayList<String> number) {
        Pin inputPin = new Pin(number.get(0), number.get(1), number.get(2), number.get(3));
        if (compareToValid(inputPin))
            return "PIN_VALID";
        else {
            triesLeft--;
            if (triesLeft > 0)
                return "PIN_INVALID";
            else
                return "NO_TRIES_LEFT";
        }
    }
    
    private boolean compareToValid (Pin inputPin) {
        return inputPin.getFirstChar().equals(VALID_PIN.getFirstChar()) &&
                inputPin.getSecondChar().equals(VALID_PIN.getSecondChar()) &&
                inputPin.getThirdChar().equals(VALID_PIN.getThirdChar()) &&
                inputPin.getFourthChar().equals(VALID_PIN.getFourthChar());
    }
    
    public void reset () {
        triesLeft = 3;
    }
}
