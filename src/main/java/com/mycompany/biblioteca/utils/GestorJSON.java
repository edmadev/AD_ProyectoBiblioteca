/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.biblioteca.models.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edma2
 */
public class GestorJSON {
    private  ObjectMapper mapper = new ObjectMapper();

    public GestorJSON() {
    }
     
    public void crearJSON(ArrayList<Usuario> listaUsuarios){
        File archivo = new File("UsuariosJSON.json");
        try {
            mapper.writeValue(archivo, listaUsuarios);
        } catch (IOException ex) {
            Logger.getLogger(GestorJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Usuario> abrirJSON(File archivo){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        JsonFactory factory = new JsonFactory();
        JsonParser parser;
        Usuario usuario;
        
        try {
            parser = factory.createParser(archivo);
            while(parser.nextToken() != JsonToken.END_ARRAY){
                usuario = mapper.readValue(parser, Usuario.class);
                listaUsuarios.add(usuario);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestorJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuarios;
    }
}
