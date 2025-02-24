/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

import java.sql.Date;

/**
 *
 * @author JHB
 */
public class Evento {
    private int idEvento;
    private String nombre;
    private Date fecha;
    private String descripcion;

    public Evento() {
    }
    

    public Evento( String nombre, Date fecha, String descripcion) {
        
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        
    }

    public Evento(int idEvento, String nombre, Date fecha, String descripcion) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public int getIdEvento() {
        return idEvento;
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion + '}';
    }

    
    
}
