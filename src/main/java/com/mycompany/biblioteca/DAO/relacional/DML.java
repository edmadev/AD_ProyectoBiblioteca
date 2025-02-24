/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.DAO.relacional;

import com.mycompany.biblioteca.models.Evento;
import com.mycompany.biblioteca.models.Libro;
import com.mycompany.biblioteca.models.Participacion;
import com.mycompany.biblioteca.models.Prestamo;
import com.mycompany.biblioteca.models.Usuario;
import com.mycompany.biblioteca.utils.ConversorCSV;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JHB
 */
public class DML {

    private Connection conexion;

    //añadi el parametro conexion pero hay que probarlo
    public DML() {
        this.conexion = new Conexion().conectar();
    }

    public int registrarLibro(String titulo, String autor, String genero, int año) {
        PreparedStatement ps = null;
        int filas = 0;
        Libro libro = new Libro(titulo, autor, genero, año);
        try {
            String consulta = "INSERT INTO libros(titulo_libro,autor,genero,año_publicacion) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, genero);
            ps.setInt(4, año);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarLibro(String titulo, String autor, String genero, int año) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE libros SET titulo_libro = ?,autor = ?,genero = ?, año_publicacion =? WHERE"
                    + " titulo_libro = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setString(3, genero);
            ps.setInt(4, año);
            ps.setString(5, titulo);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO EL LIBRO LLAMADO " + titulo);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarLibro(String titulo) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM libros WHERE titulo_libro = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, titulo);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarUsuario(String nombre, String email, String tipo, int telefono) {
        PreparedStatement ps = null;
        int filas = 0;
        Usuario usuario = new Usuario(nombre, email, tipo, telefono);
        try {
            String consulta = "INSERT INTO usuarios(nombre_usuario,email,tipo_usuario,telefono) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, tipo);
            ps.setInt(4, telefono);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarUsuario(String nombre, String email, String tipo, int telefono) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE usuarios SET nombre_usuario = ?,email = ?,tipo_usuario = ?, telefono =? WHERE"
                    + " nombre_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, tipo);
            ps.setInt(4, telefono);
            ps.setString(5, nombre);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO AL USUARIO " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarUsuario(String nombre) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM usuarios WHERE nombre_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarEvento(String nombre, Date fecha, String descripcion) {
        PreparedStatement ps = null;
        int filas = 0;
        Evento evento = new Evento(nombre, fecha, descripcion);
        try {
            String consulta = "INSERT INTO eventos(evento,fecha_evento,descipcion) VALUES (?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setDate(2, fecha);
            ps.setString(3, descripcion);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    public boolean actualizarEvento(String nombre, Date fecha, String descripcion) {
        PreparedStatement ps = null;
        boolean actualizado = false;
        int filas = 0;
        try {
            String consulta = "UPDATE eventos SET evento = ?,fecha_evento = ?,descripcion = ? WHERE"
                    + " nombre = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setDate(2, fecha);
            ps.setString(3, descripcion);
            filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("ACTUALIZACION EXITOSA");
                actualizado = true;
            } else {
                System.out.println("NO SE HA ENCONTRADO EL EVENTO " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println("NO SE PUDO ACTUALIZAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("NO SE PUDO CORTAR LA CONEXION: " + e.toString());
                }
            }
        }
        return actualizado;
    }

    public int eliminarEvento(String nombre) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "DELETE FROM eventos WHERE evento = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE ELIMINACIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
                }
            }
        }
        return filas;
    }

    public int registrarPrestamo(int usuario, int libro, Date Fprestamo, Date Fdevolucion, double multa) {
        PreparedStatement ps = null;
        int filas = 0;
        /*No tengo del todo claro si la multa la metes manualmente, haces un metodo para calcularla
        o tiene que ser una clase a parte*/
        try {
            String consulta = "INSERT INTO prestamos (id_usuario,id_libro,fecha_prestamo,fecha_limite_devolucion,multa) VALUES (?,?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, usuario);
            ps.setInt(2, libro);
            ps.setDate(3, Fprestamo);
            ps.setDate(4, Fdevolucion);
            ps.setDouble(5, multa);
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }

    /*public int registrarPrestamo(Prestamo prestamo) {
        PreparedStatement ps = null;
        int filas = 0;
        try {
            String consulta = "INSERT INTO prestamos (id_usuario,id_libro,fecha_prestamo,fecha_limite_devolucion,multa) VALUES (?,?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, prestamo.getIdLibro());
            ps.setInt(2, prestamo.getIdUsuario());
            ps.setDate(3, prestamo.getFechaPrestamo());
            ps.setDate(4, prestamo.getFechaLimiteDevolucion());
            ps.setDouble(5, prestamo.getMulta());
            filas = ps.executeUpdate();
            System.out.println("NUMERO DE INSERCIONES: " + filas);
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("CONEXION FINALIZADA");
                } catch (SQLException e) {
                    System.err.println("ERROR AL CERRAR CONEXION: " + e.toString());
                }
            }
        }
        return filas;
    }*/
    public boolean actualizarPrestamo(int idPrestamo, int usuario, int libro, Date Fprestamo, Date Fdevolucion) {

        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE prestamos SET id_usuario = ?, id_libro = ?, fecha_prestamo = ?, fecha_limite_devolución = ?, multa = ? WHERE id_prestamo = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, usuario);
            ps.setInt(2, libro);
            ps.setDate(3, Fprestamo);
            ps.setDate(4, Fdevolucion);
            filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se ha encontrado el prestamo de id: " + idPrestamo);
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar actualizar vacuna: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar PS: " + ex.toString());
                }
            }
        }
        return actualizacionExitosa;
    }

    /*public boolean actualizarPrestamo(Prestamo prestamo) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try {
            String consulta = "UPDATE prestamos SET id_usuario = ?, id_libro = ?, fecha_prestamo = ?, fecha_limite_devolución = ?, multa = ? WHERE id_prestamo = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, prestamo.getIdUsuario());
            ps.setInt(2, prestamo.getIdLibro());
            ps.setDate(3, prestamo.getFechaPrestamo());
            ps.setDate(4, prestamo.getFechaLimiteDevolucion());
            ps.setDouble(5, prestamo.getMulta());
            filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se ha encontrado el prestamo de id: " + prestamo.getIdPrestamo());
            }

        } catch (SQLException ex) {
            System.err.println("Error al intentar actualizar vacuna: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar PS: " + ex.toString());
                }
            }
        }
        return actualizacionExitosa;
    }*/

 /*public boolean actualizarMulta(Prestamo prestamo){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        int filasActualizadas;
        try{
            String consulta ="UPDATE prestamos set multa = ?"
        }
    }*/
    public int borrarPrestamo(int idPrestamo) {
        PreparedStatement ps = null;
        int filasAfectadas = 0;
        try {
            String consulta = "DELETE FROM prestamos WHERE id_prestamo= ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idPrestamo);
            filasAfectadas = ps.executeUpdate();
            System.out.println("Numero de filas afectadas: " + filasAfectadas);
        } catch (SQLException ex) {
            System.err.println("Error al modificar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar PS: " + ex.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public int registrarMulta(int idPrestamo, double montoMulta) {
        PreparedStatement ps = null;
        int filasInsertadas = 0;
        try {
            String consulta = "INSERT INTO multas (id_prestamo,monto_multa) VALUES";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idPrestamo);
            ps.setDouble(2, montoMulta);
            filasInsertadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasInsertadas);

        } catch (SQLException ex) {
            System.err.println("Error al registrar multa: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("No se ha cerrar correctamente PS: " + ex.toString());
                }
            }
        }
        return filasInsertadas;
    }

//    public int actualizarMulta(Multa multa) {
//        PreparedStatement ps = null;
//        boolean actualizacionExitosa = false;
//        int filasAfectadas = 0;
//        String consulta = "UPDATE multas SET id_prestamo = ?,monto_multa = ? WHERE id_multa = ?";
//        try {
//            ps = conexion.prepareStatement(consulta);
//            ps.setInt(1, multa.getIdPrestamo());
//            ps.setDouble(2, multa.getMontoMulta());
//            ps.setInt(3, multa.getIdMulta());
//            filasAfectadas = ps.executeUpdate();
//            if (filasAfectadas > 0) {
//                System.out.println("Actualizacion exitosa");
//                actualizacionExitosa = true;
//            } else {
//                System.out.println("No se ha encontrado la multa con id: " + multa.getIdMulta());
//            }
//            System.out.println("Filas insertadas: " + filasAfectadas);
//        } catch (SQLException ex) {
//            System.err.println("Error al insertar multa: " + ex.toString());
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException ex) {
//                    System.err.println("Error al cerrar PS: " + ex.getMessage());
//                }
//            }
//        }
//        return filasAfectadas;
//    }
//    public int eliminarMulta(Multa multa) {
//        PreparedStatement ps = null;
//        int filasAfectadas = 0;
//        try {
//            String consulta = "DELETE FROM multas WHERE id_multa = ?";
//            ps = conexion.prepareStatement(consulta);
//            ps.setInt(1, multa.getIdMulta());
//            filasAfectadas = ps.executeUpdate();
//            System.out.println("Filas eliminadas: " + filasAfectadas);
//        } catch (SQLException ex) {
//            System.err.println("Error al elimnar fila de multa: " + ex.getMessage());
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException ex) {
//                    System.err.println("Error al cerrar ps: " + ex.getMessage());
//                }
//            }
//        }
//        return filasAfectadas;
//    }
    public int registrarParticipacion(Participacion participacion) {
        PreparedStatement ps = null;
        int filasAfectadas = 0;
        try {
            String consulta = "INSERT INTO participaciones (id_evento, id_usuario) VALUES (?,?)";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, participacion.getIdEvento());
            ps.setInt(2, participacion.getIdUsuario());
            filasAfectadas = ps.executeUpdate();
            System.out.println("Numero de insercciones: " + filasAfectadas);
        } catch (SQLException ex) {
            System.err.println("Error al insertar participacion: " + ex.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar ps: " + ex.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public boolean actualizarParticipacion(Participacion participacion) {
        PreparedStatement ps = null;
        int filasAfectadas = 0;
        boolean actualizacionExitosa = false;
        try {
            String consulta = "UPDATE particiapaciones SET id_evento = ?, id_usuario = ? WHERE id_participacion = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, participacion.getIdEvento());
            ps.setInt(2, participacion.getIdUsuario());
            ps.setInt(3, participacion.getIdParticipacion());
            filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                actualizacionExitosa = true;
                System.out.println("Se ha actualizado participacion");
            } else {
                System.out.println("No se ha encontrado la participacion con id:" + participacion.getIdParticipacion());
            }
        } catch (SQLException ex) {
            System.err.println("Error al actualizar participacion: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar ps: " + ex.getMessage());
                }
            }
            return actualizacionExitosa;
        }
    }

    public int borrarParticipacion(Participacion participacion) {
        PreparedStatement ps = null;
        int filasAfectadas = 0;
        try {
            String consulta = "DELETE FROM participaciones WHERE id_participacion = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, participacion.getIdParticipacion());
            filasAfectadas = ps.executeUpdate();
            System.out.println("Numero de filas borradas: " + filasAfectadas);
        } catch (SQLException ex) {
            System.err.println("Error al borrar participacion: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar ps: " + ex.getMessage());
                }
            }
        }
        return filasAfectadas;
    }

    public ArrayList<Libro> listaLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String consulta = "SELECT * FROM libros";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                //int idLibro = rs.getInt("id_libro");
                String tituloLibro = rs.getString("titulo_libro");
                String autorLibro = rs.getString("autor");
                String generoLibro = rs.getString("genero");
                int añoLibro = rs.getInt("año_publicacion");
                Libro libro = new Libro(tituloLibro, autorLibro, generoLibro, añoLibro);
                listaLibros.add(libro);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL LISTAR LOS LIBROS: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return listaLibros;
    }

    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String consulta = "SELECT * FROM usuarios";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("nombre_usuario");
                String email = rs.getString("email");
                String tipo = rs.getString("tipo_usuario");
                int tfno = rs.getInt("telefono");
                Usuario usuario = new Usuario(nombre, email, tipo, tfno);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL LISTAR LOS USUARIOS: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return listaUsuarios;
    }

    public ArrayList<Evento> listaEventos() {
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String consulta = "SELECT * FROM eventos";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("evento");
                Date fecha = rs.getDate("fecha_evento");
                String descripcion = rs.getString("descipcion");

                Evento evento = new Evento(nombre, fecha, descripcion);
                listaEventos.add(evento);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL LISTAR LOS EVENTOS: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return listaEventos;
    }

    public ArrayList<Prestamo> listaPrestamos() {
        ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String consulta = "SELECT * FROM prestamos";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                //int idLibro = rs.getInt("id_libro");

                Date fechaPres = rs.getDate("fecha_prestamo");
                Date fechaDev = rs.getDate("fecha_limite_devolucion");

                Prestamo prestamo = new Prestamo(fechaPres, fechaDev);
                listaPrestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL LISTAR LOS LIBROS: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
        }
        return listaPrestamos;
    }

    public int insertarUsuarioArchivo(String ruta) {
        ConversorCSV conversor = new ConversorCSV();
        int numeroFilas = conversor.obtenerNumeroFilas(ruta);
        String[][] tabla = conversor.conversorCSV(ruta, numeroFilas);
        PreparedStatement ps = null;

        int filasInsertadas = 0;
        try {
            String consulta = "INSERT INTO usuarios(nombre_usuario,email,tipo_usuario,telefono) VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(consulta);
            for (String[] fila : tabla) {
                ps.setString(1, fila[0]);
                ps.setString(2, fila[1]);
                ps.setString(3, fila[2]);
                ps.setInt(4, Integer.parseInt(fila[3]));

            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL INSERTAR");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return filasInsertadas;
    }

    public Libro obtenerDatosLibro(String nombreLibro) {
        Libro libro = new Libro();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM libros WHERE titulo_libro = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombreLibro);
            rs = ps.executeQuery();

            //Comprobamos que rs tenga parametros de comprobacion.
            if (rs.next()) {
                int id_libro = rs.getInt("id_libro");
                String titulo_libro = rs.getString("titulo_libro");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                int año_publicacion = rs.getInt("año_publicacion");

                libro = new Libro(id_libro, titulo_libro, autor, genero, año_publicacion);
                System.out.println("libro encontrado");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra ResultSet: " + e.getMessage());
                }
            }
        }
        return libro;
        //ok
    }

    public Usuario obtenerDatosUsuario(String nombreUsuario) {
        Usuario usuario = new Usuario();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM usuarios WHERE nombre_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();

            //Comprobamos que rs tenga parametros de comprobacion.
            if (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String email = rs.getString("email");
                String tipo_usuario = rs.getString("tipo_usuario");
                int telefono = rs.getInt("telefono");

                usuario = new Usuario(id_usuario, nombre_usuario, email, tipo_usuario, telefono);
                System.out.println("usuario encontrado");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra ResultSet: " + e.getMessage());
                }
            }
        }
        return usuario;
        //ok
    }

    public int numeroTipo(String tipo) {
        int cont = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(*) as total FROM usuarios WHERE tipo_usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, tipo);
            rs = ps.executeQuery();

            //Comprobamos que rs tenga parametros de comprobacion.
            if (rs.next()) {
                cont = rs.getInt("total");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra ResultSet: " + e.getMessage());
                }
            }
        }
        return cont;
        //ok
    }

    public Evento obtenerDatosEvento(String nombreEvento) {
        Evento eventoObject = new Evento();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM eventos WHERE evento = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombreEvento);
            rs = ps.executeQuery();

            //Comprobamos que rs tenga parametros de comprobacion.
            if (rs.next()) {
                int id_evento = rs.getInt("id_evento");
                String evento = rs.getString("evento");
                Date fecha_evento = rs.getDate("fecha_evento");
                String descripcion = rs.getString("descripcion");

                eventoObject = new Evento(id_evento, evento, fecha_evento,descripcion);
                System.out.println("libro encontrado");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra PreparedStatement: " + e.getMessage());
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.err.println("Error al intentar cerra ResultSet: " + e.getMessage());
                }
            }
        }
        return eventoObject;
        //ok
    }

}
