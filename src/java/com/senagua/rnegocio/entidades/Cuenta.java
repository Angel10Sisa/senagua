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
public class Cuenta {

    private int idcuenta;
    private String nombre;
    private String detalle;

    public Cuenta() {
    }

    public Cuenta(int idcuenta, String nombre, String detalle) {
        this.idcuenta = idcuenta;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
