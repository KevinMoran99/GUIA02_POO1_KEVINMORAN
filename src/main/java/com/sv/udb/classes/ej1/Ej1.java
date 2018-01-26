/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class Ej1 {
    
    private List<Coin> coinList;

    public Ej1() {
        coinList = new ArrayList<>();
    }
    
    public void add(double denomination, int quantity) {
        
        coinList.add(new Coin(denomination, quantity));
    }
    
    public double calculateSum() {
        double sum = 0;
        
        for (Coin coin : coinList) {
            sum += coin.getDenomination() * coin.getQuantity();
        }
        
        return sum;
    }
}
