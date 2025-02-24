/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.noRelacional;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Se ha hecho uso de la documentación oficial de MongoDB Java Driver para realizar el CRUD debido a que en este proyecto se usa Java Sync Driver 5.3.1 
 * 
 * Enlace: https://www.mongodb.com/docs/drivers/java/sync/current/fundamentals/crud/
 * @author dam
 */
public class ConsultasMongoDB {

    private final MongoDatabase dataBase;
    private final MongoCollection<Document> coleccion;

    public ConsultasMongoDB() {
        MongoClient mongoClient = ConexionMongoDB.conectarMongoDB();
        this.dataBase = mongoClient.getDatabase("ad_biblioteca");
        this.coleccion = dataBase.getCollection("usuarios");
    }

    public boolean insertarUsuario(String nombreUsuario, String email, String tipoUsuario, int telefono) {
        try {
            Document usuarioDoc = new Document("nombreUsuario", nombreUsuario)
                    .append("email", email)
                    .append("tipoUsuario", tipoUsuario)
                    .append("telefono", telefono);
            coleccion.insertOne(usuarioDoc);
            System.out.println("MongoDB-> Usuario insertado: " + usuarioDoc.toJson());
            return true;
        } catch (Exception e) {
            System.err.println("MongoDB-> Error al intentar insertar usuario");
            return false;
        }

    }

    public boolean obtenerUsuario(String nombreUsuario) {
        //llamar a instancia mongoCollection
        try {
            Bson filtro = Filters.eq("nombreUsuario", nombreUsuario);
            if (coleccion.find(filtro).first() == null) {
                System.out.println("MongoDB-> No existe el usuario " + nombreUsuario);
                return false;
            }
            coleccion.find(filtro).forEach(doc -> System.out.println(doc.toJson()));

            System.out.println("MongoDB-> SELECT fue exitoso");
            return true;
        } catch (Exception e) {
            System.err.println("MongoDB-> Error al hacer SELECT: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarUsuario(String nombreUsuario) {
        if (!obtenerUsuario(nombreUsuario)) {
            return false;
        }

        try {
            Bson filtro = Filters.eq("nombreUsuario", nombreUsuario);
            coleccion.deleteOne(filtro);
            System.out.println("MongoDB-> DELETE exitoso de nombre: " + nombreUsuario);
            return true;
        } catch (Exception e) {
            System.err.println("MongoDB-> Error al hacer DELETE: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarUsuario(String nombreUsuario,String email, String tipoUsuario, int telefono){
        if(!obtenerUsuario(nombreUsuario)){
            return false;
        }
        try {
            Bson filtro = Filters.eq("nombreUsuario",nombreUsuario);
            Document documento = new Document ("nombreUsuario", nombreUsuario)
                    .append("email", email)
                    .append("tipoUsuario", tipoUsuario)
                    .append("telefono", telefono);
            UpdateResult resultado = coleccion.replaceOne(filtro, documento);
            System.out.println("MongoDB-> Actualizacion del usuario "+nombreUsuario+" fue exitosa");
            return true;
        } catch (Exception e) {
            System.err.println("MongoDB-> Error al intentar hacer UPDATE: "+e.getMessage());
            return false;
        }
    }
    
}
