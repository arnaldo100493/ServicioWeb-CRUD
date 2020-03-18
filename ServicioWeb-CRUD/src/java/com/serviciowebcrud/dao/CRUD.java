/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciowebcrud.dao;

import com.serviciowebcrud.modelo.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author abarrime
 */
public interface CRUD {

    public List<User> listar();

    public User listarPorIdUser(int idUser);

    public String agregar(User user);

    public String editar(User user);

    public User eliminar(int idUser);

}
