/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Haber {

    private int idhaber;
    private Cuenta cuenta;
    private int documento;
    private double valor;
    private String detalle;
    private Date fecha;

    public Haber() {
    }

    public Haber(int idhaber, Cuenta cuenta, int documento, double valor, String detalle, Date fecha) {
        this.idhaber = idhaber;
        this.cuenta = cuenta;
        this.documento = documento;
        this.valor = valor;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public int getIdhaber() {
        return idhaber;
    }

    public void setIdhaber(int idhaber) {
        this.idhaber = idhaber;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
