/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moreno.models;

/**
 *
 * @author cristina
 */
public class Movies {

    private int id;
    private String titulo;
    private Genero genero;
    private int valoracion;
    private boolean visto;

    public Movies() {

    }

    public Movies(String titulo, Genero genero, int valoracion, boolean visto) {
        this.titulo = titulo;
        this.genero = genero;
        this.valoracion = valoracion;
        this.visto = visto;
    }

    public Movies(String titulo, Genero genero, boolean visto) {
        this(titulo, genero, 0, visto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", género: " + genero + ", valoración: " + valoracion + ", visto: " + visto;
    }

}
