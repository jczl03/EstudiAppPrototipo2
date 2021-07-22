/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jczam
 */
public class Instruccion extends MiniTarea{

    String instruccion;

    public String getInstruccion() {
        return instruccion;
    }

    public Instruccion(String instruccion) {
        this.instruccion = instruccion;
    }
    
    public void print() {
        System.out.println(instruccion);
    }

    @Override
    public String toString() {
        return instruccion+"\n";
    }
    
}
