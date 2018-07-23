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
public class Multa {

    private int idmulta;
    private String nombre;
    private double valor;
    private Date fecha;
    private String descripcion;

    public Multa() {
    }

    public Multa(int idmulta, String nombre, double valor, Date fecha, String descripcion) {
        this.idmulta = idmulta;
        this.nombre = nombre;
        this.valor = valor;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getIdmulta() {
        return idmulta;
    }

    public void setIdmulta(int idmulta) {
        this.idmulta = idmulta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
