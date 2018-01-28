/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.classes.ej4;

import java.text.DecimalFormat;

/**
 *
 * @author kevin
 */
public class Ej4 {
    
    MemValue[] memory;

    public Ej4() {
        memory = new MemValue[]{
            new MemValue("A", 0),
            new MemValue("B", 0),
            new MemValue("C", 0)
        };
    }
    
    public String saveInMemory(String name, String sValue) {
        double dValue = parseOperand (sValue);
        for (MemValue mem: memory) {
            if (mem.getName().equals(name))
                mem.setValue(dValue);
        }
        
        return "(" + name + " => " + String.valueOf(dValue) + ")";
    }
    
    private double parseOperand (String operand) {
        
        for (MemValue mem: memory) {
            if (mem.getName().equals(operand))
                return mem.getValue();
        }
        
        double result = Double.parseDouble(operand);
        
        return result;
    }
    
    public String parseOperation (String operation) {
        
        String result;
        
        try {
            String[] operands = operation.split(" ");
            
            if ("".equals(operands[0])) 
                return "";
            
            
            if (operands.length == 1) 
                return String.valueOf(parseOperand(operands[0]));
            
            
            double op1 = parseOperand(operands[0]);
            double op2 = parseOperand(operands[2]);

            
            switch (operands[1]) {
                case "+":
                    result = String.valueOf(op1 + op2);
                    break;
                case "-":
                    result = String.valueOf(op1 - op2);
                    break;
                case "*":
                    result = String.valueOf(op1 * op2);
                    break;
                case "/":
                    if (op2 == 0)
                        result = "Math error";
                    else
                        result = String.valueOf(op1 / op2);
                    break;
                default:
                    result = "Syntax error";
                    break;
            }
        }
        catch (Exception e) {
            result = "Syntax error";
            System.err.println(e.getMessage());
        }
        
        return result;
    }
}
