/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.main;

import com.mycompany.biblioteca.DAO.relacional.Conexion;

/**
 *
 * @author dam
 */
public class Ejecuta {
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.conectar();
        
    }
}