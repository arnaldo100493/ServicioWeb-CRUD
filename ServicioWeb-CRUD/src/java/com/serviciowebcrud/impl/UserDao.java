/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciowebcrud.impl;

import com.serviciowebcrud.dao.CRUD;
import com.serviciowebcrud.jdbc.Conexion;
import com.serviciowebcrud.modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abarrime
 */
public class UserDao implements CRUD {

    public UserDao() {

    }

    @Override
    public List<User> listar() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);
                User user = new User(id, fname, lname);
                users.add(user);
            }
        } catch (SQLException ex) {

        }
        return users;
    }

    @Override
    public User listarPorIdUser(int idUser) {
        User user = null;
        String sql = "select * from user where id_user = ?";
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);
                user = new User(id, fname, lname);
            }

        } catch (SQLException ex) {

        }

        return user;
    }

    @Override
    public String agregar(User user) {
        String mensaje = "";
        String sql = "insert into user(id_user, fname, lname) values(?, ?, ?)";
        int filasAfectadas = 0;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, user.getIdUser());
            statement.setString(2, user.getFname());
            statement.setString(3, user.getLname());
            filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 1) {
                mensaje = "Usuario Agregado: " + "Filas Afectadas: " + filasAfectadas;
            } else {
                mensaje = "Error al agregar usuario: " + "Filas Afectadas: " + filasAfectadas;
            }
        } catch (SQLException ex) {

        }
        return mensaje;
    }

    @Override
    public String editar(User user) {
        String mensaje = "";
        String sql = "update user set fname = ?, lname = ? where id_user = " + user.getIdUser();
        int filasAfectadas = 0;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            filasAfectadas = statement.executeUpdate();
            if (filasAfectadas == 1) {
                mensaje = "Usuario Editado: " + "Filas Afectadas: " + filasAfectadas;
            } else {
                mensaje = "Error al editar usuario: " + "Filas Afectadas: " + filasAfectadas;
            }
        } catch (SQLException ex) {

        }

        return mensaje;
    }

    @Override
    public User eliminar(int idUser) {
        User user = new User();
        String sql = "delete from user where id_user = " + idUser;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {

        }
        return user;
    }

}
