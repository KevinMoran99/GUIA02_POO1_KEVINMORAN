/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej1;

/**
 *
 * @author Estudiante
 */
public class Coin {
    
    private double denomination;
    private int quantity;
    
    public Coin() {
    }

    public Coin(double denomination, int quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public double getDenomination() {
        return denomination;
    }

    public void setDenomination(double denomination) {
        this.denomination = denomination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
