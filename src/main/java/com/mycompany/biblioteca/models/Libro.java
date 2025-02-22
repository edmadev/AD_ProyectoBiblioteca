/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author JHB
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private String genero;
    private int año;
    
    public Libro(String titulo, String autor, String genero, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

   
    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", a\u00f1o=" + año + '}';
    }

    public int getIdLibro() {
        return idLibro;
    }

   
}
