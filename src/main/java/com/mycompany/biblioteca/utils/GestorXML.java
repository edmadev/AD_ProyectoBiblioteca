/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.utils;

import com.mycompany.biblioteca.DAO.relacional.DML;
import com.mycompany.biblioteca.models.Libro;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edma2
 */
public class GestorXML {

    private JAXBContext contexto;
    
    public GestorXML() {
    }

    public Libro abrirXML(File archivo) {
        Unmarshaller unmarshaller;
        try {
            JAXBContext contexto = JAXBContext.newInstance(Libro.class);
            unmarshaller = contexto.createUnmarshaller();
            return (Libro) unmarshaller.unmarshal(archivo);
        } catch (JAXBException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean crearXML(Libro libro, File archivo) {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Libro.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
            marshaller.marshal(libro, archivo); 
            return true; 
        } catch (JAXBException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }

}
