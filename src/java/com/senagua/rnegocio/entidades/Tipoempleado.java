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
public class Tipoempleado {

    private int idtipoempleado;
    private String nombre;
    private String observacion;

    public Tipoempleado() {
    }

    public Tipoempleado(int idtipoempleado, String nombre, String observacion) {
        this.idtipoempleado = idtipoempleado;
        this.nombre = nombre;
        this.observacion = observacion;
    }

    public int getIdtipoempleado() {
        return idtipoempleado;
    }

    public void setIdtipoempleado(int idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
