/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.utils;

import java.time.Year;
import java.util.regex.Pattern;


/**
 *
 * @author edma2
 */
public class Comprobaciones {

    public Comprobaciones() {
    }

    public static boolean esNumeroTelefonoValido(String telefono) {
        try {
            if (telefono == null || telefono.isEmpty()) {
                throw new IllegalArgumentException("El número de teléfono no puede ser nulo o vacío.");
            }
            return telefono.matches("\\d{7,15}");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false; // Devuelve false si hay una excepción
        }
    }

    public static boolean esNombreValido(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
            }
            return nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean esEmailValido(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El email no puede ser nulo o vacío.");
            }
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            return Pattern.matches(regex, email);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean esAnioValido(String anio) {
        try {
            if (anio == null || anio.trim().isEmpty()) {
                throw new IllegalArgumentException("El año no puede ser nulo o vacío.");
            }
            if (!anio.matches("\\d{4}")) {
                return false;
            }
            int anioNumero = Integer.parseInt(anio);
            int anioActual = Year.now().getValue();
            return anioNumero >= 1700 && anioNumero <= anioActual;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
