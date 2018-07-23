/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Angel-Pc
 */
public class Multaxmedidor {

    private int idmultamedidor;
    private Medidor medidor;
    private Multa multa;
    private Date fecha;
    private String detalle;

    public Multaxmedidor() {
    }

    public Multaxmedidor(int idmultamedidor, Medidor medidor, Multa multa, Date fecha, String detalle) {
        this.idmultamedidor = idmultamedidor;
        this.medidor = medidor;
        this.multa = multa;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public int getIdmultamedidor() {
        return idmultamedidor;
    }

    public void setIdmultamedidor(int idmultamedidor) {
        this.idmultamedidor = idmultamedidor;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

}
