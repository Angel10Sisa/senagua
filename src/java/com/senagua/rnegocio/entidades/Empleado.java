/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

/**
 *
 * @author Usuario
 */
public class Empleado {
    private int idempleado;
    private String cedula;
    private String nombre;
    private String apellido;
    private Tipoempleado tipo;
    private String usuario;
    private String clave;
    private String celular;
    private String mail;
    private String observacion;

    public Empleado() {
    }

    public Empleado(int idempleado, String cedula, String nombre, String apellido, Tipoempleado tipo, String usuario, String clave, String celular, String mail, String observacion) {
        this.idempleado = idempleado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.usuario = usuario;
        this.clave = clave;
        this.celular = celular;
        this.mail = mail;
        this.observacion = observacion;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Tipoempleado getTipo() {
        return tipo;
    }

    public void setTipo(Tipoempleado tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
}
