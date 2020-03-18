/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciowebcrud.servicioweb;

import com.serviciowebcrud.impl.UserDao;
import com.serviciowebcrud.modelo.User;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author abarrime
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    public ServicioWeb() {

    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "listar")
    public List<User> listar() {
        //TODO write your implementation code here:
        UserDao dao = new UserDao();
        List<User> users = dao.listar();
        return users;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido) {
        //TODO write your implementation code here:
        UserDao dao = new UserDao();
        User user = new User();
        user.setFname(nombre);
        user.setLname(apellido);
        String agregar = dao.agregar(user);
        return agregar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarPorIdUser")
    public User listarPorIdUser(@WebParam(name = "idUser") int idUser) {
        //TODO write your implementation code here:
        UserDao dao = new UserDao();
        User user = dao.listarPorIdUser(idUser);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editar")
    public String editar(@WebParam(name = "idUser") int idUser, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido) {
        //TODO write your implementation code here:
        UserDao dao = new UserDao();
        User user = new User();
        user.setIdUser(idUser);
        user.setFname(nombre);
        user.setLname(apellido);
        String editar = dao.editar(user);
        return editar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public User eliminar(@WebParam(name = "idUser") int idUser) {
        //TODO write your implementation code here:
        UserDao dao = new UserDao();
        User user = dao.eliminar(idUser);
        return user;
    }

}
