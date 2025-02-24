/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author edma2
 */
public class ConexionDB4O {
     private static ObjectContainer objectContainer; //para trabajar con una unica instancia de ObjectContainer
    private static final String DB_PATH = "biblioteca";

    
    public static ObjectContainer getObjectContainer() {
        return objectContainer;
    }

    public static String getDB_PATH() {
        return DB_PATH;
    }

    public void abrirConexion() {
        try {
            //cerrando la conexion previa si hubiese    
            objectContainer = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_PATH);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.err.println("Error al intentar conectar con la base de datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            if (objectContainer == null && objectContainer.ext().isClosed()) {
                objectContainer.close();
                System.out.println("Conexion Cerrada");
            }else{
                System.out.println("La conexion ya esta cerrada o no existe");
            }
        } catch (Exception e) {
            System.err.println("Error al intentar cerrar la conexion: " + e.getMessage());
        }
    }
    
}
