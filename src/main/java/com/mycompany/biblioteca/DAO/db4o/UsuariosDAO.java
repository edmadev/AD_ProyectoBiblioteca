/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.biblioteca.DAO.db4o;

import com.mycompany.biblioteca.models.Usuario;

/**
 *
 * @author edma2
 */
public interface UsuariosDAO {
    boolean insertarUsuario(Usuario usuario);
    Usuario consultarPorNombre(String nombreUsuario);
    boolean actualizarUsuario(String nombreUsuario,Usuario usuarioActualizado);
    boolean borrarUsuario(String nombreUsuario);
    boolean comprobarExistencia (String nombreUsuario);
  
}
