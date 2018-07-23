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
public class Tipomedidor {
    private int idtipomedidor;
    private String caracteristica;
    private double multa;
    private String observacion;

    public Tipomedidor() {
    }

    public Tipomedidor(int idtipomedidor, String caracteristica, double multa, String observacion) {
        this.idtipomedidor = idtipomedidor;
        this.caracteristica = caracteristica;
        this.multa = multa;
        this.observacion = observacion;
    }

    public int getIdtipomedidor() {
        return idtipomedidor;
    }

    public void setIdtipomedidor(int idtipomedidor) {
        this.idtipomedidor = idtipomedidor;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
}
