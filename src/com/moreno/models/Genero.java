/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.moreno.models;

/**
 *
 * @author cristina
 */
public enum Genero {
    ACCION("Acción"),
    AVENTURAS("Aventuras"),
    BELICA("Bélica"),
    CIENCIA_FICCION("Ciencia Ficción"),
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    ROMANTICA("Romántica"),
    TERROR("Terror");   
    
    String genero;
    
    private Genero(String genero){
        this.genero = genero;
    }
}
