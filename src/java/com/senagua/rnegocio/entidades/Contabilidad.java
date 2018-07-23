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
public class Contabilidad {

    private int idcontabilidad;
    private double debe;
    private double haber;
    private double saldo;
    private Date fecha;

    public Contabilidad() {
    }

    public Contabilidad(int idcontabilidad, double debe, double haber, double saldo, Date fecha) {
        this.idcontabilidad = idcontabilidad;
        this.debe = debe;
        this.haber = haber;
        this.saldo = saldo;
        this.fecha = fecha;
    }

    public int getIdcontabilidad() {
        return idcontabilidad;
    }

    public void setIdcontabilidad(int idcontabilidad) {
        this.idcontabilidad = idcontabilidad;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
