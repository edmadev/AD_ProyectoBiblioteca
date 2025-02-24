/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dam
 */
public class Prestamo {
    private int idPrestamo;
    private int idUsuario;
    private int idLibro;
    private java.sql.Date fechaPrestamo;
    private java.sql.Date fechaLimiteDevolucion;
    private double multa;

    public Prestamo(Date fechaPrestamo, Date fechaLimiteDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimiteDevolucion = fechaLimiteDevolucion;
        long diferencia = fechaLimiteDevolucion.getTime()-fechaPrestamo.getTime();
        double diferenciaDias = TimeUnit.MILLISECONDS.toDays(diferencia);
        if(diferenciaDias<0){
            multa = diferenciaDias*2;
        }else{
            multa =0;
        }
    }
    public Prestamo(){
        
    }
    
    

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public java.sql.Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public java.sql.Date getFechaLimiteDevolucion() {
        return fechaLimiteDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", idLibro=" + idLibro + ", fechaPrestamo=" + fechaPrestamo + ", fechaLimiteDevolucion=" + fechaLimiteDevolucion + ", multa=" + multa + '}';
    }
    
    

    
    
    
    
    
}
