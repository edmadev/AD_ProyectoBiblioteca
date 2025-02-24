/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.mycompany.biblioteca.models.Usuario;

/**
 *
 * @author edma2
 */
public class ConsultasDB4O implements UsuariosDAO{
        private ObjectContainer objectContainer;

 public ConsultasDB4O() {
        this.objectContainer = ConexionDB4O.getObjectContainer();
    }

    @Override
    public boolean insertarUsuario(Usuario usuario) {
       System.out.println("DAO interface nombre: " + usuario.getNombre());

        try {
            if (usuario.getNombre() != null) {
                objectContainer.store(usuario);
                System.out.println("DAO nombre no nulo");
                return true;
            } else if (usuario.getNombre() == null) {
                System.out.println("DAO Nombre nulo");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al insertar accion DAO: " + e.getMessage());

        }
        return false;
    }

    @Override
    public Usuario consultarPorNombre(String nombreUsuario) {
         Usuario accionEncontrada = new Usuario();
        Usuario filtro = new Usuario(nombreUsuario, "", "", 0);
        try {
            ObjectSet<Usuario> resultados = objectContainer.queryByExample(filtro);
            if (resultados.hasNext()) {
                accionEncontrada = resultados.next();
                System.out.println("Se ha encontrado accion con nombre: " + nombreUsuario);
            } else {
                System.out.println("No se ha encontrado ninguna accion con nombre: " + nombreUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Accion por nombre: " + e.getMessage());
        }
        return accionEncontrada;
    }

    @Override
    public boolean actualizarUsuario(String nombreUsuario, Usuario usuarioActualizado) {
         try {
            ObjectSet<Usuario> resultados = objectContainer.queryByExample(new Usuario(nombreUsuario, "","",0));
            if (resultados.hasNext()) {
                Usuario usuarioExistente = resultados.next();
                usuarioExistente.setNombre(usuarioActualizado.getNombre());
                usuarioExistente.setEmail(usuarioActualizado.getEmail());
                usuarioExistente.setTipo(usuarioActualizado.getTipo());
                usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
                objectContainer.store(usuarioExistente);
                System.out.println("Se ha actualizado correctamente la accion de nombre: " + usuarioExistente.getNombre());
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error al intentar actualizar la accion" + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean borrarUsuario(String nombreUsuario) {
        System.out.println("Intentando eliminar la acción: " + nombreUsuario);
        try {
            ObjectSet<Usuario> resultados = objectContainer.queryByExample(new Usuario(nombreUsuario,"", "", 0));
            if (resultados.hasNext()) {
                Usuario accionEliminar = resultados.next();
                objectContainer.delete(accionEliminar);

                System.out.println("Se ha eliminado correctamente la accion de nombre: " + nombreUsuario);
                return true;
            } else {
                System.out.println("No se encontró ninguna accion de nombre DAO: " + nombreUsuario);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al intentar eliminar accion DAO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean comprobarExistencia(String nombreUsuario) {
        Usuario filtro = new Usuario(nombreUsuario, "", "",  0);
        try {
            ObjectSet<Usuario> resultados = objectContainer.queryByExample(filtro);
            if (resultados.hasNext()) {
                System.out.println("DAO ya existe accion con nombre: " + nombreUsuario);
                return true;
            } else {
                System.out.println("DAO No se ha encontrado ninguna accion con nombre: " + nombreUsuario);
                return false;
            }
        } catch (Exception e) {
            System.out.println("DAO Error al consultar Accion por nombre: " + e.getMessage());
            return false;
        }
    }
    
}
