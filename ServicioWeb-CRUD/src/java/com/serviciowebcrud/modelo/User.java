/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciowebcrud.modelo;

/**
 *
 * @author abarrime
 */
public class User {

    private int idUser;
    private String fname;
    private String lname;

    public User() {
        this.idUser = 0;
        this.fname = "";
        this.lname = "";
    }

    public User(String fname, String lname) {
        this.idUser = 0;
        this.fname = fname;
        this.lname = lname;
    }

    public User(int idUser, String fname, String lname) {
        this.idUser = idUser;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", fname=" + fname + ", lname=" + lname + '}';
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

}
