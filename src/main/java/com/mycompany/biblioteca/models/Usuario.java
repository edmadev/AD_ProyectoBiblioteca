/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author JHB
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String email;
    private String tipoUsuario;
    private int telefono;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String email, String tipoUsuario, int telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.telefono = telefono;
    }
    
    

    public Usuario(String nombre, String email, String tipo, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipoUsuario;
    }

    public void setTipo(String tipo) {
        this.tipoUsuario = tipo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", tipo=" + tipoUsuario + ", telefono=" + telefono + '}';
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    
    
}
